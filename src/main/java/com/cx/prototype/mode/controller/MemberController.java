package com.cx.prototype.mode.controller;

import com.cx.prototype.mode.service.TMemberService;
import com.cx.prototype.util.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 会员管理
 * @Author cx
 * @Date 2019/4/26 15:12
 **/
@Api(value = "user", description = "用户控制器")
public class MemberController extends BaseController {

    @Autowired
    private TMemberService memberService;

    /**
     * 导出会员信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "export")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        memberService.export(request, response);
    }


}
