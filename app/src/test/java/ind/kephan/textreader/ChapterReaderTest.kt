package ind.kephan.textreader

import ind.kephan.textreader.model.data.Chapter
import ind.kephan.textreader.model.data.operator.TempManager
import org.junit.Test
import java.io.File

class ChapterReaderTest {
    private val path = "C:\\Users\\noval\\Downloads\\txtreader\\8869504472986962340"
    private val tempManager = TempManager()

    @Test
    fun readerTest() {
        val fileNames: MutableList<Int> = mutableListOf()
        File(path).walk().forEach {
            if (it.isFile && (it.extension == "txt"|| it.extension == "TXT")) fileNames.add(it.nameWithoutExtension.toInt())
        }
        fileNames.sort()
        val chapter = Chapter.build(8869504472986962340, "卡徒", "$path\\${fileNames[1]}.txt")
        val chapterReader = tempManager.readChapter(chapter)
        println(chapterReader.readLine())
    }
}