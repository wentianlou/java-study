package com.study.javastudy.util;

public enum ResultCodeEnum {
    // 响应码定义
    SUCCESS(200, "ok"),
    REQUEST_ERROR(400, "param error"),
    FORBIDDEN(403, "403 FORBIDDEN"),
    NOT_FOUND(404, "404 not found"),
    METHOD_NOT_ALLOWED(405, "method not allowed"),
    DATA_ERR(420, "data err"),

    SYSTEM_ERROR(500, "system error"),
    NO_ROOM_CODE(11000, "房间码不存在"),
    JOIN_ROOM_EARLIER(11005, "forbid join room too early"),
    JOIN_ROOM_OUT_OF_TIME(11006, "join room out of time"),
    EXIT_ROOM_ERROR(11007, "exit room fail"),
    ROOM_NOT_EXIST(11008, "房间不存在"),
    JOIN_ROOM_EXPER_TOO_LATE(11009,"体验课首次加入房间太迟"),
    EXPERIENCE_KEICK_OUT_USER(11010,"体验课已被踢出"),

    WECHAT_CONF_NOT_EXIT(13001,"微信配置不存在"),
    WECHAT_SEND_MSG_ERROR(13002,"发送微信消息失败"),

    RPC_ERROR(14001,"远程服务调度失败"),

    LOGIN_NUM_LIMIT_ERROR(610, "登录次数过多、请之后再试"),
    LOGIN_ACCOUNT_NOT_EXIST(601, "该账号不存在"),
    LOGIN_ACCOUNT_LOCKED(602, "账号已被锁定"),
    LOGIN_PASSWORD_ERROR(603, "密码错误"),
    SMS_CODE_ERROR(604, "验证码错误或超时"),
    NEW_ACCOUNT_EXIST(605, "账户(手机号)已存在"),
    ACCOUNT_NO_CHANGE(606, "账户(手机号)不能与当前一致"),
    ACCOUNT_DIFFERENCE(607, "账号与当前账号不一致"),

    GET_SMS_CODE_ERROR(608, "获取验证码次数频繁，请稍后再试！"),

    TOKEN_ACCESS_TOKEN_OUT_DATE(701, "accessToken out of date"),
    TOKEN_REFRESH_TOKEN_OUT_DATE(702, "refreshToken out of date"),
    TOKEN_ACCESS_TOKEN_ERROR(703, "accessToken error"),
    TOKEN_REFRESH_TOKEN_ERROR(704, "refreshToken error"),

    //画币错误码
    DM_BALANCE_NOT_ENOUGH(801,"很遗憾，您的画币余额不足，不能兑换此奖品"),
    DM_BALANCE_LOCK(802,"画币余额锁定"),
    DM_GOODS_NOT_ON_SALE(803,"很遗憾，该奖品已从商城下架，无法兑换"),
    DM_HAS_RECORD(804, "原来你已经有这节录播课了，重新兑换吧。"),
    DM_RECORD_FILL(805,"录播课已集满"),
    DM_RECORD_FILL_BEFORE_EXCHANGE(806,"录播课已集满"),

    MISS_MESSAGE(15000,"请输入完整信息"),
    PHONE_NUM_ILLEGAL(15001,"请输入正确的手机号码"),

    ALMOST_NO_WINTER_VACATION_PLACES(12004, "almost no winter vacation places"),

    // 课堂评价问卷已经填写
    CLASS_EVALUATE_QUESTIONNAIRE(16001, "课堂评价问卷已经填写"),
    // 课堂评价问卷已经超过30天
    CLASS_EVALUATE_QVERTIME(16002, "课堂评价问卷已经超过30天"),
    //RetryableException超时
    RETRYABLE_EXCEPTION_QVERTIME(17001, "呀~找不到录播课了？快去找班主任问问情况吧~");

    private final int code;
    private final String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResultCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
