package lyon.music.lyonsample2.ui.main

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableInt
import lyon.music.lyonsample2.LogL
import lyon.music.lyonsample2.Object.CountModel


class MainVieModel(val countModel:CountModel) : BaseObservable() {
    val TAG = this::class.java.simpleName
    var count: ObservableInt? = null
    fun floatingButtonCLick(view:View) {
        LogL.d(TAG,"20201130 countModel count :"+countModel.count)
        countModel.count++
        count=ObservableInt(countModel.count)
        LogL.d(TAG,"20201130 count :"+count)
        notifyChange()
    }
}