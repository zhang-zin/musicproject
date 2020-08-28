package com.example.musicproject

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.musicproject.bridge.state.MainActivityViewModel
import com.example.musicproject.databinding.ActivityMainBinding
import com.example.musicproject.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainActivityViewModel
    private var isListened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = getActivityViewModelProvider().get(MainActivityViewModel::class.java)
//        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        mainBinding.lifecycleOwner = this
//        mainBinding.vm = mainViewModel
        setContentView(R.layout.activity_main)
    }

    /**
     * 详情看：https://www.cnblogs.com/lijunamneg/archive/2013/01/19/2867532.html
     * 这个onWindowFocusChanged指的是这个Activity得到或者失去焦点的时候 就会call。。
     * 也就是说 如果你想要做一个Activity一加载完毕，就触发什么的话 完全可以用这个！！！
     *  entry: onStart---->onResume---->onAttachedToWindow----------->onWindowVisibilityChanged--visibility=0---------->onWindowFocusChanged(true)------->
     * @param hasFocus
     */
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (!isListened) {
            sharedViewModel.timeToAddSlideListener.value = true
            isListened = true
        }
    }

    /*   override fun onBackPressed() {
           // TODO: 2020/8/26
       }*/
}