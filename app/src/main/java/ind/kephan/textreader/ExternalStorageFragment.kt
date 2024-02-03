package ind.kephan.textreader

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

open class ExternalStorageFragment : Fragment() {
    private val permissionCode = 1346
    private var storageGrantCallback: (() -> Unit)? = null
    private var storageDenyCallback: (() -> Unit)? = null

    fun runtimePermission() {
        if (isGranted()) {
            storageGrantCallback?.let { it() }
        } else {
            requestStoragePermission()
        }
    }

    private fun requestStoragePermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            permissionCode
        )
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                storageGrantCallback?.let { it() }
            } else {
                storageDenyCallback?.let { it() }
            }
        }
    }

    private fun isGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }
}