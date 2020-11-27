package lyon.music.lyonsample2

import android.app.Activity

interface AppLifecycleListener {
    fun onForeground(activity: Activity?)
    fun onBackground(activity: Activity?)
}