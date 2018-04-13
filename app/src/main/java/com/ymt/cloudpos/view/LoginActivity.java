package com.ymt.cloudpos.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ymt.cloudpos.R;

/**
 * Created by zhangjifeng on 2018/4/13.
 * email : 414512194@qq.com
 * desc  :
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv = (TextView) findViewById(R.id.tv_forgetPasswd);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, AccountCheckActivity.class);
        startActivity(intent);
    }
}
