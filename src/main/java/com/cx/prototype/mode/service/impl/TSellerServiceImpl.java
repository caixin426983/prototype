package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TSeller;
import com.cx.prototype.mode.mapper.TSellerMapper;
import com.cx.prototype.mode.service.TSellerService;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author cx
 * @Date 2019/1/16 15:54
 **/
@Service
public class TSellerServiceImpl extends CrudService<TSellerMapper, TSeller> implements TSellerService {


    @Override
    public List<TSeller> list(PageParam param) {
        return null;
    }

    @Override
    public TSeller detail(Long id) {
        return super.getById(id);
    }

    @Override
    public ResultBean insert(ResultBean result, JSONObject param) {
        return super.save(result,param);
    }

    @Override
    public ResultBean update(ResultBean result,JSONObject param) {
        return super.save(result,param);
    }

    @Override
    public int delete(Long id) {
        return this.deleteById(id);
    }
}
