package com.ymt.cloudpos.view.shopfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.adapter.InsuranceProductAdapter;
import com.ymt.cloudpos.core.BaseFragment;
import com.ymt.cloudpos.core.adaper.RecyclerViewDivider;
import com.ymt.cloudpos.model.InsuranceProductModel;
import com.ymt.cloudpos.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class InsuranceProductFragment2 extends BaseFragment {

    private InsuranceProductAdapter mInsuranceProductAdapter;
    private List<InsuranceProductModel> mInsuranceProductModelList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop_insurance, container, false);

        mInsuranceProductModelList = new ArrayList<>();
        setData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewInsurance);
        mInsuranceProductAdapter = new InsuranceProductAdapter(mInsuranceProductModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mInsuranceProductAdapter);
        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, CommonUtil.dip2px(getContext(),6), ContextCompat.getColor(getContext(), R.color.alpaha_gray)));
        return view;
    }

    private void setData(){
        mInsuranceProductModelList.add(new InsuranceProductModel(R.drawable.s1, "大牌约惠暑期趴，旅游险送10%集分宝", "299"));
        mInsuranceProductModelList.add(new InsuranceProductModel(R.drawable.s2, "大牌约惠暑期趴，旅游险送10%集分宝", "599"));
        mInsuranceProductModelList.add(new InsuranceProductModel(R.drawable.s3, "大牌约惠暑期趴，旅游险送10%集分宝", "199"));
        mInsuranceProductModelList.add(new InsuranceProductModel(R.drawable.s5, "大牌约惠暑期趴，旅游险送10%集分宝", "199"));
        mInsuranceProductModelList.add(new InsuranceProductModel(R.drawable.s7, "大牌约惠暑期趴，旅游险送10%集分宝", "199"));
    }
}
