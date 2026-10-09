# 在线学习平台（Online Study Platform）

一个使用 **Vue 3 + TypeScript + Pinia + Vite** 构建的在线课程展示平台前端。项目覆盖课程浏览、分类筛选、关键词搜索、图片懒加载与视频播放，重点演示组件化、状态管理与前端性能优化的工程实践。

![license](https://img.shields.io/badge/license-MIT-blue)
![vue](https://img.shields.io/badge/vue-3.5-42b883)
![typescript](https://img.shields.io/badge/typescript-5.5-3178c6)
![vite](https://img.shields.io/badge/vite-5.4-646cff)

## 功能

- 课程列表与详情页，支持前端路由跳转
- 按分类筛选，支持关键词搜索课程、标签与简介
- 课程封面图片懒加载 + 骨架屏，减少首屏请求、优化弱网体验
- HTML5 视频播放，支持封面海报
- 使用 Pinia 集中管理课程与筛选状态，避免多组件间状态同步问题
- 响应式布局，适配桌面与移动端

## 技术栈

- Vue 3（Composition API + `<script setup>`）
- TypeScript
- Vite 作为开发与构建工具
- Pinia 管理状态
- Vue Router 管理路由
- 原生 CSS 完成视觉样式（无额外 UI 库依赖）

## 快速开始

需要 Node.js 18 及以上版本。

```bash
npm install
npm run dev
```

浏览器访问 <http://localhost:5173>。

生产构建与本地预览：

```bash
npm run build
npm run preview
```

代码质量与测试：

```bash
npm run typecheck   # vue-tsc 类型检查
npm run lint        # ESLint 检查
npm run format      # Prettier 格式化
npm test            # 运行单元测试
```

## 目录结构

```text
.
├── src/
│   ├── components/          # 通用组件
│   │   ├── LazyImage.vue
│   │   ├── CourseCard.vue
│   │   ├── CourseFilter.vue
│   │   └── CourseList.vue
│   ├── data/                # Mock 数据
│   │   └── courses.ts
│   ├── router/              # 路由
│   │   └── index.ts
│   ├── stores/              # Pinia store
│   │   ├── courses.ts
│   │   └── courses.test.ts
│   ├── styles/              # 全局样式
│   │   └── index.css
│   ├── types/               # 类型定义
│   │   └── course.ts
│   ├── views/               # 路由页面
│   │   ├── HomeView.vue
│   │   └── CourseDetailView.vue
│   ├── App.vue
│   └── main.ts
├── index.html
├── vite.config.ts
├── vitest.config.ts
├── eslint.config.js
└── tsconfig.json
```

## 关键实现

### 图片懒加载

`LazyImage` 组件通过 `IntersectionObserver` 监听图片是否进入视口，在进入视口前只渲染骨架屏，进入视口后才设置 `src`，并配合原生 `loading="lazy"` 双重兜底。

```ts
observer = new IntersectionObserver(
  ([entry]) => {
    if (entry.isIntersecting) {
      visible.value = true;
      observer?.disconnect();
    }
  },
  { rootMargin: '200px 0px' },
);
```

### 状态管理

课程数据与筛选条件统一存放在 Pinia store 中，通过 `computed` 派生过滤后的课程列表，避免重复计算。

```ts
const filteredCourses = computed(() =>
  courses.value.filter((course) => {
    // 同时匹配分类与关键词
  }),
);
```

## Roadmap

- [ ] 接入真实后端 API，替换 Mock 数据
- [ ] 增加骨架屏的通用化封装与单测
- [ ] 接入 Husky + lint-staged，在提交前自动检查
- [ ] 使用 Vue Test Utils 补充组件与交互测试
- [ ] 增加 GitHub Actions 自动构建与部署

## License

[MIT](./LICENSE)
