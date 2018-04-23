package com.ymt.cloudpos.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ymt.cloudpos.MainActivity;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.PayWayAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.core.wegit.DialogBuilder;
import com.ymt.cloudpos.model.PayWayModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentDepositActivity extends BaseActivity implements View.OnClickListener {

    private PayWayAdapter mPayWayAdapter;
    private List<PayWayModel> mPayWayModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("押金/租金支付");
        findViewById(R.id.btn_pay).setOnClickListener(this);

        mPayWayModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mPayWayAdapter = new PayWayAdapter(mPayWayModelList);
        mPayWayAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mPayWayAdapter.setChecked(position);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mPayWayAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.alpaha_gray)) );
        mHandler.postDelayed(r, 100);
    }

    Handler mHandler = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            //do something
            Log.e("run", Arrays.asList(mPayWayModelList).toString());
            //每隔1s循环执行run方法
            mHandler.postDelayed(this, 1000);
        }
    };

    private void setData(){
        mPayWayModelList.add(new PayWayModel(R.mipmap.alipay, "支付宝", true));
        mPayWayModelList.add(new PayWayModel(R.mipmap.wxpay, "微信", false));
        mPayWayModelList.add(new PayWayModel(R.mipmap.unionpay, "银联", false));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rent_deposit;
    }

    @Override
    public void onClick(View v) {
        new DialogBuilder(RentDepositActivity.this)
                .title("恭喜您！")
                .message("支付成功！祝您使用愉快！")
                .sureText("确定")
                .setCancelable(false)
                .setSureColor(R.color.bg_orig)
                .setSureOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(RentDepositActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }).build().show();
    }

    @BindingAdapter({"resImgId"})
    public static void loadImage(ImageView imageView, int id) {
        imageView.setImageResource(id);
    }
}
