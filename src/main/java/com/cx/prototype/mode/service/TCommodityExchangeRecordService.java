package com.cx.prototype.mode.service;


import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TCommodityExchangeRecord;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;

import java.util.List;
import java.util.Map;


/**
 * @author cx123
 * @since 2019-04-19
 */
public interface TCommodityExchangeRecordService {

    ResultBean list(ResultBean result, PageParam param);

    TCommodityExchangeRecord detail(Long id);

    ResultBean insert(ResultBean result, JSONObject param);

    ResultBean update(ResultBean result, JSONObject param);

    int delete(Long id);

    /**
     * 会员查询自己的礼品兑换记录
     *
     * @param memberId
     * @return
     */
    List<Map<String, Object>> exchangeRecord(Long memberId);
}