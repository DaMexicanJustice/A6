package dk.cphbusiness.template;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        message = (TextView)findViewById(R.id.message);
        message.setText("A Java Activity");
        Button toastButton = (Button)findViewById(R.id.toastButton);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRingtone();
                }
            } );
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

    }
