package com.xt36.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xt36.blog.entity.Article;

public interface ArticleMapper extends BaseMapper<Article> {
    // 继承 BaseMapper，直接拥有单表的增删改查方法，无需手写 SQL！
}
