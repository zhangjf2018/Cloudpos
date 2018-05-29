package com.ymt.cloudpos.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseFragment;
import com.ymt.cloudpos.core.adaper.ViewChangeAdapter;
import com.ymt.cloudpos.core.wegit.NoScrollViewPager;
import com.ymt.cloudpos.core.wegit.SegmentView;
import com.ymt.cloudpos.view.shopfragment.CarProductFragment;
import com.ymt.cloudpos.view.shopfragment.CarProductFragment2;
import com.ymt.cloudpos.view.shopfragment.InsuranceProductFragment;
import com.ymt.cloudpos.view.shopfragment.InsuranceProductFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class ServiceFragment extends BaseFragment {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private List<Fragment> mFragment;
    private List<String> mTitle;
    private ViewChangeAdapter mmAdapter;
    private NoScrollViewPager noScrollViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_service, container, false);

        SegmentView sv = (SegmentView) view.findViewById(R.id.sv_proSelect2);
        sv.setOnSegmentViewClickListener(new ServiceFragment.onSegmentViewClickListener());
        noScrollViewPager = (NoScrollViewPager) view.findViewById(R.id.top_viewPager2);
        ;
        //  ft.replace(R.id.fragment_content,new InsuranceProductFragment());
        //ft.commit();

        //将Fragment装进列表中
        mFragment = new ArrayList<>();
        mFragment.add(new InsuranceProductFragment2());
        mFragment.add(new CarProductFragment2());

        //将名称添加daoTab列表
        mTitle = new ArrayList<>();
        mTitle.add("Tab1");
        mTitle.add("Tab2");

        //为TabLayout添加Tab名称

        mmAdapter = new ViewChangeAdapter(getActivity().getSupportFragmentManager(), mFragment, mTitle);
        noScrollViewPager.setAdapter(mmAdapter);
        noScrollViewPager.setNoScroll(true);
        noScrollViewPager.setCurrentItem(0);

        return view;
    }

    class onSegmentViewClickListener implements SegmentView.onSegmentViewClickListener{
        @Override
        public void onSegmentViewClick(View v, int position) {
            noScrollViewPager.setCurrentItem(position, false);
        }
    }
}
