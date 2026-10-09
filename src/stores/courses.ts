import { computed, ref } from 'vue';
import { defineStore } from 'pinia';
import type { Course } from '../types/course';
import { courses as seedCourses } from '../data/courses';

export const useCoursesStore = defineStore('courses', () => {
  const courses = ref<Course[]>(seedCourses);
  const category = ref('全部');
  const keyword = ref('');

  const categories = computed(() => ['全部', ...new Set(courses.value.map((c) => c.category))]);

  const filteredCourses = computed(() => {
    const normalizedKeyword = keyword.value.trim().toLowerCase();

    return courses.value.filter((course) => {
      const matchCategory = category.value === '全部' || course.category === category.value;
      const matchKeyword =
        normalizedKeyword.length === 0 ||
        course.title.toLowerCase().includes(normalizedKeyword) ||
        course.description.toLowerCase().includes(normalizedKeyword) ||
        course.tags.some((tag) => tag.toLowerCase().includes(normalizedKeyword));

      return matchCategory && matchKeyword;
    });
  });

  function setCategory(value: string) {
    category.value = value;
  }

  function setKeyword(value: string) {
    keyword.value = value;
  }

  function getCourseById(id: string) {
    return courses.value.find((course) => course.id === id);
  }

  return {
    courses,
    category,
    keyword,
    categories,
    filteredCourses,
    setCategory,
    setKeyword,
    getCourseById,
  };
});
