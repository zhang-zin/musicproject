package com.example.musicproject.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.musicproject.data.bean.DownloadFile
import com.example.musicproject.data.bean.LibraryInfo
import com.example.musicproject.data.bean.TestAlbum

interface IRemoteRequest {

    fun getFreeMusic(liveData: MutableLiveData<TestAlbum>)

    fun getLibraryInfo(liveData: MutableLiveData<LibraryInfo>)

    fun downloadFile(liveData: MutableLiveData<DownloadFile>)
}