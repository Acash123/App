package com.example.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int countDown = 99;
    private static final String CURRENT_COUNTER = "countDown" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            countDown = savedInstanceState.getInt(CURRENT_COUNTER);
        }

        CountDown();

    }
    // 11-03-2019
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState );
        savedInstanceState.putInt(CURRENT_COUNTER,countDown);
    }

    private void CountDown(){
        final TextView textView=findViewById(R.id.textView);
      //  textView.setText("Hello"); Use this to Check for initial checking
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(countDown));
               // If u put the if condition in here U'll have to replace -1 with 0
                countDown--;
                handler.postDelayed(this, 1000);
                //---
                if(countDown==-1){
                    countDown=100; // Resetting the Counter
                }


            }
        });
    }
}
