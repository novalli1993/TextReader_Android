package ind.kephan.textreader

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ind.kephan.textreader.view.theme.TextReaderTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextReaderTheme {
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Composable
fun LatestNewsScreen() {

    // State of whether more details should be shown
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text("Some text")
        if (expanded) {
            Text("More details")
        }

        Button(
            // The expand details event is processed by the UI that
            // modifies this composable's internal state.
            onClick = { expanded = !expanded }
        ) {
            val expandText = if (expanded) "Collapse" else "Expand"
            Text("$expandText details")
        }
    }
}

@Preview
@Composable
fun LatestNewsScreenPreview() {
    LatestNewsScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextReaderTheme {
        Greeting("Android")
    }
}