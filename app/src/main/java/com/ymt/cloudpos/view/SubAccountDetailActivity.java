package com.ymt.cloudpos.view;

import android.os.Bundle;

import com.suke.widget.SwitchButton;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.model.SubAccountModel;

public class SubAccountDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("子账号详情");

        Bundle bundle = getIntent().getExtras();
        final SubAccountModel subAccountModel = (SubAccountModel) bundle.getSerializable("SubAccountModel");
        SwitchButton sbAcountStatus = (SwitchButton) findViewById(R.id.sb_accountStatus);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub_account_detail;
    }
}
