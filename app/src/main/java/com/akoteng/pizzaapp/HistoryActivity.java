package com.akoteng.pizzaapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.akoteng.pizzaapp.adapters.HistoryAdapter;
import com.akoteng.pizzaapp.classes.Pizza;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    //initialize
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    List<Pizza> historyList = new ArrayList<>();

    //log tag
    public static final String LOG_TAG = HistoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("History");

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

        //initialize components
        recyclerView = (RecyclerView) findViewById(R.id.history_recycler_view);

        //functions
        recyclerViewRelated();
        prepareCartData();

    }

    public void recyclerViewRelated(){
        mAdapter = new HistoryAdapter(historyList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void prepareCartData(){

        for(int i = 0; i <= 8; i++){
            Pizza history = new Pizza();
            historyList.add(history);
        }

        mAdapter.notifyDataSetChanged();

    }
}
