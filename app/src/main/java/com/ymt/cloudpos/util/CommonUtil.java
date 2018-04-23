package com.ymt.cloudpos.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by zhangjifeng on 2018/4/19.
 * email : 414512194@qq.com
 * desc  :
 */

public class CommonUtil {

    public static int dip2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }
}
