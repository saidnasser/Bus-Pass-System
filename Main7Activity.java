package com.example.hassan.busspass;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Main7Activity extends AppCompatActivity {

    private TextView txt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        txt1=(TextView)findViewById(R.id.textView14);

        new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                txt1.setText(""+String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));


                //should count till message recieved then cancel (missed step )
            }

            public void onFinish() {
                txt1.setText("done!");
            }

        }.start();
    }

    public void resend(View view) {
    }
}
