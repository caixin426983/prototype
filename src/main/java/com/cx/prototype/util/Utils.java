package com.cx.prototype.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Description 工具类
 * @Author cx
 * @Date 2019/1/4 16:47
 **/
public class Utils {

    private static Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * 获取随机字符串并替换掉"-"
     *
     * @return
     */
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * 用于两个对象的转换(两个对象有相同的属性),以JSON为桥梁
     *
     * @param object 原始对象
     * @param cls    转换后的对象类型
     * @param <T>
     * @return
     */
    public static <T> T parseObject(Object object, Class<T> cls) {
        return com.alibaba.fastjson.JSONObject.parseObject(com.alibaba.fastjson.JSONObject.toJSONString(object), cls);
    }

    /**
     * 数据赋值(合并两个Map或POJO类)
     *
     * @param dest 目标对象
     * @param orig 源对象
     * @return
     */
    public static boolean copyProperties(Object dest, Object orig) {
        try {
            BeanUtilsBean.getInstance().getConvertUtils().register(new DateLocaleConverter((Object) null), Date.class);
            BeanUtils.copyProperties(dest, orig);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("copyProperties:" + e);
            return false;
        }
    }
}
