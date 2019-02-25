package com.first.rcare;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Attributemood extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attributemood);
        Fragment f11=fmood.newInstance ("","");
        setme(f11);
        b1=(Button)findViewById(R.id.verygood);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),workandlesiure.class);
                startActivity(intent);

            }
        });

    }
    private void setme(Fragment f11) {
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.framemood,f11);
        ft.commit();
    }
}
