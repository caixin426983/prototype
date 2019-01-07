package com.cx.prototype.util.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 基础实体类
 * @Author cx
 * @Date 2019/1/4 15:31
 **/
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8686852328176544739L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改者
     */
    private Long updateBy;

    /**
     * 修改时间
     */
    private Date updateDate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
