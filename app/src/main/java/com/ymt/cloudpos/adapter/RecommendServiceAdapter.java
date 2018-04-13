package com.ymt.cloudpos.adapter;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.CarServiceModel;
import com.ymt.cloudpos.model.RecommendServiceModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class RecommendServiceAdapter extends RecyclerBaseAdapter<RecommendServiceModel> {

    public RecommendServiceAdapter(List<RecommendServiceModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.recommend_service_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.recommendServiceModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, RecommendServiceModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
