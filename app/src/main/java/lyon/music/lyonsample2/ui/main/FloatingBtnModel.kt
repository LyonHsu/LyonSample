package lyon.music.lyonsample2.ui.main

import android.view.View
import com.google.android.material.snackbar.Snackbar

class FloatingBtnModel {

    fun floatingButtonCLick(view: View) {
        Snackbar.make(view, "你點擊了float按鈕！！", Snackbar.LENGTH_LONG)
            .setAction("動作", null).show()
    }
}