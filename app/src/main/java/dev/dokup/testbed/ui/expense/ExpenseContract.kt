package dev.dokup.testbed.ui.expense

import dev.dokup.testbed.domain.expense.ExpenseEntity

interface ExpenseContract {
    interface View {
        fun showExpenses(expenseList: List<ExpenseEntity>)
    }

    interface Presenter {
        fun attachView(view: View)
        fun onCreate()
        fun dispose()
    }
}
