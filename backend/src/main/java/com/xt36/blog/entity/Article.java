package com.xt36.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

// @Data 是 Lombok 这个工具包提供的“魔法”符号。
// 在以前，为了能读取或修改 id、title 这些属性，我们需要在下面手写几十行 getId() 和 setTitle() 代码。
// 加了 @Data 之后，程序在编译时会自动在后台帮我们补全这些繁琐的代码，让这整个文件变得极其干净。
@Data
// @TableName 也是一个指令，它告诉系统：当前这个叫 Article 的 Java 包装盒，
// 专门用来对应 MySQL 数据库中那个名叫 "article" 的表。
@TableName("article") 
public class Article {
    
    // @TableId 告诉系统：下面紧跟的这个 id 是数据库的“主键”（也就是唯一的身份证号）。
    // type = IdType.AUTO 意思是：这个身份证号不需要我们自己手写，MySQL 会自动从 1, 2, 3... 帮我们自动增加。
    @TableId(type = IdType.AUTO) 
    private Long id; // Long 是一种装大整数的杯子，用来装编号
    
    private String title;    // String 类型的杯子，用来装文章标题（字符串文字）
    private String summary;  // 用来装文章摘要
    private String content;  // 用来装文章的正文（Markdown 内容）
    private String category; // 用来装文章的分类名
    
    // Date 类型，专门用来装时间日期，对应数据库里的 datetime 格式
    private Date createTime; 
}
