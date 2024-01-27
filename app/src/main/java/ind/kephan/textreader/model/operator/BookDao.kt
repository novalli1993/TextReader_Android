package ind.kephan.textreader.model.operator

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ind.kephan.textreader.model.data.Book
import java.io.File

@Dao
interface BookDao {
    @Query("SELECT * FROM books WHERE name = :name")
    fun getBookByName(name: String): Book?
    @Query("SELECT * FROM books WHERE id = :id")
    fun getBookById(id: Long): Book
    @Query("SELECT * FROM books ORDER BY createTime")
    fun getAllBookByTime(): List<Book>
    @Insert
    fun addBook(book: Book)
    @Insert
    fun addBook(books: List<Book>)
    @Update
    fun updateBook(book: Book)
    @Delete
    fun deleteBook(book: Book)
}