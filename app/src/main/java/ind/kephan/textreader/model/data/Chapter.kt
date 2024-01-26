package ind.kephan.textreader.model.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "chapters")
data class Chapter(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val bookId: Long,
    val title: String,
    val filePath: String
) {
    companion object {
        fun build(bookId: Long, title: String, filePath: String): Chapter{
            return Chapter(
                bookId = bookId,
                title = title,
                filePath = filePath
            )
        }
    }
}
