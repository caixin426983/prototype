package com.cx.prototype.mode.service;


import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TMember;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author cx123
 * @since 2019-04-21
 */
public interface TMemberService {

        ResultBean list(ResultBean result, PageParam param);

        TMember detail(Long id);

        ResultBean insert(ResultBean result, JSONObject param);

        ResultBean update(ResultBean result, JSONObject param);

        int delete(Long id);

        void export(HttpServletRequest request, HttpServletResponse response);
}