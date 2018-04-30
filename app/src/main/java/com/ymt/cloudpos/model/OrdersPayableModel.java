package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/30.
 * email : 414512194@qq.com
 * desc  :
 */

public class OrdersPayableModel {
    private String orderno;
    private String followUpPerson;
    private String insuranceCompanyName;
    private String plateNum;
    private String transTime;
    private String payableAmt;

    public OrdersPayableModel(String orderno, String followUpPerson, String insuranceCompanyName, String plateNum, String transTime, String payableAmt) {
        this.orderno = orderno;
        this.followUpPerson = followUpPerson;
        this.insuranceCompanyName = insuranceCompanyName;
        this.plateNum = plateNum;
        this.transTime = transTime;
        this.payableAmt = payableAmt;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getFollowUpPerson() {
        return followUpPerson;
    }

    public void setFollowUpPerson(String followUpPerson) {
        this.followUpPerson = followUpPerson;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getPayableAmt() {
        return payableAmt;
    }

    public void setPayableAmt(String payableAmt) {
        this.payableAmt = payableAmt;
    }
}
