package com.example.localchat;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class activity_audio extends AppCompatActivity {



    // creating a variable for
    // button and media player
    Button playBtn, pauseBtn;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        // initializing our buttons
        playBtn = findViewById(R.id.idBtnPlay);
        pauseBtn = findViewById(R.id.idBtnPause);

        // setting on click listener for our play and pause buttons.
        playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // calling method to play audio.
                playBeep();
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking the media player
                // if the audio is playing or not.
                if (mp.isPlaying()) {
                    // pausing the media player if media player
                    // is playing we are calling below line to
                    // stop our media player.
                    mp.stop();
                    mp.reset();
                    mp.release();

                    // below line is to display a message
                    // when media player is paused.
                    Toast.makeText(activity_audio.this, "Audio has been paused", Toast.LENGTH_SHORT).show();
                } else {
                    // this method is called when media
                    // player is not playing.
                    Toast.makeText(activity_audio.this, "Audio has not played", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void playBeep() {
        try {
            mp = new MediaPlayer();
            AssetFileDescriptor descriptor = getAssets().openFd("asd.mp3");
            mp.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mp.prepare();
            mp.setVolume(1f,1f);
            mp.setLooping(false);
            mp.start();
            Thread.sleep(500);
            mp.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}