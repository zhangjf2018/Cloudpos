package com.ymt.cloudpos.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.ymt.cloudpos.BR;

/**
 * Created by zhangjifeng on 2018/5/17.
 * email : 414512194@qq.com
 * desc  :
 */

public class UserInfo extends BaseObservable {
    private String name;
    private String acc;
    private String password;
    public final ObservableField<Integer> accDeleteVisible = new ObservableField<>(View.GONE);
    public final ObservableField<Integer> passwordDeleteVisible = new ObservableField<>(View.GONE);

    public UserInfo() {
    }

    public UserInfo(String name, String acc, String password) {
        this.name = name;
        this.acc = acc;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        setPasswordDeleteVisible();
        notifyPropertyChanged(BR.password);
    }

    private void setPasswordDeleteVisible() {
        if(TextUtils.isEmpty(password)){
            passwordDeleteVisible.set(View.GONE);
        }else{
            passwordDeleteVisible.set(View.VISIBLE);
        }
    }
    @Bindable
    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
        setAccDeleteVisible();
        notifyPropertyChanged(BR.acc);
    }

    private void setAccDeleteVisible() {
        if(TextUtils.isEmpty(acc)){
            accDeleteVisible.set(View.GONE);
        }else{
            accDeleteVisible.set(View.VISIBLE);
        }
    }

    public void accClear(View view){
        setAcc(null);
    }

    public void passwordClear(View view){
        setPassword(null);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", acc='" + acc + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
