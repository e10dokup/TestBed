package dev.dokup.testbed.infra.expense

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.dokup.testbed.domain.expense.ExpenseEntity

@Database(
    entities = [
        ExpenseEntity::class
    ],
    version = ExpenseDatabase.DATABASE_VERSION

)
abstract class ExpenseDatabase: RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object {
        const val DATABASE_VERSION = 1
    }
}
