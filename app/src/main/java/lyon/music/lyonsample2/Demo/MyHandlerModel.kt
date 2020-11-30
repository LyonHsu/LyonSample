package lyon.music.lyonsample2.Demo

import android.app.Activity
import android.view.View
import android.widget.Toast


class MyHandlerModel(var mainActivity: Activity) {

    fun onClick(view: View?) {
        Toast.makeText(mainActivity, "onClick pressed.", Toast.LENGTH_LONG).show()
    }

}