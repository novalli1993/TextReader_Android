package ind.kephan.textreader.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "books")
data class Book(
    @PrimaryKey
    val id: Long,
    val name: String,
    val size: Long,
    val chapterCount: Int,
    val createTime: Long
) {
    companion object {
        fun build(name: String, size: Long, chapterCount: Int): Book {
            return Book(
                id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE,
                name = name,
                size = size,
                chapterCount = chapterCount,
                createTime = System.currentTimeMillis()
            )
        }
    }
}