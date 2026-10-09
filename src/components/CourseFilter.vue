<script setup lang="ts">
import { storeToRefs } from 'pinia';
import { useCoursesStore } from '../stores/courses';

const store = useCoursesStore();
const { categories, category, keyword } = storeToRefs(store);
</script>

<template>
  <div class="course-filter">
    <input
      v-model="keyword"
      type="search"
      placeholder="搜索课程、标签或简介…"
      class="course-filter__search"
      aria-label="搜索课程"
    />
    <div class="course-filter__categories" role="tablist" aria-label="课程分类">
      <button
        v-for="c in categories"
        :key="c"
        type="button"
        role="tab"
        :aria-selected="category === c"
        class="course-filter__chip"
        :class="{ 'course-filter__chip--active': category === c }"
        @click="store.setCategory(c)"
      >
        {{ c }}
      </button>
    </div>
  </div>
</template>
