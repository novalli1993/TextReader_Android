package ind.kephan.textreader.view.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ind.kephan.textreader.LatestNewsScreen
import ind.kephan.textreader.R
import ind.kephan.textreader.view.theme.TextReaderTheme

class ListView: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextReaderTheme {
                // A surface container using the 'background' color from the theme
                ListContent()
            }
        }
    }
}

@Composable
fun ListContent(
    numbs: Int = 0,
    names: MutableList<String> = mutableListOf(),
    pages: MutableList<Int> = mutableListOf()
) {
    Base("阅读器") {
        ListPainter(numbs, names, pages)
    }
}

@Composable
fun ListPainter(
    numbs: Int,
    names: MutableList<String>,
    pages: MutableList<Int>
) {
    if (numbs == 0) {
        return Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .zIndex(0F)
                .fillMaxSize()
        ) {
            Text(
                text = "暂时没有书籍",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    } else {
        return Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            for ((name, page) in names.zip(pages)) {
                Item_Book(name, page)
            }
        }
    }
}

@Composable
fun Item_Book(
    name: String,
    page: Int,
) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .zIndex(10F),
        shadowElevation = 10.dp) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp)
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                text = "$page pages",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview
@Composable
fun ListContentPreview() {
    TextReaderTheme {
        ListContent()
    }
}