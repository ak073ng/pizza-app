package com.akoteng.pizzaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.akoteng.pizzaapp.classes.Constants;
import com.andrognito.flashbar.Flashbar;
import com.andrognito.flashbar.anim.FlashAnim;

public class PromptDetailsActivity extends AppCompatActivity {

    protected EditText firstname_et, surname_et, email_et, mobile_et, pin_et, confirm_pin_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_details);

        //initialize components
        firstname_et = (EditText)findViewById(R.id.firstname_et);
        surname_et = (EditText)findViewById(R.id.surname_et);
        email_et = (EditText)findViewById(R.id.email_et);
        mobile_et = (EditText)findViewById(R.id.mobile_et);
        pin_et = (EditText)findViewById(R.id.pin_et);
        confirm_pin_et = (EditText)findViewById(R.id.confirm_pin_et);

    }

    //save user information to shared preference
    public void saveUserInfo(View view){

        String firstname = firstname_et.getText().toString();
        String surname = surname_et.getText().toString();
        String email = email_et.getText().toString();
        String mobile = mobile_et.getText().toString();
        String pin = pin_et.getText().toString();
        String confirm_pin = confirm_pin_et.getText().toString();

        if(firstname.isEmpty()){
            showMessage("Missing", "First name field is empty!");
        }else if(surname.isEmpty()){
            showMessage("Missing", "Surname field is empty!");
        }else if(email.isEmpty()){
            showMessage("Missing", "Email field is empty!");
        }else if(mobile.isEmpty()){
            showMessage("Missing","Phone number field is empty!");
        }else if(pin.isEmpty()){
            showMessage("Missing", "Pin field is empty!");
        }else if(confirm_pin.isEmpty()){
            showMessage("Missing", "Confirm pin field is empty!");
        }else if(!pin.contains(confirm_pin)){
            showMessage("Error", "Both pins are not matching!");
        }else if(!firstname.isEmpty() && !surname.isEmpty() && !email.isEmpty()
                && !mobile.isEmpty() && !pin.isEmpty() && !confirm_pin.isEmpty()){
            showMessage("Sweet","Thanks for the info. Saving...");
            showMessage("Next time...","Use the pin to access app on launch.");

            //initialize shared preference and its editor
            SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            editor.putString(Constants.FIRSTNAME, firstname);
            editor.putString(Constants.SURNAME, surname);
            editor.putString(Constants.EMAIL, email);
            editor.putString(Constants.MOBILE, mobile);
            editor.putString(Constants.PIN, pin);
            editor.putString(Constants.CONFIRM_PIN, confirm_pin);
            editor.putBoolean(Constants.IS_INFO_FILLED, true);

            editor.apply();
            Log.d(Constants.PROMPT_DETAILS_ACTIVITY, "USER INFO SAVED TO PREFERENCE");

            //proceed to next page
            toEnterLocationActivity();

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
    public void toEnterLocationActivity(){
        Intent toEnterLocation = new Intent(this, EnterLocationActivity.class);
        startActivity(toEnterLocation);
    }


}
