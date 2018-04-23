package com.example.hassan.busspass;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main6Activity extends AppCompatActivity implements TextWatcher {
    private EditText ed1;
    private EditText ed2;
    private Button btn;
    private TextWatcher textwatcher=null;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        btn=(Button)findViewById(R.id.button8);
        ed1=(EditText)findViewById(R.id.editText10);
        ed2=(EditText)findViewById(R.id.editText12);
        ed1.addTextChangedListener(this);
        ed2.addTextChangedListener(this);

        ed1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               ed2.setEnabled(false);
               return false;
            }


        });

        ed2.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ed1.setEnabled(false);
                return false;
            }


        });








    }

    //button
    public void verify(View view) {
        myintent=new Intent(this,Main7Activity.class);
        startActivity(myintent);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String email=ed1.getText().toString();
        String num=ed2.getText().toString();
        if(isValidEmail(email))
        {
           btn.setEnabled(true);
        }
        else if(num.length()==11){

            btn.setEnabled(true);
        }


    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    //function for valodation email
    public static boolean isValidEmail(String email)
    {
        String expression = "^[\\w\\.]+@([\\w]+\\.)+[A-Z]{2,7}$";
        CharSequence inputString = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches())
        {
            return true;
        }
        else{
            return false;
        }
    }
}

