package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.InsuranceAgentAdapter;
import com.ymt.cloudpos.adapter.InsuranceSelectedAgentAdapter;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.Arrays;
import java.util.List;

public class InsuranceAgentUploadPInfoActivity extends BaseActivity {

    private InsuranceSelectedAgentAdapter mInsuranceSelectedAgentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("选择保险公司");

        Bundle bundle = getIntent().getExtras();
        List<InsuranceAgentModel> insuranceAgentModelList = (List<InsuranceAgentModel>) bundle.getSerializable("InsuranceAgentModel");
        Log.e("InsuranceAgentModel", Arrays.asList(insuranceAgentModelList).toString());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_select_insurance_agent);
        mInsuranceSelectedAgentAdapter = new InsuranceSelectedAgentAdapter(insuranceAgentModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(mInsuranceSelectedAgentAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_agent_upload_pinfo;
    }
}
