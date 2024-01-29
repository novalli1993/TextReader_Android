package ind.kephan.textreader

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import ind.kephan.textreader.model.data.MainDataBase
import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.operator.BookDao
import org.junit.Test

class BookRepositoryTest {
    @Test
    fun testAddBook() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val mainDataBase: MainDataBase = Room.inMemoryDatabaseBuilder(context, MainDataBase::class.java).build()
        val bookDao: BookDao = mainDataBase.getBookDao()
        val book = Book.build("Sample", 1145, 123)
        bookDao.addBook(book)
        assert(bookDao.getBookByName("Sample") == book)
        Log.d("Some Data", bookDao.getBookByName("Sample")?.id.toString())
        Log.d("Some Data", bookDao.getBookByName("Sample")?.name.toString())
        Log.d("Some Data", bookDao.getBookByName("Sample")?.size.toString())
        Log.d("Some Data", bookDao.getBookByName("Sample")?.createTime.toString())
    }
}