package com.ymt.cloudpos.view;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;
import com.ymt.cloudpos.view.effectinsurance.WholeComboFragment;

import java.util.ArrayList;

public class EffectInsuranceActivity extends BaseActivity {

    private SegmentTabLayout segmentTabLayout;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"全保套餐", "经济套餐", "基础套餐", "交强险", "自定义"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("车险方案详情");

        initFragmentData();
        segmentTabLayout = (SegmentTabLayout) findViewById(R.id.stl_insurance);
        initPager();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_effect_insurance;
    }

    private void initFragmentData(){
        mFragments.add(WholeComboFragment.getInstance(mTitles[0]));
        mFragments.add(WholeComboFragment.getInstance(mTitles[1]));
        mFragments.add(WholeComboFragment.getInstance(mTitles[2]));
        mFragments.add(WholeComboFragment.getInstance(mTitles[3]));
        mFragments.add(WholeComboFragment.getInstance(mTitles[4]));
    }

    private void initPager(){
        final ViewPager vp_insurance = (ViewPager) findViewById(R.id.vp_insurance);
        vp_insurance.setAdapter(new InsurancePagerAdapter(getSupportFragmentManager()));
        vp_insurance.setOffscreenPageLimit(5);
        segmentTabLayout.setTabData(mTitles);
        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp_insurance.setCurrentItem(position , false);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        vp_insurance.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                segmentTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_insurance.setCurrentItem(0);

//        segmentTabLayout.showDot(1);
//
//        //设置未读消息红点
//        segmentTabLayout.showDot(2);
//        MsgView rtv_3_2 = segmentTabLayout.getMsgView(2);
//        if (rtv_3_2 != null) {
//            rtv_3_2.setBackgroundColor(Color.parseColor("#6D8FB0"));
//        }
    }
    private class InsurancePagerAdapter extends FragmentPagerAdapter {
        public InsurancePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
