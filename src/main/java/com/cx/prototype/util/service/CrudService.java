package com.cx.prototype.util.service;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.prototype.util.Utils;
import com.cx.prototype.util.entity.BaseEntity;
import com.cx.prototype.util.entity.Info;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.shiro.ShiroUtil;

import java.util.Date;
import java.util.List;


/**
 * @Description
 * @Author cx
 * @Date 2019/1/8 11:42
 **/
public abstract class CrudService<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> {


    /**
     * 泛型实体
     */
    protected Class<T> entityClass = null;

    /**
     * 根据ID 查询实体
     *
     * @param id
     * @return
     */
    public T getById(Long id) {
        return this.baseMapper.selectById(id);
    }

    /**
     * 根据字段查询实体
     *
     * @param t
     * @return
     */
    public T getByEntity(T t) {
        return this.baseMapper.selectOne(t);
    }

    /**
     * 查询所有数据的列表
     *
     * @return
     */
    public List<T> findList() {
        return this.baseMapper.selectList(null);
    }

    /**
     * 根据字段查询数据列表
     *
     * @param t
     * @return
     */
    public List<T> findListByEntity(T t) {
        EntityWrapper<T> wrapper = new EntityWrapper<>();
        return this.baseMapper.selectList(wrapper);
    }

    /**
     * 纯粹的保存数据
     *
     * @param t
     * @return
     */
    public int save(T t) {
        if (t.getId() == null || t.getId().equals(0L)) {
            //新增
            t.setCreateDate(new Date());
            t.setCreateBy(ShiroUtil.getUserId());
            return this.baseMapper.insert(t);
        } else {
            //修改
            t.setUpdateBy(ShiroUtil.getUserId());
            t.setUpdateDate(new Date());
            return this.baseMapper.updateById(t);
        }
    }

    /**
     * 待结果生成的保存数据
     *
     * @param result
     * @param dataParam
     * @return
     */
    public ResultBean save(ResultBean result, JSONObject dataParam) {
        int count;
        T t = this.getById(dataParam.getLong("id"));
        if (t == null) {
            try {
                t = this.getInstance();
            } catch (Exception e) {
                return result.FAIL();
            }
        }

        //数据合并
        if (!Utils.copyProperties(t, dataParam)) {
            return result.FAIL(Info.Save.typeError());
        }

        //TODO 这里可以进行数据校验

        count = this.save(t);

        return result.SUCCESS(Info.Save.success(count));
    }

    /**
     *
     * @param result
     * @param t
     * @return
     */
    public ResultBean save(ResultBean result, T t) {
        int count;
        T entity = this.getById(t.getId());
        if (entity == null) {
            try {
                entity = this.getInstance();
            } catch (Exception e) {
                return result.FAIL();
            }
        }

        //数据合并
        if (!Utils.copyProperties(entity, t)) {
            return result.FAIL(Info.Save.typeError());
        }

        //TODO 这里可以进行数据校验

        count = this.save(entity);

        return result.SUCCESS(Info.Save.success(count));
    }

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    public int deleteById(Long id) {
        return this.baseMapper.deleteById(id);
    }

    /**
     * 根据字段删除数据
     *
     * @param t
     * @return
     */
    public int deleteByEntity(T t) {
        EntityWrapper<T> wrapper = new EntityWrapper<>();
        return this.baseMapper.delete(wrapper);
    }


    public T getInstance() throws Exception {
        return entityClass.newInstance();
    }

    /**
     * 纯粹的批量删除,以逗号分隔,兼容单条
     *
     * @param ids
     * @return
     */
    public int multiDelete(String ids) {
        int count = 0;
        for (String id : ids.split(",")) {
            if (StringUtils.isEmpty(id)) {
                count += this.deleteById(Long.parseLong(id));
            }
        }
        return count;
    }

    /**
     * 带结果生成地批量删除, 以逗号分割, 兼容单条
     */
    public ResultBean multiDelete(ResultBean result, String ids) {
        int count = this.multiDelete(ids);
        return result.SUCCESS(Info.Delete.success(count));
    }


}
