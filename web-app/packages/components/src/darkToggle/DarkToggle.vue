<script setup lang="ts">
function toggleDark() {
  const isDark = document.documentElement.classList.toggle('dark')
  localStorage.setItem('color-schema', isDark ? 'dark' : 'light')
}
</script>

<template>
  <button class="!outline-none" @click="toggleDark">
    <div class="dark:i-carbon-moon i-carbon-sun" />
  </button>
</template>
