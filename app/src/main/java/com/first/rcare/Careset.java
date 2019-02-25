package com.first.rcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Careset extends AppCompatActivity {
    Button byes,bno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_careset);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        byes=(Button)findViewById(R.id.yes);
        bno=(Button)findViewById(R.id.no);
        Fragment f11=Attributeyn.newInstance ("","");
        setme(f11);
        byes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Attributemood.class);
                startActivity(i);
            }
        });
        bno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f11=Attributeyn.newInstance ("","");
                setme(f11);
            }
        });


    }
    private void setme(Fragment f11) {
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.framecare,f11);
        ft.commit();
    }

}
