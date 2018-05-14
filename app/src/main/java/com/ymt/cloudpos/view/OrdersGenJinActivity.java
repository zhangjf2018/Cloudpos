package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.MineGridAdapter;
import com.ymt.cloudpos.adapter.MineOrderStatusAdapter;
import com.ymt.cloudpos.adapter.OrdersGenJinAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.MineGridModel;
import com.ymt.cloudpos.model.MineOrderStatusModel;
import com.ymt.cloudpos.model.OrdersGenJinModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class OrdersGenJinActivity extends BaseActivity {

    private OrdersGenJinAdapter mOrdersGenJinAdapter;
    private List<OrdersGenJinModel> mOrdersGenJinModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("跟进订单");

        initOrderGenJinView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_orders_gen_jin;
    }

    private void initOrderGenJinView() {
        mOrdersGenJinModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_genJinList);
        mOrdersGenJinAdapter = new OrdersGenJinAdapter(mOrdersGenJinModelList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mOrdersGenJinAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,8), ContextCompat.getColor(this, R.color.bg_gray)) );
        mOrdersGenJinAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }

    private void setData() {
        mOrdersGenJinModelList.add(new OrdersGenJinModel("已提交"));
        mOrdersGenJinModelList.add(new OrdersGenJinModel("跟进中"));
        mOrdersGenJinModelList.add(new OrdersGenJinModel("待支付"));
        mOrdersGenJinModelList.add(new OrdersGenJinModel("已完成"));
        mOrdersGenJinModelList.add(new OrdersGenJinModel("已取消"));
    }
}
