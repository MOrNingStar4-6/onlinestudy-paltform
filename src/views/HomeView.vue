<script setup lang="ts">
import CourseFilter from '../components/CourseFilter.vue';
import CourseList from '../components/CourseList.vue';
</script>

<template>
  <main class="home">
    <header class="home__header">
      <h1 class="home__title">Study Hub</h1>
      <p class="home__subtitle">一个使用 Vue 3 + TypeScript + Pinia 构建的在线课程展示平台</p>
    </header>
    <CourseFilter />
    <CourseList />
  </main>
</template>
