package ind.kephan.textreader.model

import androidx.room.Database
import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.Chapter

@Database(entities = [Book::class, Chapter::class], version = 1, )
class Library {
}