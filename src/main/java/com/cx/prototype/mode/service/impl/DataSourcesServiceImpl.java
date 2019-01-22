package com.cx.prototype.mode.service.impl;

import com.cx.prototype.mode.mapper.DataSourcesMapper;
import com.cx.prototype.mode.service.DataSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/22 10:42
 **/
@Service
@Transactional
public class DataSourcesServiceImpl implements DataSourcesService {

    @Autowired
    private DataSourcesMapper dataSourcesMapper;


    @Override
    public List<Map> listTable() {
        return dataSourcesMapper.listTable();
    }

    @Override
    public List<Map> listTableColumn(String tableName) {
        return dataSourcesMapper.listTableColumn(tableName);
    }
}
