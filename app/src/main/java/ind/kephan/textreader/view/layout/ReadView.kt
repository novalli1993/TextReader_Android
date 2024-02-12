package ind.kephan.textreader.view.layout

import android.content.res.Resources
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ind.kephan.textreader.strList
import ind.kephan.textreader.viewmodel.PrintPage

private val sample = ind.kephan.textreader.sample
val density = Resources.getSystem().displayMetrics.density
val height = Resources.getSystem().displayMetrics.heightPixels
val width = Resources.getSystem().displayMetrics.widthPixels
val viewConfig = ViewConfig.default(density, height, width)

@Composable
fun ReadView(page: String, modifier: Modifier) {
    Text(
        text = page,
        fontSize = viewConfig.pageFontSize.sp,
        lineHeight = viewConfig.pageLineHeight.sp,
        modifier = modifier
    )
}

@Preview
@Composable
fun ReadViewPreview() {
    val printPage = PrintPage()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val info =
            "H: $height W: $width\n" +
            "PPI: $density; Character per line: ${((viewConfig.width-viewConfig.pagePadding*2) / density / viewConfig.pageFontSize).toInt()}; " +
            "Max Line: ${(height / density / viewConfig.pageLineHeight).toInt()}\n" +
                    "${Resources.getSystem().displayMetrics.heightPixels.toDouble()}"
        // TODO 生成内容
        val pageContent = printPage.pageConstructor(strList, density, viewConfig)
        ReadView(
            page = pageContent.content,
            Modifier.padding(start = viewConfig.pagePadding.dp, end = viewConfig.pagePadding.dp)
        )
    }
}

@Preview
@Composable
fun ReadViewPreview2() {
    val printPage = PrintPage()

    Column(
        modifier = Modifier
    ) {
        val info =
            "H: $height W: $width\n" +
                    "PPI: $density; Character per line: ${((viewConfig.width-viewConfig.pagePadding*2) / density / viewConfig.pageFontSize).toInt()}; " +
                    "Max Line: ${(height / density / viewConfig.pageLineHeight).toInt()}\n"
        // TODO 生成内容
        val pageContent = printPage.pageConstructor(strList, density, viewConfig)
        ReadView(
            page = "$info\n${pageContent.content.split("\n").size}",
            Modifier.padding(start = viewConfig.pagePadding.dp, end = viewConfig.pagePadding.dp)
        )
    }
}