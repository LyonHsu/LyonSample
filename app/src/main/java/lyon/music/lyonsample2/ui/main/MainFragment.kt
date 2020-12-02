package lyon.music.lyonsample2.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import lyon.music.lyonsample2.LogL
import lyon.music.lyonsample2.R
import lyon.music.lyonsample2.databinding.MainFragmentBinding
import org.json.JSONArray

/**
 * https://www.hangge.com/blog/cache/detail_2294.html
 */
class MainFragment(var mainVieModel:MainViewModel) : Fragment() {
    val TAG = "MainFragment"

    lateinit var viewDataBinding:MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false
        )

        viewDataBinding.mainViewModel = mainVieModel
        var view = viewDataBinding.root
        return view
    }

    override fun onConfigurationChanged(configuration: Configuration) {
        super.onConfigurationChanged(configuration)
        //获取屏幕方向
        val l = Configuration.ORIENTATION_LANDSCAPE
        val p = Configuration.ORIENTATION_PORTRAIT

        if (configuration.orientation == l) {
            LogL.e(TAG, "现在是横屏")

        }
        if (configuration.orientation == p) {
            LogL.e(TAG, "现在是竖屏")

        }
    }

}