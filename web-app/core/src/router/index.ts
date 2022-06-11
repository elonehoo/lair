import { createRouter, createWebHistory } from 'vue-router'
import {Error} from '@lair/pages'
import Default from '../page/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', component: Default, name: 'Default' },
    { path: '/:pathMatch(.*)*', component: Error, name: 'Error' },
  ],
})

export default router
