import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router';
//import type { RouteRecordRaw } from 'vue-router';
import UsersView from '../views/UsersView.vue';

interface MyRouteMeta {
  title?: string
  titleKey?: string
}

const routes: Array<RouteRecordRaw & { meta: MyRouteMeta }> = [
  {
    path: '/users',
    name: 'Users',
    component: UsersView,
    meta: { title: 'Users', titleKey: 'users' }
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
