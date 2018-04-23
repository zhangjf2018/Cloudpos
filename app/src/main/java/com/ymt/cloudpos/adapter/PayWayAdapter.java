package com.ymt.cloudpos.adapter;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.CarServiceModel;
import com.ymt.cloudpos.model.PayWayModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class PayWayAdapter extends RecyclerBaseAdapter<PayWayModel> {

    private  List<PayWayModel> mData;

    public PayWayAdapter(List<PayWayModel> mData) {
        super(mData);
        this.mData = mData;
    }

    public void setChecked( int position){
        for (int i=0; i<mData.size();++i){
            mData.get(i).setChecked(false);
        }
        mData.get(position).setChecked(true);
        notifyDataSetChanged();
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.pay_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.payWayModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(final RecyclerViewHolder holder, int position, PayWayModel item) {
        Log.e("bindCustomData", "bindCustomData*************");
        CheckBox cb = (CheckBox) holder.getBinding().getRoot().findViewById(R.id.cb_payWay);
        final PayWayModel p = item;
        final int pos = position;
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(pos);
            }
        });
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
