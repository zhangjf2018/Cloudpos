package com.ymt.cloudpos.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;


public class AccountCheckActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolBarTitle("账户验证");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_check;
    }
}
