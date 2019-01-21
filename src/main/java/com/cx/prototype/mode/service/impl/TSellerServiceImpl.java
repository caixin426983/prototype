package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TSeller;
import com.cx.prototype.mode.mapper.TSellerMapper;
import com.cx.prototype.mode.service.TSellerService;
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
 * @Date 2019/1/16 15:54
 **/
@Service
@Transactional
public class TSellerServiceImpl extends CrudService<TSellerMapper, TSeller> implements TSellerService {


    @Override
    public ResultBean list(ResultBean result, PageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<TSeller> sellerList = super.findList();
        PageInfo<TSeller> pageInfo = new PageInfo<>(sellerList);
        return result.SUCCESS().addData(pageInfo);
    }

    @Override
    public TSeller detail(Long id) {
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
        return this.deleteById(id);
    }
}
