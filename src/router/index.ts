import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CourseDetailView from '../views/CourseDetailView.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: HomeView },
    { path: '/courses/:id', name: 'course-detail', component: CourseDetailView, props: true },
    { path: '/:pathMatch(.*)*', redirect: '/' },
  ],
});

export default router;
