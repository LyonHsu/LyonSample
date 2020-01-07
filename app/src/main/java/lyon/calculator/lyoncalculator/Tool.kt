package lyon.calculator.lyoncalculator

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log

class Tool{
    val TAG=Tool::class.toString()

    fun getVersionCode(context:Context):Int{
        var packageManager:PackageManager = context.packageManager
        var packageInfo = packageManager.getPackageInfo(context.packageName,0)
        var versionCode=packageInfo.versionCode
        return versionCode
    }

    fun getVersionName(context:Context):String{
        var versionName:String

            var packageManager: PackageManager = context.packageManager
            var packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            versionName = packageInfo.versionName

        return versionName
    }

    fun dpToPx(context: Context,dp:Int):Int{
        if(context == null) {
            return -1;
        }
        val scale = context.resources.displayMetrics.density
        var px =  ((dp * scale + 0.5f).toInt())
        Log.d(TAG,"dpToPx:"+px)
        return px

    }
}