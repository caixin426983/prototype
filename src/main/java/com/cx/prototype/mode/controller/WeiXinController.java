package com.cx.prototype.mode.controller;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.service.TCommodityExchangeRecordService;
import com.cx.prototype.mode.service.TCommodityService;
import com.cx.prototype.mode.service.TMemberService;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(description = "微信接口控制器")
@RestController
@RequestMapping("weixin")
public class WeiXinController extends BaseController {

    @Autowired
    private TCommodityService commodityService;

    @Autowired
    private TMemberService memberService;

    @Autowired
    private TCommodityExchangeRecordService commodityExchangeRecordService;

    @ApiOperation(value = "充值—还未实现", notes = "充值—还未实现")
    @RequestMapping(value = "recharge", method = RequestMethod.POST)
    public ResultBean recharge(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "参数", required = true) JSONObject param) {
        return null;
    }

    @ApiOperation(value = "分页查询所有商品列表", notes = "分页查询所有商品列表")
    @RequestMapping(value = "pageQueryCommodity", method = RequestMethod.POST)
    public ResultBean pageQueryCommodity(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "分页参数", required = true) PageParam param) {
        return commodityService.list(success(request, response), param);
    }


    @ApiOperation(value = "根据积分查询能兑换的商品", notes = "根据积分查询能兑换的商品")
    @RequestMapping(value = "pageQueryCommodityByIntegral", method = RequestMethod.POST)
    public ResultBean pageQueryCommodityByIntegral(HttpServletRequest request, HttpServletResponse response,
                                                   @ApiParam(value = "会员当前积分", required = true) @RequestParam Integer integral) {
        return this.getDataSuccess(request, response, commodityService.queryByIntegral(integral));
    }


    @ApiOperation(value = "查询会员信息", notes = "查询会员信息")
    @RequestMapping(value = "queryMemberInfo", method = RequestMethod.POST)
    public ResultBean queryMemberInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "会员ID", required = true) @RequestParam Long id) {
        return this.getDataSuccess(request, response, memberService.detail(id));
    }

    @ApiOperation(value = "查询兑换记录")
    @RequestMapping(value = "exchangeRecord", method = RequestMethod.POST)
    public ResultBean exchangeRecord(HttpServletRequest request, HttpServletResponse response, @ApiParam(value = "会员ID", required = true) @RequestParam Long id) {

        return this.getDataSuccess(request, response, commodityExchangeRecordService.exchangeRecord(id));
    }


}
