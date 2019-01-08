package com.cx.prototype.util.shiro;

import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.util.entity.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.util.StringUtils;

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

    /**
     * 对密码进行加密
     *
     * @return
     */
    public static String getPassword(UserInfo userInfo) {
        String password = userInfo.getPassword();
        String salt = userInfo.getCredentialsSalt();//拿取盐值
        if (StringUtils.isEmpty(password)) {
            password = Constant.DEFAULT_PASSWORD;
        }
        Md5Hash md5Hash = new Md5Hash(password, salt, 2);
        return md5Hash.toString();
    }

}
