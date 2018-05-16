package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.OrdersGenJinAdapter;
import com.ymt.cloudpos.adapter.RenewalInsuranceNoticeAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.RenewalInsuranceNoticeModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class RenewalInsuranceNoticeActivity extends BaseActivity {

    private RenewalInsuranceNoticeAdapter mRenewalInsuranceNoticeAdapter;
    private List<RenewalInsuranceNoticeModel> mRenewalInsuranceNoticeModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("续保通知");
        initRenewalInsuranceNoticeView();
    }

    private void initRenewalInsuranceNoticeView() {
        mRenewalInsuranceNoticeModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_renewalInsuranceNotice);
        mRenewalInsuranceNoticeAdapter = new RenewalInsuranceNoticeAdapter(mRenewalInsuranceNoticeModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mRenewalInsuranceNoticeAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,8), ContextCompat.getColor(this, R.color.bg_gray)) );
        mRenewalInsuranceNoticeAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }

    private void setData() {
        mRenewalInsuranceNoticeModelList.add(new RenewalInsuranceNoticeModel("1"));
        mRenewalInsuranceNoticeModelList.add(new RenewalInsuranceNoticeModel("2"));
        mRenewalInsuranceNoticeModelList.add(new RenewalInsuranceNoticeModel("1"));
        mRenewalInsuranceNoticeModelList.add(new RenewalInsuranceNoticeModel("1"));
        mRenewalInsuranceNoticeModelList.add(new RenewalInsuranceNoticeModel("1"));
        mRenewalInsuranceNoticeModelList.add(new RenewalInsuranceNoticeModel("1"));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_renewal_insurance_notice;
    }
}
