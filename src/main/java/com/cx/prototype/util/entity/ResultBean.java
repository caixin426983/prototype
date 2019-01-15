package com.cx.prototype.util.entity;


public class ResultBean {

    private int code;

    private String message;

    private Object data ;

    public ResultBean() {
    }

    /**
     * 默认失败方法
     *
     * @return
     */
    public ResultBean FAIL() {
        return FAIL(Constant.FAIL_CODE, Constant.FAIL_CN);
    }

    /**
     * 设置为失败,自定义附加消息
     *
     * @param message
     * @return
     */
    public ResultBean FAIL(String message) {
        return FAIL(Constant.FAIL_CODE, message);
    }

    /**
     * 设置为失败,自定义
     *
     * @param code
     * @param message
     * @return
     */
    public ResultBean FAIL(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    /**
     * 默认成功
     *
     * @return
     */
    public ResultBean SUCCESS() {
        return SUCCESS(Constant.SUCCESS_CODE, Constant.SUCCESS);
    }

    /**
     * 成功——自定义消息
     *
     * @param message
     * @return
     */
    public ResultBean SUCCESS(String message) {
        return SUCCESS(Constant.SUCCESS_CODE, message);
    }

    /**
     * 成功——自定义状态码+消息
     *
     * @param code
     * @param message
     * @return
     */
    public ResultBean SUCCESS(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 添加数据
     *
     * @param data
     * @return
     */
    public ResultBean addData(Object data) {
        this.data = data;
        return this;
    }
}
