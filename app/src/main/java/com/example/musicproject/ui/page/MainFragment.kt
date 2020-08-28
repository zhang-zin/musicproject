package com.example.musicproject.ui.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.musicproject.R
import com.example.musicproject.bridge.request.MusicRequestViewModel
import com.example.musicproject.bridge.state.MainActivityViewModel
import com.example.musicproject.bridge.state.MainViewModel
import com.example.musicproject.data.bean.TestMusic
import com.example.musicproject.databinding.AdapterPlayItemBinding
import com.example.musicproject.databinding.FragmentMainBinding
import com.example.musicproject.ui.adapter.SimpleBaseBindingAdapter
import com.example.musicproject.ui.base.BaseFragment

class MainFragment : BaseFragment() {

    lateinit var mainBinding: FragmentMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var musicRequestViewModel: MusicRequestViewModel
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = getFragmentViewModelProvider().get(MainViewModel::class.java)
        musicRequestViewModel =
            getFragmentViewModelProvider().get(MusicRequestViewModel::class.java)
        mainActivityViewModel =
            getFragmentViewModelProvider(activity as AppCompatActivity).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        mainBinding.click = ClickProxy()
        mainBinding.vm = mainViewModel
        return mainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.initTagAndPage.set(true)
        mainViewModel.pageAssetPath.set("https://www.baidu.com/")

        val adapter = object : SimpleBaseBindingAdapter<TestMusic, AdapterPlayItemBinding>(
            context,
            R.layout.adapter_play_item
        ) {
            override fun onSimpleBindItem(
                binding: AdapterPlayItemBinding?,
                item: TestMusic?,
                holder: BaseBindingViewHolder
            ) {
                binding?.run {
                    tvTitle.text = item?.title ?: ""
                    tvArtist.text = item?.artist?.name ?: ""
                    Glide.with(this@MainFragment).load(item?.coverImg).into(ivCover)

                }
            }
        }

        mainBinding.rv.adapter = adapter

        musicRequestViewModel.musicsLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null && it.musics != null) {
                adapter.mList = it.musics
                adapter.notifyDataSetChanged()
            }
        })

        musicRequestViewModel.requestMusics()

    }

    inner class ClickProxy {
        // 当在首页点击 “菜单” 的时候，直接导航到 ---> 菜单的Fragment界面
        fun openMenu() {
            mainActivityViewModel.openDrawer.value = true
        }

        // 当在首页点击 “搜索图标” 的时候，直接导航到 ---> 搜索的Fragment界面
        fun search() {
            nav().navigate(R.id.action_mainFragment_to_searchFragment)
        }
    }

}