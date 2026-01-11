import { createRouter, createWebHistory } from 'vue-router';
//import type { RouteRecordRaw } from 'vue-router';
import UsersView from '../views/UsersView.vue';

const routes = [
  {
    path: '/users',
    name: 'Users',
    component: UsersView
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
