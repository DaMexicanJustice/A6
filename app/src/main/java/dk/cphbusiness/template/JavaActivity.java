package dk.cphbusiness.template;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class JavaActivity extends Activity {

    private TextView message;
    private MediaRecorder mRecorder;
    private String mFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        message = (TextView)findViewById(R.id.playing);
        message.setText("A Java Activity");
        Button toastButton = (Button)findViewById(R.id.toastButton);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRingtone();
                }
            } );
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";
        }

    public void showKotlinClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        }

    public void startMusicRaw() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.bomberman);
        mediaPlayer.start();
    }

    public void startRingtone() {
        Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        MediaPlayer mp = MediaPlayer.create(this, ringtoneUri);
        mp.start();
    }

    public void startMusicSD() throws IOException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        File path = android.os.Environment.getExternalStorageDirectory();
        mediaPlayer.setDataSource(path + "urmp3filename");
    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {

        }

        mRecorder.start();
    }

    }
