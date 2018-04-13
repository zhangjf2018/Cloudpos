package com.ymt.cloudpos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

import java.util.List;

/**
 * MainActivity的片段管理,关联bottomNavigationBar的点击
 * */

public class FragmentUtils {

    private FragmentManager mFragmentManager;
    private List<Fragment> mList;
    private BottomNavigationBar mBottomNavigationBar;
    private int mLayout;
    private int mCurrentIndex;

    public static FragmentUtils getInstance(FragmentManager supportFragmentManager, List<Fragment> fragmentList, int fragment_content, BottomNavigationBar bottomNavigationBar) {
        return new FragmentUtils( supportFragmentManager, fragmentList, fragment_content, bottomNavigationBar);
    }

    public FragmentUtils(FragmentManager supportFragmentManager, List<Fragment> fragmentList, int fragment_content, BottomNavigationBar bottomNavigationBar) {
        this.mFragmentManager = supportFragmentManager;
        this.mList = fragmentList;
        this.mBottomNavigationBar = bottomNavigationBar;
        this.mLayout = fragment_content;
        showFragment(0);
    }

    //显示fragment
    private void showFragment(int position) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        Fragment fragment;
        fragment = mList.get(position);
        if (!fragment.isAdded()) {
            ft.add( mLayout, fragment );
        }
        ft.show(fragment);
        if (mCurrentIndex != position){
            ft.hide(mList.get(mCurrentIndex));
            mCurrentIndex = position;
        }
        ft.commit();
    }

    public void getFragment() {
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        showFragment(0);
                        break;
                    case 1:
                        showFragment(1);
                        break;
                    case 2:
                        showFragment(2);
                        break;
                    case 3:
                        showFragment(3);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }
}
