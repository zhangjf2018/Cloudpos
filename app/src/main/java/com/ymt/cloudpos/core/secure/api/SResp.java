package com.ymt.cloudpos.core.secure.api;

/**
 * Created by zhangjifeng on 2018/5/18.
 * email : 414512194@qq.com
 * desc  :
 */

public class SResp {
    private String retcode;
    private String retmsg;

    public SResp() {
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }
}
