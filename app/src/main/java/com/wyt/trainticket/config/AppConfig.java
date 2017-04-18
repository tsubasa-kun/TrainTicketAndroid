package com.wyt.trainticket.config;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 设置，接口
 */
public class AppConfig {
    /**
     * https://kyfw.12306.cn/otn/leftTicket/queryX?leftTicketDTO.train_date=2017-03-18&leftTicketDTO.from_station=VAP&leftTicketDTO.to_station=NKH&purpose_codes=ADULT
     */

    /**
     * 12306api地址
     */
    public static final String API_URL = "https://kyfw.12306.cn/otn/leftTicket/query";

    /**
     * 出发时间参数
     */
    public static final String DATE = "leftTicketDTO.train_date";

    /**
     * 出发站参数
     */
    public static final String FROM = "leftTicketDTO.from_station";

    /**
     * 终点站参数
     */
    public static final String TO = "leftTicketDTO.to_station";

    /**
     * 车票类型 ADULT-成人，0X00-学生
     */
    public static final String TYPE = "purpose_codes";

    /**
     * 成人
     */
    public static final String ADULT = "ADULT";

    /**
     * 学生
     */
    public static final String STUDENT = "0X00";

    /**
     * 全部
     */
    public static final int MODEL_ALL = 0;

    /**
     * G/D/C
     */
    public static final int MODEL_GDC = 1;

    /**
     * Z字头
     */
    public static final int MODEL_Z = 2;

    /**
     * T字头
     */
    public static final int MODEL_T = 3;

    /**
     * K字头
     */
    public static final int MODEL_K = 4;

    /**
     * 其他
     */
    public static final int MODEL_OTHER = 5;


    /**
     * 座次席别
     */
    public static final String SWZ = "商务座";
    public static final String YDZ = "一等座";
    public static final String EDZ = "二等座";
    public static final String YZ = "硬座";
    public static final String YW = "硬卧";
    public static final String WZ = "无座";

    /**
     * 订单状态
     */
    public static final int ORDER_UNFINISHED = 2;
    public static final int ORDER_NOW = 0;
    public static final int ORDER_OLD = 1;

    /**
     * http://192.168.1.8:8080/TrainTicketServer/api/RegisterServlet
     */

    /**
     * 域名
     */
    public static final String DOMAIN = "http://192.168.1.8:8080";

    /**
     * 服务器API地址
     */
    public static final String SERVER_URL = DOMAIN + "/TrainTicketServer/servlet/";

    /**
     * 注册
     */
    public static final String REGISTER = SERVER_URL + "RegisterServlet";

    /**
     * 登录
     */
    public static final String LOGIN = SERVER_URL + "LoginServlet";

    /**
     * 修改信息
     */
    public static final String MODIFY_INFO = SERVER_URL + "ModifyInfoServlet";

    /**
     * 修改密码
     */
    public static final String RESET_PASSWORD = SERVER_URL + "ResetPasswordServlet";

    /**
     * 查询车票
     */
    public static final String QUERY_TICKET = SERVER_URL + "QueryTicketServlet";

    /**
     * 购买车票
     */
    public static final String BUY_TICKET = SERVER_URL + "BuyTicketServlet";

    /**
     * 查询订单
     */
    public static final String QUERY_ORDER = SERVER_URL + "QueryOrderServlet";
}
