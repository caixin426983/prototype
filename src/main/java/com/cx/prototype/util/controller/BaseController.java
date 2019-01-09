package com.cx.prototype.util.controller;

import com.cx.prototype.util.entity.Constant;
import com.cx.prototype.util.entity.ResultBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description BaseController类 封装一下返回结果
 * @Author cx
 * @Date 2019/1/8 10:36
 **/
public class BaseController {

    /**
     * 生成一个Result，默认采用成功标识
     *
     * @param request
     * @param response
     * @return
     */
    public ResultBean success(HttpServletRequest request, HttpServletResponse response) {
        ResultBean resultBean = new ResultBean();
        return resultBean.SUCCESS();
    }

    /**
     * 生成一个带结果Result，默认采用成功标识
     *
     * @param request
     * @param response
     * @param data
     * @return
     */
    public ResultBean getDataSuccess(HttpServletRequest request, HttpServletResponse response, Object data) {
        return success(request, response).addData("data", data);
    }


    /**
     * 生成一个带结果Result，自定义消息
     *
     * @param code
     * @param message
     * @return
     */
    public ResultBean fail(int code, String message) {
        ResultBean resultBean = new ResultBean();
        return resultBean.FAIL(code, message);
    }

    /**
     * 生成一个错误标识，采用默认的code码与消息
     *
     * @return
     */
    public ResultBean fail(String message) {
        return fail(Constant.FAIL_CODE, message);
    }


    /**
     * 生成一个错误标识，采用默认的code码与消息
     *
     * @return
     */
    public ResultBean fail() {
        return fail(Constant.FAIL_CODE, Constant.FAIL_CN);
    }
}
