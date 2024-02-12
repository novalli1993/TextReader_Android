package ind.kephan.textreader

import ind.kephan.textreader.model.data.operator.TempManager
import org.junit.Test
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale

class TempManagerTest {
    private val path = "J:\\Study\\卡徒.txt"
    private val file = File(path)
    val cachePath = "C:\\Users\\noval\\Downloads\\txtreader"
    @Test
    fun tempFormatTest(){
        val tempFormat = TempManager()
        val (book, chapters) = tempFormat.splitFile(file, cachePath)
        val dateFormat = SimpleDateFormat("z yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        println(book.id)
        println(book.chapterCount)
        println(chapters.size)
        println(chapters[0].id)
        println(chapters[0].title)
        println(chapters[0].filePath)
        println(chapters[1].id)
        println(chapters[1].title)
        println(chapters[1].filePath)
        println(chapters[2].id)
        println(chapters[2].title)
        println(chapters[2].filePath)
        tempFormat.deleteFiles(chapters.subList(100,200))
    }
}