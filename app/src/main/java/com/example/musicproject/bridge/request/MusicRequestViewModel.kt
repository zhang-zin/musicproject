package com.example.musicproject.bridge.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicproject.data.bean.TestAlbum
import com.example.musicproject.data.repository.HttpRequestManager

class MusicRequestViewModel : ViewModel() {

    val musicsLiveData = MutableLiveData<TestAlbum>()

    fun requestMusics() {
        HttpRequestManager.getFreeMusic(musicsLiveData)
    }
}