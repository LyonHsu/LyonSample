package lyon.music.lyonsample2.ui.main.Model

import android.view.View
import androidx.databinding.ObservableInt
import com.google.android.material.snackbar.Snackbar
import lyon.music.lyonsample2.LogL
import lyon.music.lyonsample2.ui.main.MainViewModel

class FloatingBtnModel(var mainVieModel: MainViewModel) {
    val TAG = this::class.java.simpleName
    fun floatingButtonCLick(view: View) {
        var countModel = mainVieModel.countModel
        LogL.d(TAG,"20201130 countModel count :"+countModel.count)
        countModel.count++
        mainVieModel.count = ObservableInt(countModel.count)
        mainVieModel.notifyChange()
    }
}