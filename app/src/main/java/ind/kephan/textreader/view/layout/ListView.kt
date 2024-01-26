package ind.kephan.textreader.view.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.view.theme.TextReaderTheme
import ind.kephan.textreader.viewmodel.PrintList

class ListView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextReaderTheme {
                // A surface container using the 'background' color from the theme
                LatestNewsScreen()
            }
        }
    }
}

@Composable
fun Base(
    numbs: Int = 0,
    names: MutableList<String> = mutableListOf(),
    pages: MutableList<Int> = mutableListOf(),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(15F),
            shadowElevation = 10.dp
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "阅读器",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Image(
                    painter = painterResource(R.drawable.dots_white),
                    contentDescription = "setting",
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        if (numbs == 0) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .zIndex(0F)
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "暂时没有书籍",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                for ((name, page) in names.zip(pages)) {
                    Item_Book(name, page)
                }
            }
        }
    }
}

@Composable
fun Item_Book(
    name: String = "first book",
    page: Int = 129,
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
fun BasePreview() {
    TextReaderTheme {
//        val printList = null
//        val printList = PrintList(bookList = BookList(Book()))
//        Base(printList.getNumb(),printList.getNames(),printList.getPages())
    }
}