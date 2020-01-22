package dev.dokup.testbed.domain.expense

import io.reactivex.Completable
import io.reactivex.Single

interface ExpenseRepository {
    fun getExpenses(): Single<List<ExpenseEntity>>
    fun insertExpense(entity: ExpenseEntity): Completable
    fun deleteExpense(entity: ExpenseEntity): Completable
}
