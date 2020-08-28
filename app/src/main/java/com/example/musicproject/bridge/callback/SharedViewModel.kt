package com.example.musicproject.bridge.callback

import androidx.lifecycle.ViewModel
import com.zj.architecture.bridge.callback.UnPeekLiveData
import java.util.*

class SharedViewModel : ViewModel() {

    // 存放记录，打开过“搜索界面”就会记录下来，owner.getClass().getSimpleName():SearchFragment / owner.getClass().getSimpleName():SearchFragment
    val TAG_OF_SECONDARY_PAGES: List<String> = ArrayList()

    val timeToAddSlideListener: UnPeekLiveData<Boolean> = UnPeekLiveData()

}