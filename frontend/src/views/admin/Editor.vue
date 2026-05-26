<script setup>
import { ref, computed } from 'vue'
import MarkdownIt from 'markdown-it'
import hljs from 'highlight.js'
import 'highlight.js/styles/github.css'

const md = new MarkdownIt({
  html: true,
  linkify: true,
  typographer: true,
  highlight: function (str, lang) {
    if (lang && hljs.getLanguage(lang)) {
      try {
        return hljs.highlight(str, { language: lang }).value;
      } catch (__) {}
    }
    return '';
  }
});

const rawMarkdown = ref(`
# 在这里写下你的新文章...
`);

const renderedHtml = computed(() => {
  return md.render(rawMarkdown.value)
})
</script>

<template>
  <div class="editor-container h-[calc(100vh-64px)] flex overflow-hidden">
    <div class="pane left-pane flex-1 border-r border-gray-200">
      <textarea v-model="rawMarkdown" class="w-full h-full p-6 text-base font-mono bg-gray-50 text-gray-800 outline-none resize-none" placeholder="请输入 Markdown 代码..."></textarea>
    </div>
    <div class="pane right-pane flex-1 bg-gray-100 flex justify-center p-8 overflow-y-auto">
      <div class="preview-area w-full max-w-sm bg-white min-h-[667px] shadow-sm p-6 rounded-lg border border-gray-200" v-html="renderedHtml"></div>
    </div>
  </div>
</template>

<style scoped>
/* 微信排版基础样式 */
:deep(.preview-area h1) { font-size: 20px; color: #333; text-align: center; border-bottom: 1px solid #eaeaea; padding-bottom: 10px; }
:deep(.preview-area h2) { font-size: 18px; color: #007bff; border-left: 4px solid #007bff; padding-left: 10px; margin-top: 30px; }
:deep(.preview-area p) { font-size: 15px; line-height: 1.75; color: #555; letter-spacing: 1px; }
:deep(.preview-area pre) { background-color: #f6f8fa; padding: 15px; border-radius: 6px; overflow-x: auto; font-size: 13px; }
:deep(.preview-area blockquote) { border-left: 4px solid #e1e4e8; padding-left: 15px; color: #6a737d; margin-left: 0; background: #fcfcfc; padding: 10px 15px; }
</style>
