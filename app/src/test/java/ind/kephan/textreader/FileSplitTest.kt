package ind.kephan.textreader

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import ind.kephan.textreader.model.data.MainDataBase
import ind.kephan.textreader.model.data.operator.TempManager
import org.junit.Test

class FileSplitTest {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val fileName = "test_short.txt"
    private val inputStream = context.assets.open(fileName).bufferedReader()
    private var fileSize: Long = 0

    @Test
    fun addBook_ReadChapter() {
        val mainDataBase = Room.inMemoryDatabaseBuilder(context, MainDataBase::class.java).build()
        val bookDao = mainDataBase.getBookDao()
        val chapterDao = mainDataBase.getChapterDao()
        val tempManager = TempManager()
        val (book, chapters) = tempManager.splitFile(
            inputStream,
            fileName,
            fileSize,
            context.filesDir.path
        )
        bookDao.addBook(book)
        chapterDao.addChapter(chapters)
        bookDao.getBookByName("test_short.txt")?.let { assert(it == book) }
        bookDao.getBookByName("test_short.txt")?.let { assert(it.id == book.id) }
        bookDao.getBookByName("test_short.txt")?.let { assert(it.size == book.size) }
        bookDao.getBookByName("test_short.txt")?.let { assert(it.name == book.name) }
        bookDao.getBookByName("test_short.txt")
            ?.let { assert(it.chapterCount == book.chapterCount) }

        assert(chapterDao.getAllChapters(book.id).size == chapters.size)
        for (id in 1L..20L) {
            val index = id - 1
            assert(
                chapterDao.getChapterById(
                    book.id,
                    id
                ).filePath == chapters[index.toInt()].filePath
            )
        }
//        File(chapterDao.getChapterById(book.id, id+1).filePath).forEachLine {line ->
//            Log.d("TXT", line)
//        }
    }
}