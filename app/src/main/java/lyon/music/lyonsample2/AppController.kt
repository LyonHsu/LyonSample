package lyon.music.lyonsample2

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log


var DeBug:Boolean=false
class AppController : Application(){
    val TAG = this::class.java.simpleName
    var appController: AppController = this
    lateinit var appLifecycleListener: AppLifecycleListener
    lateinit var activityLifecycleCallbacks:ActivityLifecycleCallbacks
    var nowActivity: Activity? = null
    override fun onCreate() {
        super.onCreate()
        this.appController = this
        val DeBug = getAppMetaDataBoolean(appController, "isDeBug", false)
        setLDeBug(DeBug)
        activityLifecycleCallbacks =  object: ActivityLifeCycleCallback() {
            override fun onNowActivity(activity: Activity) {
                nowActivity = activity;
            }

        }
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
        Log.e(TAG,"onCreate isDeBug:"+DeBug)
    }

    @Synchronized
    fun getInstance(): AppController? {
        return this.appController
    }

    fun getNowActivity(function: () -> Unit): Activity? {
        return nowActivity
    }


    private fun getAppMetaDataBoolean(
        context: Context,
        metaName: String,
        defaultValue: Boolean
    ): Boolean {
        try { //application标签下用getApplicationinfo，如果是activity下的用getActivityInfo
            val packageManager = context.packageManager
            val applicationInfo = packageManager.getApplicationInfo(context.packageName,PackageManager.GET_META_DATA)
            val metaData =  applicationInfo.metaData
            val value =metaData.getBoolean(metaName, defaultValue)
            if(value)
                print("isDeBug meta-data         $metaName = $value")
            return value
        } catch (e: Exception) {
            Log.e(TAG,"isDeBug:"+Tool.FormatStackTrace(e))
            return defaultValue
        }
    }

    fun getLDeBug(): Boolean {
        return  DeBug as Boolean
    }

    fun setLDeBug(dsBug:Boolean){
        DeBug=dsBug
    }
}


