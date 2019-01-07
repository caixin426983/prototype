package com.cx.prototype.mode.controller;

import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户控制层
 * @Author cx
 * @Date 2019/1/7 14:45
 **/
@RestController
@RequestMapping(value = "user")
@Api(value = "user")
public class UserController {


    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ApiOperation(value = "getUser",notes = "getUser")
    public ResultBean getUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("liaohang");
        userInfo.setName("廖航");
        return ResultBean.SUCCESS(userInfo);
    }


}
