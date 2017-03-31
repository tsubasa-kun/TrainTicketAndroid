package com.wyt.trainticket.model.bean;

/**
 * Created by Cookie on 2017/3/31.
 * <p>
 * description：一般结果实体类
 */

public class ResultBean {
    /**
     * resStatus : esStatus
     * resMsg : resMsg
     */
    private String resStatus;
    private String resMsg;

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
