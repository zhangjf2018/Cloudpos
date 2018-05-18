package com.ymt.cloudpos.core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.util.CommonUtil;

/**
 * Created by ai on 2018/4/14.
 */

public abstract class BaseActivity extends AppCompatActivity  {

    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    private Toolbar mToolbar;
    private TextView tvNavTitle;
    private TextView tvNavRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initToolBar();
        tvNavTitle = (TextView) findViewById(R.id.tv_navTitle);
        tvNavRight = (TextView) findViewById(R.id.tv_navRight);
    }

    private void initToolBar(){
        mToolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        if(mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mToolbar.setNavigationOnClickListener(new BackClickListenr());
        }
    }

    public void setToolBarTitle(CharSequence title) {
        if(tvNavTitle != null) {
            tvNavTitle.setText(title);
        }
    }

    public void setToolBarRight( CharSequence text){
        if(tvNavRight != null) {
            tvNavRight.setVisibility(View.VISIBLE);
            tvNavRight.setText(text);
        }
    }

    public void setToolBarRightOnclickListener(View.OnClickListener listener){
        tvNavRight.setOnClickListener(listener);
    }

    public void showToast( String msg){
        CommonUtil.showToast(this, msg);
    }
    public void showToastError( String msg){
        CommonUtil.toastError(this, msg);
    }
    public void showSuccess( String msg){
        CommonUtil.toastSuccess(this, msg);
    }
    public void showInfo( String msg){
        CommonUtil.toastInfo(this, msg);
    }

    protected abstract int getLayoutId();

    private class BackClickListenr implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}
