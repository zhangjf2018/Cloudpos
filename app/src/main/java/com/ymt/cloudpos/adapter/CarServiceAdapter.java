package com.ymt.cloudpos.adapter;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.CarServiceModel;


import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class CarServiceAdapter extends RecyclerBaseAdapter<CarServiceModel> {

    public CarServiceAdapter(List<CarServiceModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.function_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.carServiceModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, CarServiceModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
