package com.example.musicproject.data.bean

import java.io.File

data class DownloadFile(
    var progress: Int = 0,
    var file: File? = null,
    var isForgive: Boolean = false
)
