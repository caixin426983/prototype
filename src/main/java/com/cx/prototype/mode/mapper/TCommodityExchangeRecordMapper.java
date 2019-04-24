package com.cx.prototype.mode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cx.prototype.mode.entity.TCommodityExchangeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author cx123
 * @since 2019-04-19
 */
@Repository
public interface TCommodityExchangeRecordMapper extends BaseMapper<TCommodityExchangeRecord> {


    /**
     * 会员查询自己的礼品兑换记录
     *
     * @param memberId
     * @return
     */
    List<Map<String, Object>> exchangeRecord(Long memberId);

}
