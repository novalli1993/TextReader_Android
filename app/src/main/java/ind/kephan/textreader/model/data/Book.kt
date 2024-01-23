package ind.kephan.textreader.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val name: String,
    val filePath: String,
    var paragraphs: Long,
    var chapters: Long
) {
}