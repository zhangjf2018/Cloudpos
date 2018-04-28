package com.ymt.cloudpos.core;

import android.app.Application;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;

import com.ymt.cloudpos.R;

import es.dmoral.toasty.Toasty;

/**
 * Created by zhangjifeng on 2018/3/30.
 * email : 414512194@qq.com
 * desc  :
 */

public class CustomApplication extends Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initToast();
    }

    private void initToast() {
        Toasty.Config.getInstance()
        .setErrorColor(ContextCompat.getColor(this, R.color.red)) // optional
        .setInfoColor(ContextCompat.getColor(this, R.color.green)) // optional
        .setSuccessColor(ContextCompat.getColor(this, R.color.green)) // optional
        .setWarningColor(ContextCompat.getColor(this, R.color.holo_orange_light)) // optional
        .setTextColor(ContextCompat.getColor(this, R.color.white)) // optional
       // .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
        .setToastTypeface(Typeface.DEFAULT) // optional
        .setTextSize(22) // optional
        .apply();
    }

    public static Application getInstance(){
        return instance;
    }
    
}
