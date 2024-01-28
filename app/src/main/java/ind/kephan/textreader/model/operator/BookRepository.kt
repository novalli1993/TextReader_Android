package ind.kephan.textreader.model.operator

import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.operator.BookDao
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class BookRepository (private val bookDao: BookDao) {
    suspend fun addBook(book: Book) {
        withContext(IO) {
            if (isExist(book)) {
                bookDao.addBook(book)
            }
        }
    }

    suspend fun addBook(bookList: List<Book>) {
        withContext(IO) {
            val books = bookList.filter {
                isExist(it)
            }
            bookDao.addBook(books)
            // TODO 增加重名文件反馈
//            print(bookList.filterNot { isExist(it) })
        }
    }

    suspend fun updateBook(book: Book){
        withContext(IO) {
            bookDao.updateBook(book)
        }
    }

    suspend fun deleteBook(book: Book){
        withContext(IO) {
            bookDao.deleteBook(book)
        }
    }

    fun getBookByName(name: String): Book? {
        return bookDao.getBookByName(name)
    }

    private fun isExist(book: Book): Boolean {
        return bookDao.getBookByName(book.name) != null
    }

    
    // 单例模式
    companion object {
        private var instance: BookRepository? = null

        fun getInstance(bookDao: BookDao): BookRepository{
            return instance ?: synchronized(this){
                instance ?: BookRepository(bookDao).also { instance = it }
            }
        }
    }
}