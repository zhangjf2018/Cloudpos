package com.ymt.cloudpos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class CustomServiceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("客户服务");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_service;
    }
}
