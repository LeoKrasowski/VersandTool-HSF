import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router';
//import type { RouteRecordRaw } from 'vue-router';
import UsersView from '../views/UsersView.vue';
import Dashboard from '@/views/Dashboard.vue';
import StartPage from '@/views/StartPage.vue';
import Schweizer_karte from '@/views/Schweizer_karte.vue'

interface MyRouteMeta {
  title?: string
  titleKey?: string
}

const routes: Array<RouteRecordRaw & { meta: MyRouteMeta }> = [
  {
    path: '/',
    name: 'startpage',
    component: StartPage,
    meta: {titleKey: 'start'}
  },

  {
    path: '/users',
    name: 'Users',
    component: UsersView,
    meta: { title: 'Users', titleKey: 'users' }
  },

  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard,
    meta: { title: 'Dashboard', titleKey: 'dashboard'}
  },

  {
    path: '/schweizer_karte',
    name: 'schweizer karte',
    component: Schweizer_karte,
    meta: { title: 'schweizer_karte', titleKey: 'schweizer_karte'}
  },


];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
