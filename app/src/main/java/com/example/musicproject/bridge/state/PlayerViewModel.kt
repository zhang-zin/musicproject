package com.example.musicproject.bridge.state

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.musicproject.R
import com.example.musicproject.player.PlayerManager
import com.kunminx.player.PlayingInfoManager
import com.zj.architecture.utils.Utils
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class PlayerViewModel : ViewModel() {

    // 歌曲名称
    val title = ObservableField<String>()

    // 歌手
    val artist = ObservableField<String>()

    // 歌曲封面地址
    val coverImg = ObservableField<String>()

    // 歌曲正方形图片
    val placeholder = ObservableField<Drawable>()

    // 歌曲总时长
    val maxSeekDuration = ObservableInt()

    // 当前播放进度
    val currentSeekPosition = ObservableInt()

    // 播放状态
    val isPlaying = ObservableBoolean()

    // 播放状态图标改变
    val playModeIcon = ObservableField<MaterialDrawableBuilder.IconValue>()

    init {
        title.set(Utils.getApp().getString(R.string.app_name))
        artist.set(Utils.getApp().getString(R.string.app_name))
        placeholder.set(Utils.getApp().resources.getDrawable(R.mipmap.bg_album_default))
//        when (PlayerManager.repeatMode) {
//            PlayingInfoManager.RepeatMode.LIST_LOOP -> {
//                // 列表循环
//                playModeIcon.set(MaterialDrawableBuilder.IconValue.REPEAT)
//            }
//
//            PlayingInfoManager.RepeatMode.ONE_LOOP -> {
//                // 单曲循环
//                playModeIcon.set(MaterialDrawableBuilder.IconValue.REPEAT_ONCE)
//            }
//            else -> {
//                // 随机播放
//                playModeIcon.set(MaterialDrawableBuilder.IconValue.SHUFFLE)
//            }
//        }
        playModeIcon.set(MaterialDrawableBuilder.IconValue.SHUFFLE)
    }
}