package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.PayWayAdapter;
import com.ymt.cloudpos.adapter.WithDrawCashDetailAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.PayWayModel;
import com.ymt.cloudpos.model.WithDrawCashDetailModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class WithDrawCashDetailActivity extends BaseActivity {

    private WithDrawCashDetailAdapter mWithDrawCashDetailAdapter;
    private List<WithDrawCashDetailModel> mWithDrawCashDetailModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("资金明细");

        mWithDrawCashDetailModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mWithDrawCashDetailAdapter = new WithDrawCashDetailAdapter(mWithDrawCashDetailModelList);
        mWithDrawCashDetailAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mWithDrawCashDetailAdapter);
        recyclerView.addItemDecoration( new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.alpaha_gray)) );

    }

    private void setData(){
        mWithDrawCashDetailModelList.add(new WithDrawCashDetailModel("提现", "-3500.00", "2018-05-01 12:12:09"));
        mWithDrawCashDetailModelList.add(new WithDrawCashDetailModel("提现", "-10000.00", "2018-05-01 13:12:29"));
        mWithDrawCashDetailModelList.add(new WithDrawCashDetailModel("提现", "-8000.00", "2018-05-01 14:32:19"));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_with_draw_cash_detail;
    }
}
