package lyon.music.lyonsample2.ui.main

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lyon.music.lyonsample2.ui.main.Model.CountModel
import lyon.music.lyonsample2.ui.main.Model.FloatingBtnModel


class MainViewModel() : ViewModel() {
    val TAG = this::class.java.simpleName
    val countModel = CountModel()
    var count: ObservableInt? = null
    var countObject: MutableLiveData<Int> = MutableLiveData()
    var textViewId : ObservableInt? = null
    var floatingBtnModel = FloatingBtnModel(this)

}