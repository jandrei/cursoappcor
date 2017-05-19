package com.appcorsan;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sala01 on 19/05/2017.
 */

public class Preferences {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public static void saveStringPreferences(Context ctx, String key, String value){
        SharedPreferences.Editor editor = ctx.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringPreferences(Context ctx, String key){
        SharedPreferences sharedPref = ctx.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPref.getString(key,null);
    }

    public static String getToken(Context ctx){
        String s = getStringPreferences(ctx, Utils.TOKEN_API_AOMC);
        return s;
    }
}
