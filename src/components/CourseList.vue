<script setup lang="ts">
import { storeToRefs } from 'pinia';
import { useCoursesStore } from '../stores/courses';
import CourseCard from './CourseCard.vue';

const store = useCoursesStore();
const { filteredCourses } = storeToRefs(store);
</script>

<template>
  <p v-if="filteredCourses.length === 0" class="course-list__empty">
    没有找到匹配的课程，换个关键词试试。
  </p>
  <div v-else class="course-list">
    <CourseCard v-for="course in filteredCourses" :key="course.id" :course="course" />
  </div>
</template>
