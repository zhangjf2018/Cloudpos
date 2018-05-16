package com.ymt.cloudpos.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.RenewalInsuranceNoticeAdapter;
import com.ymt.cloudpos.adapter.SubAccountAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.SubAccountModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class SubAccountActivity extends BaseActivity {

    private SubAccountAdapter mSubAccountAdapter;
    private List<SubAccountModel> mSubAccountModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("子账号管理");
        initSubAccountView();

        setToolBarRight("添加");
        setToolBarRightOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SubAccountActivity.this, SubAccountAddActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initSubAccountView() {
        mSubAccountModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_subAccount);
        mSubAccountAdapter = new SubAccountAdapter(mSubAccountModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mSubAccountAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,2), ContextCompat.getColor(this, R.color.bg_gray)) );
        mSubAccountAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                SubAccountModel sam = mSubAccountModelList.get(position);
                Intent intent = new Intent();
                intent.setClass(SubAccountActivity.this, SubAccountDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("SubAccountModel", sam);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setData() {
        mSubAccountModelList.add(new SubAccountModel("1"));
        mSubAccountModelList.add(new SubAccountModel("1"));
        mSubAccountModelList.add(new SubAccountModel("1"));
        mSubAccountModelList.add(new SubAccountModel("1"));
        mSubAccountModelList.add(new SubAccountModel("1"));
        mSubAccountModelList.add(new SubAccountModel("1"));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub_account;
    }
}
