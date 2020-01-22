package dev.dokup.testbed.domain.expense

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter

@Entity(tableName = "expense")
data class ExpenseEntity constructor(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Long,
    @ColumnInfo(name = "created_at") val createdAt: Long
) {
    companion object {
        private const val CREATED_AT_FORMAT = "yyyy/MM/dd HH:mm"
    }

    val createdAtString: String
        get() {
            val instant = Instant.ofEpochMilli(createdAt)
            val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
            return localDateTime.format(DateTimeFormatter.ofPattern(CREATED_AT_FORMAT))
        }
}
