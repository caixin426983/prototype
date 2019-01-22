package com.cx.prototype.mode.controller;

import com.cx.prototype.mode.service.DataSourcesService;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/22 10:52
 **/
@Api(description = "读取数据库")
@RestController
@RequestMapping(value = "dataSource")
public class DataSourceController extends BaseController {

    @Autowired
    private DataSourcesService dataSourcesService;

    @ApiOperation(value = "listTable", notes = "获取所有表")
    @RequestMapping(value = "listTable", method = RequestMethod.GET)
    public ResultBean listTable(HttpServletRequest request, HttpServletResponse response) {
        return super.getDataSuccess(request, response, dataSourcesService.listTable());
    }

    @ApiOperation(value = "listTableColumn", notes = "获取表的所有字段")
    @RequestMapping(value = "listTableColumn", method = RequestMethod.POST)
    public ResultBean listTableColumn(HttpServletRequest request, HttpServletResponse response, @RequestParam String tableName) {
        return super.getDataSuccess(request, response, dataSourcesService.listTableColumn(tableName));
    }


}
