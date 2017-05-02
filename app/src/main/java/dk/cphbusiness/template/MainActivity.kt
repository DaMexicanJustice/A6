package dk.cphbusiness.template

import android.app.Activity
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.media.RingtoneManager
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick
import java.io.File


class MainActivity : Activity() {

    lateinit var mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toastButton.onClick { startMusic()}
        playSMSButton.onClick { startRingtone() }
        killButton.onClick { mp.stop() }
        recordingButton.onClick { startRecording() }

        }

    fun startMusic() {
        mp = MediaPlayer.create(this, R.raw.bomberman)
        mp.start()
    }

    fun startRingtone() {
        val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        mp = MediaPlayer.create(this, ringtoneUri)
        mp.start()
    }

    fun startMusicSD() {
        mp = MediaPlayer()
        val path = android.os.Environment.getExternalStorageDirectory()
        mp.setDataSource(path.toString() + "urmp3filename")
    }

    fun startRecording() {
        val dir = Environment.getExternalStorageDirectory()

        val audioFile = File.createTempFile("sound", ".3gp", dir)

        val recorder = MediaRecorder()
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        recorder.setOutputFile(audioFile.absolutePath)
        recorder.prepare();
        recorder.start();
    }

    }
