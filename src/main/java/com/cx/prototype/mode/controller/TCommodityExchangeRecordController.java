package com.cx.prototype.mode.controller;


import com.cx.prototype.util.controller.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.prototype.mode.service.TCommodityExchangeRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author cx123
 * @since 2019-04-19
 */
@Api(description = "")
@RestController
@RequestMapping("/tCommodityExchangeRecord")
public class TCommodityExchangeRecordController extends BaseController {
private final Logger logger=LoggerFactory.getLogger(TCommodityExchangeRecordController.class);

@Autowired
public TCommodityExchangeRecordService iTCommodityExchangeRecordService;


        @ApiOperation(value = "list", notes = "分页")
        @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
        public ResultBean list(HttpServletRequest request, HttpServletResponse response, PageParam param){
            return iTCommodityExchangeRecordService.list(success(request,response),param);
        }


        @ApiOperation(value = "detail", notes = "查看详情")
        @RequestMapping(value ="/detail", method = RequestMethod.POST)
        public ResultBean detail(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "id", required = true) @RequestParam Long id){
            return this.getDataSuccess(request, response, iTCommodityExchangeRecordService.detail(id));
        }

        @ApiOperation(value = "insert", notes = "新增")
        @RequestMapping(value = "insert", method = RequestMethod.POST)
        public ResultBean insert(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
            return iTCommodityExchangeRecordService.insert(super.success(request, response), param);
        }

        @ApiOperation(value = "update", notes = "修改")
        @RequestMapping(value = "update", method = RequestMethod.POST)
        public ResultBean update(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
         return iTCommodityExchangeRecordService.update(super.success(request, response), param);
        }

        @ApiOperation(value = "delete", notes = "删除")
        @RequestMapping(value = "delete", method = RequestMethod.POST)
        public ResultBean delete(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "id", required = true) @RequestParam Long id) {
            return this.getDataSuccess(request, response, iTCommodityExchangeRecordService.delete(id));
        }


}
