package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("设置");
        findViewById(R.id.ll_logOut).setOnClickListener(this);
        findViewById(R.id.ll_modifyPasswd).setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_modifyPasswd:
                Intent intent = new Intent();
                intent.setClass(SettingActivity.this, MineModifyPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_logOut:
                break;
            default:
                break;
        }
    }
}
