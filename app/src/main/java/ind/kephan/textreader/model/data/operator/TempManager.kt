package ind.kephan.textreader.model.data.operator

import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.Chapter
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.regex.Matcher
import java.util.regex.Pattern


class TempManager {
    fun saveFiles(file: File): Pair<Book, MutableList<Chapter>> {
        val name: String = file.name
        val size: Long = file.length()
        val chapterCount: Int

        val bookId: Long

        val titles: MutableList<String> = mutableListOf()
        val filePaths: MutableList<String> = mutableListOf()
        val filePieces: MutableList<String> = mutableListOf()
        val reader = BufferedReader(FileReader(file))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            if (isTitle(line)) {
                line?.let { titles.add(it) }
                // TODO 临时的文件地址
                filePaths.add(filePieces.size.toString())

                filePieces.clear()
            } else {
                line?.let { filePieces.add(it) }
            }
        }
        chapterCount = filePaths.size
        val book = Book.build(name, size, chapterCount)
        bookId = book.id
        val chapters: MutableList<Chapter> = mutableListOf()
        titles.zip(filePaths).forEach { (title, filePath) ->
            chapters.add(Chapter.build(bookId, title, filePath))
        }
        return book to chapters
    }

    fun deleteFiles(chapters: List<Chapter>) {
        chapters.forEach { chapter ->
            val file = File(chapter.filePath)
            file.delete()
        }
    }

    private fun isTitle(paragraph: String?): Boolean {
        if (paragraph == null || paragraph.contains("。") || paragraph.contains("：“")) return false
        val r =
            """
            \s*\S*(第[0-9|零一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾百千万]+[节章卷回话]|[c|C]hapter.*[0-9]|☆、.*|[上中下终]卷|卷[0-9|零一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾]+|[引子|楔子|序][
            \s]|[Ll][Vv].[0-9]+|－Quiz [0-9]+).*
            """.trimIndent()
        val p: Pattern = Pattern.compile(r)
        val m: Matcher = p.matcher(paragraph)
        return m.matches()
    }
}