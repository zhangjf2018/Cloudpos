package com.ymt.cloudpos.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseFragment;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class MineFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        return view;
    }
}
