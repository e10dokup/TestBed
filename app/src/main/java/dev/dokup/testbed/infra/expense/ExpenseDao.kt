package dev.dokup.testbed.infra.expense

import androidx.room.*
import dev.dokup.testbed.domain.expense.ExpenseEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense")
    fun all(): Single<List<ExpenseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: ExpenseEntity): Completable

    @Delete
    fun delete(entity: ExpenseEntity): Completable
}
