package com.ymt.cloudpos.core.secure.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by zhangjifeng on 2018/5/18.
 * email : 414512194@qq.com
 * desc  :
 */

public class AesResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    AesResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String string = value.string();
        Log.e("----","#解密前@#" + string);
       // string = AesEncryptionUtil.decrypt(string);
        Log.e("----","#解密后@#" + string);
        return adapter.fromJson(string);
    }
}
