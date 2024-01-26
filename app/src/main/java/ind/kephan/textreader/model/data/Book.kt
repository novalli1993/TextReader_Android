package ind.kephan.textreader.model.data

import androidx.compose.ui.text.Paragraph
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "books")
data class Book(
    @PrimaryKey
    val id: Long,
    var name: String,
    val size: Long,
    val createTime: Date
) {
    companion object {
        fun build(name: String, size: Long, createTime: Date): Book {
            return Book(
                id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,
                name = name,
                size = size,
                createTime = createTime
            )
        }
    }
}