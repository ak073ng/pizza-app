package com.akoteng.pizzaapp.classes;

import com.akoteng.pizzaapp.CartActivity;
import com.akoteng.pizzaapp.EnterLocationActivity;
import com.akoteng.pizzaapp.HistoryActivity;
import com.akoteng.pizzaapp.HomeActivity;
import com.akoteng.pizzaapp.MyDetailsActivity;
import com.akoteng.pizzaapp.OrderFullActivity;
import com.akoteng.pizzaapp.OrderSuccessActivity;
import com.akoteng.pizzaapp.PromptDetailsActivity;
import com.akoteng.pizzaapp.SplashActivity;

public class Constants {

    //user info storage in preference
    public static final String USER = "user";

    public static final String FIRSTNAME = "firstname";
    public static final String SURNAME = "surname";
    public static final String EMAIL = "email";
    public static final String MOBILE = "mobile";
    public static final String PIN = "pin";
    public static final String CONFIRM_PIN = "confirm_pin";

    public static final String CITY = "city";
    public static final String LOCATION = "location";
    public static final String ADDRESS = "address";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    public static final String ORDERED_ITEMS = "target_weight";
    public static final String CART_ITEMS = "user_id";

    public static final String IS_INFO_FILLED = "is_info_filled";

    //activity contexts
    public static final String SPLASH_ACTIVITY =  SplashActivity.class.getSimpleName();
    public static final String PROMPT_DETAILS_ACTIVITY =  PromptDetailsActivity.class.getSimpleName();
    public static final String MY_DETAILS_ACTIVITY = MyDetailsActivity.class.getSimpleName();
    public static final String HOME_ACTIVITY =  HomeActivity.class.getSimpleName();
    public static final String CART_ACTIVITY =  CartActivity.class.getSimpleName();
    public static final String HISTORY_ACTIVITY =  HistoryActivity.class.getSimpleName();
    public static final String ORDER_SUCCESS_ACTIVITY = OrderSuccessActivity.class.getSimpleName();
    public static final String ORDER_FULL_ACTIVITY = OrderFullActivity.class.getSimpleName();
    public static final String ENTER_LOCATION_ACTIVITY = EnterLocationActivity.class.getSimpleName();

}
