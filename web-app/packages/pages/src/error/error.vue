<script setup lang="ts">
const emit = defineEmits([
  'back'
])

function back(){
  emit('back')
}
</script>

<template>
  <main p="x4 y10" text="center teal-700 dark:gray-200">
    <div text-4xl>
      <div i-carbon-warning inline-block />
    </div>
    <div>Not found</div>
    <div>
      <button btn text-sm m="3 t8" @click="back">
        Back
      </button>
    </div>
  </main>
</template>
