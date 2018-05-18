package com.ymt.cloudpos.core.network;

import android.databinding.tool.util.L;
import android.util.Log;

import com.ymt.cloudpos.constant.ConstantAPIURI;
import com.ymt.cloudpos.constant.ConstantOKHTTP;
import com.ymt.cloudpos.core.secure.api.Aes2ConverterFactory;
import com.ymt.cloudpos.core.secure.api.AesConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by zhangjifeng on 2018/5/18.
 * email : 414512194@qq.com
 * desc  :
 */

public class RetrofitTool {

    private OkHttpClient mOkHttpClient;
    private HttpLoggingInterceptor HTTP_LOGGING_INTERCEPTOR = new HttpLoggingInterceptor(
            new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("OKHttp-----", message);
                }
            }
    ).setLevel(HttpLoggingInterceptor.Level.BODY);
    private Retrofit retrofit;

    public RetrofitTool() {
        Log.e("*****************","********************");
        mOkHttpClient = new OkHttpClient.Builder()
                //log 拦截器
                .addInterceptor(HTTP_LOGGING_INTERCEPTOR)
                .connectTimeout(ConstantOKHTTP.CONN_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ConstantOKHTTP.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(ConstantOKHTTP.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(ConstantAPIURI.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(Aes2ConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
       // .addConverterFactory(GsonConverterFactory.create())
    }
    public static RetrofitTool getInstance() {
        return RetrofitToolHolder.singleTonInstance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class RetrofitToolHolder {
        private static final RetrofitTool singleTonInstance = new RetrofitTool();
    }
}
