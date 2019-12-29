package com.pinxixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *@SpringBootApplication用于启动SpringBoot项目
 * SpringBoot默认包扫描机制是：从启动类所在包开始，扫描当前包及其子包下的所有文件。
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
