package dev.dokup.testbed.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.dokup.testbed.infra.expense.ExpenseDao
import dev.dokup.testbed.infra.expense.ExpenseDatabase
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {

    private val expenseDatabase: ExpenseDatabase =
        Room.databaseBuilder(
            application,
            ExpenseDatabase::class.java,
            "expense.db"
        ).build()

    @Singleton
    @Provides
    fun provideExpenseDatabase() = expenseDatabase

    @Singleton
    @Provides
    fun provideExpenseDao(expenseDatabase: ExpenseDatabase): ExpenseDao {
        return expenseDatabase.expenseDao()
    }
}
