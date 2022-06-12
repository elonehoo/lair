<script setup lang="ts">
import {Counter} from '@lair/components'
const props = defineProps<{ name: string }>()
const emit = defineEmits([
  'back'
])
function back(){
  emit('back')
}
</script>

<template>
<div>
    <div i-twemoji:victory-hand text-4xl inline-block animate-shake-x animate-duration-5000 />
    <h3 text-2xl font-500>
      Hi,
    </h3>
    <div text-xl>{{ props.name }}!</div>

    <p class="text-sm opacity-50">
      <em>Dynamic route!</em>
    </p>

    <Counter/>

    <div>
      <button
        class="text-sm mt-8 m-3 btn"
        @click="back"
      >
        Back
      </button>
    </div>
  </div>
</template>
