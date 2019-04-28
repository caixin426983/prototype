package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.TMember;
import com.cx.prototype.mode.mapper.TMemberMapper;
import com.cx.prototype.mode.pojo.TMemberPojo;
import com.cx.prototype.mode.service.TMemberService;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.excel.ExportExcel;
import com.cx.prototype.util.service.CrudService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cx123
 * @since 2019-04-21
 */
@Service
@Transactional
public class TMemberServiceImpl extends CrudService<TMemberMapper, TMember> implements TMemberService {


    @Autowired
    private TMemberMapper memberMapper;


    @Override
    public ResultBean list(ResultBean result, PageParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<TMember> list = super.findList();
        PageInfo<TMember> pageInfo = new PageInfo<>(list);
        return result.SUCCESS().addData(pageInfo);
    }

    @Override
    public TMember detail(Long id) {
        return super.getById(id);
    }

    @Override
    public ResultBean insert(ResultBean result, JSONObject param) {
        return super.save(result, param);
    }

    @Override
    public ResultBean update(ResultBean result, JSONObject param) {
        return super.save(result, param);
    }

    @Override
    public int delete(Long id) {
        return this.deleteById(id);
    }


    @Override
    public void export(HttpServletRequest request, HttpServletResponse response) {
        List<TMemberPojo> list = this.memberMapper.exportMember();
        //拿取导出模板
        String templatePath = "";
        try {
            templatePath = ResourceUtils.getURL("classpath:exportTem/Member.xlsx").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileInputStream io = null;
        ServletOutputStream outputStream = null;
        try {
            response.setContentType("application/octet-stream; charset=utf-8");
            String fileName = "会员信息汇总.xls";
            response.setHeader("Content-disposition", "attachment; filename=" + new String((fileName).getBytes("UTF-8"), "ISO8859-1"));
            outputStream = response.getOutputStream();
            io = new FileInputStream(templatePath);
            Workbook wb = null;
            try {
                wb = new XSSFWorkbook(io);
            } catch (Exception ex) {
                io.close();
                io = new FileInputStream(templatePath);
                wb = new HSSFWorkbook(io);
            }

            Sheet sheet = wb.getSheetAt(0);
            CellStyle bodyStyle = ExportExcel.getBodyStyle(wb);

            Cell cell = null;
            //构建数据表格
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Row bodyRow = sheet.createRow(i + 1);
                    TMemberPojo pojo = list.get(i);
                    Field[] fields = pojo.getClass().getDeclaredFields();
                    Cell cell0 = bodyRow.createCell(0);
                    cell0.setCellStyle(bodyStyle);
                    cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell0.setCellValue(i + 1);

                    for (int j = 0; j < fields.length; j++) {
                        cell = bodyRow.createCell(j + 1);
                        cell.setCellStyle(bodyStyle);
                        cell.setCellValue(String.valueOf(
                                pojo.getClass().getMethod("get" +
                                        fields[j].getName().substring(0, 1).toUpperCase() +
                                        fields[j].getName().substring(1)).invoke(pojo)));
                    }
                }
            }
            //输出文件
            wb.write(outputStream);
            outputStream.flush();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != io) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}