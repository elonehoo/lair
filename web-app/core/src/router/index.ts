import { createRouter, createWebHistory } from 'vue-router'
import Error from '../page/error/index.vue'
import Home from '../page/hi/index.vue'
import Default from '../page/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', component: Default, name: 'Default' },
    { path: '/hi/:name', component: Home, name: 'Home',props: true },
    { path: '/:pathMatch(.*)*', component: Error, name: 'Error' },
  ],
})

export default router
