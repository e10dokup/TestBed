package dev.dokup.testbed.infra.expense

import dev.dokup.testbed.domain.expense.ExpenseEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ExpenseLocalDataSource @Inject constructor(
    private val expenseDao: ExpenseDao
) {

    fun all(): Single<List<ExpenseEntity>> {
        return expenseDao.all()
    }

    fun insert(entity: ExpenseEntity): Completable {
        return expenseDao.insert(entity)
    }

    fun delete(entity: ExpenseEntity): Completable {
        return expenseDao.delete(entity)
    }
}
