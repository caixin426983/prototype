package com.cx.prototype.mode.service;

import java.util.List;
import java.util.Map;

public interface DataSourcesService {



    List<Map> listTable();

    List<Map> listTableColumn(String tableName);


}
