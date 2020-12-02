package lyon.music.lyonsample2.ui.main

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import lyon.music.lyonsample2.BaseActivity
import lyon.music.lyonsample2.ui.main.Model.CountModel
import lyon.music.lyonsample2.R
import lyon.music.lyonsample2.databinding.ActivityMainBinding


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    val TAG = this::class.java.simpleName
    lateinit var context:Context
    lateinit var mActivityMainBinding: ActivityMainBinding //當定義好 <Layout></Layout> 標籤後根據佈局檔名稱產生
    lateinit var mainFragment: MainFragment
    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        init()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.option_main, menu)
        return  super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                AlertDialog.Builder(context).setTitle(context.getString(R.string.action_settings)).setMessage(context.getString(
                    R.string.action_settings
                )).setCancelable(true).create().show()

                true
            }
            R.id.action_add ->{
                AlertDialog.Builder(context).setTitle(context.getString(R.string.addNew)).setMessage(context.getString(
                    R.string.addNew
                )).setCancelable(true).create().show()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        LyonNavigation(item)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun init(){
        //DataBinding 的 setContentView() 方式，省略原本的 setContentView(R.layout.activity_main);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val countModel = CountModel()
        mainViewModel= MainViewModel(countModel)
        mainFragment = MainFragment(mainViewModel)
        mActivityMainBinding.mainViewModel = mainViewModel


        titleColor= R.drawable.side_nav_bar;
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)


        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_layout, mainFragment)
        transaction.commit()
    }



}


