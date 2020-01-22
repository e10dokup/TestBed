package dev.dokup.testbed.ui.expense

import android.util.Log
import dev.dokup.testbed.domain.expense.ExpenseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
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

    private fun loadExpenses() {
        repository.getExpenses()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showExpenses(it)
            }, {
                Log.e("loadExpenses", it.localizedMessage, it)
            })
            .addTo(disposable)
    }
}
