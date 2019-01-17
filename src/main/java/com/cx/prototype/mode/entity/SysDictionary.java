package com.cx.prototype.mode.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.cx.prototype.util.entity.BaseEntity;

/**
 * @Description 字典类
 * @Author cx
 * @Date 2019/1/17 15:38
 **/
@TableName(value = "sys_dictionary")
public class SysDictionary extends BaseEntity {

    private static final long serialVersionUID = -4530502820010364404L;
    /**
     * 编码类型code
     */
    private String code;
    /**
     * 编码类型描述
     */
    private String codeName;
    /**
     * code编码(用于)
     */
    private Integer detail;
    /**
     * 编码详细信息
     */
    private String detailName;
    /**
     * 排序
     */
    private Integer sort;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getDetail() {
        return detail;
    }

    public void setDetail(Integer detail) {
        this.detail = detail;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
