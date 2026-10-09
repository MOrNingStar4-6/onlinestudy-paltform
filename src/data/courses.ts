import type { Course } from '../types/course';

const SAMPLE_VIDEO =
  'https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4';

export const courses: Course[] = [
  {
    id: 'react-hooks',
    title: 'React Hooks 从入门到进阶',
    description:
      '系统掌握 useState、useEffect、useMemo、useCallback 等核心 Hook，并用自定义 Hook 组织业务逻辑。',
    category: '前端开发',
    cover: 'https://picsum.photos/seed/react-hooks/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '林老师',
    duration: '12 小时',
    level: '进阶',
    tags: ['React', 'TypeScript', 'Hooks'],
  },
  {
    id: 'typescript-basics',
    title: 'TypeScript 类型体操入门',
    description:
      '从类型注解、接口与泛型开始，逐步理解联合类型、条件类型与工具类型在实际项目中的用法。',
    category: '前端开发',
    cover: 'https://picsum.photos/seed/typescript-basics/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '周老师',
    duration: '8 小时',
    level: '入门',
    tags: ['TypeScript', '类型系统'],
  },
  {
    id: 'vite-build',
    title: 'Vite 工程化实战',
    description:
      '理解 Vite 的构建原理与插件机制，搭建带环境变量、代理与按需加载的现代化前端工程。',
    category: '前端开发',
    cover: 'https://picsum.photos/seed/vite-build/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '陈老师',
    duration: '6 小时',
    level: '进阶',
    tags: ['Vite', '工程化', '构建'],
  },
  {
    id: 'node-express',
    title: 'Node.js + Express 后端入门',
    description:
      '使用 Express 搭建 RESTful API，理解路由、中间件与错误处理，并完成一个可运行的服务端。',
    category: '后端开发',
    cover: 'https://picsum.photos/seed/node-express/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '王老师',
    duration: '10 小时',
    level: '入门',
    tags: ['Node.js', 'Express', 'REST API'],
  },
  {
    id: 'mysql-design',
    title: 'MySQL 数据库设计与优化',
    description:
      '从范式设计到索引优化，理解常见查询性能问题，并学会在真实业务中设计合理的表结构。',
    category: '后端开发',
    cover: 'https://picsum.photos/seed/mysql-design/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '赵老师',
    duration: '9 小时',
    level: '进阶',
    tags: ['MySQL', '数据库', '索引'],
  },
  {
    id: 'algo-sorting',
    title: '算法与数据结构：排序与查找',
    description:
      '掌握常见排序与查找算法的时间复杂度分析，并通过刷题建立稳定的算法直觉。',
    category: '计算机基础',
    cover: 'https://picsum.photos/seed/algo-sorting/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '孙老师',
    duration: '15 小时',
    level: '进阶',
    tags: ['算法', '数据结构', '面试'],
  },
  {
    id: 'os-concurrency',
    title: '操作系统：进程与并发',
    description:
      '理解进程、线程、锁与调度，从底层视角解释并发程序为什么难写，以及如何写出正确代码。',
    category: '计算机基础',
    cover: 'https://picsum.photos/seed/os-concurrency/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '钱老师',
    duration: '11 小时',
    level: '高级',
    tags: ['操作系统', '并发', '线程'],
  },
  {
    id: 'ai-prompt-eng',
    title: 'AI 提示词工程入门',
    description:
      '学习如何设计结构化提示词，把大模型能力应用到代码生成、文档总结与日常工作流中。',
    category: '人工智能',
    cover: 'https://picsum.photos/seed/ai-prompt-eng/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '吴老师',
    duration: '5 小时',
    level: '入门',
    tags: ['AI', '提示词', '大模型'],
  },
  {
    id: 'ai-rag-basics',
    title: 'RAG 检索增强生成基础',
    description:
      '理解向量检索与 RAG 的基本流程，动手搭建一个最小可用的知识库问答示例。',
    category: '人工智能',
    cover: 'https://picsum.photos/seed/ai-rag-basics/800/450',
    videoUrl: SAMPLE_VIDEO,
    instructor: '郑老师',
    duration: '7 小时',
    level: '进阶',
    tags: ['RAG', '向量检索', 'AI 应用'],
  },
];
