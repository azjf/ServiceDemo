package org.example.servicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG = "MyService";
    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate() executed");
        Log.d("MyService", "MyService thread id is " + Thread.currentThread().getId());

        /*Notification notification = new Notification(R.mipmap.ic_launcher,
                "Notification test", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        notification.setLatestEventInfo(this, "Caption", "Content",
                pendingIntent);
        startForeground(1, notification);*/
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }



    class MyBinder extends Binder {
        public void startDownload() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("TAG", "startDownload() executed");
                }
            }).start();
        }
    }
}