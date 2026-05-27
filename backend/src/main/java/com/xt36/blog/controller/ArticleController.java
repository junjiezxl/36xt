package com.xt36.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xt36.blog.entity.Article;
import com.xt36.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    // 获取文章列表（按时间倒序）
    @GetMapping
    public List<Article> getArticles() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return articleMapper.selectList(queryWrapper);
    }

    // 根据ID获取文章详情
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleMapper.selectById(id);
    }

    // 保存新文章
    @PostMapping
    public String saveArticle(@RequestBody Article article) {
        if (article.getCreateTime() == null) {
            article.setCreateTime(new Date());
        }
        articleMapper.insert(article);
        return "success";
    }
}
