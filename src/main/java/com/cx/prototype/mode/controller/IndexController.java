package com.cx.prototype.mode.controller;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController extends BaseController {


    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    public ResultBean ajaxLogin(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo) {
        JSONObject jsonObject = new JSONObject();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.getDataSuccess(request, response, jsonObject);
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/noLogin",method = RequestMethod.GET)
    public ResultBean noLogin() {
        return this.fail();
    }

    /**
     * 无权限
     *
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ResultBean unauth() {
        return this.fail();
    }

    /**
     * 用户退出
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResultBean logout(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return this.success(request, response);
    }




}
