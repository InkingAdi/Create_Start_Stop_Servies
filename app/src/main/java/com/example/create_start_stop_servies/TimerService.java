package com.example.create_start_stop_servies;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {

    //To increment the counter by 1
    int counter = 0;


    // A facility for threads to schedule tasks for future execution in a background thread.
    // Tasks may be scheduled for one-time execution, or for repeated execution at regular intervals.
    Timer timer = new Timer();

    public TimerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
          Timer is started when btn_start is clicked and onStartCommand is called.

     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //Display Toast to inform user that Service Started.
        Toast.makeText(this, "Service Started !",Toast.LENGTH_LONG).show();

        //A task that can be scheduled for one-time or repeated execution by a Timer.
        TimerTask tt;
        tt = new TimerTask() {
            @Override
            public void run() {

                //Display Value of counter in Lo Cat Window of Android Studio
                Log.i("MY_SERVICE",String.valueOf(++counter));
            }
        };

        //1000 milliseconds means 1 seconds
        timer.scheduleAtFixedRate(tt,0,1000);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(timer !=null){

            //Terminate the timer
            timer.cancel();

        }

        Toast.makeText(this, "Service Destroyed!",Toast.LENGTH_LONG).show();

    }
}