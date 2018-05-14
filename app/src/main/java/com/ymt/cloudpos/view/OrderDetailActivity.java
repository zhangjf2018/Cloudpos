package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.OrdersDetailPersonInfoAdapter;
import com.ymt.cloudpos.adapter.OrdersDetailTypeAdapter;
import com.ymt.cloudpos.adapter.OrdersGenJinAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.OrderDetailPersonInfoModel;
import com.ymt.cloudpos.model.OrderDetailTypeModel;
import com.ymt.cloudpos.model.OrdersGenJinModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class OrderDetailActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    private List<OrderDetailTypeModel> mOrderDetailTypeModelList;
    private OrdersDetailTypeAdapter mOrdersDetailTypeAdapter;

    private List<OrderDetailPersonInfoModel> mOrderDetailPersonInfoModelList;
    private OrdersDetailPersonInfoAdapter mOrdersDetailPersonInfoAdapter;

    private List<CheckBox> mCheckList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("订单详情");

        Bundle bundle = getIntent().getExtras();
        final OrdersGenJinModel ordersGenJinModel = ( OrdersGenJinModel ) bundle.getSerializable("OrdersGenJinModel");
        showSuccess( ordersGenJinModel.getName());

        initOrderType();
        initOrderPersonInfo();
        mCheckList = new ArrayList<>();
        mCheckList.add((CheckBox) findViewById(R.id.cb_merAddr));
        mCheckList.add((CheckBox) findViewById(R.id.cb_newAddr));
        for(CheckBox cb : mCheckList){
            cb.setOnCheckedChangeListener(this);
        }
    }

    private void initOrderPersonInfo() {
        mOrderDetailPersonInfoModelList = new ArrayList<>();
        setPersonData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_OrderPersonInfo);
        mOrdersDetailPersonInfoAdapter = new OrdersDetailPersonInfoAdapter( mOrderDetailPersonInfoModelList );
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mOrdersDetailPersonInfoAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.bg_gray)) );
        mOrdersDetailPersonInfoAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }

    private void setPersonData() {
        mOrderDetailPersonInfoModelList.add(new OrderDetailPersonInfoModel("商业险", "8888.88"));
        mOrderDetailPersonInfoModelList.add(new OrderDetailPersonInfoModel("交强险 (含车船税)", "8888.88"));
        mOrderDetailPersonInfoModelList.add(new OrderDetailPersonInfoModel("车主姓名", "陈小春"));
        mOrderDetailPersonInfoModelList.add(new OrderDetailPersonInfoModel("身份证", "123456789012345678"));
    }

    private void initOrderType(){
        mOrderDetailTypeModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_OrderType);
        mOrdersDetailTypeAdapter = new OrdersDetailTypeAdapter( mOrderDetailTypeModelList );
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mOrdersDetailTypeAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.bg_gray)) );
        mOrdersDetailTypeAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
    }

    private void setData() {
        mOrderDetailTypeModelList.add(new OrderDetailTypeModel("已提交"));
        mOrderDetailTypeModelList.add(new OrderDetailTypeModel("跟进中"));
        mOrderDetailTypeModelList.add(new OrderDetailTypeModel("待支付"));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        if(isChecked) {
            for (int i = 0; i < mCheckList.size(); i++) {
                //不等于当前选中的就变成false
                if (mCheckList.get(i).getId() == compoundButton.getId()) {
                    mCheckList.get(i).setChecked(true);
                } else {
                    mCheckList.get(i).setChecked(false);
                }
                Log.e("222","222:" + mCheckList.get(i).getText().toString() + ":"+compoundButton.getText().toString());
            }
        }
    }
}
