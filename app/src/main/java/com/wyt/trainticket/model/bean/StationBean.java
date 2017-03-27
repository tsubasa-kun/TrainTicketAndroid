package com.wyt.trainticket.model.bean;

import java.util.List;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 站点实体类
 */
public class StationBean {

    /**
     * station_info : [{"station":"北京北","code":"VAP"},{"station":"北京东","code":"BOP"},{"station":"北京","code":"BJP"},{"station":"北京南","code":"VNP"},{"station":"北京西","code":"BXP"}]
     * status : ok
     */

    private String status;
    /**
     * station : 北京北
     * code : VAP
     */

    private List<StationInfoEntity> station_info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StationInfoEntity> getStation_info() {
        return station_info;
    }

    public void setStation_info(List<StationInfoEntity> station_info) {
        this.station_info = station_info;
    }

    public static class StationInfoEntity {
        private String station;
        private String code;

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
