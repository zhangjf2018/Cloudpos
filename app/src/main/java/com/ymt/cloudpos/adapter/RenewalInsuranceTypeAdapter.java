package com.ymt.cloudpos.adapter;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.RenewalInsuranceTypeModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class RenewalInsuranceTypeAdapter extends RecyclerBaseAdapter<RenewalInsuranceTypeModel> {

    public RenewalInsuranceTypeAdapter(List<RenewalInsuranceTypeModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.renewal_select_insurance_type_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.renewalInsuranceTypeModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, RenewalInsuranceTypeModel item) {
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
