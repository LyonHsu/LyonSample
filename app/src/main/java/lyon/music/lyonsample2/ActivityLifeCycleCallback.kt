package lyon.music.lyonsample2

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

public abstract class ActivityLifeCycleCallback: Application.ActivityLifecycleCallbacks {
    val TAG = this::class.java.simpleName
    private var resumed = 0
    private var pausedd = 0
    var ReumseLifeActivity: Activity? = null
    var PausedLifeActivity: Activity? = null
    private val foreground = false

    override fun onActivityPaused(activity: Activity) {
        LogL.d(TAG,"onActivityPaused:"+activity::class.simpleName)
        PausedLifeActivity = activity;
    }

    override fun onActivityStarted(activity: Activity) {
        LogL.d(TAG,"onActivityStarted:"+activity::class.simpleName)
    }

    override fun onActivityDestroyed(activity: Activity) {
        LogL.d(TAG,"onActivityDestroyed:"+activity::class.simpleName)
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
        LogL.d(TAG,"onActivitySaveInstanceState:"+activity::class.simpleName)
    }

    override fun onActivityStopped(activity: Activity) {
        LogL.d(TAG,"onActivityStopped:"+activity::class.simpleName)
    }

    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        LogL.d(TAG,"onActivityCreated:"+activity::class.simpleName)
    }

    override fun onActivityResumed(activity: Activity) {
        LogL.d(TAG,"onActivityResumed:"+activity::class.simpleName)
        ++resumed
        ReumseLifeActivity = activity
        onNowActivity(ReumseLifeActivity!!)
    }

    abstract fun onNowActivity(activity:Activity)
}