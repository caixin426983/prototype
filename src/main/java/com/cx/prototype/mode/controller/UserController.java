package com.cx.prototype.mode.controller;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.mode.service.UserInfoService;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 用户控制层
 * @Author cx
 * @Date 2019/1/7 14:45
 **/
@RestController
@RequestMapping(value = "user")
@Api(value = "user")
public class UserController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    @ApiOperation(value = "getUser", notes = "getUser")
    public ResultBean getUser(HttpServletRequest request, HttpServletResponse response) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("liaohang");
        userInfo.setName("廖航");
        return this.getDataSuccess(request, response, userInfo);
    }


    /**
     * 注册用户
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "register", notes = "注册用户")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBean register(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
        UserInfo user = userInfoService.findByUsername(param.getString("username"));
        if (null != user) {
            return this.fail(402, "该用户已存在！");
        }
        return this.userInfoService.save(this.success(request, response), param);
    }

}
