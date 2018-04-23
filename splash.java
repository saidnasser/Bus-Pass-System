package com.example.hassan.busspass;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    Animation anim1,anim2,anim3;
   private ImageView img1,img2;
   private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        img1=(ImageView)findViewById(R.id.imageView11);
        img2=(ImageView)findViewById(R.id.imageView);
        txt1=(TextView)findViewById(R.id.textView9);

         anim1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hiddenshow);
         anim2=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up_to_down);
         anim3=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hiddenshow);

        img1.startAnimation(anim1);
        img2.setAnimation(anim2);
        txt1.startAnimation(anim3);

        Thread mythread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent spintent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(spintent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();





    }

    public void start(View view) {
    }
}
