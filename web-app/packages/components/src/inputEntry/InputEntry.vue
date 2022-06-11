<script setup lang="ts">
const props = defineProps<{ name: string }>()
</script>

<template>
  <div>
    <input
      id="input"
      v-model="props.name"
      placeholder="What's your name?"
      type="text" autocomplete="off"
      p="x-4 y-2" m="t-5" w="250px"
      text="center" bg="transparent"
      border="~ rounded gray-200 dark:gray-700"
      outline="none active:none"
    >
    <div>
      <button
        m-3 text-sm btn
        :disabled="!name"
      >
        GO
      </button>
    </div>
  </div>
</template>
