package com.ymt.cloudpos.model;

/**
 * Created by zhangjifeng on 2018/4/12.
 * email : 414512194@qq.com
 * desc  :
 */

public class PayWayModel {
    private int resImgId;
    private String title;
    private boolean isChecked;

    public PayWayModel() {
    }

    public PayWayModel(int resImgId, String title, boolean isChecked) {
        this.resImgId = resImgId;
        this.title = title;
        this.isChecked = isChecked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResImgId() {
        return resImgId;
    }

    public void setResImgId(int resImgId) {
        this.resImgId = resImgId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "PayWayModel{" +
                "resImgId=" + resImgId +
                ", title='" + title + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
