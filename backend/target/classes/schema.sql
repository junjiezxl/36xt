-- 如果表不存在，则创建 article 表
CREATE TABLE IF NOT EXISTS `article` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` VARCHAR(255) NOT NULL COMMENT '文章标题',
  `summary` VARCHAR(500) COMMENT '文章摘要',
  `content` LONGTEXT NOT NULL COMMENT '文章内容(Markdown)',
  `category` VARCHAR(100) COMMENT '分类',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- 插入一条初始测试数据（如果表是空的）
INSERT INTO `article` (`title`, `summary`, `content`, `category`)
SELECT '你好，36xt博客', '这是第一篇测试文章摘要，代表着全栈博客后端引擎启动成功！', '## 欢迎使用 \n这是一篇来自 MySQL 数据库的文章。', '后端实战'
WHERE NOT EXISTS (SELECT 1 FROM `article`);
