package com.example.musicproject.player.notification

import android.media.browse.MediaBrowser
import android.media.session.MediaSession
import android.media.session.PlaybackState
import android.os.Bundle
import android.service.media.MediaBrowserService


class PlayerService : MediaBrowserService() {

    // 媒体会话，受控端
    private lateinit var mediaSession: MediaSession
    //PlaybackState的构建
    private val mState: PlaybackState = PlaybackState.Builder()
        .setState(PlaybackState.STATE_NONE, 0, 1.0f) //三个参数分别是，状态，位置，播放速度
        .build()

    override fun onCreate() {
        mediaSession = MediaSession(this, "PlayerService")
        mediaSession.setCallback(mCallback)
        mediaSession.setPlaybackState(mState)
        sessionToken = mediaSession.sessionToken
        super.onCreate()
    }

    override fun onLoadChildren(p0: String, p1: Result<MutableList<MediaBrowser.MediaItem>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot? {
        // 第一个参数为客户端的packageName，
        // 第二个参数为Uid
        // 第三个参数是从客户端传递过来的Bundle。
        // 通过以上参数来进行判断，若同意连接，则返回BrowserRoot对象，否则返回null;
        return BrowserRoot("MyMedia", null)
    }

    private val mCallback = object : MediaSession.Callback() {
        override fun onPlay() {
            super.onPlay()
        }

        override fun onPause() {
            super.onPause()
        }


    }


}
