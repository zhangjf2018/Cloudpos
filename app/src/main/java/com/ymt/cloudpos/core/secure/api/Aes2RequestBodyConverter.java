package com.ymt.cloudpos.core.secure.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by zhangjifeng on 2018/5/18.
 * email : 414512194@qq.com
 * desc  :
 */

public class Aes2RequestBodyConverter implements Converter<String, RequestBody> {
    //private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

    Aes2RequestBodyConverter() {

    }

    @Override
    public RequestBody convert(String value) throws IOException {
        String json = value.toString();
        Log.e("----","#加密前#" + json);
        //json = AesEncryptionUtil.encrypt(json);
        Log.e("----","#加密后#" + json);
        return RequestBody.create(MEDIA_TYPE, json);
    }
}
