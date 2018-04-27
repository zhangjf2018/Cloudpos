package com.ymt.cloudpos.adapter;

import android.view.View;
import android.widget.ImageView;

import com.ymt.cloudpos.BR;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.adaper.RecyclerBaseAdapter;
import com.ymt.cloudpos.core.adaper.RecyclerViewHolder;
import com.ymt.cloudpos.model.IdUploadModel;
import com.ymt.cloudpos.model.RecommendGoodModel;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/3/21.
 * email : 414512194@qq.com
 * desc  :
 */
public class InsuranceAgentUploadItemAdapter extends RecyclerBaseAdapter<IdUploadModel> {

    public InsuranceAgentUploadItemAdapter(List<IdUploadModel> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.insurance_agent_upload_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.idUploadModel;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, final int position, IdUploadModel item) {
        ImageView delete = (ImageView) holder.getBinding().getRoot().findViewById(R.id.iv_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.get(position).setLocPath(null);
                notifyDataSetChanged();
            }
        });
    }

    public interface BindCustomEvent {
        public void bind(RecyclerViewHolder holder, int position, IdUploadModel item);
    }

    @Override
    public int getStartMode() {
        return 1;
    }
}
