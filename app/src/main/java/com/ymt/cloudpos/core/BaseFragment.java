package com.ymt.cloudpos.core;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.ymt.cloudpos.util.CommonUtil;

/**
 * Created by zhangjifeng on 2018/3/29.
 * email : 414512194@qq.com
 * desc  :
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = getActivity();
    }

    public void showToast( String msg){
        CommonUtil.showToast(mContext, msg);
    }
    public void showToastError( String msg){
        CommonUtil.toastError(mContext, msg);
    }
    public void showSuccess( String msg){
        CommonUtil.toastSuccess(mContext, msg);
    }
    public void showInfo( String msg){
        CommonUtil.toastInfo(mContext, msg);
    }
}
