package com.example.musicproject.bridge.state

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * MainFragment 的ViewModel处理播放列表的显示
 */
class MainViewModel : ViewModel() {
    // ObservableBoolean 防止抖动，频繁改变，使用这个的场景
    // 切换最近播放和最佳实践
    val initTagAndPage = ObservableBoolean()

    // 最佳实践，webView地址
    val pageAssetPath = ObservableField<String>()
}