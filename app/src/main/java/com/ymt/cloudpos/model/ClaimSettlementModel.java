package com.ymt.cloudpos.model;

/**
 * Created by ai on 2018/4/29.
 */

public class ClaimSettlementModel {
    private String name;
    private String key;
    private String value;
    private String placeHodler;

    public ClaimSettlementModel(String name, String key, String value, String placeHodler) {
        this.name = name;
        this.key = key;
        this.value = value;
        this.placeHodler = placeHodler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPlaceHodler() {
        return placeHodler;
    }

    public void setPlaceHodler(String placeHodler) {
        this.placeHodler = placeHodler;
    }
}
