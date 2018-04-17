package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class PhoneCheckActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("手机验证");

        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_phone_check;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this, ModifyPasswordActivity.class);
        startActivity(intent);
    }
}
