package lyon.music.lyonsample2.Demo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 * MyDataObjModel1 類別繼承了 BaseObservable 類別，在其中我們定義了兩個參數，
 * 分別是 text 以及 color，並定義了針對這兩個參數的 get 與 set 方法，這邊要注意的是，
 * 我們在 get 方法前面有標註了 @Bindable，這代表著這個 get 方法定義完成以後，
 * 系統會根據這個方法的名稱自動產生取值的參數名稱(getAlias() 會自動產生 alias 參數名稱)，
 * BR 類亦會自動生成(名字與參數名稱一致)；set 方法則可以由我們自行定義，
 * 並在 set 方法的最後加入 notifyPropertyChanged(BR.title) 方法通知 View 更新。
 */

class MyDataObjModel1 : BaseObservable() {
    private var text: String? = null
    private var color = 0

    @get:Bindable
    var alias: String?
        get() = text
        set(mText) {
            text = mText
            //notifyPropertyChanged(com.example.xylon.databingsample.BR.alias)//通知 View 更新。
        }

    @get:Bindable
    var backgroundColor: Int
        get() = color
        set(mColor) {
            color = mColor
            //notifyPropertyChanged(com.example.xylon.databingsample.BR.backgroundColor)//通知 View 更新。
        }

}