package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.SysDictionary;
import com.cx.prototype.mode.mapper.SysDictionaryMapper;
import com.cx.prototype.mode.service.SysDictionaryService;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.service.CrudService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/17 15:52
 **/
@Service
@Transactional
public class SysDictionaryServiceImpl extends CrudService<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {

    @Override
    public ResultBean list(ResultBean result, PageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<SysDictionary> sellerList = super.findList();
        PageInfo<SysDictionary> pageInfo = new PageInfo<>(sellerList);
        return result.SUCCESS().addData(pageInfo);
    }

    @Override
    public SysDictionary detail(Long id) {
        return super.getById(id);
    }

    @Override
    public ResultBean insert(ResultBean result, JSONObject param) {
        return super.save(result, param);
    }

    @Override
    public ResultBean update(ResultBean result, JSONObject param) {
        return super.save(result, param);
    }

    @Override
    public int delete(Long id) {
        return super.deleteById(id);
    }
}
