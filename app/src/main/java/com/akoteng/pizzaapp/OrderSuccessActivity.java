package com.akoteng.pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class OrderSuccessActivity extends AppCompatActivity implements View.OnClickListener {

    //initialize
    Button btn_to_home, btn_check_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        //initialize components
        btn_to_home = (Button)findViewById(R.id.btn_to_home);
        btn_to_home.setOnClickListener(this);

        btn_check_order = (Button)findViewById(R.id.btn_check_order);
        btn_check_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_to_home:
                Intent to_home = new Intent(this, HomeActivity.class);
                startActivity(to_home);
                break;
            case R.id.btn_check_order:
                Intent to_check_order = new Intent(this, HomeActivity.class);
                startActivity(to_check_order);
                break;
        }
    }
}
