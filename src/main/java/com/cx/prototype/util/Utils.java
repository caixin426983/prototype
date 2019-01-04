package com.cx.prototype.util;

/**
 * @Description 工具类
 * @Author cx
 * @Date 2019/1/4 16:47
 **/
public class Utils {


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
}
