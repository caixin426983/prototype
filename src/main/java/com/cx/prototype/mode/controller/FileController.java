package com.cx.prototype.mode.controller;

import com.cx.prototype.util.controller.BaseController;
import com.cx.prototype.util.entity.Constant;
import com.cx.prototype.util.entity.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/22 14:13
 **/
@Controller
@RequestMapping(value = "file")
public class FileController extends BaseController {

    private final static String filePath = Constant.FILE_UPLOAD_PATH;

    @RequestMapping(value = "download", method = RequestMethod.GET)
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {

    }


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean uploadFile(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("file") MultipartFile file) {

        //文件名
        String filename = file.getOriginalFilename();

        //文件后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));

        // 重新生成唯一文件名，用于存储数据库
        String newFileName = UUID.randomUUID().toString() + suffixName;


        File newFilePath = new File(filePath + "\\" + suffixName);
        if (!newFilePath.exists() && !newFilePath.isDirectory()) {
            newFilePath.mkdirs();
        }

        //创建文件
        File dest = new File(filePath + "\\" + suffixName + "\\" + newFileName);
        //存放文件路径(可写进数据库)
        String absolutePath = dest.getAbsolutePath();
        try {
            file.transferTo(dest);
            return this.getDataSuccess(request, response, absolutePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.fail();
    }


}
