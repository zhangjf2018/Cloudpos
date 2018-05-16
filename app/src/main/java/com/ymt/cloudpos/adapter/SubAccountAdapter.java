package com.ymt.cloudpos.adapter;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.RecommendGoodModel;
import com.ymt.cloudpos.model.SubAccountModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class SubAccountAdapter extends RecyclerBaseAdapter<SubAccountModel> {

    public SubAccountAdapter(List<SubAccountModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.sub_account_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.subAccountModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, SubAccountModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
