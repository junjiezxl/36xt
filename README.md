# 36学堂 (36xt.com)

深入浅出，通晓技术之美。记录代码世界里的三十六计。

这是一个使用 [Astro](https://astro.build/) 构建的极简风格个人博客，使用了 [Tailwind CSS](https://tailwindcss.com/) 进行样式定制，提供像羊皮纸一样舒适优雅的阅读体验。

## 🚀 核心特性

- **极简设计**: 专注于内容本身的呈现，去除冗余视觉干扰。
- **Markdown / MDX 支持**: 开箱即用，支持直接使用 Markdown 或 MDX 编写文章。
- **现代化架构**: 基于 Astro，极致的加载速度和 SEO 优化。
- **Tailwind CSS 深度集成**: 自定义了柔和的配色系统（Parchment & Charcoal）与排版规范。
- **快速部署**: 专为 Cloudflare Pages, Vercel 或 Netlify 设计的零配置部署体系。

## 🧞 本地开发指南

在本地运行或修改这个博客：

1. **安装依赖**
   ```bash
   npm install
   ```
   *(如果你在中国大陆，建议使用 `npm install --registry=https://registry.npmmirror.com` 提升安装速度)*

2. **启动本地开发服务器**
   ```bash
   npm run dev
   ```
   随后在浏览器中访问 `http://localhost:4321`。

3. **构建生产版本**
   ```bash
   npm run build
   ```

## ✍️ 如何写文章？

所有的博客文章都保存在 `src/content/blog/` 目录中。
你只需要在该目录下创建一个新的 `.md` 文件，使用以下的 Frontmatter 格式即可发布新文章：

```markdown
---
title: '你的文章标题'
description: '文章的简短描述'
pubDate: '2026-05-25'
heroImage: '../../assets/你的封面图.jpg'
---

在这里写下你的 Markdown 正文...
```

所有的静态图片（封面图、内容配图）推荐放在 `src/assets/` 目录中，并通过相对路径引用。

## 🌐 部署

推荐将本项目推送到 GitHub 后，使用 **Cloudflare Pages** 进行部署：
- **框架预设 (Framework preset)**: Astro
- **构建命令 (Build command)**: `npm run build`
- **输出目录 (Build output directory)**: `dist`

## 📄 开源协议

本项目基于 MIT 协议开源。
