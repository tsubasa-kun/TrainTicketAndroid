package com.wyt.trainticket.model.bean;

import android.os.Parcel;

import java.util.List;

/**
 * Created by Cookie on 2017/4/17.
 * <p>
 * description：车票列表实体类
 */

public class TicketListBean extends ResultBean {
    private List<TicketBean> tickets;

    public List<TicketBean> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketBean> tickets) {
        this.tickets = tickets;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.tickets);
    }

    public TicketListBean() {
    }

    protected TicketListBean(Parcel in) {
        super(in);
        this.tickets = in.createTypedArrayList(TicketBean.CREATOR);
    }

    public static final Creator<TicketListBean> CREATOR = new Creator<TicketListBean>() {
        @Override
        public TicketListBean createFromParcel(Parcel source) {
            return new TicketListBean(source);
        }

        @Override
        public TicketListBean[] newArray(int size) {
            return new TicketListBean[size];
        }
    };
}
