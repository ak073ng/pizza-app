package com.akoteng.pizzaapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.akoteng.pizzaapp.classes.Constants;
import com.andrognito.flashbar.Flashbar;
import com.andrognito.flashbar.anim.FlashAnim;

import pugman.com.simplelocationgetter.SimpleLocationGetter;

public class EnterLocationActivity extends AppCompatActivity implements View.OnClickListener, SimpleLocationGetter.OnLocationGetListener {

    //initialize
    TextView tv_city, tv_area, tv_address;
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

        //initialize components
        tv_city = (TextView)findViewById(R.id.tv_enter_city);
        tv_city.setText("City");
        tv_city.setOnClickListener(this);

        tv_area = (TextView)findViewById(R.id.tv_enter_area);
        tv_area.setText("Area");
        tv_area.setOnClickListener(this);

        tv_address = (TextView)findViewById(R.id.tv_enter_address);
        tv_address.setText("Address");
        tv_address.setOnClickListener(this);

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
            case R.id.tv_enter_address:
                getAddress();
                break;
            case R.id.btn_to_home:
                checkLocationInput();
                break;
        }
    }

    public void cityOptionsDIalog(){

        final CharSequence cityList[] = new CharSequence[] {"Nairobi", "Mombasa", "Kisumu",
                "Eldoret", "Nakuru", "Naivasha", "Thika"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select your city");
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

        final CharSequence areaList[] = new CharSequence[] {"CBD", "Westlands", "Karen", "Lavington", "Langata"
                , "Eastleigh", "Ongata Rongai"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select your area");
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

    private boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            requestPermissions();
            return false;
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }

    //get address
    private void getAddress(){

        if (checkPermissions() == true) {

            SimpleLocationGetter getter = new SimpleLocationGetter(this, this);
            getter.getLastLocation();

            showMessage("ADDRESS OBTAINED", "We've located you. Click continue to proceed.");

        }else{

            requestPermissions();

        }

    }

    //checks if input is registered before proceeding to next page
    //also, stores input city and area values to intent
    public void checkLocationInput(){
        String city = tv_city.getText().toString();
        String area = tv_area.getText().toString();
        String address = tv_address.getText().toString();

        if(city != "City" && area != "Area" && address != "Address"){

            //initialize shared preference and its editor
            SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            editor.putString(Constants.CITY, city);
            editor.putString(Constants.LOCATION, area);
            //editor.putString(Constants.ADDRESS, address);

            editor.apply();
            Log.d(Constants.ENTER_LOCATION_ACTIVITY, "USER LOCATION DETAILS SAVED");

            //proceed to homepage
            toHomeActivity();

        } else{

            showMessage("HOLD ON...", "We need your location first!");

        }
    }

    //flash bar to show system messages
    public void showMessage(String title, String message){

        new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .title(title)
                .message(message)
                .backgroundColorRes(R.color.colorAccent)
                .duration(2000)//1 second
                .enterAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(750)
                        .alpha()
                        .overshoot())
                .exitAnimation(FlashAnim.with(this)
                        .animateBar()
                        .duration(400)
                        .accelerateDecelerate())
                .enableSwipeToDismiss()
                .build().show();

    }

    //start enter-location activity
    public void toHomeActivity(){
        Intent toHomeLocation = new Intent(this, HomeActivity.class);
        startActivity(toHomeLocation);
    }

    @Override
    public void onLocationReady(Location location) {

        tv_address.setText(location.getLatitude() + " , " + location.getLongitude());

        //initialize shared preference and its editor
        SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(Constants.LATITUDE, String.valueOf(location.getLatitude()));
        editor.putString(Constants.LONGITUDE, String.valueOf(location.getLongitude()));

        editor.apply();
        Log.d(Constants.ENTER_LOCATION_ACTIVITY, "USER LATITUDE AND LONGITUDE SAVED: " + location);

    }

    @Override
    public void onError(String s) {

        Log.d(Constants.ENTER_LOCATION_ACTIVITY, "USER LATITUDE AND LONGITUDE REFUSED TO SAVE");

        showMessage("TURN ON LOCATION", "We could not get your geolocation. Turn on location and try again");

    }
}
