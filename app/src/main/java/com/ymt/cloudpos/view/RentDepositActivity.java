package com.ymt.cloudpos.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
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
import com.ymt.cloudpos.util.LoginStatus;

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
      //  mHandler.postDelayed(r, 100);
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

/*        ProgressDialog progressDialog = new ProgressDialog(RentDepositActivity.this, R.style.dialog);//1.创建一个ProgressDialog的实例
       // ProgressDialog progressDialog = new ProgressDialog(RentDepositActivity.this);//1.创建一个ProgressDialog的实例
        //progressDialog.setTitle("这是一个 progressDialog");//2.设置标题
        progressDialog.setMessage("正在加载中，请稍等......");//3.设置显示内容
        progressDialog.setMessage("正在加载中");//3.设置显示内容
        progressDialog.setCancelable(true);//4.设置可否用back键关闭对话框
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       // progressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        progressDialog.show();//5.将ProgessDialog显示出来*/

//        WindowManager.LayoutParams params = progressDialog.getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        progressDialog.getWindow().setAttributes(params);


        new DialogBuilder(RentDepositActivity.this)
                .title("恭喜您！")
                .message("支付成功！祝您使用愉快！")
                .sureText("确定")
                .setCancelable(false)
                .setSureColor(R.color.bg_orig)
                .setSureOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginStatus.saveLoginStatus(RentDepositActivity.this,"1");
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
