package com.ymt.cloudpos.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.CarServiceAdapter;
import com.ymt.cloudpos.adapter.MineGridAdapter;
import com.ymt.cloudpos.core.BaseFragment;
import com.ymt.cloudpos.core.adaper.GridDividerItemDecoration;
import com.ymt.cloudpos.model.CarServiceModel;
import com.ymt.cloudpos.model.MineGridModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class MineFragment extends BaseFragment {

    private MineGridAdapter mMineGridAdapter;
    private List<MineGridModel> mMineGridModelList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        mMineGridModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mMineGridAdapter = new MineGridAdapter(mMineGridModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(mMineGridAdapter);
        recyclerView.addItemDecoration(new GridDividerItemDecoration(CommonUtil.dip2px(getContext(),2), ContextCompat.getColor(getContext(), R.color.bg_gray)));

        view.findViewById(R.id.tv_withDrawCash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), WithDrawCashActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.tv_payable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), OrdersPayableActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void setData(){
        mMineGridModelList.add(new MineGridModel(R.mipmap.personal, "个人资料"));
        mMineGridModelList.add(new MineGridModel(R.mipmap.time, "续保通知"));
        mMineGridModelList.add(new MineGridModel(R.mipmap.pay_rent, "租金支付"));
        mMineGridModelList.add(new MineGridModel(R.mipmap.custom_service, "客户服务"));
        mMineGridModelList.add(new MineGridModel(R.mipmap.sub_account, "子账号管理"));
        mMineGridModelList.add(new MineGridModel(R.mipmap.settings, "设置"));

    }

    @BindingAdapter({"resImgId"})
    public static void loadImage(ImageView imageView, int id) {
        imageView.setImageResource(id);
    }
}
