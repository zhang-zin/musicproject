package com.example.musicproject.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.musicproject.R
import com.example.musicproject.bridge.request.DownLoadViewModel
import com.example.musicproject.bridge.state.SearchViewModel
import com.example.musicproject.databinding.FragmentSearchBinding
import com.example.musicproject.ui.base.BaseFragment

class SearchFragment : BaseFragment() {

    lateinit var searchBinding: FragmentSearchBinding
    lateinit var searchViewModel: SearchViewModel
    lateinit var downLoadViewModel: DownLoadViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchViewModel = getFragmentViewModelProvider().get(SearchViewModel::class.java)
        downLoadViewModel =
            getFragmentViewModelProvider(mActivity).get(DownLoadViewModel::class.java)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            nav().navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        searchBinding.lifecycleOwner = this
        searchBinding.executePendingBindings()
        searchBinding.click = ClickProxy()
        searchBinding.vm = searchViewModel
        return searchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        downLoadViewModel.downloadFileLiveData.observe(viewLifecycleOwner, Observer {
            searchViewModel.progress.set(it.progress)
        })
    }

    inner class ClickProxy {

        fun back() {
            nav().navigateUp()
        }

        // 测试下载，离开页面即中止
        fun testLifecycleDownload() {
            downLoadViewModel.requestDownloadFile()
        }

        // 测试下载，返回页面依然有效
        fun testDownload() {
            downLoadViewModel.requestDownloadFile()
        }
    }
}