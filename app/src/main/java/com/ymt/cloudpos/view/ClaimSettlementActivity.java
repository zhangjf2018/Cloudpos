package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.ClaimSettlementAdapter;
import com.ymt.cloudpos.adapter.RenewalInsuranceTypeAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.ClaimSettlementModel;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.RenewalInsuranceTypeModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class ClaimSettlementActivity extends BaseActivity {

    private ClaimSettlementAdapter mClaimSettlementAdapter;
    private List<ClaimSettlementModel> mClaimSettlementModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("填写理赔需求");
        mClaimSettlementModelList=new ArrayList<>();

        setData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mClaimSettlementAdapter = new ClaimSettlementAdapter(mClaimSettlementModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mClaimSettlementAdapter);
        recyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(this,1), ContextCompat.getColor(this, R.color.alpaha_gray)) );
    }

    private void setData(){
        mClaimSettlementModelList.add(new ClaimSettlementModel( "车牌号码", "carno", null,"请输入车牌号码"));
        mClaimSettlementModelList.add(new ClaimSettlementModel( "对接人", "to_take_over", null,"请输入对接人姓名"));
        mClaimSettlementModelList.add(new ClaimSettlementModel( "对接电话", "docked_telphone", null,"请输入对接人电话"));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_claim_settlement;
    }
}
