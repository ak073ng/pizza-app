package com.akoteng.pizzaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class EnterLocationActivity extends AppCompatActivity implements View.OnClickListener {

    //initialize
    TextView tv_city, tv_area;
    Button btn_to_home;

    //keys
    public final String CITY_NAME_KEY = "username";
    public final String AREA_NAME_KEY = "password";

    //log tag
    public static final String LOG_TAG = EnterLocationActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_location);
        //overridePendingTransition(R.anim.trans_right_in, R.anim.trans_left_out);

        //initialize components
        tv_city = (TextView)findViewById(R.id.tv_enter_city);
        tv_city.setText("City");
        tv_city.setOnClickListener(this);

        tv_area = (TextView)findViewById(R.id.tv_enter_area);
        tv_area.setText("Area");
        tv_area.setOnClickListener(this);

        btn_to_home = (Button)findViewById(R.id.btn_to_home);
        btn_to_home.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.tv_enter_city:
                cityOptionsDIalog();
                break;
            case R.id.tv_enter_area:
                areaOptionsDIalog();
                break;
            case R.id.btn_to_home:
                checkLocationInput();
                break;
        }
    }

    public void cityOptionsDIalog(){

        final CharSequence cityList[] = new CharSequence[] {"city 1", "city 2", "city 3", "city 4"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select a city");
        builder.setItems(cityList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on option[which]
                tv_city.setText(cityList[which].toString());
                dialog.cancel();
            }
        });
        builder.show();

    }

    public void areaOptionsDIalog(){

        final CharSequence areaList[] = new CharSequence[] {"area 1", "area 2", "area 3", "area 4"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select an area");
        builder.setItems(areaList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on option[which]
                tv_area.setText(areaList[which].toString());
                dialog.cancel();
            }
        });
        builder.show();

    }

    //checks if input is registered before proceeding to next page
    //also, stores input city and area values to intent
    public void checkLocationInput(){
        String city_name = tv_city.getText().toString();
        String area_name = tv_area.getText().toString();

        if(city_name != "City" && area_name != "Area"){
            Intent to_home = new Intent(this, HomeActivity.class);
            to_home.putExtra(CITY_NAME_KEY, city_name);
            to_home.putExtra(AREA_NAME_KEY, area_name);
            startActivity(to_home);
        } else{
            FrameLayout flayout = (FrameLayout) findViewById(R.id.location_frame_layout);
            Snackbar.make(flayout, "We need your location first", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .setActionTextColor(getResources().getColor(R.color.green))
                    .show();
        }
    }

}
