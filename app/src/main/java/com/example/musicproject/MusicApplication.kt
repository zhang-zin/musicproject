package com.example.musicproject

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.musicproject.player.PlayerManager
import com.zj.architecture.utils.Utils

class MusicApplication : Application(), ViewModelStoreOwner {

    private val mAppViewModelStore: ViewModelStore = ViewModelStore()
    private val mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)

    override fun onCreate() {
        super.onCreate()

        Utils.init(this)

        PlayerManager.init(this)
    }

    override fun getViewModelStore(): ViewModelStore {
        return mAppViewModelStore
    }

    public fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(
            this, mFactory
        )
    }

}