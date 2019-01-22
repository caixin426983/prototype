package com.cx.prototype.mode.controller;

import com.cx.prototype.mode.service.DataSourcesService;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.Constant;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.file.FileUtils;
import com.cx.prototype.util.file.ZipUtil;
import com.cx.prototype.util.gen.MysqlGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/22 10:52
 **/
@Api(description = "代码生成模块")
@RestController
@RequestMapping(value = "gen")
public class GenController extends BaseController {

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

    @ApiOperation(value = "generatorTable", notes = "生成所选表的数据")
    @RequestMapping(value = "generatorTable/{tableNames}", method = RequestMethod.GET)
    public void generatorTable(HttpServletRequest request, HttpServletResponse response,
                               @PathVariable String tableNames) {
        MysqlGenerator.gen(tableNames);
        ZipUtil.createZip(Constant.FILE_DOWNLOAD_PATH, Constant.FILE_DOWNLOAD_PATH, false);
        try {
            FileUtils.downloadFile(response, Constant.FILE_DOWNLOAD_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
