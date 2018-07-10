package com.akoteng.pizzaapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.akoteng.pizzaapp.adapters.CartAdapter;
import com.akoteng.pizzaapp.adapters.PizzaAdapter;
import com.akoteng.pizzaapp.classes.Cart;
import com.akoteng.pizzaapp.classes.Pizza;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    //initialize
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    List<Cart> cartList = new ArrayList<>();
    Button btn_checkout;

    //log tag
    public static final String LOG_TAG = CartActivity.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cart");

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
        recyclerView = (RecyclerView) findViewById(R.id.cart_recycler_view);

        btn_checkout = (Button)findViewById(R.id.btn_checkout);
        btn_checkout.setOnClickListener(this);

        //functions
        recyclerViewRelated();
        prepareCartData();

    }

    public void recyclerViewRelated(){
        mAdapter = new CartAdapter(cartList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void prepareCartData(){

        for(int i = 0; i <= 8; i++){
            Cart cart = new Cart("Pizza name" + i, "medium", i, 1200, "Some info here");
            cartList.add(cart);
        }

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_checkout:
                Intent to_next = new Intent(this, OrderSuccessActivity.class);
                startActivity(to_next);
        }
    }
}
