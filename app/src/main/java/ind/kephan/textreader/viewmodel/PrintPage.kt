package ind.kephan.textreader.viewmodel

import ind.kephan.textreader.view.layout.ViewConfig

class PrintPage {
    fun pageConstructor(content: List<String>, density: Float, viewConfig: ViewConfig): Page {
        val characterSize = viewConfig.pageFontSize * density
        val lineHeight = viewConfig.pageLineHeight * density
        val characterPerLine = ((viewConfig.width-viewConfig.pagePadding*2) / characterSize).toInt()
        var maxLine = ((viewConfig.height - viewConfig.titleBarHeight) / lineHeight).toInt()

        var paragraphs = content
        var paragraphCount = 0
        var newStart = 0
        val page = StringBuffer()
        while (maxLine > 0) {
            val p = paragraphs.first()
            paragraphs = paragraphs.subList(1,paragraphs.size)
            if ((p.length / characterPerLine) > maxLine) {
                newStart = maxLine * characterPerLine + 1
                page.append("${p.substring(0, newStart)}\n")
                break
            } else {
                page.append("$p\n")
                paragraphCount += 1
                maxLine -= (p.length / characterPerLine + 1)
            }
        }
        return Page(page.toString(), paragraphCount, newStart)
    }
}

data class Page(
    val content: String,
    val paragraph: Int,
    val newStart: Int
)