package com.example.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountDown();
    }
    private void CountDown(){
        final TextView textView=findViewById(R.id.textView);
      //  textView.setText("Hello"); Use this to Check for initial checking
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(counter));
                counter--;
                handler.postDelayed(this, 1000);

            }
        });
    }
}
