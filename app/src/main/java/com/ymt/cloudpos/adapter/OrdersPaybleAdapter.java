package com.ymt.cloudpos.adapter;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.OrdersPayableModel;
import com.ymt.cloudpos.model.RecommendGoodModel;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class OrdersPaybleAdapter extends RecyclerBaseAdapter<OrdersPayableModel> {

    public OrdersPaybleAdapter(List<OrdersPayableModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.orders_payable_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.ordersPayableModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, OrdersPayableModel item) {
        TextView tvPay = (TextView) holder.getBinding().getRoot().findViewById(R.id.tv_pay);
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(v.getContext(), "点击付款", Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
