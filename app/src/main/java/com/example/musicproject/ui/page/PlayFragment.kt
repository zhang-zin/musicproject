package com.example.musicproject.ui.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.musicproject.R
import com.example.musicproject.bridge.state.PlayerViewModel
import com.example.musicproject.databinding.FragmentPlayBinding
import com.example.musicproject.ui.base.BaseFragment
import com.example.musicproject.ui.view.PlayerSlideListener
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class PlayFragment : BaseFragment() {

    lateinit var playerViewModel: PlayerViewModel
    lateinit var binding: FragmentPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playerViewModel = getFragmentViewModelProvider().get(PlayerViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_play, container, false)
        binding.lifecycleOwner = this
        binding.vm = playerViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.timeToAddSlideListener.observe(viewLifecycleOwner, Observer {
            if (view.parent.parent is SlidingUpPanelLayout) {
                val parent = view.parent.parent as SlidingUpPanelLayout
                parent.addPanelSlideListener(PlayerSlideListener(binding, parent))
            }
        })
    }

}