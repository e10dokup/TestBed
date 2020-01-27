package dev.dokup.testbed.ui.expense

import android.util.Log
import dev.dokup.testbed.domain.expense.ExpenseEntity
import dev.dokup.testbed.domain.expense.ExpenseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class ExpensePresenter @Inject constructor(
    private val repository: ExpenseRepository
) : ExpenseContract.Presenter {

    private lateinit var view: ExpenseContract.View

    private val disposable = CompositeDisposable()

    override fun attachView(view: ExpenseContract.View) {
        this.view = view
    }

    override fun onCreate() {
        loadExpenses()
    }

    override fun dispose() {
        disposable.dispose()
    }

    override fun onClickSaveButton(name: String, price: String) {
        if (name.isEmpty()) {
            view.showError("Name must not empty.")
            return
        }
        if (price.isEmpty()) {
            view.showError("Price must not empty.")
            return
        }
        saveExpense(name, price.toLong())
    }

    private fun loadExpenses() {
        repository.getExpenses()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showExpenses(it)
            }, {
                Log.e("loadExpenses", it.localizedMessage, it)
                view.showError(it?.localizedMessage ?: "Failure load expenses")
            })
            .addTo(disposable)
    }

    private fun saveExpense(name: String, price: Long) {
        val createdAt = ZonedDateTime.now().toEpochSecond()
        val entity = ExpenseEntity(
            name = name,
            price = price,
            createdAt = createdAt * 1000
        )
        repository.insertExpense(entity)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadExpenses()
            }, {
                Log.e("saveExpense", it.localizedMessage, it)
                view.showError(it?.localizedMessage ?: "Failure save expense")
            })
            .addTo(disposable)
    }
}
