<template>
  <div class="max-w-3xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
    <article class="bg-white p-8 rounded-2xl shadow-sm border border-gray-100">
      <header class="mb-8">
        <h1 class="text-3xl font-extrabold text-gray-900">{{ article.title }}</h1>
        <div class="mt-4 flex items-center text-sm text-gray-500">
          <span class="text-primary font-medium">{{ article.category }}</span>
          <span class="mx-2">&bull;</span>
          <span>{{ article.date }}</span>
        </div>
      </header>
      <div class="prose prose-blue max-w-none" v-html="renderedHtml"></div>
    </article>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import MarkdownIt from 'markdown-it'
import hljs from 'highlight.js'
import 'highlight.js/styles/github.css'

const route = useRoute()
const md = new MarkdownIt({
  html: true,
  highlight: function (str, lang) {
    if (lang && hljs.getLanguage(lang)) {
      try {
        return hljs.highlight(str, { language: lang }).value;
      } catch (__) {}
    }
    return '';
  }
})

// 模拟获取文章数据
const article = ref({
  title: 'Vue 3 + Java 全栈博客搭建指南',
  date: '2026-05-26',
  category: '实战教程',
  content: `
## 为什么选择这套架构？

Java 负责提供稳健的数据接口，Vue 3 负责提供极速的用户体验。

\`\`\`java
@RestController
public class ArticleController {
    @GetMapping("/api/articles")
    public List<Article> getArticles() {
        return articleService.findAll();
    }
}
\`\`\`

这是一种非常经典的搭配方式。
  `
})

const renderedHtml = computed(() => md.render(article.value.content))
</script>

<style scoped>
/* 简单的排版样式 */
:deep(.prose h2) {
  font-size: 1.5rem;
  font-weight: bold;
  margin-top: 2rem;
  margin-bottom: 1rem;
  color: #1e293b;
}
:deep(.prose p) {
  margin-bottom: 1rem;
  line-height: 1.75;
  color: #475569;
}
:deep(.prose pre) {
  background-color: #f8fafc;
  padding: 1rem;
  border-radius: 0.5rem;
  overflow-x: auto;
  font-size: 0.875rem;
}
</style>
