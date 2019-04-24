package com.cx.prototype.mode.controller;


import org.springframework.stereotype.Controller;
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

import com.cx.prototype.mode.service.TCommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author cx123
 * @since 2019-04-19
 */
@Api(description = "商品接口")
@RestController
@RequestMapping("/tCommodity")
public class TCommodityController extends BaseController {
private final Logger logger=LoggerFactory.getLogger(TCommodityController.class);

@Autowired
public TCommodityService iTCommodityService;


        @ApiOperation(value = "list", notes = "分页")
        @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
        public ResultBean list(HttpServletRequest request, HttpServletResponse response, PageParam param){
            return iTCommodityService.list(success(request,response),param);
        }


        @ApiOperation(value = "detail", notes = "查看详情")
        @RequestMapping(value ="/detail", method = RequestMethod.POST)
        public ResultBean detail(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "id", required = true) @RequestParam Long id){
            return this.getDataSuccess(request, response, iTCommodityService.detail(id));
        }

        @ApiOperation(value = "insert", notes = "新增")
        @RequestMapping(value = "insert", method = RequestMethod.POST)
        public ResultBean insert(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
            return iTCommodityService.insert(super.success(request, response), param);
        }

        @ApiOperation(value = "update", notes = "修改")
        @RequestMapping(value = "update", method = RequestMethod.POST)
        public ResultBean update(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject param) {
         return iTCommodityService.update(super.success(request, response), param);
        }

        @ApiOperation(value = "delete", notes = "删除")
        @RequestMapping(value = "delete", method = RequestMethod.POST)
        public ResultBean delete(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "id", required = true) @RequestParam Long id) {
            return this.getDataSuccess(request, response, iTCommodityService.delete(id));
        }


        @ApiOperation(value = "queryByIntegral", notes = "根据积分查询可兑换的商品")
        @RequestMapping(value = "queryByIntegral" ,method = RequestMethod.POST)
        public ResultBean queryByIntegral(HttpServletRequest request,HttpServletResponse response,@ApiParam(value = "integral", required = true) @RequestParam Integer integral){
            return this.getDataSuccess(request,response,this.iTCommodityService.queryByIntegral(integral));
        }

}
