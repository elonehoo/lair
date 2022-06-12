<script setup lang="ts">
import {Footer} from '@lair/components'
import { useRouter} from 'vue-router'

const router = useRouter()

</script>

<template>
  <main class="px-10 py-20 text-center gray-700 dark:gray-200">
    <router-view />
    <Footer github-link="https://github.com/elonehoo/static"><router-link to="/" i-carbon-home /></Footer>
    <div class="mt-5 mx-auto text-center opacity-25 text-sm">
      [{{router.currentRoute.value.name}} Layout]
    </div>
  </main>
</template>

<style>
</style>
