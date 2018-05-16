package com.ymt.cloudpos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.BaseActivity;

public class SubAccountAddActivity extends BaseActivity implements View.OnClickListener {
    private Boolean showPassword = true;
    private ImageView mIvPasswordHidden;
    private EditText mEtInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolBarTitle("添加子账号");

        mIvPasswordHidden = (ImageView) findViewById(R.id.iv_passwordHidden);
        mIvPasswordHidden.setOnClickListener(this);
        mEtInputPassword = (EditText) findViewById(R.id.et_inputPassword);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub_account_add;
    }

    @Override
    public void onClick(View v) {

        if(showPassword){
            mIvPasswordHidden.setImageDrawable(ContextCompat.getDrawable(this,R.mipmap.pic_open_eye));
            mEtInputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            mEtInputPassword.setSelection(mEtInputPassword.getText().toString().length());
            showPassword = !showPassword;
        } else {// 隐藏密码
            mIvPasswordHidden.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.pic_close_eye));
            mEtInputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            mEtInputPassword.setSelection(mEtInputPassword.getText().toString().length());
            showPassword = !showPassword;
        }
    }
}
