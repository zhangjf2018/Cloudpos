package com.ymt.cloudpos.adapter;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.InsuranceAgentModel;
import com.ymt.cloudpos.model.PayWayModel;
import com.ymt.cloudpos.model.RecommendGoodModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class InsuranceAgentAdapter extends RecyclerBaseAdapter<InsuranceAgentModel> {

    private List<InsuranceAgentModel> dataList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    public InsuranceAgentAdapter(List<InsuranceAgentModel> mData) {
        super(mData);
        this.dataList = mData;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.select_insurance_agent_item;
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
        final CheckBox cb = (CheckBox) holder.getBinding().getRoot().findViewById(R.id.cb_isCheck);
        final InsuranceAgentModel p = item;
        final int pos = position;

//        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.e("count1", count+":"+pos);
//                if(isChecked){
//                    if(count > 2) {
//                        cb.setChecked(false);
//                        return;
//                    }
//                    count ++;
//                }else {
//                    count --;
//                }
//                dataList.get(pos).setCheckOn(isChecked);
//            }
//        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheck(pos, cb);
            }
        });
    }

    public void setCheck(int position, View view){
        Log.e("count2", count+":"+position);

        boolean check = dataList.get(position).isCheckOn();
        if(check){
            count --;
            if(count<0) count=0;
            dataList.get(position).setCheckOn(false);
            notifyDataSetChanged();
            return;
        }

        if(count>2){
            ((CheckBox)view).setChecked(false);
            return;
        }
        count ++;
        dataList.get(position).setCheckOn(true);
        notifyDataSetChanged();
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
