package com.ymt.cloudpos.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangjifeng on 2018/5/17.
 * email : 414512194@qq.com
 * desc  :
 */

public class ValidateUtil {

    public static boolean isAccValid(String str) {
        Pattern p = Pattern.compile("[A-Za-z0-9]{5,20}");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
