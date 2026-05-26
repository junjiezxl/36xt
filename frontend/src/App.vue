<script setup>
import { ref, computed } from 'vue'
import MarkdownIt from 'markdown-it'
import hljs from 'highlight.js'
import 'highlight.js/styles/github.css' // We will use a Github style for code blocks

// Initialize markdown-it with highlight.js integration
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
    return ''; // use external default escaping
  }
});

const rawMarkdown = ref(`
# 欢迎使用 36xt-Editor

这是一款专为微信公众号排版设计的 Markdown 编辑器。

## 支持特性

- **加粗**，*斜体*，[链接](https://36xt.com)
- 列表
- 代码高亮

\`\`\`javascript
function hello() {
  console.log("Hello, 36xt!");
}
\`\`\`

> 引用块也可以很漂亮
`);

const renderedHtml = computed(() => {
  return md.render(rawMarkdown.value)
})
</script>

<template>
  <div class="editor-container">
    <header class="header">
      <h1>36xt Markdown 排版工具</h1>
    </header>
    <main class="workspace">
      <div class="pane left-pane">
        <textarea v-model="rawMarkdown" class="md-input" placeholder="请输入 Markdown 代码..."></textarea>
      </div>
      <div class="pane right-pane">
        <div class="preview-area" v-html="renderedHtml"></div>
      </div>
    </main>
  </div>
</template>

<style scoped>
.editor-container {
  display: flex;
  flex-direction: column;
  height: 100vh;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
}

.header {
  height: 60px;
  background-color: #24292e;
  color: white;
  display: flex;
  align-items: center;
  padding: 0 20px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.header h1 {
  font-size: 1.2rem;
  margin: 0;
}

.workspace {
  display: flex;
  flex: 1;
  overflow: hidden;
}

.pane {
  flex: 1;
  overflow-y: auto;
  border-right: 1px solid #e1e4e8;
}

.md-input {
  width: 100%;
  height: 100%;
  border: none;
  resize: none;
  padding: 20px;
  font-size: 16px;
  font-family: 'SFMono-Regular', Consolas, 'Liberation Mono', Menlo, Courier, monospace;
  background-color: #f6f8fa;
  color: #24292e;
  outline: none;
}

.right-pane {
  background-color: #ffffff;
  padding: 40px;
  display: flex;
  justify-content: center;
}

.preview-area {
  max-width: 375px; /* Simulate mobile width */
  width: 100%;
  background-color: #fff;
  min-height: 667px;
  box-shadow: 0 0 20px rgba(0,0,0,0.05);
  padding: 20px;
  border-radius: 8px;
  border: 1px solid #eaeaea;
}

/* Base styles for the preview to look like WeChat */
:deep(.preview-area h1) {
  font-size: 20px;
  color: #333;
  text-align: center;
  border-bottom: 1px solid #eaeaea;
  padding-bottom: 10px;
}

:deep(.preview-area h2) {
  font-size: 18px;
  color: #007bff;
  border-left: 4px solid #007bff;
  padding-left: 10px;
  margin-top: 30px;
}

:deep(.preview-area p) {
  font-size: 15px;
  line-height: 1.75;
  color: #555;
  letter-spacing: 1px;
}

:deep(.preview-area pre) {
  background-color: #f6f8fa;
  padding: 15px;
  border-radius: 6px;
  overflow-x: auto;
  font-size: 13px;
}

:deep(.preview-area blockquote) {
  border-left: 4px solid #e1e4e8;
  padding-left: 15px;
  color: #6a737d;
  margin-left: 0;
  background: #fcfcfc;
  padding: 10px 15px;
}
</style>
