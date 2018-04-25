package com.ymt.cloudpos.model;

import java.util.List;

/**
 * Created by zhangjifeng on 2018/4/24.
 * email : 414512194@qq.com
 * desc  :
 */

public class WholeComboModel {
    private String name ;
    private int resImgId;
    private List<WholeComboItemModel> wholeComboItemModels;

    public WholeComboModel(String name, int resImgId, List<WholeComboItemModel> wholeComboItemModels) {
        this.name = name;
        this.resImgId = resImgId;
        this.wholeComboItemModels = wholeComboItemModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResImgId() {
        return resImgId;
    }

    public void setResImgId(int resImgId) {
        this.resImgId = resImgId;
    }

    public List<WholeComboItemModel> getWholeComboItemModels() {
        return wholeComboItemModels;
    }

    public void setWholeComboItemModels(List<WholeComboItemModel> wholeComboItemModels) {
        this.wholeComboItemModels = wholeComboItemModels;
    }
}
