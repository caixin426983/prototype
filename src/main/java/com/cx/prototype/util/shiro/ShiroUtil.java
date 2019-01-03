package com.cx.prototype.util.shiro;

import com.cx.prototype.mode.entity.UserInfo;
import org.apache.shiro.SecurityUtils;

/**
 * @Description Shiro工具类
 * @Author cx
 * @Date 2019/1/3 17:16
 **/
public class ShiroUtil {

    /**
     * 获取当前登录的用户名
     */
    public static String getUsername() {
        return SecurityUtils.getSubject().getPrincipal().toString();
    }


    /**
     * 获取当前登录的用户ID
     */
    public static Long getUserId() {
        return ((UserInfo) SecurityUtils.getSubject().getPrincipal()).getId();
    }


}
