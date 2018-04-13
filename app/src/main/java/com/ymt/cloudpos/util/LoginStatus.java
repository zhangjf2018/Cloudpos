package com.ymt.cloudpos.util;

import android.content.Context;

/**
 * Created by zhangjifeng on 2018/4/13.
 * email : 414512194@qq.com
 * desc  :
 */

public class LoginStatus {

    private final static String mPname="userInfo";
    private final static String mKey = "userId";

    public static void saveLoginStatus(Context context, String userId ){
        SharedPreferenceUtil.save(context, mPname, mKey, userId );
    }

    /**
     * 获取用户登录状态
     * @param context
     * @return true 已登录 false 未登录
     */
    public static boolean isLogin(Context context){
        boolean flag = false;
        String userId = SharedPreferenceUtil.get(context, mPname, mKey);
        if (userId != null && !("".equals(userId))){
            flag = true;
        }
        return flag;
    }

}
