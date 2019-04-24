package com.cx.prototype.mode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cx.prototype.mode.entity.TCommodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author cx123
 * @since 2019-04-19
 */
@Repository
public interface TCommodityMapper extends BaseMapper<TCommodity> {

    /**
     * 根据积分查询可兑换的商品
     * @param integral
     * @return
     */
    List<TCommodity> queryByIntegral(@Param("integral") Integer integral);

}
