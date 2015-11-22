package com.example.lt413.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    private boolean runningService = false;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(getApplicationContext(),"startCommand",Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);

    }
    @Override
    public void onCreate() {
        super.onCreate();
        runningService = true;
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(runningService) {
                    System.out.println("服务正在运行");
                    try{
                        sleep(1000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }


        }.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
        runningService=false;
    }
}
