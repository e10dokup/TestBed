package dev.dokup.testbed.ui.main

import android.app.Activity
import dev.dokup.testbed.ui.dog.DogActivity
import dev.dokup.testbed.ui.expense.ExpenseActivity
import dev.dokup.testbed.ui.logcat.LogcatActivity
import dev.dokup.testbed.ui.memoryleak.MemoryLeakActivity
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

    fun navigateToDogSample() {
        activity.startActivity(DogActivity.createIntent(activity))
    }

    fun navigateToMemoryLeakSample() {
        activity.startActivity(MemoryLeakActivity.createIntent(activity))
    }
}
