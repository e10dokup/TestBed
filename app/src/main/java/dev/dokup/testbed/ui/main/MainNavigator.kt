package dev.dokup.testbed.ui.main

import android.app.Activity
import dev.dokup.testbed.ui.expense.ExpenseActivity
import dev.dokup.testbed.ui.logcat.LogcatActivity
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val activity: Activity
) {
    fun navigateToLogcatSample() {
        activity.startActivity(LogcatActivity.createIntent(activity))
    }

    fun navigateToExpenseSample() {
        activity.startActivity(ExpenseActivity.createIntent(activity))
    }
}
