package com.ymt.cloudpos.adapter;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.InsuranceAgentModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class InsuranceSelectedAgentAdapter extends RecyclerBaseAdapter<InsuranceAgentModel> {

    public InsuranceSelectedAgentAdapter(List<InsuranceAgentModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.selected_insurance_agent_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.insuranceAgentModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, InsuranceAgentModel item) {
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
