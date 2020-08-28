package com.example.musicproject.player

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.musicproject.data.bean.TestAlbum
import com.example.musicproject.data.bean.TestMusic
import com.kunminx.player.PlayerController
import com.kunminx.player.bean.base.BaseAlbumItem
import com.kunminx.player.bean.base.BaseArtistItem
import com.kunminx.player.bean.base.BaseMusicItem
import com.kunminx.player.bean.dto.ChangeMusic
import com.kunminx.player.bean.dto.PlayingMusic
import com.kunminx.player.contract.IPlayController
import com.kunminx.player.contract.IServiceNotifier

object PlayerManager : IPlayController<TestAlbum, TestMusic> {

    private val mController = PlayerController<TestAlbum, TestMusic>()
    private lateinit var mContext: Context

    fun init(context: Context) {
        init(context, null)
    }

    override fun init(context: Context, iServiceNotifier: IServiceNotifier?) {
        mContext = context.applicationContext
        mController.init(mContext, null) {
            if (it) {

            }
        }
    }


    override fun clear() {

    }

    override fun requestLastPlayingInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayModeLiveData(): MutableLiveData<Enum<out Enum<*>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAlbum(musicAlbum: TestAlbum?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadAlbum(musicAlbum: TestAlbum?, playIndex: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setChangingPlayingMusic(changingPlayingMusic: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeMode() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playAudio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playAudio(albumIndex: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPlayingMusicLiveData(): MutableLiveData<PlayingMusic<BaseArtistItem, BaseAlbumItem<*, *>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPauseLiveData(): MutableLiveData<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAlbum(): BaseAlbumItem<out BaseMusicItem<*>, *> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playAgain() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPaused(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPlaying(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRepeatMode(): Enum<out Enum<*>> {
        return mController.repeatMode
    }

    override fun getChangeMusicLiveData(): MutableLiveData<ChangeMusic<BaseAlbumItem<*, *>, BaseMusicItem<*>, BaseArtistItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setSeek(progress: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAlbumIndex(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playPrevious() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resumeAudio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pauseAudio() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInited(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAlbumMusics(): MutableList<Any?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentPlayingMusic(): BaseMusicItem<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun togglePlay() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playNext() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTrackTime(progress: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}