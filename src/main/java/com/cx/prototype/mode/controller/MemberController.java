package com.cx.prototype.mode.controller;

import com.cx.prototype.mode.service.TMemberService;
import com.cx.prototype.util.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 会员管理
 * @Author cx
 * @Date 2019/4/26 15:12
 **/
@Api(value = "user", description = "会员控制器")
@Controller
@RequestMapping(value = "member")
public class MemberController extends BaseController {

    @Autowired
    private TMemberService memberService;

    /**
     * 导出会员信息
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "export",method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response) {
        memberService.export(request, response);
    }


}
