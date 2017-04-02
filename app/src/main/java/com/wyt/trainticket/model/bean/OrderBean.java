package com.wyt.trainticket.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 订单实体类
 */
public class OrderBean extends ResultBean implements Parcelable {
    private String orderId;//订单ID
    private String account;//账户
    private String trainNo;//车次
    private String fromStation;//出发地
    private String startTime;//出发时间
    private String toStation;//目的地
    private String endTime;//到站时间
    private String date;//日期
    private String seat;//席别
    private String carriage;//车厢
    private String seatNo;// 座位号
    private String money;//票价
    private String type;//车票类型

    public String getCarriage() {
        return carriage;
    }

    public void setCarriage(String carriage) {
        this.carriage = carriage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orderId);
        dest.writeString(this.account);
        dest.writeString(this.trainNo);
        dest.writeString(this.fromStation);
        dest.writeString(this.startTime);
        dest.writeString(this.toStation);
        dest.writeString(this.endTime);
        dest.writeString(this.date);
        dest.writeString(this.seat);
        dest.writeString(this.carriage);
        dest.writeString(this.seatNo);
        dest.writeString(this.money);
        dest.writeString(this.type);
    }

    public OrderBean() {
    }

    protected OrderBean(Parcel in) {
        this.orderId = in.readString();
        this.account = in.readString();
        this.trainNo = in.readString();
        this.fromStation = in.readString();
        this.startTime = in.readString();
        this.toStation = in.readString();
        this.endTime = in.readString();
        this.date = in.readString();
        this.seat = in.readString();
        this.carriage = in.readString();
        this.seatNo = in.readString();
        this.money = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<OrderBean> CREATOR = new Parcelable.Creator<OrderBean>() {
        @Override
        public OrderBean createFromParcel(Parcel source) {
            return new OrderBean(source);
        }

        @Override
        public OrderBean[] newArray(int size) {
            return new OrderBean[size];
        }
    };
}
