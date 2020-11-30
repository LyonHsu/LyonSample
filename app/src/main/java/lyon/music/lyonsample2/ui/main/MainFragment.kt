package lyon.music.lyonsample2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import lyon.music.lyonsample2.R
import lyon.music.lyonsample2.databinding.MainFragmentBinding

/**
 * https://www.hangge.com/blog/cache/detail_2294.html
 */
class MainFragment(var mainVieModel:MainVieModel) : Fragment() {
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



}