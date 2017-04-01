package com.wyt.trainticket.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cookie on 2017/3/31.
 * <p>
 * description：一般结果实体类
 */

public class ResultBean implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resStatus);
        dest.writeString(this.resMsg);
    }

    public ResultBean() {
    }

    protected ResultBean(Parcel in) {
        this.resStatus = in.readString();
        this.resMsg = in.readString();
    }

    public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator<ResultBean>() {
        @Override
        public ResultBean createFromParcel(Parcel source) {
            return new ResultBean(source);
        }

        @Override
        public ResultBean[] newArray(int size) {
            return new ResultBean[size];
        }
    };
}
