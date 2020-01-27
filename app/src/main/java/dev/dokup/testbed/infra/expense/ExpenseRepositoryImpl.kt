package dev.dokup.testbed.infra.expense

import dev.dokup.testbed.domain.expense.ExpenseEntity
import dev.dokup.testbed.domain.expense.ExpenseRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepositoryImpl @Inject constructor(
    private val expenseLocalDataSource: ExpenseLocalDataSource
): ExpenseRepository {
    override fun getExpenses(): Single<List<ExpenseEntity>> {
        return expenseLocalDataSource.all()
            .subscribeOn(Schedulers.io())
    }

    override fun insertExpense(entity: ExpenseEntity): Completable {
        return expenseLocalDataSource.insert(entity)
            .subscribeOn(Schedulers.io())
    }

    override fun deleteExpense(entity: ExpenseEntity): Completable {
        return expenseLocalDataSource.delete(entity)
            .subscribeOn(Schedulers.io())
    }
}
