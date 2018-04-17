package com.ymt.cloudpos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class RentDepositActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("押金/租金支付");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rent_deposit;
    }
}
