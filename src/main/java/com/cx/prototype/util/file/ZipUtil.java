package com.cx.prototype.util.file;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description 文件打包工具类
 * @Author cx
 * @Date 2019/1/22 16:37
 **/
public class ZipUtil {


    private static final Logger log = LoggerFactory.getLogger(ZipUtil.class);

    private ZipUtil() {
    }


    /**
     * 文件夹内文件删除
     *
     * @param dir
     * @return
     */
    public static void deleteDir(File dir) {
        if (dir.exists())

            if (dir.isDirectory()) {
                String[] childrens = dir.list();
                System.out.println(JSONObject.toJSON(childrens));
                // 递归删除目录中的子目录下
                for (String child : childrens) {
                    System.out.println(child);
                    File file1 = new File(dir, child);

                    file1.delete();
                }
            }

    }


    /**
     * 清空文件和文件目录
     *
     * @param f
     */
    public static void clean(File f) throws Exception {
        String cs[] = f.list();
        if (cs == null || cs.length <= 0) {
            System.out.println("delFile:[ " + f + " ]");
            boolean isDelete = f.delete();
            if (!isDelete) {
                System.out.println("delFile:[ " + f.getName() + "文件删除失败！" + " ]");
                throw new Exception(f.getName() + "文件删除失败！");
            }
        } else {
            for (int i = 0; i < cs.length; i++) {
                String cn = cs[i];
                String cp = f.getPath() + File.separator + cn;
                File f2 = new File(cp);
                if (f2.exists() && f2.isFile()) {
                    System.out.println("delFile:[ " + f2 + " ]");
                    boolean isDelete = f2.delete();
                    if (!isDelete) {
                        System.out.println("delFile:[ " + f2.getName() + "文件删除失败！" + " ]");
                        throw new Exception(f2.getName() + "文件删除失败！");
                    }
                } else if (f2.exists() && f2.isDirectory()) {
                    clean(f2);
                }
            }
            System.out.println("delFile:[ " + f + " ]");
            boolean isDelete = f.delete();
            if (!isDelete) {
                System.out.println("delFile:[ " + f.getName() + "文件删除失败！" + " ]");
                throw new Exception(f.getName() + "文件删除失败！");
            }
        }
    }


    public static void compress(File f, String baseDir, ZipOutputStream zos) {
        if (!f.exists()) {
            System.out.println("待压缩的文件目录或文件" + f.getName() + "不存在");
            return;
        }


        File[] fs = f.listFiles();
        BufferedInputStream bis = null;
        //ZipOutputStream zos = null;
        byte[] bufs = new byte[1024 * 10];
        FileInputStream fis = null;


        try {
            //zos = new ZipOutputStream(new FileOutputStream(zipFile));
            for (int i = 0; i < fs.length; i++) {
                String fName = fs[i].getName();
                System.out.println("压缩：" + baseDir + fName);
                if (fs[i].isFile()) {
                    ZipEntry zipEntry = new ZipEntry(baseDir + fName);
                    zos.putNextEntry(zipEntry);
                    //读取待压缩的文件并写进压缩包里
                    fis = new FileInputStream(fs[i]);
                    bis = new BufferedInputStream(fis, 1024 * 10);
                    int read = 0;
                    while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                        zos.write(bufs, 0, read);
                    }
                    //如果需要删除源文件，则需要执行下面2句
//                    fis.close();
//                    fs[i].delete();
                } else if (fs[i].isDirectory()) {
                    compress(fs[i], baseDir + fName + "/", zos);
                }
            }//end for
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (null != bis)
                    bis.close();
                //if(null!=zos)
                //zos.close();
                if (null != fis)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
