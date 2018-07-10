package com.akoteng.pizzaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Pizza name");

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


    }

    //get pizza sizes
    public void getPizzaSizes(View view){

        final TextView select_size = (TextView)findViewById(R.id.tv_pizza_size);

        final CharSequence pizzaSizeList[] = new CharSequence[] {"Small", "Medium", "Large"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select a size");
        builder.setItems(pizzaSizeList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on option[which]
                select_size.setText(pizzaSizeList[which].toString());
                dialog.cancel();
            }
        });
        builder.show();
    }
}
