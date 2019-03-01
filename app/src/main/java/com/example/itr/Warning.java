package com.example.itr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;


import java.util.Random;

public class Warning extends AppCompatActivity {
    String[] syList = {"Jitters/shivering","weak cry", "poor feeding"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                       .setAction("Action", null).show();
//            }
//        });


        ListView symptoms = (ListView) findViewById(R.id.answer);
        ListAdapter myAdapter = new ArrayAdapter<String>(symptoms.getContext(), android.R.layout.simple_list_item_1, syList);
        symptoms.setAdapter(myAdapter);
        symptoms.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                syData(position);


                    }
                }
        );
    }

    protected void onResume(){
        super.onResume();

    }

    public void triggerW(){
        Intent in = new Intent(getBaseContext(),MainActivity.class);
        startActivity(in);
    }

    public void syData(int pos){


        new AlertDialog.Builder(Warning.this)
                .setTitle(syList[pos])
                .setMessage("Are you sure you want to delete this entry?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, null)

                // A null listener allows the button to dismiss the dialog and take no further action.
                //.setNegativeButton(android.R.string.no, null)
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
