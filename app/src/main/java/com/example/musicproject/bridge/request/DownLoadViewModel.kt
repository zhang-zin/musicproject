package com.example.musicproject.bridge.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicproject.data.bean.DownloadFile
import com.example.musicproject.data.repository.HttpRequestManager

class DownLoadViewModel : ViewModel() {

    val downloadFileLiveData = MutableLiveData<DownloadFile>()
    val downloadFileCanBeStoppedLiveData = MutableLiveData<DownloadFile>()

    fun requestDownloadFile() {
        HttpRequestManager.downloadFile(downloadFileLiveData)
    }
}