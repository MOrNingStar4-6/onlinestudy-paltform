# 在线学习平台（Online Study Platform）

一个前后端分离的在线课程展示平台：前端使用 **Vue 3 + TypeScript + Pinia + Vite**，后端使用 **Java 17 + Spring Boot + Spring Data JPA + H2**。覆盖课程浏览、分类筛选、关键词搜索、图片懒加载与视频播放，演示全栈开发中的组件化、状态管理、REST API 与数据库持久化实践。

![license](https://img.shields.io/badge/license-MIT-blue)
![vue](https://img.shields.io/badge/vue-3.5-42b883)
![typescript](https://img.shields.io/badge/typescript-5.5-3178c6)
![vite](https://img.shields.io/badge/vite-5.4-646cff)
![spring boot](https://img.shields.io/badge/spring--boot-3.3-6db33f)
![java](https://img.shields.io/badge/java-17-007396)

## 功能

- 课程列表与详情页，支持前端路由跳转
- 按分类筛选，支持关键词搜索课程、标签与简介
- 课程封面图片懒加载 + 骨架屏，减少首屏请求、优化弱网体验
- HTML5 视频播放，支持封面海报
- 后端提供课程列表与详情 REST API，数据持久化到 H2 内存数据库
- 响应式布局，适配桌面与移动端

## 技术栈

**前端**

- Vue 3（Composition API + `<script setup>`）
- TypeScript
- Vite、Pinia、Vue Router
- 原生 CSS（无额外 UI 库依赖）

**后端**

- Java 17
- Spring Boot 3.3、Spring Web、Spring Data JPA
- H2 内存数据库

## 目录结构

```text
.
├── src/                    # 前端源码
│   ├── components/
│   ├── data/               # 前端 Mock 数据
│   ├── router/
│   ├── stores/             # Pinia store
│   ├── styles/
│   ├── types/
│   └── views/
├── backend/                # 后端源码（Spring Boot）
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/donghan/studyhub/
│       │   ├── StudyHubApplication.java
│       │   ├── course/     # 实体、仓库、控制器
│       │   └── config/     # CORS 与种子数据
│       └── resources/application.yml
├── index.html
├── vite.config.ts
└── package.json
```

## 快速开始

### 前端

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

### 后端

需要 JDK 17 与 Maven（或使用 IntelliJ IDEA 打开 `backend/` 目录）。

```bash
cd backend
mvn spring-boot:run
```

服务启动在 <http://localhost:8080>，H2 控制台位于 <http://localhost:8080/h2-console>。

## API 接口

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/api/courses` | 课程列表，支持 `?category=` 与 `?keyword=` 过滤 |
| GET | `/api/courses/{id}` | 课程详情 |

示例：

```bash
curl "http://localhost:8080/api/courses?category=前端开发"
curl "http://localhost:8080/api/courses?keyword=TypeScript"
```

> 当前前端默认使用 `src/data/courses.ts` 的 Mock 数据，可独立运行；接入后端时，将 `src/stores/courses.ts` 改为请求 `http://localhost:8080/api/courses` 即可（后端已配置 CORS 允许 `http://localhost:5173`）。

## 关键实现

### 图片懒加载（前端）

`LazyImage` 组件通过 `IntersectionObserver` 监听图片是否进入视口，在进入视口前只渲染骨架屏，进入视口后才设置 `src`，并配合原生 `loading="lazy"` 双重兜底。

### 状态管理（前端）

课程数据与筛选条件统一存放在 Pinia store 中，通过 `computed` 派生过滤后的课程列表，避免重复计算。

### REST API 与持久化（后端）

课程通过 `@Entity` 映射到 `courses` 表，标签使用 `@ElementCollection` 存到关联表；`CourseController` 提供列表过滤与详情接口，启动时由 `DataSeeder` 写入种子数据。

## Roadmap

- [ ] 前端接入后端 API，替换 Mock 数据
- [ ] 增加骨架屏的通用化封装与单测
- [ ] 接入 Husky + lint-staged，在提交前自动检查
- [ ] 使用 Vue Test Utils 补充组件与交互测试
- [ ] 增加 GitHub Actions 自动构建与部署

## License

[MIT](./LICENSE)
