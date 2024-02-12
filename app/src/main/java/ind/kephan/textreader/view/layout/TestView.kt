package ind.kephan.textreader.view.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ind.kephan.textreader.view.layout.Base
import ind.kephan.textreader.view.theme.TextReaderTheme

@Composable
fun TestIU() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Test")
        }
        Text("Result")
    }
}


@Preview
@Composable
fun TestIUPreview() {
    TextReaderTheme {
        Base("Test"){ TestIU()}
    }
}