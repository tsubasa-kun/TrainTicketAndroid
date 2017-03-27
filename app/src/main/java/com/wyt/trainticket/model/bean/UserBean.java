package com.wyt.trainticket.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cookie on 2017/3/23 0023.
 *
 * 用户实体类
 */
public class UserBean implements Parcelable {
    private String userId;
    private String account;
    private String password;
    private String realName;
    private String idNumber;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.account);
        dest.writeString(this.password);
        dest.writeString(this.realName);
        dest.writeString(this.idNumber);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.userId = in.readString();
        this.account = in.readString();
        this.password = in.readString();
        this.realName = in.readString();
        this.idNumber = in.readString();
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
