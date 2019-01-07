package com.cx.prototype.mode.controller;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.util.entity.Constant;
import com.cx.prototype.util.entity.ResultBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    public ResultBean ajaxLogin(UserInfo userInfo) {
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
        return ResultBean.SUCCESS(jsonObject);
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     *
     * @return
     */
    @RequestMapping(value = "/noLogin")
    public ResultBean noLogin() {
        return ResultBean.FAIL(Constant.NO_LOGIN_CODE, Constant.NO_LOGIN_CN);
    }

    /**
     * 无权限
     *
     * @return
     */
    @RequestMapping(value = "/unauth")
    public ResultBean unauth() {
        return ResultBean.FAIL(Constant.NO_AUTH_CODE, Constant.NO_AUTH_CN);
    }

    /**
     * 用户退出
     *
     * @return
     */
    @RequestMapping(value = "logout")
    public ResultBean logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultBean.SUCCESS();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResultBean test() {
        return ResultBean.SUCCESS("111111111111111111111");
    }

}
