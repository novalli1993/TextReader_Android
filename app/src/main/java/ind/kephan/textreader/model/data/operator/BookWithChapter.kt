package ind.kephan.textreader.model.data.operator

import androidx.room.Embedded
import androidx.room.Relation
import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.Chapter

data class BookWithChapter (
    @Embedded val book: Book,
    @Relation(parentColumn = "id",entityColumn = "bookId") val chapters: List<Chapter>
)