package lyon.music.lyonsample2.ui.main.Model

import android.view.View
import androidx.databinding.ObservableInt
import com.google.android.material.snackbar.Snackbar
import lyon.music.lyonsample2.LogL
import lyon.music.lyonsample2.ui.main.MainViewModel

class FloatingBtnModel(var mainVieModel: MainViewModel) {
    val TAG = this::class.java.simpleName
    var count =0;
    fun floatingButtonCLick(view: View) {
        //var count = (mainVieModel.countObject?.value ?: 0).toInt()
        mainVieModel.countObject?.value=count++
        LogL.d(TAG,"20201204 countModel count :"+mainVieModel.countObject?.value)
    }
}