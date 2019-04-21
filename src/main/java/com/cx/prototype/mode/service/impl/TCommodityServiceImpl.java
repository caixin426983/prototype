package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TCommodity;
import com.cx.prototype.mode.mapper.TCommodityMapper;
import com.cx.prototype.mode.service.TCommodityService;
import com.cx.prototype.util.service.CrudService;
import org.springframework.stereotype.Service;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cx123
 * @since 2019-04-19
 */
@Service
@Transactional
public class TCommodityServiceImpl extends CrudService<TCommodityMapper, TCommodity> implements TCommodityService {


        @Autowired
        private TCommodityMapper tCommodityMapper;


        @Override
        public ResultBean list(ResultBean result, PageParam param) {
            PageHelper.startPage(param.getPageNum(), param.getPageSize());
            List<TCommodity> list = super.findList();
            PageInfo<TCommodity> pageInfo = new PageInfo<>(list);
            return result.SUCCESS().addData(pageInfo);
        }

        @Override
        public TCommodity detail(Long id) {
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

        /**
         * 重新了删除方法。 只是改变商品的状态。便于商品删除后，兑换记录的查询
         * @param id
         * @return
         */
        @Override
            public int delete(Long id) {
                TCommodity commodity = new TCommodity();
                commodity.setId(id);
                commodity.setState(2);
                return  super.updateById(commodity)?1 :0;
            }

        @Override
        public List<TCommodity> queryByIntegral(Integer integral) {
            return this.tCommodityMapper.queryByIntegral(integral);
        }


}