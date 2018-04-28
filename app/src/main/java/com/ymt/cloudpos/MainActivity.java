package com.ymt.cloudpos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.ymt.cloudpos.core.CustomApplication;
import com.ymt.cloudpos.observable.EventBadgeItem;
import com.ymt.cloudpos.util.LoginStatus;
import com.ymt.cloudpos.view.HomeFragment;
import com.ymt.cloudpos.view.LoginActivity;
import com.ymt.cloudpos.view.MineFragment;
import com.ymt.cloudpos.view.ServiceFragment;
import com.ymt.cloudpos.view.ShopFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private BottomNavigationBar mBottomNavigationBar;
    private TextBadgeItem mTextBadgeItem;
//    private BadgeItem mBadgeItem2;
    private int num;
    private ImageView mIconView;
    private ImageView mIconView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!LoginStatus.isLogin(this)){
           // Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            //startActivity(intent);
        }
        initTab();
        initFragment();
    }

    /**
     * 初识化tab
     */
    private void initTab() {
        EventBadgeItem.getInstance().register(this);

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setInActiveColor(R.color.line_bg_color);
        mBottomNavigationBar.setActiveColor(R.color.mainColor);
        mBottomNavigationBar.setBarBackgroundColor(R.color.white);

        mTextBadgeItem = new TextBadgeItem();

        List<BottomNavigationItem> items = new ArrayList<>();
        items.add(getItem(R.mipmap.icon_home, R.string.main_home));
        items.add(getItem(R.mipmap.icon_type, R.string.main_shop));
        items.add(getItem(R.mipmap.icon_sc, R.string.main_service));
        items.add(getItem(R.mipmap.icon_mine, R.string.main_mine));

        for (BottomNavigationItem item : items) {
            mBottomNavigationBar.addItem(item);
        }
        mBottomNavigationBar.setFirstSelectedPosition(CustomApplication.mainCurrentFragmentPos);
        mBottomNavigationBar.initialise();
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                CustomApplication.mainCurrentFragmentPos = position;
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    /**
     * 初始化对应的fragment
     */
    private void initFragment() {
        //tab 和 fragment 联动
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ShopFragment());
        fragmentList.add(new ServiceFragment());
        fragmentList.add(new MineFragment());
        FragmentUtils.getInstance(getSupportFragmentManager(), fragmentList, R.id.fragment_content, mBottomNavigationBar).getFragment();
    }

    private BottomNavigationItem getItem(int icon, int string) {
        return new BottomNavigationItem(icon, string);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String) {
//            mBadgeItem.setText((String) arg);
//            mBadgeItem2.setText((String) arg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBadgeItem.getInstance().unregister(this);
    }
}
