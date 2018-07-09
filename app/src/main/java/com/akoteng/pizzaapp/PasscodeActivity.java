package com.akoteng.pizzaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akoteng.pizzaapp.classes.Constants;
import com.andrognito.flashbar.Flashbar;
import com.andrognito.flashbar.anim.FlashAnim;

import in.arjsna.passcodeview.PassCodeView;

public class PasscodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);

        final PassCodeView passCodeView = (PassCodeView)findViewById(R.id.pass_code_view);

        //initialize shared preference
        final SharedPreferences pref = getSharedPreferences(Constants.USER, Context.MODE_PRIVATE);

        //assign user input pin to passcode
        passCodeView.setKeyTextColor(getResources().getColor(R.color.white));
        passCodeView.setFilledDrawable(R.drawable.full_icon);
        passCodeView.setEmptyDrawable(R.drawable.empty_icon);
        passCodeView.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
            @Override
            public void onTextChanged(String text) {

                //check if pins matches
                if(text.length() == 4){

                    if(text.equals(pref.getString(Constants.PIN, null))){

                        //proceed to homepage activity
                        toHomeActivity();

                        passCodeView.reset();

                    }else{

                        showMessage("Invalid credentials", "Pins do not match. Try again.");

                    }
                }
            }
        });

    }

    //proceed to home page
    public void toHomeActivity(){
        Intent to_home_activity = new Intent(this, HomeActivity.class);
        startActivity(to_home_activity);
    }

    //flash bar to show system messages
    public void showMessage(String title, String message){

        new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .title(title)
                .message(message)
                .backgroundColorRes(R.color.colorAccent)
                .duration(2000)//2 second
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
}
