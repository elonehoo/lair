<script setup lang="ts">
import { computed } from 'vue'
const props = defineProps(['name'])
const emit = defineEmits([
  'go',
  'update:name'
])
function go(){
  emit('go')
}
const name = computed({
  get() {
    return props.name
  },
  set(value) {
    emit('update:name', value)
  }
})
</script>

<template>
  <div>
    <input
      id="input"
      v-model="name"
      placeholder="What's your name?"
      type="text" autocomplete="off"
      p="x-4 y-2" m="t-5" w="250px"
      text="center" bg="transparent"
      border="~ rounded gray-200 dark:gray-700"
      outline="none active:none"
      @keydown.enter="go"
    >
    <div>
      <button
        m-3 text-sm btn
        :disabled="props.name.length <= 0"
        @click="go"
      >
        GO
      </button>
    </div>
  </div>
</template>
