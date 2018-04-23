package com.example.hassan.busspass;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  {
    Intent myintent;
    Bundle b;
    Dialog mydialog;
    private EditText editTextemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadlocale();
        setContentView(R.layout.activity_main);

        //change language of actionbar

        /*android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        */

        mydialog=new Dialog(this);
        }


    //creating menu

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mymenu=getMenuInflater();
       mymenu.inflate(R.menu.main_activity_menu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        //change language
        if(id==R.id.language){

            showChangeLanguageDialog();

        }

        if (id==R.id.exit){
            finish();
            System.exit(0);

        }


        return super.onOptionsItemSelected(item);


    }
    */

    //function to change language

    private void showChangeLanguageDialog() {

        final String[] listitems={"Arabic","English","French"};
        final AlertDialog.Builder mbiulder=new AlertDialog.Builder(MainActivity.this);
        mbiulder.setTitle("Choose Language");
        mbiulder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                if(i==0){

                    setLocale("ar");
                    recreate();

                }
                else if(i==1){

                    setLocale("en");
                    recreate();
                }
                else if(i==2){
                    setLocale("fr");
                    recreate();

                }

            }
        });
        AlertDialog mdialog=mbiulder.create();
        mdialog.show();


    }

    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }

    public void loadlocale(){

        SharedPreferences prefs=getSharedPreferences("settings",MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }



    public void login(View view) {
        EditText txtuser=(EditText)findViewById(R.id.editText2);
        EditText txtpass=(EditText)findViewById(R.id.editText3);

        String email = txtuser.getText().toString();
        if(!(isValidEmail(email)))
        {
            txtuser.setError(getString(R.string.email2));
            txtuser.requestFocus();
            return;
        }

        if(txtpass.length()==0){
           txtpass.setError(getString(R.string.item)+" "+txtpass.getHint().toString()+getString(R.string.item2));
            txtpass.requestFocus();
            return;

        }

        myintent=new Intent(this,Main2Activity.class);
        b=new Bundle();
        b.putString("username",txtuser.getText().toString());
        b.putString("password",txtpass.getText().toString());
        myintent.putExtras(b);
        startActivity(myintent);

    }

    public void createaccount(View view) {
        myintent=new Intent(this,Main3Activity.class);
        startActivity(myintent);

    }

    public void taketour(View view) {
        myintent=new Intent(this,Main5Activity.class);
        startActivity(myintent);
    }

    public void forget(View view) {
        myintent=new Intent(this,Main6Activity.class);
        startActivity(myintent);

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


    public void changelanguage(View view) {
        showChangeLanguageDialog();

    }

    public void exitapp(View view) {
        finish();
        System.exit(0);
    }
}
