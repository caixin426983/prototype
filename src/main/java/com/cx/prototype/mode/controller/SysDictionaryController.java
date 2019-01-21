package com.cx.prototype.mode.controller;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.service.SysDictionaryService;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description字典控制器
 * @Author cx
 * @Date 2019/1/17 15:53
 **/
@Api(description = "字典控制器")
@RestController
@RequestMapping(value = "dictionary")
public class SysDictionaryController extends BaseController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @ApiOperation(value = "list", notes = "分页")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ResultBean list(HttpServletRequest request, HttpServletResponse response, PageParam param) {
        return sysDictionaryService.list(super.success(request, response), param);
    }



    @ApiOperation(value = "detail", notes = "查看详情")
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    public ResultBean detail(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "id", required = true) @RequestParam Long id) {
        return this.getDataSuccess(request, response, sysDictionaryService.detail(id));
    }

    @ApiOperation(value = "insert", notes = "新增")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResultBean insert(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
        return sysDictionaryService.insert(super.success(request, response), param);
    }

    @ApiOperation(value = "update", notes = "修改")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBean update(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
        return sysDictionaryService.update(super.success(request, response), param);
    }

    @ApiOperation(value = "delete", notes = "删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultBean delete(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "id", required = true) @RequestParam Long id) {
        return this.getDataSuccess(request, response, sysDictionaryService.delete(id));
    }


}
