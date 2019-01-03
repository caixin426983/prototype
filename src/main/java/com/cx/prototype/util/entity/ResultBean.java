package com.cx.prototype.util.entity;


public class ResultBean<T> {

    private int code;

    private String message;

    private Object data;

    public ResultBean() {
    }

    public static ResultBean error() {
        return error(Constant.FAIL_CODE, Constant.FAIL_CN);
    }

    public static ResultBean error(int code, String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        return resultBean;
    }

    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(Constant.SUCCESS_CODE);
        resultBean.setMessage(Constant.SUCCESS);
        return resultBean;
    }

    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(Constant.SUCCESS_CODE);
        resultBean.setMessage(Constant.SUCCESS);
        resultBean.setData(data);
        return resultBean;
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
}
