package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/30.
 * email : 414512194@qq.com
 * desc  :
 */

public class WithDrawCashDetailModel {
    private String transType;
    private String withDrawCashAmt;
    private String withDrawCashTime;

    public WithDrawCashDetailModel(String transType, String withDrawCashAmt, String withDrawCashTime) {
        this.transType = transType;
        this.withDrawCashAmt = withDrawCashAmt;
        this.withDrawCashTime = withDrawCashTime;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getWithDrawCashAmt() {
        return withDrawCashAmt;
    }

    public void setWithDrawCashAmt(String withDrawCashAmt) {
        this.withDrawCashAmt = withDrawCashAmt;
    }

    public String getWithDrawCashTime() {
        return withDrawCashTime;
    }

    public void setWithDrawCashTime(String withDrawCashTime) {
        this.withDrawCashTime = withDrawCashTime;
    }
}
