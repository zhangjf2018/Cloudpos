package com.ymt.cloudpos.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ymt.cloudpos.R;

/**
 * Created by ai on 2018/4/14.
 */

public abstract class BaseActivity extends AppCompatActivity  {

    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    private Toolbar mToolbar;
    private TextView tvNavTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mToolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar =  getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(new BackClickListenr());

        tvNavTitle = (TextView) findViewById(R.id.tv_navTitle);
    }

    public void setToolBarTitle(CharSequence title) {
        if(tvNavTitle != null) {
            tvNavTitle.setText(title);
        }
    }

    protected abstract int getLayoutId();

    private class BackClickListenr implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
