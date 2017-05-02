package dk.cphbusiness.template

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick

class MainActivity : Activity() {

    lateinit var mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "A Kotlin Activity"
        toastButton.onClick { startMusic()}
        }

    fun startMusic() {
        mp = MediaPlayer.create(this, R.raw.bomberman)
        mp.start()
    }

    fun showJavaClicked(view: View) {
        startActivity(Intent(this, JavaActivity::class.java))
        }

    fun startRingtone() {
        val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        mp = MediaPlayer.create(this, ringtoneUri)
        mp.start()
    }

    fun startMusicSD() {
        mp = MediaPlayer()
        val path = android.os.Environment.getExternalStorageDirectory()
        mp.setDataSource(path.toString() + "urmp3filename")
    }

    }
