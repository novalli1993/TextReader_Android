package ind.kephan.textreader.view.layout

import android.content.Context

data class ViewConfig(
    val height: Int,
    val width: Int,
    val titleBarHeight: Double,
    val titleFontSize: Double,
    var pageFontSize: Double,
    var pageLineHeight: Double,
    var pagePadding: Double
) {
    companion object {
        fun default(context: Context): ViewConfig {
            val density = context.resources.displayMetrics.density
            val height = context.resources.displayMetrics.heightPixels
            val width = context.resources.displayMetrics.widthPixels
            return default(density, height, width)
        }

        fun default(density: Float, height: Int, width: Int): ViewConfig {
            val titleBarHeight = 52.0
            val titleFontSize = 24.0
            val pageFontSize = 16.0
            val pageLineHeight = pageFontSize * 1.5
            val pagePadding = 15.0
            return ViewConfig(height, width, titleBarHeight, titleFontSize, pageFontSize, pageLineHeight, pagePadding)
        }
    }
}