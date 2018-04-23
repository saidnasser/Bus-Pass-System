package com.example.hassan.busspass;

import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;

public class Main5Activity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    Spinner sp1, sp2;
    ArrayAdapter<CharSequence> arrivearray;
    ArrayAdapter<CharSequence> departarray;

    Button b;
    TableLayout tableLayout;

    private String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //invisible tablelayout
        b = (Button) findViewById(R.id.button10);
        tableLayout = (TableLayout) findViewById(R.id.table);
        tableLayout.setVisibility(tableLayout.INVISIBLE);


        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);

        arrivearray = ArrayAdapter.createFromResource(this, R.array.arrivestations, R.layout.spinner_item2);
        departarray = ArrayAdapter.createFromResource(this, R.array.departstations, R.layout.spinner_item);
        arrivearray.setDropDownViewResource(R.layout.spinner_item);
        departarray.setDropDownViewResource(R.layout.spinner_item);
        sp1.setPrompt(Integer.toString(R.string.selectstation));
        sp1.setAdapter(arrivearray);
        sp2.setAdapter(departarray);


        //listener for spinners


    }


    public void show(View view) {


        if ((sp1.getSelectedItemPosition()==0 || sp2.getSelectedItemPosition()==0)) {


            tableLayout.setVisibility(tableLayout.INVISIBLE);

        }
        else if(sp1.getSelectedItemPosition()==sp2.getSelectedItemPosition()){
            tableLayout.setVisibility(tableLayout.INVISIBLE);


        }
        else{
            tableLayout.setVisibility(tableLayout.VISIBLE);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {







    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void swap(View view) {

        int temp=0;

        temp=sp1.getSelectedItemPosition();
        sp1.setSelection(sp2.getSelectedItemPosition());
        sp2.setSelection(temp);

    }
}