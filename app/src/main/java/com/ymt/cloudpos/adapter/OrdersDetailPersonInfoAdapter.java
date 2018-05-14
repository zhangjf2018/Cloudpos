package com.ymt.cloudpos.adapter;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.OrderDetailPersonInfoModel;
import com.ymt.cloudpos.model.OrdersPayableModel;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class OrdersDetailPersonInfoAdapter extends RecyclerBaseAdapter<OrderDetailPersonInfoModel> {

    public OrdersDetailPersonInfoAdapter(List<OrderDetailPersonInfoModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.orders_detail_personinfo_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.orderDetailPersonInfoModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, OrderDetailPersonInfoModel item) {

    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
