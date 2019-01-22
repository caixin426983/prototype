package com.cx.prototype.util.gen;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.cx.prototype.util.entity.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author cx
 * @Date 2019/1/17 16:46
 **/
public class MysqlGenerator extends MybatisPlusGenerator {


    public static void gen(String tableName) {
//        int result = scanner();
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(Constant.FILE_DOWNLOAD_PATH)//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(true)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        //.setKotlin(true) 是否生成 kotlin 代码
                        .setAuthor("cx")
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        // .setEntityName("%sEntity");
                        // .setMapperName("%sDao")
                        // .setXmlName("%sDao")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                // .setControllerName("%sAction")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public DbColumnType processTypeConvert(String fieldType) {
//                                System.out.println("转换类型：" + fieldType);
//                                if (fieldType.toLowerCase().contains("tinyint")) {
//                                    return DbColumnType.BOOLEAN;
//                                }
                                return super.processTypeConvert(fieldType);
                            }
                        })
                        .setDriverName("com.mysql.cj.jdbc.Driver")
                        .setUsername("root")
                        .setPassword("root")
                        .setUrl("jdbc:mysql://127.0.0.1:3306/shiro?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        // .setDbColumnUnderline(true)//全局下划线命名
//                        .setTablePrefix(new String[]{"tbl_", "mp_"})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tableName) // 需要生成的表
                        // .setExclude(new String[]{"test"}) // 排除生成的表
                        .setTableFillList(tableFillList)
                        // 自定义实体父类
                        .setSuperEntityClass("com.cx.prototype.util.entity.BaseEntity")
                        // 自定义实体，公共字段
                        .setSuperEntityColumns(new String[]{"id", "create_by", "create_date", "update_by", "update_date"})
                        // 自定义 mapper 父类
                        // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                        // 自定义 service 父类
                        .setSuperServiceClass(null)
                        // 自定义 service 实现类父类
                        .setSuperServiceImplClass("com.cx.prototype.util.service.CrudService")
                        // 自定义controller实现类父类
                        .setSuperControllerClass("com.cx.prototype.util.controller.BaseController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                // .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
//                        .setModuleName("test")
                        .setParent("com.cx.prototype.mode")// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
        ).
//                setCfg(
//                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
//                new InjectionConfig() {
//                    @Override
//                    public void initMap() {
//                        Map<String, Object> map = new HashMap<>();
//                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                        this.setMap(map);
//                    }
//                }.
//                        setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
//                                        "/templates/mapper.xml" + ((1 == result) ? ".ftl" : ".vm")) {
//                                    // 自定义输出文件目录
//                                    @Override
//                                    public String outputFile(TableInfo tableInfo) {
//                                        return "D:/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
//                                    }
//                                })
//                        )
//        ).
        setTemplate(
        // 关闭默认 xml 生成，调整生成 至 根目录
        new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                .setController("/template/controller.java.vm")
                .setEntity("/template/entity.java.vm")
                .setMapper("/template/mapper.java.vm")
                .setXml("/template/mapper.xml.vm")
                .setService("/template/service.java.vm")
                .setServiceImpl("/template/serviceImpl.java.vm")
);
        // 执行生成
//        if (1 == result) {
////            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        }
        mpg.execute();

    }


}
