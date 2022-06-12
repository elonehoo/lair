<script setup lang="ts">
import {Counter} from '@lair/components'

const props = defineProps<{ name: string }>()

const emit = defineEmits([
  'back'
])

function back(){
  emit('back')
}

const user = {
  otherNames:[
    'John',
    'Jane'
  ]
}
</script>

<template>
<div>
    <div i-twemoji:victory-hand text-4xl inline-block animate-shake-x animate-duration-5000 />
    <h3 text-2xl font-500>
      Hi,
    </h3>
    <div text-xl>{{ props.name }}!</div>

    <template v-if="user.otherNames.length">
      <p text-sm my-4>
        <span op-50>Also as known as:</span>
        <ul>
          <li v-for="otherName in user.otherNames" :key="otherName">
            <router-link :to="`/hi/${otherName}`" replace>
              {{ otherName }}
            </router-link>
          </li>
        </ul>
      </p>
    </template>

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
