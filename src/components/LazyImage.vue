<script setup lang="ts">
import { onBeforeUnmount, onMounted, ref } from 'vue';

const props = defineProps<{
  src: string;
  alt: string;
}>();

const container = ref<HTMLDivElement | null>(null);
const visible = ref(false);
const loaded = ref(false);
let observer: IntersectionObserver | null = null;

onMounted(() => {
  if (!container.value) return;

  if (!('IntersectionObserver' in window)) {
    visible.value = true;
    return;
  }

  observer = new IntersectionObserver(
    ([entry]) => {
      if (entry.isIntersecting) {
        visible.value = true;
        observer?.disconnect();
      }
    },
    { rootMargin: '200px 0px' },
  );

  observer.observe(container.value);
});

onBeforeUnmount(() => observer?.disconnect());
</script>

<template>
  <div ref="container" class="lazy-image" :aria-busy="!loaded">
    <div v-if="!loaded" class="lazy-image__skeleton" aria-hidden="true" />
    <img
      v-if="visible"
      :src="props.src"
      :alt="props.alt"
      class="lazy-image__img"
      loading="lazy"
      @load="loaded = true"
    />
  </div>
</template>
