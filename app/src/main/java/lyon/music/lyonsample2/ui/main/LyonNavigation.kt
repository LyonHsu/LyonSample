package lyon.music.lyonsample2.ui.main

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.MenuItem
import lyon.music.lyonsample2.R
import lyon.music.lyonsample2.Tool

fun LyonNavigation(context: Context, item: MenuItem) {
    // Handle navigation view item clicks here.
    when (item.itemId) {
        R.id.nav_float_view -> {
            AlertDialog.Builder(context).setTitle(context.getString(R.string.action_settings)).setMessage(context.getString(
                R.string.menu_FloatView
            )).setCancelable(true).create().show()

        }
        R.id.nav_about_me -> {
            var alert =  AlertDialog.Builder(context)
            alert.setTitle(context.getString(R.string.menu_aboutMe)).setMessage(context.getString(
                R.string.about_Me_sub
            )).setCancelable(true)
            alert.setPositiveButton(context.getString(R.string.contactMe),object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Tool.shareEmail(
                        context,
                        "lejiteyu@gmail.com",
                        "Android App " + context.getString(R.string.app_name) + "ver:" + Tool.getVersionName(
                            context
                        ) + "(" + Tool.getVersionCode(
                            context
                        ) + ")",
                        "hello"
                    )
                }
            })
            alert.create()
            alert.show()
        }
    }

}