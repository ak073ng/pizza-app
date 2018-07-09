package com.akoteng.pizzaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.akoteng.pizzaapp.classes.Constants;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //animate splash page logo
        YoYo.with(Techniques.Bounce)
                .duration(1000)
                .repeat(3)
                .playOn(findViewById(R.id.logo));

        //after 5 seconds, navigate to next screen
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 2 seconds
                    sleep(2*1000);

                    //initialize shared preference and its editor
                    SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);

                    //determine navigation
                    if(pref.getBoolean(Constants.IS_INFO_FILLED, false) == true){

                        //proceed to passcode activity before homepage activity
                        toPasscodeActivity();

                    }else{

                        //proceed to prompt-details activity
                        toPromptDetailsActivity();

                    }

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //proceed to home page
    public void toPasscodeActivity(){
        Intent to_passcode_activity = new Intent(this, PasscodeActivity.class);
        startActivity(to_passcode_activity);
    }

    //proceed to prompt-details activity
    public void toPromptDetailsActivity(){
        Intent to_prompt_details_activity = new Intent(this,PromptDetailsActivity.class);
        startActivity(to_prompt_details_activity);
    }
}
