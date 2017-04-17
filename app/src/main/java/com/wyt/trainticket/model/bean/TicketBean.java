package com.wyt.trainticket.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cookie on 2017/4/17 0017.
 * <p>
 * 车票信息实体类
 */
public class TicketBean extends ResultBean {
    private String trainId;// 火车ID
    private String trainCode;// 车次
    private String startDate;// 日期
    private String startStationName;// 出发站
    private String startTime;// 出发时间
    private String lishi;// 历时
    private String toStationName;// 目的地
    private String arriveTime;// 到达时间
    private String wzNum;// 无座数量
    private String ywNum;// 硬卧数量
    private String yzNum;// 硬座数量
    private String zeNum;// 二等座数量
    private String zyNum;// 一等座数量
    private String swzNum;// 商务座数量
    private String wzMoney;// 无座价格
    private String ywMoney;// 硬卧价格
    private String yzMoney;// 硬座价格
    private String zeMoney;// 二等座价格
    private String zyMoney;// 一等座价格
    private String swzMoney;// /商务座价格

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLishi() {
        return lishi;
    }

    public void setLishi(String lishi) {
        this.lishi = lishi;
    }

    public String getToStationName() {
        return toStationName;
    }

    public void setToStationName(String toStationName) {
        this.toStationName = toStationName;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getWzNum() {
        return wzNum;
    }

    public void setWzNum(String wzNum) {
        this.wzNum = wzNum;
    }

    public String getYwNum() {
        return ywNum;
    }

    public void setYwNum(String ywNum) {
        this.ywNum = ywNum;
    }

    public String getYzNum() {
        return yzNum;
    }

    public void setYzNum(String yzNum) {
        this.yzNum = yzNum;
    }

    public String getZeNum() {
        return zeNum;
    }

    public void setZeNum(String zeNum) {
        this.zeNum = zeNum;
    }

    public String getZyNum() {
        return zyNum;
    }

    public void setZyNum(String zyNum) {
        this.zyNum = zyNum;
    }

    public String getSwzNum() {
        return swzNum;
    }

    public void setSwzNum(String swzNum) {
        this.swzNum = swzNum;
    }

    public String getWzMoney() {
        return wzMoney;
    }

    public void setWzMoney(String wzMoney) {
        this.wzMoney = wzMoney;
    }

    public String getYwMoney() {
        return ywMoney;
    }

    public void setYwMoney(String ywMoney) {
        this.ywMoney = ywMoney;
    }

    public String getYzMoney() {
        return yzMoney;
    }

    public void setYzMoney(String yzMoney) {
        this.yzMoney = yzMoney;
    }

    public String getZeMoney() {
        return zeMoney;
    }

    public void setZeMoney(String zeMoney) {
        this.zeMoney = zeMoney;
    }

    public String getZyMoney() {
        return zyMoney;
    }

    public void setZyMoney(String zyMoney) {
        this.zyMoney = zyMoney;
    }

    public String getSwzMoney() {
        return swzMoney;
    }

    public void setSwzMoney(String swzMoney) {
        this.swzMoney = swzMoney;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.trainId);
        dest.writeString(this.trainCode);
        dest.writeString(this.startDate);
        dest.writeString(this.startStationName);
        dest.writeString(this.startTime);
        dest.writeString(this.lishi);
        dest.writeString(this.toStationName);
        dest.writeString(this.arriveTime);
        dest.writeString(this.wzNum);
        dest.writeString(this.ywNum);
        dest.writeString(this.yzNum);
        dest.writeString(this.zeNum);
        dest.writeString(this.zyNum);
        dest.writeString(this.swzNum);
        dest.writeString(this.wzMoney);
        dest.writeString(this.ywMoney);
        dest.writeString(this.yzMoney);
        dest.writeString(this.zeMoney);
        dest.writeString(this.zyMoney);
        dest.writeString(this.swzMoney);
    }

    public TicketBean() {
    }

    protected TicketBean(Parcel in) {
        super(in);
        this.trainId = in.readString();
        this.trainCode = in.readString();
        this.startDate = in.readString();
        this.startStationName = in.readString();
        this.startTime = in.readString();
        this.lishi = in.readString();
        this.toStationName = in.readString();
        this.arriveTime = in.readString();
        this.wzNum = in.readString();
        this.ywNum = in.readString();
        this.yzNum = in.readString();
        this.zeNum = in.readString();
        this.zyNum = in.readString();
        this.swzNum = in.readString();
        this.wzMoney = in.readString();
        this.ywMoney = in.readString();
        this.yzMoney = in.readString();
        this.zeMoney = in.readString();
        this.zyMoney = in.readString();
        this.swzMoney = in.readString();
    }

    public static final Creator<TicketBean> CREATOR = new Creator<TicketBean>() {
        @Override
        public TicketBean createFromParcel(Parcel source) {
            return new TicketBean(source);
        }

        @Override
        public TicketBean[] newArray(int size) {
            return new TicketBean[size];
        }
    };
}
