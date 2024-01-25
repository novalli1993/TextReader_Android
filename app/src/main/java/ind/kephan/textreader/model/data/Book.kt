package ind.kephan.textreader.model.data

import androidx.compose.ui.text.Paragraph
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "books")
data class Book(
    @PrimaryKey
    val id: Long,
    var name: String,
    var chapters: List<Chapter>
) {
    companion object {
        fun build(name: String, chapters: List<Chapter>): Book {
            return Book(
                id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,
                name = name,
                chapters = chapters
            )
        }
    }
}