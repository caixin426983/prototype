package com.cx.prototype.mode.entity;

import com.cx.prototype.util.entity.BaseEntity;

/**
 * @Description 商家实体类
 * @Author cx
 * @Date 2019/1/16 15:47
 **/
public class TSeller extends BaseEntity {
    private static final long serialVersionUID = 5153316594988916528L;


    /**
     * 商家编号
     */
    private String number;

    /**
     * 商家名称
     */
    private String name;

    /**
     * 店铺类型
     */
    private Integer type;

    /**
     * 所属目录
     */
    private String catalog;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
