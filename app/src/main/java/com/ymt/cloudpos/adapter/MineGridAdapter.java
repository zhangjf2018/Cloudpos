package com.ymt.cloudpos.adapter;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.MineGridModel;
import com.ymt.cloudpos.model.RecommendGoodModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class MineGridAdapter extends RecyclerBaseAdapter<MineGridModel> {

    public MineGridAdapter(List<MineGridModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.mine_grid_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.mineGridModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, MineGridModel item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
