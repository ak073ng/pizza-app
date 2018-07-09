package com.akoteng.pizzaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.akoteng.pizzaapp.adapters.PizzaAdapter;
import com.akoteng.pizzaapp.classes.Constants;
import com.akoteng.pizzaapp.classes.Pizza;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //initialize
    TextView tv_change_location, tv_show_location;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    List<Pizza> pizzaList = new ArrayList<>();

    //keys
    public final String CITY_NAME_KEY = "username";
    public final String AREA_NAME_KEY = "password";

    //log tag
    public static final String LOG_TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize components
        tv_change_location = (TextView)findViewById(R.id.tv_change_location);
        tv_change_location.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        //functions
        assignLocationValues();

        //creating and populating recycler view
        recyclerViewRelated();
        preparePizzaData();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundColor(getResources().getColor(R.color.green));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_cart_from_fab = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(to_cart_from_fab);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //set user name and email to view
        View headerView = navigationView.getHeaderView(0);
        TextView navUserName = (TextView) headerView.findViewById(R.id.user_name_tv);
        TextView navUserEmail = (TextView) headerView.findViewById(R.id.user_email_tv);

        //initialize shared preference
        SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);

        String user_name = pref.getString(Constants.FIRSTNAME, null) + " " + pref.getString(Constants.SURNAME, null);
        String user_email = pref.getString(Constants.EMAIL, null);

        navUserName.setText(user_name);
        navUserEmail.setText(user_email);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cart) {
            Intent to_cart_from_nav = new Intent(this, CartActivity.class);
            startActivity(to_cart_from_nav);
        } else if (id == R.id.nav_order) {

        } else if (id == R.id.nav_history) {
            Intent to_history = new Intent(this, HistoryActivity.class);
            startActivity(to_history);
        } else if (id == R.id.nav_details) {
            Intent to_my_details = new Intent(this, MyDetailsActivity.class);
            startActivity(to_my_details);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_change_location:
                Intent to_enter_location = new Intent(this, EnterLocationActivity.class);
                startActivity(to_enter_location);
                break;
        }
    }

    public void assignLocationValues(){

        //home app bar
        TextView show_city = (TextView)findViewById(R.id.tv_show_city);
        TextView show_location = (TextView)findViewById(R.id.tv_show_location);

        //initialize shared preference
        SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);

        //get city and location from preference and store in variable
        String user_city = pref.getString(Constants.CITY, null);
        String user_location = pref.getString(Constants.LOCATION, null);

        //set data to view
        show_city.setText(user_city);
        show_location.setText(user_location);

    }

    public void recyclerViewRelated(){
        mAdapter = new PizzaAdapter(pizzaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void preparePizzaData(){
        //get app context
        Context context = getApplicationContext();
        //get drawable
        Drawable drawable = context.getResources().getDrawable(R.drawable.img3);
        // convert drawable to bitmap
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

        for(int i = 0; i <= 8; i++){
            Pizza pizza = new Pizza(drawable, "Pizza name " + i);
            pizzaList.add(pizza);
        }

        mAdapter.notifyDataSetChanged();

    }
}
