package dev.dokup.testbed.ui.expense

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ExpenseActivityModule {
    @ContributesAndroidInjector(
        modules = [
            ExpenseActivityBindsModule::class
        ]
    )
    fun contributeExpenseActivity(): ExpenseActivity
}
