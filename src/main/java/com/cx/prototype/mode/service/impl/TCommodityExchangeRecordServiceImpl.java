package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TCommodityExchangeRecord;
import com.cx.prototype.mode.mapper.TCommodityExchangeRecordMapper;
import com.cx.prototype.mode.service.TCommodityExchangeRecordService;
import com.cx.prototype.util.service.CrudService;
import org.springframework.stereotype.Service;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cx123
 * @since 2019-04-19
 */
@Service
@Transactional
public class TCommodityExchangeRecordServiceImpl extends CrudService<TCommodityExchangeRecordMapper, TCommodityExchangeRecord> implements TCommodityExchangeRecordService {


    @Autowired
    private TCommodityExchangeRecordMapper tCommodityExchangeRecordMapper;


    @Override
    public ResultBean list(ResultBean result, PageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<TCommodityExchangeRecord> list = super.findList();
        PageInfo<TCommodityExchangeRecord> pageInfo = new PageInfo<>(list);
        return result.SUCCESS().addData(pageInfo);
    }

    @Override
    public TCommodityExchangeRecord detail(Long id) {
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

    @Override
    public List<Map<String, Object>> exchangeRecord(Long memberId) {
        return tCommodityExchangeRecordMapper.exchangeRecord(memberId);
    }


}