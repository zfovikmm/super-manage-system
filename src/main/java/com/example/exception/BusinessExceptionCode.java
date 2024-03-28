package com.example.exception;

public enum BusinessExceptionCode {

    USER_LOGIN_NAME_EXIST("用户名已存在"),
    USER_IS_NOT_LOGGED_IN("用户未登录"),
    LPN_LOGIN_NAME_EXIST("车牌已存在"),

    ParkNum_LOGIN_NAME_EXIST("车位已存在"),
    ReservationNum_LOGIN_NAME_EXIST("车位已被占用"),
    LOGIN_USER_ERROR("用户名不存在或密码错误"),
    VOTE_REPEAT("您已点赞过"),
    RESERVATION_TIME_LEGAL("请输入合法时间"),
    BALANCE_IS_INSUFFICIENT("余额不足"),
    LeaseNum_LOGIN_NAME_EXIST("车位已被占用"),
    USER_NOT_REGISTERED("用户未注册")
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
