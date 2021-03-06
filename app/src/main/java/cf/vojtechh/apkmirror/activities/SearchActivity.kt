package cf.vojtechh.apkmirror.activities

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cf.vojtechh.apkmirror.R
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)

        MaterialDialog.Builder(this).title(R.string.search).inputRange(1, 100).theme(Theme.LIGHT)
                .negativeText(android.R.string.cancel).input(R.string.search, R.string.nothing) { _, _ -> }
                .onPositive { dialog, _ ->
                    val i = Intent(this@SearchActivity, MainActivity::class.java)
                    if (dialog.inputEditText != null)
                        i.putExtra("url", "https://www.apkmirror.com/?s=" + dialog.inputEditText!!.text)
                    else
                        Toast.makeText(this@SearchActivity, getString(R.string.search_error), Toast.LENGTH_SHORT).show()
                    startActivity(i)
                    finish()
                }.onNegative { _, _ -> finish() }.show()
    }
}
