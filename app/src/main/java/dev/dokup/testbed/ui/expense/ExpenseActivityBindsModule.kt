package dev.dokup.testbed.ui.expense

import android.app.Activity
import dagger.Binds
import dagger.Module

@Module
interface ExpenseActivityBindsModule {
    @Binds
    fun bindActivity(activity: ExpenseActivity): Activity
}
