package com.example.musicproject.player.helper

import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.RemoteControlClient
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import com.example.musicproject.player.notification.PlayerReceiver

class PlayerCallHelper constructor(val playerCallHelperListener: PlayerCallHelperListener) :
    AudioManager.OnAudioFocusChangeListener {

    var ignoreAudioFocus = false
    var tempPause = false
    var isTempPauseByPhone = false

    override fun onAudioFocusChange(focusChange: Int) {
        if (ignoreAudioFocus) {
            ignoreAudioFocus = false
            return
        }

        when (focusChange) {
            AudioManager.AUDIOFOCUS_LOSS -> {
                if (playerCallHelperListener.isPlaying() && !playerCallHelperListener.isPaused()) {
                    playerCallHelperListener.pauseAudio()
                    tempPause = true
                }
            }
            AudioManager.AUDIOFOCUS_GAIN -> {
                if (tempPause) {
                    tempPause = false
                    playerCallHelperListener.playAudio()
                }
            }
        }
    }

    private val phoneStateListener = object : PhoneStateListener() {
        override fun onCallStateChanged(state: Int, phoneNumber: String?) {
            super.onCallStateChanged(state, phoneNumber)
            when (state) {
                TelephonyManager.CALL_STATE_IDLE -> {
                    if (isTempPauseByPhone) {
                        playerCallHelperListener.playAudio()
                        isTempPauseByPhone = false
                    }
                }
                TelephonyManager.CALL_STATE_RINGING -> {
                    if (playerCallHelperListener.isPlaying() && !playerCallHelperListener.isPaused()) {
                        playerCallHelperListener.pauseAudio()
                        isTempPauseByPhone = true
                    }
                }
                TelephonyManager.CALL_STATE_OFFHOOK -> {
                }
            }
        }
    }
    private lateinit var audioManager: AudioManager
    private lateinit var remoteControlClient: RemoteControlClient

    fun bindCallListener(context: Context) {
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    fun bindRemoteController(context: Context) {
        audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val remoteComponentName = ComponentName(context, PlayerReceiver::class.java.name)
        audioManager.registerMediaButtonEventReceiver(remoteComponentName)
        val mediaButtonIntent = Intent(Intent.ACTION_MEDIA_BUTTON)
        mediaButtonIntent.component = remoteComponentName
        val mediaPendingIntent = PendingIntent.getBroadcast(context, 0, mediaButtonIntent, 0)
        remoteControlClient = RemoteControlClient(mediaPendingIntent)
        audioManager.registerRemoteControlClient(remoteControlClient)
        remoteControlClient.setTransportControlFlags(
            RemoteControlClient.FLAG_KEY_MEDIA_PLAY or
                    RemoteControlClient.FLAG_KEY_MEDIA_PAUSE or
                    RemoteControlClient.FLAG_KEY_MEDIA_PLAY_PAUSE or
                    RemoteControlClient.FLAG_KEY_MEDIA_STOP or
                    RemoteControlClient.FLAG_KEY_MEDIA_PREVIOUS or
                    RemoteControlClient.FLAG_KEY_MEDIA_NEXT
        )
    }

    interface PlayerCallHelperListener {

        fun playAudio()

        fun isPlaying(): Boolean

        fun isPaused(): Boolean

        fun pauseAudio()
    }
}