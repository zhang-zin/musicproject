package com.example.musicproject.ui.base

import android.content.Context
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.musicproject.MusicApplication
import com.example.musicproject.bridge.callback.SharedViewModel

open class BaseFragment : Fragment() {

    lateinit var sharedViewModel: SharedViewModel
    lateinit var mActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedViewModel = getAppViewModelProvider().get(SharedViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    fun getAppViewModelProvider(): ViewModelProvider {
        return (mActivity.application as MusicApplication).getAppViewModelProvider()
    }

    fun getFragmentViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, defaultViewModelProviderFactory)
    }

    fun getFragmentViewModelProvider(activity: AppCompatActivity): ViewModelProvider {
        return ViewModelProvider(activity, activity.defaultViewModelProviderFactory)
    }

    fun nav(): NavController {
        return NavHostFragment.findNavController(this)
    }
}