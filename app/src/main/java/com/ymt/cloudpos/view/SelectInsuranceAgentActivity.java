package com.ymt.cloudpos.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.CarServiceAdapter;
import com.ymt.cloudpos.adapter.InsuranceAgentAdapter;
import com.ymt.cloudpos.adapter.RecommendServiceAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.CarServiceModel;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.PayWayModel;
import com.ymt.cloudpos.model.RecommendServiceModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectInsuranceAgentActivity extends BaseActivity {

    private InsuranceAgentAdapter mInsuranceAgentAdapter;
    private List<InsuranceAgentModel> mInsuranceAgentModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInsuranceAgentModelList= new ArrayList<>();

        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mInsuranceAgentAdapter = new InsuranceAgentAdapter(mInsuranceAgentModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mInsuranceAgentAdapter);
        recyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.alpaha_gray)) );
        mInsuranceAgentAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mInsuranceAgentAdapter.setCheck(position,view.findViewById(R.id.cb_isCheck));
            }
        });
        mHandler.postDelayed(r, 100);//延时100毫秒

    }
    Handler mHandler = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            //do something
            //每隔1s循环执行run方法
            //Log.e("lll", Arrays.asList(mInsuranceAgentModelList).toString());
            mHandler.postDelayed(this, 1000);
        }
    };


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
        return R.layout.activity_select_insurance_agent;
    }
}
