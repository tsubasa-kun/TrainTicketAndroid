package com.wyt.trainticket.model.bean;

import android.os.Parcel;

import java.util.List;

/**
 * Created by Cookie on 2017/4/20.
 * <p>
 * description：联系人列表实体类
 */

public class MemberListBean extends ResultBean {

    private List<MemberBean> members;

    public List<MemberBean> getMembers() {
        return members;
    }

    public void setMembers(List<MemberBean> members) {
        this.members = members;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.members);
    }

    public MemberListBean() {
    }

    protected MemberListBean(Parcel in) {
        super(in);
        this.members = in.createTypedArrayList(MemberBean.CREATOR);
    }

    public static final Creator<MemberListBean> CREATOR = new Creator<MemberListBean>() {
        @Override
        public MemberListBean createFromParcel(Parcel source) {
            return new MemberListBean(source);
        }

        @Override
        public MemberListBean[] newArray(int size) {
            return new MemberListBean[size];
        }
    };
}
