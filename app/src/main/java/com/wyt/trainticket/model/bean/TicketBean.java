package com.wyt.trainticket.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 车票信息实体类
 */
public class TicketBean implements Parcelable {

    /**
     * validateMessagesShowId : _validatorMessage
     * status : true
     * httpstatus : 200
     * data : [{"queryLeftNewDTO":{"train_no":"240000G1010C","station_train_code":"G101","start_station_telecode":"VNP","start_station_name":"北京南","end_station_telecode":"AOH","end_station_name":"上海虹桥","from_station_telecode":"VNP","from_station_name":"北京南","to_station_telecode":"AOH","to_station_name":"上海虹桥","start_time":"06:44","arrive_time":"12:38","day_difference":"0","train_class_name":"","lishi":"05:54","canWebBuy":"Y","lishiValue":"354","yp_info":"vMYMSN0OgRxNoButoqHgSfgwbVfU6TjKOwsBsKRRH6DVGft2","control_train_day":"20301231","start_train_date":"20170318","seat_feature":"O3M393","yp_ex":"O0M090","train_seat_feature":"3","train_type_code":"2","start_province_code":"31","start_city_code":"0357","end_province_code":"33","end_city_code":"0712","seat_types":"OM9","location_code":"P2","from_station_no":"01","to_station_no":"11","control_day":29,"sale_time":"1230","is_support_card":"1","controlled_train_flag":"0","controlled_train_message":"正常车次，不受控","gg_num":"--","gr_num":"--","qt_num":"--","rw_num":"--","rz_num":"--","tz_num":"--","wz_num":"--","yb_num":"--","yw_num":"--","yz_num":"--","ze_num":"有","zy_num":"有","swz_num":"18"},"secretStr":"AW79wOuQxbfqhfbW1KqO%2FmcAkH9i0M9Z1VMkzfuE7bVFQ3HAT2lgiaDiG6BHMjzXyTcbanhjQ%2Fa3%0Ab%2BNF2qpW4OsrQnmy6w5TUKptzCgasqXXaKYazKcAiFgYv2COBpxskjXcQ7913MvUK8z%2FJau72ysN%0AyX0Jw15QFsxiO%2F6LL3XJS21HDULYyoMF%2FiBukz7f9KHK2uA6Rcki0ZtRxH86DkaNc%2FPnqKCBBaDK%0AS3Ekocc158iBuz0o%2FatxMnFdC0iKj2v7%2FUYgTvlyFx10N5tcNgjq4eWjQpInGZCRu0J8Gt4gBlyk%0A0qIdsxNdIEY%3D","buttonTextInfo":"预订"},{"queryLeftNewDTO":{"train_no":"24000000G502","station_train_code":"G5","start_station_telecode":"VNP","start_station_name":"北京南","end_station_telecode":"AOH","end_station_name":"上海虹桥","from_station_telecode":"VNP","from_station_name":"北京南","to_station_telecode":"AOH","to_station_name":"上海虹桥","start_time":"07:00","arrive_time":"11:55","day_difference":"0","train_class_name":"","lishi":"04:55","canWebBuy":"Y","lishiValue":"295","yp_info":"AjLT3TJyJXDrnZpgTLWkkmbO4cG0KcWG67rnrWgWabrrGuiC","control_train_day":"20301231","start_train_date":"20170318","seat_feature":"O3M393","yp_ex":"O0M090","train_seat_feature":"3","train_type_code":"2","start_province_code":"31","start_city_code":"0357","end_province_code":"33","end_city_code":"0712","seat_types":"OM9","location_code":"P2","from_station_no":"01","to_station_no":"04","control_day":29,"sale_time":"1230","is_support_card":"1","controlled_train_flag":"0","controlled_train_message":"正常车次，不受控","gg_num":"--","gr_num":"--","qt_num":"--","rw_num":"--","rz_num":"--","tz_num":"--","wz_num":"--","yb_num":"--","yw_num":"--","yz_num":"--","ze_num":"有","zy_num":"有","swz_num":"20"},"secretStr":"%2FpkkQAHqAkak9jIxDEbhkyJl6514kV8CdWDM3LRpcBczccmmlUzmn6orjb6X7xaTuw%2BVi1Zedwx8%0AbRC0%2BGFxoKTBo6Rnv9%2FPf76vOfACo8zvUc89gtfPUOXgC1flgdnJTN4golGyAE%2B7N%2FTHviqk6ij0%0AK7FMPUJFmgsOzjEaSTjaN6naIx2Q7HLorJJl5Qyj5j10N5FS67aZIeUqJ5aenGGgWWGoCYLR9Sze%0A84SkPPglaBrkbBJzuK1x6wAz4dPcPloDYfa%2BfZe8QZTE1gjf%2Fle%2BpEylnQZUxKWV1mWFJHV5fI7P%0AbGHO7k8A2LQ%3D","buttonTextInfo":"预订"}]
     * messages : []
     * validateMessages : {}
     */

    private String validateMessagesShowId;
    private boolean status;
    private int httpstatus;
    /**
     * queryLeftNewDTO : {"train_no":"240000G1010C","station_train_code":"G101","start_station_telecode":"VNP","start_station_name":"北京南","end_station_telecode":"AOH","end_station_name":"上海虹桥","from_station_telecode":"VNP","from_station_name":"北京南","to_station_telecode":"AOH","to_station_name":"上海虹桥","start_time":"06:44","arrive_time":"12:38","day_difference":"0","train_class_name":"","lishi":"05:54","canWebBuy":"Y","lishiValue":"354","yp_info":"vMYMSN0OgRxNoButoqHgSfgwbVfU6TjKOwsBsKRRH6DVGft2","control_train_day":"20301231","start_train_date":"20170318","seat_feature":"O3M393","yp_ex":"O0M090","train_seat_feature":"3","train_type_code":"2","start_province_code":"31","start_city_code":"0357","end_province_code":"33","end_city_code":"0712","seat_types":"OM9","location_code":"P2","from_station_no":"01","to_station_no":"11","control_day":29,"sale_time":"1230","is_support_card":"1","controlled_train_flag":"0","controlled_train_message":"正常车次，不受控","gg_num":"--","gr_num":"--","qt_num":"--","rw_num":"--","rz_num":"--","tz_num":"--","wz_num":"--","yb_num":"--","yw_num":"--","yz_num":"--","ze_num":"有","zy_num":"有","swz_num":"18"}
     * secretStr : AW79wOuQxbfqhfbW1KqO%2FmcAkH9i0M9Z1VMkzfuE7bVFQ3HAT2lgiaDiG6BHMjzXyTcbanhjQ%2Fa3%0Ab%2BNF2qpW4OsrQnmy6w5TUKptzCgasqXXaKYazKcAiFgYv2COBpxskjXcQ7913MvUK8z%2FJau72ysN%0AyX0Jw15QFsxiO%2F6LL3XJS21HDULYyoMF%2FiBukz7f9KHK2uA6Rcki0ZtRxH86DkaNc%2FPnqKCBBaDK%0AS3Ekocc158iBuz0o%2FatxMnFdC0iKj2v7%2FUYgTvlyFx10N5tcNgjq4eWjQpInGZCRu0J8Gt4gBlyk%0A0qIdsxNdIEY%3D
     * buttonTextInfo : 预订
     */

    private List<DataEntity> data;
    private List<String> messages;

    public String getValidateMessagesShowId() {
        return validateMessagesShowId;
    }

    public void setValidateMessagesShowId(String validateMessagesShowId) {
        this.validateMessagesShowId = validateMessagesShowId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(int httpstatus) {
        this.httpstatus = httpstatus;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public static class DataEntity implements Parcelable {

        /**
         * train_no : 240000G1010C
         * station_train_code : G101
         * start_station_telecode : VNP
         * start_station_name : 北京南
         * end_station_telecode : AOH
         * end_station_name : 上海虹桥
         * from_station_telecode : VNP
         * from_station_name : 北京南
         * to_station_telecode : AOH
         * to_station_name : 上海虹桥
         * start_time : 06:44
         * arrive_time : 12:38
         * day_difference : 0
         * train_class_name :
         * lishi : 05:54
         * canWebBuy : Y
         * lishiValue : 354
         * yp_info : vMYMSN0OgRxNoButoqHgSfgwbVfU6TjKOwsBsKRRH6DVGft2
         * control_train_day : 20301231
         * start_train_date : 20170318
         * seat_feature : O3M393
         * yp_ex : O0M090
         * train_seat_feature : 3
         * train_type_code : 2
         * start_province_code : 31
         * start_city_code : 0357
         * end_province_code : 33
         * end_city_code : 0712
         * seat_types : OM9
         * location_code : P2
         * from_station_no : 01
         * to_station_no : 11
         * control_day : 29
         * sale_time : 1230
         * is_support_card : 1
         * controlled_train_flag : 0
         * controlled_train_message : 正常车次，不受控
         * gg_num : --
         * gr_num : --
         * qt_num : --
         * rw_num : --
         * rz_num : --
         * tz_num : --
         * wz_num : --
         * yb_num : --
         * yw_num : --
         * yz_num : --
         * ze_num : 有
         * zy_num : 有
         * swz_num : 18
         */

        private QueryLeftNewDTOEntity queryLeftNewDTO;
        private String secretStr;
        private String buttonTextInfo;

        public QueryLeftNewDTOEntity getQueryLeftNewDTO() {
            return queryLeftNewDTO;
        }

        public void setQueryLeftNewDTO(QueryLeftNewDTOEntity queryLeftNewDTO) {
            this.queryLeftNewDTO = queryLeftNewDTO;
        }

        public String getSecretStr() {
            return secretStr;
        }

        public void setSecretStr(String secretStr) {
            this.secretStr = secretStr;
        }

        public String getButtonTextInfo() {
            return buttonTextInfo;
        }

        public void setButtonTextInfo(String buttonTextInfo) {
            this.buttonTextInfo = buttonTextInfo;
        }

        public static class QueryLeftNewDTOEntity implements Parcelable {
            private String train_no;
            private String station_train_code;
            private String start_station_telecode;
            private String start_station_name;
            private String end_station_telecode;
            private String end_station_name;
            private String from_station_telecode;
            private String from_station_name;
            private String to_station_telecode;
            private String to_station_name;
            private String start_time;
            private String arrive_time;
            private String day_difference;
            private String train_class_name;
            private String lishi;
            private String canWebBuy;
            private String lishiValue;
            private String yp_info;
            private String control_train_day;
            private String start_train_date;
            private String seat_feature;
            private String yp_ex;
            private String train_seat_feature;
            private String train_type_code;
            private String start_province_code;
            private String start_city_code;
            private String end_province_code;
            private String end_city_code;
            private String seat_types;
            private String location_code;
            private String from_station_no;
            private String to_station_no;
            private int control_day;
            private String sale_time;
            private String is_support_card;
            private String controlled_train_flag;
            private String controlled_train_message;
            private String gg_num;
            private String gr_num;
            private String qt_num;
            private String rw_num;
            private String rz_num;
            private String tz_num;
            private String wz_num;
            private String yb_num;
            private String yw_num;
            private String yz_num;
            private String ze_num;
            private String zy_num;
            private String swz_num;

            public String getTrain_no() {
                return train_no;
            }

            public void setTrain_no(String train_no) {
                this.train_no = train_no;
            }

            public String getStation_train_code() {
                return station_train_code;
            }

            public void setStation_train_code(String station_train_code) {
                this.station_train_code = station_train_code;
            }

            public String getStart_station_telecode() {
                return start_station_telecode;
            }

            public void setStart_station_telecode(String start_station_telecode) {
                this.start_station_telecode = start_station_telecode;
            }

            public String getStart_station_name() {
                return start_station_name;
            }

            public void setStart_station_name(String start_station_name) {
                this.start_station_name = start_station_name;
            }

            public String getEnd_station_telecode() {
                return end_station_telecode;
            }

            public void setEnd_station_telecode(String end_station_telecode) {
                this.end_station_telecode = end_station_telecode;
            }

            public String getEnd_station_name() {
                return end_station_name;
            }

            public void setEnd_station_name(String end_station_name) {
                this.end_station_name = end_station_name;
            }

            public String getFrom_station_telecode() {
                return from_station_telecode;
            }

            public void setFrom_station_telecode(String from_station_telecode) {
                this.from_station_telecode = from_station_telecode;
            }

            public String getFrom_station_name() {
                return from_station_name;
            }

            public void setFrom_station_name(String from_station_name) {
                this.from_station_name = from_station_name;
            }

            public String getTo_station_telecode() {
                return to_station_telecode;
            }

            public void setTo_station_telecode(String to_station_telecode) {
                this.to_station_telecode = to_station_telecode;
            }

            public String getTo_station_name() {
                return to_station_name;
            }

            public void setTo_station_name(String to_station_name) {
                this.to_station_name = to_station_name;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getArrive_time() {
                return arrive_time;
            }

            public void setArrive_time(String arrive_time) {
                this.arrive_time = arrive_time;
            }

            public String getDay_difference() {
                return day_difference;
            }

            public void setDay_difference(String day_difference) {
                this.day_difference = day_difference;
            }

            public String getTrain_class_name() {
                return train_class_name;
            }

            public void setTrain_class_name(String train_class_name) {
                this.train_class_name = train_class_name;
            }

            public String getLishi() {
                return lishi;
            }

            public void setLishi(String lishi) {
                this.lishi = lishi;
            }

            public String getCanWebBuy() {
                return canWebBuy;
            }

            public void setCanWebBuy(String canWebBuy) {
                this.canWebBuy = canWebBuy;
            }

            public String getLishiValue() {
                return lishiValue;
            }

            public void setLishiValue(String lishiValue) {
                this.lishiValue = lishiValue;
            }

            public String getYp_info() {
                return yp_info;
            }

            public void setYp_info(String yp_info) {
                this.yp_info = yp_info;
            }

            public String getControl_train_day() {
                return control_train_day;
            }

            public void setControl_train_day(String control_train_day) {
                this.control_train_day = control_train_day;
            }

            public String getStart_train_date() {
                return start_train_date;
            }

            public void setStart_train_date(String start_train_date) {
                this.start_train_date = start_train_date;
            }

            public String getSeat_feature() {
                return seat_feature;
            }

            public void setSeat_feature(String seat_feature) {
                this.seat_feature = seat_feature;
            }

            public String getYp_ex() {
                return yp_ex;
            }

            public void setYp_ex(String yp_ex) {
                this.yp_ex = yp_ex;
            }

            public String getTrain_seat_feature() {
                return train_seat_feature;
            }

            public void setTrain_seat_feature(String train_seat_feature) {
                this.train_seat_feature = train_seat_feature;
            }

            public String getTrain_type_code() {
                return train_type_code;
            }

            public void setTrain_type_code(String train_type_code) {
                this.train_type_code = train_type_code;
            }

            public String getStart_province_code() {
                return start_province_code;
            }

            public void setStart_province_code(String start_province_code) {
                this.start_province_code = start_province_code;
            }

            public String getStart_city_code() {
                return start_city_code;
            }

            public void setStart_city_code(String start_city_code) {
                this.start_city_code = start_city_code;
            }

            public String getEnd_province_code() {
                return end_province_code;
            }

            public void setEnd_province_code(String end_province_code) {
                this.end_province_code = end_province_code;
            }

            public String getEnd_city_code() {
                return end_city_code;
            }

            public void setEnd_city_code(String end_city_code) {
                this.end_city_code = end_city_code;
            }

            public String getSeat_types() {
                return seat_types;
            }

            public void setSeat_types(String seat_types) {
                this.seat_types = seat_types;
            }

            public String getLocation_code() {
                return location_code;
            }

            public void setLocation_code(String location_code) {
                this.location_code = location_code;
            }

            public String getFrom_station_no() {
                return from_station_no;
            }

            public void setFrom_station_no(String from_station_no) {
                this.from_station_no = from_station_no;
            }

            public String getTo_station_no() {
                return to_station_no;
            }

            public void setTo_station_no(String to_station_no) {
                this.to_station_no = to_station_no;
            }

            public int getControl_day() {
                return control_day;
            }

            public void setControl_day(int control_day) {
                this.control_day = control_day;
            }

            public String getSale_time() {
                return sale_time;
            }

            public void setSale_time(String sale_time) {
                this.sale_time = sale_time;
            }

            public String getIs_support_card() {
                return is_support_card;
            }

            public void setIs_support_card(String is_support_card) {
                this.is_support_card = is_support_card;
            }

            public String getControlled_train_flag() {
                return controlled_train_flag;
            }

            public void setControlled_train_flag(String controlled_train_flag) {
                this.controlled_train_flag = controlled_train_flag;
            }

            public String getControlled_train_message() {
                return controlled_train_message;
            }

            public void setControlled_train_message(String controlled_train_message) {
                this.controlled_train_message = controlled_train_message;
            }

            public String getGg_num() {
                return gg_num;
            }

            public void setGg_num(String gg_num) {
                this.gg_num = gg_num;
            }

            public String getGr_num() {
                return gr_num;
            }

            public void setGr_num(String gr_num) {
                this.gr_num = gr_num;
            }

            public String getQt_num() {
                return qt_num;
            }

            public void setQt_num(String qt_num) {
                this.qt_num = qt_num;
            }

            public String getRw_num() {
                return rw_num;
            }

            public void setRw_num(String rw_num) {
                this.rw_num = rw_num;
            }

            public String getRz_num() {
                return rz_num;
            }

            public void setRz_num(String rz_num) {
                this.rz_num = rz_num;
            }

            public String getTz_num() {
                return tz_num;
            }

            public void setTz_num(String tz_num) {
                this.tz_num = tz_num;
            }

            public String getWz_num() {
                return wz_num;
            }

            public void setWz_num(String wz_num) {
                this.wz_num = wz_num;
            }

            public String getYb_num() {
                return yb_num;
            }

            public void setYb_num(String yb_num) {
                this.yb_num = yb_num;
            }

            public String getYw_num() {
                return yw_num;
            }

            public void setYw_num(String yw_num) {
                this.yw_num = yw_num;
            }

            public String getYz_num() {
                return yz_num;
            }

            public void setYz_num(String yz_num) {
                this.yz_num = yz_num;
            }

            public String getZe_num() {
                return ze_num;
            }

            public void setZe_num(String ze_num) {
                this.ze_num = ze_num;
            }

            public String getZy_num() {
                return zy_num;
            }

            public void setZy_num(String zy_num) {
                this.zy_num = zy_num;
            }

            public String getSwz_num() {
                return swz_num;
            }

            public void setSwz_num(String swz_num) {
                this.swz_num = swz_num;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.train_no);
                dest.writeString(this.station_train_code);
                dest.writeString(this.start_station_telecode);
                dest.writeString(this.start_station_name);
                dest.writeString(this.end_station_telecode);
                dest.writeString(this.end_station_name);
                dest.writeString(this.from_station_telecode);
                dest.writeString(this.from_station_name);
                dest.writeString(this.to_station_telecode);
                dest.writeString(this.to_station_name);
                dest.writeString(this.start_time);
                dest.writeString(this.arrive_time);
                dest.writeString(this.day_difference);
                dest.writeString(this.train_class_name);
                dest.writeString(this.lishi);
                dest.writeString(this.canWebBuy);
                dest.writeString(this.lishiValue);
                dest.writeString(this.yp_info);
                dest.writeString(this.control_train_day);
                dest.writeString(this.start_train_date);
                dest.writeString(this.seat_feature);
                dest.writeString(this.yp_ex);
                dest.writeString(this.train_seat_feature);
                dest.writeString(this.train_type_code);
                dest.writeString(this.start_province_code);
                dest.writeString(this.start_city_code);
                dest.writeString(this.end_province_code);
                dest.writeString(this.end_city_code);
                dest.writeString(this.seat_types);
                dest.writeString(this.location_code);
                dest.writeString(this.from_station_no);
                dest.writeString(this.to_station_no);
                dest.writeInt(this.control_day);
                dest.writeString(this.sale_time);
                dest.writeString(this.is_support_card);
                dest.writeString(this.controlled_train_flag);
                dest.writeString(this.controlled_train_message);
                dest.writeString(this.gg_num);
                dest.writeString(this.gr_num);
                dest.writeString(this.qt_num);
                dest.writeString(this.rw_num);
                dest.writeString(this.rz_num);
                dest.writeString(this.tz_num);
                dest.writeString(this.wz_num);
                dest.writeString(this.yb_num);
                dest.writeString(this.yw_num);
                dest.writeString(this.yz_num);
                dest.writeString(this.ze_num);
                dest.writeString(this.zy_num);
                dest.writeString(this.swz_num);
            }

            public QueryLeftNewDTOEntity() {
            }

            protected QueryLeftNewDTOEntity(Parcel in) {
                this.train_no = in.readString();
                this.station_train_code = in.readString();
                this.start_station_telecode = in.readString();
                this.start_station_name = in.readString();
                this.end_station_telecode = in.readString();
                this.end_station_name = in.readString();
                this.from_station_telecode = in.readString();
                this.from_station_name = in.readString();
                this.to_station_telecode = in.readString();
                this.to_station_name = in.readString();
                this.start_time = in.readString();
                this.arrive_time = in.readString();
                this.day_difference = in.readString();
                this.train_class_name = in.readString();
                this.lishi = in.readString();
                this.canWebBuy = in.readString();
                this.lishiValue = in.readString();
                this.yp_info = in.readString();
                this.control_train_day = in.readString();
                this.start_train_date = in.readString();
                this.seat_feature = in.readString();
                this.yp_ex = in.readString();
                this.train_seat_feature = in.readString();
                this.train_type_code = in.readString();
                this.start_province_code = in.readString();
                this.start_city_code = in.readString();
                this.end_province_code = in.readString();
                this.end_city_code = in.readString();
                this.seat_types = in.readString();
                this.location_code = in.readString();
                this.from_station_no = in.readString();
                this.to_station_no = in.readString();
                this.control_day = in.readInt();
                this.sale_time = in.readString();
                this.is_support_card = in.readString();
                this.controlled_train_flag = in.readString();
                this.controlled_train_message = in.readString();
                this.gg_num = in.readString();
                this.gr_num = in.readString();
                this.qt_num = in.readString();
                this.rw_num = in.readString();
                this.rz_num = in.readString();
                this.tz_num = in.readString();
                this.wz_num = in.readString();
                this.yb_num = in.readString();
                this.yw_num = in.readString();
                this.yz_num = in.readString();
                this.ze_num = in.readString();
                this.zy_num = in.readString();
                this.swz_num = in.readString();
            }

            public static final Creator<QueryLeftNewDTOEntity> CREATOR = new Creator<QueryLeftNewDTOEntity>() {
                @Override
                public QueryLeftNewDTOEntity createFromParcel(Parcel source) {
                    return new QueryLeftNewDTOEntity(source);
                }

                @Override
                public QueryLeftNewDTOEntity[] newArray(int size) {
                    return new QueryLeftNewDTOEntity[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.queryLeftNewDTO, flags);
            dest.writeString(this.secretStr);
            dest.writeString(this.buttonTextInfo);
        }

        public DataEntity() {
        }

        protected DataEntity(Parcel in) {
            this.queryLeftNewDTO = in.readParcelable(QueryLeftNewDTOEntity.class.getClassLoader());
            this.secretStr = in.readString();
            this.buttonTextInfo = in.readString();
        }

        public static final Creator<DataEntity> CREATOR = new Creator<DataEntity>() {
            @Override
            public DataEntity createFromParcel(Parcel source) {
                return new DataEntity(source);
            }

            @Override
            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.validateMessagesShowId);
        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
        dest.writeInt(this.httpstatus);
        dest.writeList(this.data);
        dest.writeList(this.messages);
    }

    public TicketBean() {
    }

    protected TicketBean(Parcel in) {
        this.validateMessagesShowId = in.readString();
        this.status = in.readByte() != 0;
        this.httpstatus = in.readInt();
        this.data = new ArrayList<DataEntity>();
        in.readList(this.data, DataEntity.class.getClassLoader());
        this.messages = new ArrayList<String>();
        in.readList(this.messages, String.class.getClassLoader());
    }

    public static final Parcelable.Creator<TicketBean> CREATOR = new Parcelable.Creator<TicketBean>() {
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
