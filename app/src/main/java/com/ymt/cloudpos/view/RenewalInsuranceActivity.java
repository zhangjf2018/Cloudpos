package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.InsuranceAgentAdapter;
import com.ymt.cloudpos.adapter.RenewalInsuranceSelectedAgentAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class RenewalInsuranceActivity extends BaseActivity {

    private RenewalInsuranceSelectedAgentAdapter mRenewalInsuranceSelectedAgentAdapter;
    private List<InsuranceAgentModel> mInsuranceAgentModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("选择保险公司");

        mInsuranceAgentModelList= new ArrayList<>();

        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRenewalInsuranceSelectedAgentAdapter = new RenewalInsuranceSelectedAgentAdapter(mInsuranceAgentModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mRenewalInsuranceSelectedAgentAdapter);
        recyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.alpaha_gray)) );
        mRenewalInsuranceSelectedAgentAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(RenewalInsuranceActivity.this, RenewalInsuranceTypeActivity.class);
                Bundle args = new Bundle();
                args.putSerializable("insuranceAgentModel", mInsuranceAgentModelList.get(position));
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    private void setData(){
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "平安", R.mipmap.pingan));
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "中国人寿", R.mipmap.renshou));
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "太平洋保险", R.mipmap.taipingyangbaoxian));
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "信诚保险", R.mipmap.ximcheng));
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "众城保险", R.mipmap.zhongcheng));
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "中国人民保险", R.mipmap.renmin));
        mInsuranceAgentModelList.add(new InsuranceAgentModel( "中国大地保险", R.mipmap.dadi));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_renewal_insurance;
    }
}
