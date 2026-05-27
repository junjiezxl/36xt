package com.xt36.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xt36.blog.entity.Article;

// interface 代表这是一个“接口”，你可以把它理解为一份“职位说明书”。
// extends BaseMapper<Article> 代表：这份说明书继承了 MyBatis-Plus 框架里预先写好的神级技能 BaseMapper。
// <Article> 代表：这个神级技能是专门用来操作 Article (文章) 这个包装盒的。
// 只要写了这一行代码，这个 ArticleMapper 瞬间就学会了如何往数据库里增加、删除、修改、查询文章，
// 我们一行 SQL 语句都不需要自己手写了！
public interface ArticleMapper extends BaseMapper<Article> {
    // 这里空空如也，因为父类 BaseMapper 已经帮我们干了所有脏活累活。
}
