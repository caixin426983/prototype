package com.cx.prototype.util.file;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Description 文件上传下载工具类
 * @Author cx
 * @Date 2019/1/22 14:41
 **/
public class FileUtils {


    public static void downloadFile(HttpServletResponse response, String filePath,String fileName) throws FileNotFoundException {
        if (fileName != null) {
            //设置文件路径
            //如果上传目录为/static/images/upload/，则可以如下获取：
            //File upload = new File(path.getAbsolutePath(),"static/images/upload/");
            File file = new File(filePath);
            if (file.exists()) {
                response.setContentType("application/force-download");//设置文件下载不打开
                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);//设置文件名
//                response.setHeader("Content-Disposition", "attachment;");//设置文件名
                byte[] buffer = new byte[2048];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
