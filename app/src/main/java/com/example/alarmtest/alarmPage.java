package com.example.alarmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

public class alarmPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_page);

        RingtoneManager.setActualDefaultRingtoneUri(alarmPage.this,RingtoneManager.TYPE_ALARM, Uri.parse("android.resource://com.example.alarmtest/" + R.raw.file_example_mp3_700kb));
        Uri uri = RingtoneManager.getActualDefaultRingtoneUri(alarmPage.this, RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(alarmPage.this, uri);
        if (ringtone != null) {
            ringtone.setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build());
            ringtone.play();
        }
    }
}