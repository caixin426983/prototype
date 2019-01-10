package com.cx.prototype.mode.controller;


import com.cx.prototype.mode.service.SysResourcesService;
import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.ResultBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "resources")
public class SysResourcesController extends BaseController {

    @Autowired
    private SysResourcesService sysResourcesService;

    @RequestMapping(value = "getUserMenu", method = RequestMethod.GET)
    @ApiOperation(value = "getUserMenu", notes = "获取用户菜单")
    public ResultBean getUserMenu(HttpServletRequest request, HttpServletResponse response) {
        return sysResourcesService.getUserMenu(super.success(request, response));
    }


}
