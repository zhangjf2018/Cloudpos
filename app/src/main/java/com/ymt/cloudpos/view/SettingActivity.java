package com.ymt.cloudpos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("设置");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }
}
