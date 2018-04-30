package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class WithDrawCashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("提现");
        setToolBarRight("交易明细");
        setToolBarRightOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WithDrawCashActivity.this, WithDrawCashDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_with_draw_cash;
    }


}
