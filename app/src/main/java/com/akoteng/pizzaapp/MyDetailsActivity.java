package com.akoteng.pizzaapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.akoteng.pizzaapp.classes.History;

import java.util.ArrayList;
import java.util.List;

public class MyDetailsActivity extends AppCompatActivity {

    //initialize

    //log tag
    public static final String LOG_TAG = MyDetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);

        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("My Details");

        //change color of toolbar actions
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.light_gray), PorterDuff.Mode.SRC_ATOP);

        //change color of toolbar title
        toolbar.setTitleTextColor(getResources().getColor(R.color.gray));

        //when back button is pressed
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();
            }
        });


        //initiliaze components

    }
}
