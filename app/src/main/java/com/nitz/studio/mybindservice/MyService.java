package com.nitz.studio.mybindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by poddarn on 9/19/16.
 */
public class MyService extends Service {

    private final IBinder mBinder  =  new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    public void printMessage(){
        Toast.makeText(MyService.this, "Service method started", Toast.LENGTH_LONG).show();
        for (long i=0; i < 1000000; i++){

        }
        Toast.makeText(MyService.this, "Finished", Toast.LENGTH_SHORT).show();
    }
}
