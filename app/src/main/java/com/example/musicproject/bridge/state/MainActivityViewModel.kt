package com.example.musicproject.bridge.state

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * MainActivity的viewModel，控制抽屉的开关
 */
class MainActivityViewModel : ViewModel() {

    val openDrawer = MutableLiveData<Boolean>()

    val allowDrawerOpen = MutableLiveData<Boolean>()

    init {
        allowDrawerOpen.value = true
    }

}