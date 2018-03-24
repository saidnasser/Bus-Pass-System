package com.example.hossamelzhar.egyptbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    String Usr="Hossam Elzhar";
    String Pass="H12345";
    public void butnclk(View view) {
        EditText txtusr=(EditText)findViewById(R.id.editText);
        EditText txtpass=(EditText)findViewById(R.id.editText2);
        TextView txt=(TextView)findViewById(R.id.textView);
        Intent i=new Intent(this,Main2Activity.class);
        Bundle b=new Bundle();
        b.putString("user",txtusr.getText().toString());
        b.putString("pass",txtpass.getText().toString());
        i.putExtras(b);
        if(Usr.equals(txtusr.getText().toString())&&Pass.equals(txtpass.getText().toString()))
            startActivity(i);
        else if(txt.getText().toString().equals("User Name"))
            Toast.makeText(this,"User Name OR Password is WRONG",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"اسم المستخدم أو كلمة المرور خطأ",Toast.LENGTH_LONG).show();
    }
}
