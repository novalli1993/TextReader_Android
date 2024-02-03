package ind.kephan.textreader

import android.content.Context
import android.view.inputmethod.ExtractedTextRequest
import androidx.test.core.app.ApplicationProvider
import org.junit.Test


class ExternalStorageFragmentTest {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val fileName = "test.txt"
    private val path = "test"

    private val grant = {println("Permission has been granted by user.")}
    private val deny = {println("Permission has been denied by user.")}

    @Test
    fun test() {
    }
}