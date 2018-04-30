package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.OrdersPaybleAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.OrdersPayableModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class OrdersPayableActivity extends BaseActivity {

    private OrdersPaybleAdapter mOrdersPaybleAdapter;
    private List<OrdersPayableModel> mOrdersPayableModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("我的应付订单");
        mOrdersPayableModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mOrdersPaybleAdapter = new OrdersPaybleAdapter(mOrdersPayableModelList);
        mOrdersPaybleAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mOrdersPaybleAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,8), ContextCompat.getColor(this, R.color.bg_gray)) );
    }

    private void setData(){
        mOrdersPayableModelList.add(new OrdersPayableModel("DJ20199018203948172859Y088892932", "陈小春", "中国平安","粤B891235", "2018-05-01 18:18:00", "8888.88"));
        mOrdersPayableModelList.add(new OrdersPayableModel("DJ2019901820394817285", "陈小", "中国平安","粤B855555",  "2018-05-01 19:18:00", "18888.88"));
        mOrdersPayableModelList.add(new OrdersPayableModel("DJ201990159Y08889293203948123123", "陈春", "中国大地财险","粤B88888",  "2018-05-01 20:18:00", "28888.88"));
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_orders_payable;
    }
}
