package ind.kephan.textreader.view.layout

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ind.kephan.textreader.R
import ind.kephan.textreader.view.theme.TextReaderTheme

@Composable
fun Base(
    viewName: String,
    content: @Composable () -> Unit
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
                    text = viewName,
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
        content()
    }
}

@Preview
@Composable
fun BasePreview() {
    TextReaderTheme {
        Base("基础视图"){}
    }
}