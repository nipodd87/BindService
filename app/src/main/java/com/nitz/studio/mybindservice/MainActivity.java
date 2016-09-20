package com.nitz.studio.mybindservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private MyService mService;
    private boolean status;
    private ServiceConnection sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MyService.LocalBinder binder = (MyService.LocalBinder) iBinder;
                mService = binder.getService();
                status=true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
    }

    public void onBindClick(View view){
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, sc, Context.BIND_AUTO_CREATE);
        status=true;

    }
    public void onUnbindClick(View view){
        if (status){
            unbindService(sc);
        } else{
            Toast.makeText(this, "Already Unbinded", Toast.LENGTH_LONG).show();
        }
    }
    public void onStartClick(View view){
        mService.printMessage();
    }


}
