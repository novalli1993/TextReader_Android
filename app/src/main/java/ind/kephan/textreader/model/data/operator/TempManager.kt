package ind.kephan.textreader.model.data.operator

import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.Chapter
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.RandomAccessFile
import java.util.regex.Matcher
import java.util.regex.Pattern


class TempManager {
    fun splitFile(
        reader: BufferedReader,
        name: String,
        size: Long,
        cachePath: String
    ): Pair<Book, MutableList<Chapter>> {
        var chapterIndex = 1

        val book = Book.build(name, size, 0)
        val bookId = book.id

        val titles: MutableList<String> = mutableListOf()
        val filePaths: MutableList<String> = mutableListOf()
        val filePieces: MutableList<String> = mutableListOf()
        var line: String?
        val tmpPath = "$cachePath\\$bookId"
        val tmpFolder = File(tmpPath)
        if (!tmpFolder.exists()) {
            tmpFolder.mkdirs()
        }
        while (reader.readLine().also { line = it } != null) {
            if (isTitle(line)) {
                line?.let { titles.add(it) }

                if (filePieces.isNotEmpty()) {
                    val chapterFile = "$tmpPath\\$chapterIndex.txt"
                    saveChapter(chapterFile, filePieces)
                    filePaths.add(chapterFile)
                    filePieces.clear()
                    chapterIndex++
                }
            } else {
                line?.let { filePieces.add(it) }
            }
        }
        if (filePieces.isNotEmpty()) {
            val chapterFile = "$tmpPath\\$chapterIndex.txt"
            saveChapter(chapterFile, filePieces)
            filePaths.add(chapterFile)
            filePieces.clear()
        }
        if (titles.size < filePaths.size) {
            titles.add(0, "引子")
        }
        book.chapterCount = filePaths.size
        val chapters: MutableList<Chapter> = mutableListOf()
        titles.zip(filePaths).forEach { (title, filePath) ->
            chapters.add(Chapter.build(bookId, title, filePath))
        }
        return book to chapters
    }

    fun splitFile(file: File, cachePath: String): Pair<Book, MutableList<Chapter>> {
        return splitFile(BufferedReader(FileReader(file)), file.name, file.length(), cachePath)
    }

    fun readChapter(chapter: Chapter): BufferedReader {
        return BufferedReader(FileReader(chapter.filePath))
    }

    fun deleteFiles(chapters: List<Chapter>) {
        val mainDir = File(chapters[0].filePath).parentFile ?: return
        chapters.forEach {
            val file = File(it.filePath)
            file.delete()
        }
        if (mainDir.list()?.isEmpty() == true) {
            mainDir.delete()
        }
    }

    private fun isTitle(paragraph: String?): Boolean {
        if (paragraph == null || paragraph.contains("。") || paragraph.contains("：“")) return false
        val r =
            """
            \s*\S*(第[0-9|零一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾百千万]+[节章卷回话]|[c|C]hapter.*[0-9]|☆、.*|[上中下终]卷|卷[0-9|零一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾]+|[引子|楔子|序][
            \s]|[Ll][Vv].[0-9]+|－Quiz [0-9]+).*
            """.trim()
        val p: Pattern = Pattern.compile(r)
        val m: Matcher = p.matcher(paragraph)
        return m.matches()
    }

    private fun paragraphFormat(p: String): String {
        return p.trim()
    }

    private fun saveChapter(path: String, filePieces: MutableList<String>) {
        val tmp = File(path)
        val writer = FileWriter(tmp, true)
        filePieces.forEach {
            if (it.isNotBlank()) {
                writer.write("${paragraphFormat(it)}\n")
            }
        }
        writer.close()
    }
}