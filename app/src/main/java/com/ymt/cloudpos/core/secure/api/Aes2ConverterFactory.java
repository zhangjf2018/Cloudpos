package com.ymt.cloudpos.core.secure.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/**
 * Created by zhangjifeng on 2018/5/18.
 * email : 414512194@qq.com
 * desc  :
 */

public class Aes2ConverterFactory extends Factory {

    public static Aes2ConverterFactory create() {
        return create(new Gson());
    }


    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public static Aes2ConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new Aes2ConverterFactory(gson);
    }

    private final Gson gson;

    private Aes2ConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                            Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new Aes2ResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        Log.e("----","#发起请求#");
        return new Aes2RequestBodyConverter(); // 请求
    }
}
