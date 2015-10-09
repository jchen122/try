package com.example.jiaweichen.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mp;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.



    return null;

    }
    public void onCreate(){
        super.onCreate();
        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();
        mp=MediaPlayer.create(this,R.raw.song);
        mp.start();
    }
    public int onStartCommand(Intent intent, int flags,int startId){
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        mp.start();
        return super.onStartCommand(intent, flags, startId);

    }
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Music Stopped",Toast.LENGTH_LONG).show();
        mp.stop();
    }




}
