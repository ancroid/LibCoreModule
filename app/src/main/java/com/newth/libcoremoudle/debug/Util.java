package com.newth.libcoremoudle.debug;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;


public class Util {
    public static final String COOKIE = "CookieFile";
    public static final String CAPTCHA="CaptchaFile";
    public static void writeCookieToSP(String cookie) {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor= MyApplicattion.getMyContext().getSharedPreferences(COOKIE, Context.MODE_PRIVATE).edit();
        editor.putString("cookie",cookie);
        editor.apply();
    }
    public static String readCookieFromSP() {
        SharedPreferences preferences=MyApplicattion.getMyContext().getSharedPreferences(COOKIE,Context.MODE_PRIVATE);
        return preferences.getString("cookie","");
    }
    public static void writeCaptchaToSP(String captcha) {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor= MyApplicattion.getMyContext().getSharedPreferences(CAPTCHA, Context.MODE_PRIVATE).edit();
        editor.putString("captcha",captcha);
        editor.apply();
    }
    public static String readCaptchaFromSP() {
        SharedPreferences preferences=MyApplicattion.getMyContext().getSharedPreferences(CAPTCHA,Context.MODE_PRIVATE);
        return preferences.getString("captcha","");
    }
}
