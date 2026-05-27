package com.xt36.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 是整个项目的“灵魂启动符”。
// 它告诉电脑：这是一个 Spring Boot 项目，请在后台帮我自动配置好成百上千个底层组件。
@SpringBootApplication
// @MapperScan 告诉系统：“仓库管理员”都在哪个包底下。
// 启动时，系统会跑到 "com.xt36.blog.mapper" 目录下去找所有的 Mapper 接口，并把它们唤醒。
@MapperScan("com.xt36.blog.mapper") 
public class BlogApplication {
    
    // public static void main 是所有 Java 程序的终极入口起点。
    // 就好像一辆汽车的“一键启动”按钮。按下它，SpringApplication.run() 就会让这辆车轰鸣着跑起来。
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
