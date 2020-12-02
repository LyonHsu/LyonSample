package lyon.music.lyonsample2.ui.main

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableInt
import lyon.music.lyonsample2.ui.main.Model.CountModel
import lyon.music.lyonsample2.ui.main.Model.FloatingBtnModel


class MainViewModel(val countModel: CountModel) : BaseObservable() {
    val TAG = this::class.java.simpleName
    var count: ObservableInt? = null
    var floatingBtnModel =
        FloatingBtnModel(this)

}