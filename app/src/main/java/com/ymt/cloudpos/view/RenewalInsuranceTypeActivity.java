package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.RenewalInsuranceSelectedAgentAdapter;
import com.ymt.cloudpos.adapter.RenewalInsuranceTypeAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.RenewalInsuranceTypeModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RenewalInsuranceTypeActivity extends BaseActivity {

    private RenewalInsuranceTypeAdapter mRenewalInsuranceTypeAdapter;
    private List<RenewalInsuranceTypeModel> mRenewalInsuranceTypeModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("选择续保方式");

        Bundle bundle = getIntent().getExtras();
        final InsuranceAgentModel insuranceAgentModel = (InsuranceAgentModel) bundle.getSerializable("insuranceAgentModel");
        ImageView imageView = (ImageView) findViewById(R.id.iv_selectInsuranceAgent);
        imageView.setImageResource(insuranceAgentModel.getResImgId());

        mRenewalInsuranceTypeModelList = new ArrayList<>();

        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRenewalInsuranceTypeAdapter = new RenewalInsuranceTypeAdapter(mRenewalInsuranceTypeModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mRenewalInsuranceTypeAdapter);
        recyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.alpaha_gray)) );
        mRenewalInsuranceTypeAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(RenewalInsuranceTypeActivity.this, mRenewalInsuranceTypeModelList.get(position).getClsName());
                Bundle args = new Bundle();
                args.putSerializable("insuranceAgentModel",insuranceAgentModel);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    private void setData(){
        mRenewalInsuranceTypeModelList.add(new RenewalInsuranceTypeModel( "同上年险种", LastYearsDangerActivity.class));
        mRenewalInsuranceTypeModelList.add(new RenewalInsuranceTypeModel( "选择新的险种/保额", EffectInsuranceActivity.class));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_renewal_insurance_type;
    }
}
