package com.ymt.cloudpos.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.OrdersGenJinModel;
import com.ymt.cloudpos.model.OrdersPayableModel;
import com.ymt.cloudpos.view.OrderDetailActivity;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class OrdersGenJinAdapter extends RecyclerBaseAdapter<OrdersGenJinModel> {

    private Context mContext;

    public OrdersGenJinAdapter(List<OrdersGenJinModel> mData, Context context) {
        super(mData);
        this.mContext = context;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.orders_genjin_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.ordersGenJinModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, final OrdersGenJinModel item) {
        TextView tvCancel = (TextView) holder.getBinding().getRoot().findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(v.getContext(), "点击取消订单", Toast.LENGTH_SHORT, true).show();
            }
        });
        TextView tvDetail = (TextView) holder.getBinding().getRoot().findViewById(R.id.tv_detail);
        tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext, OrderDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("OrdersGenJinModel",item);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
