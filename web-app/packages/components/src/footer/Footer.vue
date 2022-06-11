<script setup lang="ts">
import { DarkToggle } from '../index'

const props = defineProps<{ githubLink: string }>()
</script>

<template>
  <div text="xl gray4" m-5 flex justify-center gap-3>
    <slot></slot>
    <a i-carbon-logo-github :href="props.githubLink" target="_blank" />
    <DarkToggle />
  </div>
</template>
