<script setup lang="ts">
const props = defineProps<{ count: number,date:any }>()
</script>

<template>
  <div text-gray:80>
    <span font-500 text-gray>{{props.count}}</span>
    page views since
    <span text-gray>{{props.date}}</span>
  </div>
</template>
