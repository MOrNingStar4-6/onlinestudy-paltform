<script setup lang="ts">
import { RouterLink } from 'vue-router';
import type { Course } from '../types/course';
import LazyImage from './LazyImage.vue';

defineProps<{
  course: Course;
}>();
</script>

<template>
  <article class="course-card">
    <RouterLink :to="`/courses/${course.id}`" class="course-card__link">
      <LazyImage :src="course.cover" :alt="course.title" class="course-card__cover" />
      <div class="course-card__body">
        <div class="course-card__meta">
          <span class="course-card__category">{{ course.category }}</span>
          <span class="course-card__level">{{ course.level }}</span>
        </div>
        <h3 class="course-card__title">{{ course.title }}</h3>
        <p class="course-card__desc">{{ course.description }}</p>
        <div class="course-card__footer">
          <span class="course-card__instructor">{{ course.instructor }}</span>
          <span class="course-card__duration">{{ course.duration }}</span>
        </div>
      </div>
    </RouterLink>
  </article>
</template>
