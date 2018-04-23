package com.example.hassan.busspass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtv=(TextView) findViewById(R.id.textView2);
        Bundle b=getIntent().getExtras();
        String firstname=b.getString("firstname");
        String lastname=b.getString("lastname");
        txtv.setText("Hello"+firstname+""+lastname+"In Your New Account In BussPass Application .");
    }

}
