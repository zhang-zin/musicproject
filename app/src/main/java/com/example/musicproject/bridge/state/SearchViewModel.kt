package com.example.musicproject.bridge.state

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val progress = ObservableField<Int>()
}