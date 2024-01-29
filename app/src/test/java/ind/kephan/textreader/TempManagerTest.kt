package ind.kephan.textreader

import ind.kephan.textreader.model.data.operator.TempManager
import org.junit.Test
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TempManagerTest {
    private val path = "J:\\Study\\test_short.txt"
    private val file = File(path)
    @Test
    fun tempFormatTest(){
        val tempFormat = TempManager()
        val (book, _) = tempFormat.saveFiles(file)
        val dateFormat = SimpleDateFormat("z yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        println(dateFormat.format(Date(book.createTime)))
    }
}