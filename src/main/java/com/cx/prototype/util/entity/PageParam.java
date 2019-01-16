package com.cx.prototype.util.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * @Description 分页工具类
 * @Author cx
 * @Date 2019/1/16 16:24
 **/
public class PageParam implements Serializable {
    private static final long serialVersionUID = -2834738901267570561L;

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 条件参数
     */
    private JSONObject whereMap;

    public PageParam(int pageNum, int pageSize, JSONObject whereMap) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.whereMap = whereMap;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public JSONObject getWhereMap() {
        return whereMap;
    }

    public void setWhereMap(JSONObject whereMap) {
        this.whereMap = whereMap;
    }
}
