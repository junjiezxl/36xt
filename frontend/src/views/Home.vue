<template>
  <div class="max-w-3xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
    <h1 class="text-3xl font-extrabold text-gray-900 mb-8">最新文章</h1>
    <div class="space-y-8">
      <div v-for="article in articles" :key="article.id" class="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 hover:shadow-md transition-shadow">
        <div class="flex items-center text-sm text-gray-500 mb-2">
          <span class="text-primary font-medium">{{ article.category }}</span>
          <span class="mx-2">&bull;</span>
          <span>{{ article.date }}</span>
        </div>
        <router-link :to="`/article/${article.id}`" class="block mt-2">
          <h2 class="text-xl font-bold text-gray-900 hover:text-primary transition-colors">{{ article.title }}</h2>
          <p class="mt-3 text-base text-gray-500">{{ article.summary }}</p>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

// 模拟数据库数据
const articles = ref([
  {
    id: 1,
    title: 'Vue 3 + Java 全栈博客搭建指南',
    summary: '如何从零开始，使用现代技术栈搭建一个高性能、易于扩展的全栈博客系统...',
    date: '2026-05-26',
    category: '实战教程'
  },
  {
    id: 2,
    title: '深入理解 Markdown 排版原理',
    summary: '为什么微信公众号不支持外部样式表？如何优雅地将 Markdown 渲染并注入内联 CSS...',
    date: '2026-05-25',
    category: '前端技术'
  }
])
</script>
