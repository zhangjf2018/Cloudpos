package com.ymt.cloudpos.view;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;


public class AccountCheckActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBarTitle("账户验证");
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_check;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(AccountCheckActivity.this, PhoneCheckActivity.class);
        startActivity(intent);
    }
}
