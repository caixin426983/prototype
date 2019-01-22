package com.cx.prototype.mode.controller;

import com.cx.prototype.util.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/22 14:13
 **/
@Controller
@RequestMapping(value = "file")
public class FileController extends BaseController {

    @RequestMapping(value = "downloadFile", method = RequestMethod.GET)
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {


    }


}
