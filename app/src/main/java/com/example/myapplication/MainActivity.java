package com.example.myapplication;


import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Toast;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    final boolean[] handan = {true};

    public void right(View v) {

    }

    public void left(View v) {

    }

    private ImageView imageAndroid;

    private SoundPool soundPool;
    private int oto;
    private Button buttonPushMe;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                //USAGE_MEDIA
                //USAGE_GAME
                .setUsage(AudioAttributes.USAGE_GAME)
                //CONTENT_TYPE_MUSIC
                //CONTENT_TYPE_SPEECH, etc.
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                //　ストリーム数に応じて
                .setMaxStreams(2)
                .build();
        oto = soundPool.load(this, R.raw.oto, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d("debug", "sampleId" + sampleId);
                Log.d("debug", "status=" + status);
            }
        });


        buttonPushMe = (Button) findViewById(R.id.button_right);
        imageAndroid = (ImageView) findViewById(R.id.image1);
        buttonPushMe.setOnTouchListener(new ImageView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (handan[0] == false) {
                            Toast myToast = Toast.makeText(
                                    getApplicationContext(),
                                    "操作は無効です。",
                                    Toast.LENGTH_SHORT
                            );
                            myToast.show();
                        }

                }
                if (handan[0] == true) {
                    soundPool.play(oto, 0.0f, 1.0f, 0, 0, 1);
                    imageAndroid.setImageResource(R.drawable.d);

                    handan[0] = false;

                }

                return false;

            }

        });

        buttonPushMe = (Button) findViewById(R.id.button_left);
        imageAndroid = (ImageView) findViewById(R.id.image1);
        buttonPushMe.setOnTouchListener(new ImageView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (handan[0] == false) {
                            Toast myToast = Toast.makeText(
                                    getApplicationContext(),
                                    "操作は無効です。",
                                    Toast.LENGTH_SHORT
                            );
                            myToast.show();
                        }
                }
                if (handan[0] == true) {
                    soundPool.play(oto, 1.0f, 0.0f, 0, 0, 1);
                    imageAndroid.setImageResource(R.drawable.g);
                    handan[0] = false;
                }
                return false;
            }

        });


        buttonPushMe = (Button) findViewById(R.id.modoru);
        imageAndroid = (ImageView) findViewById(R.id.image1);
        buttonPushMe.setOnTouchListener(new ImageView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                imageAndroid.setImageResource(R.drawable.music_handbell);

                handan[0] = true;

                return false;
            }
        });
    }
}