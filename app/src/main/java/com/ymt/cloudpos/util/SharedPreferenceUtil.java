package com.ymt.cloudpos.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhangjifeng on 2018/4/13.
 * email : 414512194@qq.com
 * desc  :
 */

public class SharedPreferenceUtil {

    public static void save(Context context, String preference_name,  String key, String value){
        SharedPreferences sharedpreferences=context.getSharedPreferences(preference_name,  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String get(Context context, String preference_name,  String key){
        SharedPreferences sharedpreferences=context.getSharedPreferences(preference_name,  Context.MODE_PRIVATE);
        String value = sharedpreferences.getString( key, null);
        return value;
    }
}
