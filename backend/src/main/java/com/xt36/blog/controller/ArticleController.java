package com.xt36.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xt36.blog.entity.Article;
import com.xt36.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// @RestController 告诉 Spring Boot：我这个类是个专门接待客人的“服务员”。
// 而且，我端出去的菜必须是纯数据（JSON格式），不能夹杂网页代码。
@RestController
// @RequestMapping 设置了服务员的“专属包厢”。
// 意思是：凡是浏览器里请求地址以 "/api/articles" 开头的电话，全部转接给我处理。
@RequestMapping("/api/articles")
public class ArticleController {

    // @Autowired 代表“自动装配”，这是一个找帮手的指令。
    // 意思是：服务员自己不会去仓库拿货，他在这里通过这个标签，
    // 把“仓库管理员” (ArticleMapper) 喊过来，让他随时待命。
    @Autowired
    private ArticleMapper articleMapper;

    // @GetMapping 意思是：当遇到浏览器的 GET 请求（通常是读取、获取数据）时，就执行下面的方法。
    // 这个方法叫 getArticles()，它的任务是返回一个装满文章的列表：List<Article>。
    @GetMapping
    public List<Article> getArticles() {
        // QueryWrapper 是 MyBatis-Plus 提供的一个查询条件的盒子。
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        // orderByDesc 意思是：按照 "create_time"（发布时间）进行降序排列（最新发布的排最前面）。
        queryWrapper.orderByDesc("create_time");
        
        // 最后，指挥仓库管理员 (articleMapper) 拿着刚才的条件盒子去数据库取数据，并把取出来的列表返回给前端。
        return articleMapper.selectList(queryWrapper);
    }

    // 这里的 "/{id}" 代表网址后面会跟着一个动态的数字，比如 /api/articles/1
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        // @PathVariable 的作用是把网址里的那个数字 1，提取出来塞给参数 id。
        // 然后指挥管理员按照这个 id 去查询唯一的那篇文章，并返回。
        return articleMapper.selectById(id);
    }

    // @PostMapping 意思是：当遇到 POST 请求（通常是前端提交表单、保存新数据）时，执行下面的方法。
    // @RequestBody 的作用是：把前端通过网络传过来的一长串 JSON 字符串数据，自动转换、打包成一个 Article 类型的盒子。
    @PostMapping
    public String saveArticle(@RequestBody Article article) {
        // 如果这篇文章没有发布时间，我们就给它打上当前的时间烙印（new Date()）
        if (article.getCreateTime() == null) {
            article.setCreateTime(new Date());
        }
        // 指挥管理员把这个装好数据的包装盒，塞进（insert）数据库里。
        articleMapper.insert(article);
        return "success";
    }
}
