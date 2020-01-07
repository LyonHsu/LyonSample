package lyon.calculator.lyoncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    val TAG:String = "MainActivity"
    lateinit var navigationDialog: NavigationDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"start onCreate")
        navigationDialog = NavigationDialog()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.MenuButton -> {
                navigationDialog.showRightDialog(this)
            } else -> println("item not found onOptionsItemSelected")
        }


        return super.onOptionsItemSelected(item)
    }
}
