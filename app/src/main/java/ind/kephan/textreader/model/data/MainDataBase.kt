package ind.kephan.textreader.model.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.Chapter
import ind.kephan.textreader.model.data.operator.BookDao
import ind.kephan.textreader.model.data.operator.ChapterDao

@Database(entities = [Book::class, Chapter::class], version = 1)
abstract class MainDataBase: RoomDatabase() {
    abstract fun getBookDao(): BookDao
    abstract fun getChapterDao(): ChapterDao
}