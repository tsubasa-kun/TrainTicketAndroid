package com.wyt.trainticket.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cookie on 2017/4/20.
 * <p>
 * description：联系人实体类
 */

public class MemberBean extends ResultBean implements Parcelable {
    private int id;//ID
    private int userId;//用户ID
    private String memberRealName;//联系人真实姓名
    private String memberIdNumber;//联系人身份证号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMemberRealName() {
        return memberRealName;
    }

    public void setMemberRealName(String memberRealName) {
        this.memberRealName = memberRealName;
    }

    public String getMemberIdNumber() {
        return memberIdNumber;
    }

    public void setMemberIdNumber(String memberIdNumber) {
        this.memberIdNumber = memberIdNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.userId);
        dest.writeString(this.memberRealName);
        dest.writeString(this.memberIdNumber);
    }

    public MemberBean() {
    }

    protected MemberBean(Parcel in) {
        this.id = in.readInt();
        this.userId = in.readInt();
        this.memberRealName = in.readString();
        this.memberIdNumber = in.readString();
    }

    public static final Parcelable.Creator<MemberBean> CREATOR = new Parcelable.Creator<MemberBean>() {
        @Override
        public MemberBean createFromParcel(Parcel source) {
            return new MemberBean(source);
        }

        @Override
        public MemberBean[] newArray(int size) {
            return new MemberBean[size];
        }
    };
}
