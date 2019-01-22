package com.cx.prototype.mode.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface DataSourcesMapper {


    List<Map> listTable();

    List<Map> listTableColumn(@Param("tableName") String tableName);

}
