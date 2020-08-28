package com.example.musicproject.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.musicproject.R
import com.example.musicproject.data.bean.DownloadFile
import com.example.musicproject.data.bean.LibraryInfo
import com.example.musicproject.data.bean.TestAlbum
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zj.architecture.utils.Utils
import java.util.*

/**
 * 仓库的角色
 */
object HttpRequestManager : ILoadRequest, IRemoteRequest {
    override fun getFreeMusic(liveData: MutableLiveData<TestAlbum>) {
        val gson = Gson()
        val type = object : TypeToken<TestAlbum?>() {}.type
        val testAlbum: TestAlbum =
            gson.fromJson(Utils.getApp().getString(R.string.free_music_json), type)

        // TODO

        liveData.value = testAlbum
    }

    override fun getLibraryInfo(liveData: MutableLiveData<LibraryInfo>) {
    }

    override fun downloadFile(liveData: MutableLiveData<DownloadFile>) {
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                var value = liveData.value
                if (value == null) {
                    value = DownloadFile()
                }

                if (value.progress < 100) {
                    value.progress = value.progress + 1
                } else {
                    timer.cancel()
                    value.progress = 0
                    return
                }

                if (value.isForgive) {
                    timer.cancel()
                    value.progress = 0
                    return
                }

                liveData.postValue(value)
                downloadFile(liveData)
            }
        }
        timer.schedule(task, 100)
    }
}