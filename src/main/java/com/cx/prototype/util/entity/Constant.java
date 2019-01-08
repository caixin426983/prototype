package com.cx.prototype.util.entity;

/**
 * @Description 常量
 * @Author cx
 * @Date 2019/1/3 16:42
 **/
public class Constant {

    //成功失败常量
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAIL_CODE = 500;
    public static final Integer NO_LOGIN_CODE = 401; // 未登录
    public static final Integer NO_AUTH_CODE = 403; // 无权限

    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";
    public static final String SUCCESS_CN = "操作成功";
    public static final String FAIL_CN = "操作失败";
    public static final String NO_LOGIN_CN = "未登录";
    public static final String NO_AUTH_CN = "无权限";
    public static final String ILLEGAL_CN = "非法的用户";

    public static final String DEFAULT_PASSWORD = "123456";

}
