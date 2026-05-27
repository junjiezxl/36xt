package com.xt36.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("article") // 指定数据库表名
public class Article {
    @TableId(type = IdType.AUTO) // 主键自增
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String category;
    private Date createTime;
}
