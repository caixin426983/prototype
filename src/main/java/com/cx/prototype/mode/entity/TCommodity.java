package com.cx.prototype.mode.entity;


import com.baomidou.mybatisplus.annotations.TableName;
import com.cx.prototype.util.entity.BaseEntity;


/**
 * @author cx123
 * @since 2019-04-19
 */
@TableName("t_commodity")
public class TCommodity extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    private String name;
    /**
     * 图片1
     */
    private String img1;
    /**
     * 图片2
     */
    private String img2;
    /**
     * 图片3
     */
    private String img3;
    /**
     * 类型(保留字段)
     */
    private Integer type;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String describe;
    /**
     * 对应积分
     */
    private Integer integral;

    /**
     * 库存
     */
    private Integer stock;
    /**
     * 状态(1：启用  ; 2: 禁用)
     */
    private Integer state;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
