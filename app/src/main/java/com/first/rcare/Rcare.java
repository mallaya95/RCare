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
import android.widget.TextView;

import static com.first.rcare.R.drawable.corner;

public class Rcare extends AppCompatActivity {
    Button b1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcare);
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
//        Fragment f11=ChatActivity.newInstance ("","");
//        setme(f11);
//        try {
//            Thread.sleep(2000);
//
//        }
//        catch (Exception e){}
        textView=(TextView)findViewById(R.id.textView);
//        textView.
//        textView.setText("Hi! Lets get acquainted!    ");


        b1=(Button)findViewById(R.id.rok);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),Basicdata.class);
                startActivity(i);
            }
        });

    }

//    private void setme(Fragment f11) {
//        FragmentManager fm =getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.addToBackStack(null);
//        ft.replace(R.id.frame,f11);
//        ft.commit();
//    }

}
