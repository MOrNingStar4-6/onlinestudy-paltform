export type CourseLevel = '入门' | '进阶' | '高级';

export interface Course {
  id: string;
  title: string;
  description: string;
  category: string;
  cover: string;
  videoUrl: string;
  instructor: string;
  duration: string;
  level: CourseLevel;
  tags: string[];
}
