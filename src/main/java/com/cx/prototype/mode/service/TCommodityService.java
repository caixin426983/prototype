package com.cx.prototype.mode.service;


import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TCommodity;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;


import java.util.List;


/**
 *
 * @author cx123
 * @since 2019-04-19
 */
public interface TCommodityService{

        ResultBean list(ResultBean result, PageParam param);

        TCommodity detail(Long id);

        ResultBean insert(ResultBean result, JSONObject param);

        ResultBean update(ResultBean result, JSONObject param);

        int delete(Long id);

        /**
         * 根据积分查询可兑换的商品
         * @param integral
         * @return
         */
        List<TCommodity> queryByIntegral(Integer integral);

}