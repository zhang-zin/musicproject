package com.example.musicproject.ui.base

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.example.musicproject.MusicApplication
import com.example.musicproject.bridge.callback.SharedViewModel
import com.zj.architecture.data.manager.NetworkStateManager
import com.zj.architecture.utils.AdaptScreenUtils
import com.zj.architecture.utils.BarUtils
import com.zj.architecture.utils.ScreenUtils

open class BaseActivity : AppCompatActivity() {

    lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)
        BarUtils.setStatusBarLightMode(this, true)

        sharedViewModel = getAppViewModelProvider().get(SharedViewModel::class.java)
        lifecycle.addObserver(NetworkStateManager.getInstance() as DefaultLifecycleObserver)

    }

    override fun getResources(): Resources {
        return if (ScreenUtils.isPortrait()) {
            AdaptScreenUtils.adaptWidth(super.getResources(), 360)
        } else {
            AdaptScreenUtils.adaptHeight(super.getResources(), 640)
        }
    }

    fun getAppViewModelProvider(): ViewModelProvider {
        return (application as MusicApplication).getAppViewModelProvider()
    }

    fun getActivityViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, defaultViewModelProviderFactory)
    }
}