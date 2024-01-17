package com.example.create_start_stop_servies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(view -> {

            Intent intent = new Intent(this, TimerService.class);

            /*
                When start button is clicked then service is started by the help of intent and startService() function.
                onStartCommand IS called when we start service button.
            */
            startService(intent);

        });

        btn_stop.setOnClickListener(view -> {

            /*
            When we click btn_stop then onDestroy() function in the service is called.

             */
            Intent i = new Intent(this, TimerService.class);
            stopService(i);

        });
    }
}