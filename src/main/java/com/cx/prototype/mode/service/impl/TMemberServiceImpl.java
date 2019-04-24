package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TMember;
import com.cx.prototype.mode.mapper.TMemberMapper;
import com.cx.prototype.mode.service.TMemberService;
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
 * 服务实现类
 * </p>
 *
 * @author cx123
 * @since 2019-04-21
 */
@Service
@Transactional
public class TMemberServiceImpl extends CrudService<TMemberMapper, TMember> implements TMemberService {


    @Autowired
    private TMemberMapper tMemberMapper;


    @Override
    public ResultBean list(ResultBean result, PageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<TMember> list = super.findList();
        PageInfo<TMember> pageInfo = new PageInfo<>(list);
        return result.SUCCESS().addData(pageInfo);
    }

    @Override
    public TMember detail(Long id) {
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