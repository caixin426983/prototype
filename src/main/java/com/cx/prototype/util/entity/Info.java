package com.cx.prototype.util.entity;

/**
 * @Description 提示信息
 * @Author cx
 * @Date 2019/1/9 15:46
 **/
public class Info {

    /**
     * 保存
     */
    public static class Save {

        // 成功
        public static String success(int count) {
            return "成功保存 " + count + " 条数据!";
        }

        // 失败
        public static String fail() {
            return "保存失败!";
        }

        // 失败 - 自定义文字
        public static String fail(String text) {
            return "保存失败, " + text;
        }

        // 失败 - 类型不匹配
        public static String typeError() {
            return "保存失败, 数据类型不能完全匹配!";
        }

        // 失败 - 重复
        public static String repeated(String type) {
            return "保存失败, 已存在重复的" + type + "!";
        }
    }


    /**
     * 删除
     */
    public static class Delete {
        // 成功
        public static String success(int count) {
            return "成功删除 " + count + " 条数据!";
        }

        // 失败
        public static String fail() {
            return "删除失败!";
        }

        // 失败 - 自定义文字
        public static String fail(String text) {
            return "删除失败, " + text + "!";
        }
    }
}
