package com.ymt.cloudpos.util;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by zhangjifeng on 2018/4/19.
 * email : 414512194@qq.com
 * desc  :
 */

public class CommonUtil {

    public static int dip2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static void toastError(Context context,
                                 String content) {
        Toasty.error(context, content, Toast.LENGTH_SHORT, true).show();
    }
    public static void toastSuccess(Context context,
                                  String content) {
        Toasty.success(context, content, Toast.LENGTH_SHORT, true).show();
    }

    public static void toastInfo(Context context,
                                    String content) {
        Toasty.info(context, content, Toast.LENGTH_SHORT, true).show();
    }


    private static Toast toast;
    public static void showToast(Context context,
                                 String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
