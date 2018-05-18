package com.ymt.cloudpos.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.GsonBuilder;
import com.ymt.cloudpos.R;
import com.ymt.cloudpos.core.network.RetrofitTool;
import com.ymt.cloudpos.core.secure.api.SResp;
import com.ymt.cloudpos.databinding.ActivityLoginBinding;
import com.ymt.cloudpos.model.UserInfo;
import com.ymt.cloudpos.test.Book;
import com.ymt.cloudpos.test.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangjifeng on 2018/4/13.
 * email : 414512194@qq.com
 * desc  :
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setUserInfo(new UserInfo());
        //setContentView(R.layout.activity_login);

        binding.tvForgetPasswd.setOnClickListener(this);
        binding.btnLogin.setOnClickListener(this);
//        final EditText etLoginPassword = (EditText) findViewById(R.id.et_loginPassword);
//        etLoginPassword.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String editable = etLoginPassword.getText().toString();
//                String regEx = "[^a-zA-Z0-9#?!&*$@^]";  //只能输入字母或数字
//                Pattern p = Pattern.compile(regEx);
//                Matcher m = p.matcher(editable);
//                String str = m.replaceAll("").trim();    //删掉不是字母或数字的字符
//                if(!editable.equals(str)){
//                    etLoginPassword.setText(str);  //设置EditText的字符
//                    etLoginPassword.setSelection(str.length()); //因为删除了字符，要重写设置新的光标所在位置
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.tv_forgetPasswd:
                intent.setClass(LoginActivity.this, AccountCheckActivity.class);
                break;
            case R.id.btn_login:

             /*   RetrofitService service = RetrofitTool.getInstance().getRetrofit().create(RetrofitService.class);
                Call<Book> call =  service.getSearchBooks("金瓶梅", null, 0, 1);
                call.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Log.e("888:",response.body()+"");
                    }
                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Log.e("Throwable", t.getMessage());
                    }
                });*/

                RetrofitService service = RetrofitTool.getInstance().getRetrofit().create(RetrofitService.class);
                Call<SResp> call =  service.postQuery("biz=1231&name=张是打发");
                call.enqueue(new Callback<SResp>() {
                    @Override
                    public void onResponse(Call<SResp> call, Response<SResp> response) {
                        Log.e("888:",response.body()+"");
                        Log.e("aa", response.body().getRetcode());
                        Log.e("aa", response.body().getRetmsg());
                    }
                    @Override
                    public void onFailure(Call<SResp> call, Throwable t) {
                        Log.e("Throwable", t.getMessage());
                    }
                });

                Log.e("000",binding.getUserInfo().toString());
                intent.setClass(LoginActivity.this, RentDepositActivity.class);
                break;
        }
        startActivity(intent);
    }
}
