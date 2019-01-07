package com.cx.prototype;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot项目的Bean装配默认规则是根据Application类所在的包位置从上往下扫描！
 * “Application类”是指SpringBoot项目入口类。这个类的位置很关键：
 * 如果Application类所在的包为：com.springboot.controller，则只会扫描com.springboot.controller包及其所有子包，
 * 如果service或dao所在包不在com.springboot.controller及其子包下，则不会被扫描！
 * <p>
 * 故此Application类应该放在父包com.springboot中，这样就能扫描到com.springboot.controller，service，dao包里的bean了。
 * <p>
 * <p>
 * <p>
 * <p>
 * Spring Boot默认会扫描启动类同包以及子包下的注解，那么如何进行改变这种扫描包的方式呢，原理很简单就是：
 * ComponentScan注解进行指定要扫描的包以及要扫描的类。
 * ComponentScan(basePackages={"com","com.hha"})
 */


@SpringBootApplication
@ServletComponentScan(basePackages = "com.cx.prototype.config")
@ComponentScan(basePackages = {"com.cx.prototype.*"})
@MapperScan(basePackages = {"com.cx.prototype.mode.mapper"})
@EnableSwagger2
//@EnableCaching
public class PrototypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);
    }

}

