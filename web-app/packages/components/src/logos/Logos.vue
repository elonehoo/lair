<script setup lang="ts">
const props = defineProps<{ spring: string,vite:string }>()
</script>

<template>
  <div inline-flex text-2xl font-300 cursor-default mb-6>
    <div flex flex-col children:mx-auto>
      <img w-18 h-18 inline-block :src="props.spring">
      <span text-green5 mt--0>Spring</span>
    </div>
    <div
      text="3xl gray4"
      m="x-4 y-auto"
      transition-all-500
      transform
      hover:rotate-135
      i-carbon-add
    />
    <div flex flex-col children:mx-auto>
      <img w-18 h-18 inline-block :src="props.vite">
      <span text-purple5 mt--0>Vite</span>
    </div>
  </div>
</template>
