package com.example.hassan.busspass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView t=(TextView) findViewById(R.id.textView3);

        Bundle b=getIntent().getExtras();
        String user=b.getString("username");
        String pass=b.getString("password");
        t.setText("username :" +  user +" " + "password :"+pass);

    }

}
