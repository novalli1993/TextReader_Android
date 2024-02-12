package ind.kephan.textreader

import android.content.res.Resources
import ind.kephan.textreader.view.layout.ViewConfig
import ind.kephan.textreader.viewmodel.PrintPage
import org.junit.Test

class PrintPageTest {
    val printPage = PrintPage()
    val density = Resources.getSystem().displayMetrics.density
    val height = Resources.getSystem().displayMetrics.heightPixels
    val width = Resources.getSystem().displayMetrics.widthPixels
    val viewConfig = ViewConfig.default(density, height, width)

    @Test
    fun pageConstructorTest() {
        val page = printPage.pageConstructor(strList,density,viewConfig)
        println(page.content)
    }
}