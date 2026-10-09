package com.donghan.studyhub.config;

import com.donghan.studyhub.entity.Course;
import com.donghan.studyhub.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    private static final String SAMPLE_VIDEO =
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    @Bean
    CommandLineRunner seedCourses(CourseRepository repository) {
        return args -> {
            if (repository.count() > 0) {
                return;
            }

            repository.saveAll(List.of(
                    new Course("react-hooks", "React Hooks 从入门到进阶",
                            "系统掌握 useState、useEffect、useMemo、useCallback 等核心 Hook，并用自定义 Hook 组织业务逻辑。",
                            "前端开发", "https://picsum.photos/seed/react-hooks/800/450", SAMPLE_VIDEO,
                            "林老师", "12 小时", "进阶", List.of("React", "TypeScript", "Hooks")),
                    new Course("typescript-basics", "TypeScript 类型体操入门",
                            "从类型注解、接口与泛型开始，逐步理解联合类型、条件类型与工具类型在实际项目中的用法。",
                            "前端开发", "https://picsum.photos/seed/typescript-basics/800/450", SAMPLE_VIDEO,
                            "周老师", "8 小时", "入门", List.of("TypeScript", "类型系统")),
                    new Course("vite-build", "Vite 工程化实战",
                            "理解 Vite 的构建原理与插件机制，搭建带环境变量、代理与按需加载的现代化前端工程。",
                            "前端开发", "https://picsum.photos/seed/vite-build/800/450", SAMPLE_VIDEO,
                            "陈老师", "6 小时", "进阶", List.of("Vite", "工程化", "构建")),
                    new Course("node-express", "Node.js + Express 后端入门",
                            "使用 Express 搭建 RESTful API，理解路由、中间件与错误处理，并完成一个可运行的服务端。",
                            "后端开发", "https://picsum.photos/seed/node-express/800/450", SAMPLE_VIDEO,
                            "王老师", "10 小时", "入门", List.of("Node.js", "Express", "REST API")),
                    new Course("mysql-design", "MySQL 数据库设计与优化",
                            "从范式设计到索引优化，理解常见查询性能问题，并学会在真实业务中设计合理的表结构。",
                            "后端开发", "https://picsum.photos/seed/mysql-design/800/450", SAMPLE_VIDEO,
                            "赵老师", "9 小时", "进阶", List.of("MySQL", "数据库", "索引")),
                    new Course("algo-sorting", "算法与数据结构：排序与查找",
                            "掌握常见排序与查找算法的时间复杂度分析，并通过刷题建立稳定的算法直觉。",
                            "计算机基础", "https://picsum.photos/seed/algo-sorting/800/450", SAMPLE_VIDEO,
                            "孙老师", "15 小时", "进阶", List.of("算法", "数据结构", "面试")),
                    new Course("os-concurrency", "操作系统：进程与并发",
                            "理解进程、线程、锁与调度，从底层视角解释并发程序为什么难写，以及如何写出正确代码。",
                            "计算机基础", "https://picsum.photos/seed/os-concurrency/800/450", SAMPLE_VIDEO,
                            "钱老师", "11 小时", "高级", List.of("操作系统", "并发", "线程")),
                    new Course("ai-prompt-eng", "AI 提示词工程入门",
                            "学习如何设计结构化提示词，把大模型能力应用到代码生成、文档总结与日常工作流中。",
                            "人工智能", "https://picsum.photos/seed/ai-prompt-eng/800/450", SAMPLE_VIDEO,
                            "吴老师", "5 小时", "入门", List.of("AI", "提示词", "大模型")),
                    new Course("ai-rag-basics", "RAG 检索增强生成基础",
                            "理解向量检索与 RAG 的基本流程，动手搭建一个最小可用的知识库问答示例。",
                            "人工智能", "https://picsum.photos/seed/ai-rag-basics/800/450", SAMPLE_VIDEO,
                            "郑老师", "7 小时", "进阶", List.of("RAG", "向量检索", "AI 应用"))
            ));
        };
    }
}
