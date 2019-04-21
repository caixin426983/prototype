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
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

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
    @RequestMapping(value = "generatorTable", method = RequestMethod.POST)
    public void generatorTable(HttpServletRequest request, HttpServletResponse response,
                               @ApiParam(value = "表名称", required = true) @RequestParam String[] tableNames) {
        MysqlGenerator.gen(tableNames);

        String sourceFilePath = Constant.FILE_DOWNLOAD_PATH;
        File sourceDir = new File(sourceFilePath);
        File zipFile = new File(sourceFilePath + ".zip");
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(zipFile));
            String baseDir = Constant.FILE_DOWNLOAD_PATH;
            ZipUtil.compress(sourceDir, baseDir, zos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (zos != null)
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        try {
            FileUtils.downloadFile(response, Constant.FILE_DOWNLOAD_PATH + ".zip", "code.zip");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        zipFile.delete();//删除打包后的zip文件
//        ZipUtil.deleteDir(sourceDir); //删除生成的文件

    }

}
