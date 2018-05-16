package com.ymt.cloudpos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.model.OrdersGenJinModel;
import com.ymt.cloudpos.model.SubAccountModel;

public class SubAccountDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("子账号详情");

        Bundle bundle = getIntent().getExtras();
        final SubAccountModel subAccountModel = (SubAccountModel) bundle.getSerializable("SubAccountModel");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub_account_detail;
    }
}
