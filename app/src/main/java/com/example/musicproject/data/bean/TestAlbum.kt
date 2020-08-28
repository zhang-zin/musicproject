package com.example.musicproject.data.bean

import com.kunminx.player.bean.base.BaseAlbumItem
import com.kunminx.player.bean.base.BaseArtistItem
import com.kunminx.player.bean.base.BaseMusicItem

// 专辑 Mid
data class TestAlbum(var albumMid: String? = "") : BaseAlbumItem<TestMusic, TestArtist>()

// 歌曲 Mid
data class TestMusic(var songMid: String? = "") : BaseMusicItem<TestArtist?>()

// 歌手相关
data class TestArtist(var birthday: String? = "") : BaseArtistItem()

