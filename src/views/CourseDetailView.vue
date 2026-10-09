<script setup lang="ts">
import { computed } from 'vue';
import { RouterLink } from 'vue-router';
import { useCoursesStore } from '../stores/courses';

const props = defineProps<{
  id: string;
}>();

const store = useCoursesStore();
const course = computed(() => store.getCourseById(props.id));
</script>

<template>
  <main class="course-detail-page">
    <article v-if="course" class="course-detail">
      <RouterLink to="/" class="course-detail__back">← 返回课程列表</RouterLink>
      <h1 class="course-detail__title">{{ course.title }}</h1>
      <p class="course-detail__meta">
        {{ course.category }} · {{ course.level }} · {{ course.instructor }} · {{ course.duration }}
      </p>
      <video class="course-detail__video" :src="course.videoUrl" :poster="course.cover" controls>
        你的浏览器不支持视频播放。
      </video>
      <p class="course-detail__desc">{{ course.description }}</p>
      <div class="course-detail__tags">
        <span v-for="tag in course.tags" :key="tag" class="course-detail__tag">{{ tag }}</span>
      </div>
    </article>
    <div v-else class="course-detail">
      <p>课程不存在。</p>
      <RouterLink to="/" class="course-detail__back">← 返回课程列表</RouterLink>
    </div>
  </main>
</template>
