<script setup lang="ts">
import {Counter} from '@lair/components'
import {all} from '@lair/api'

const props = defineProps<{ name: string }>()

const emit = defineEmits([ 'back' ])

function back(){
  emit('back')
}

let users:any = $ref([])

all().then(res=>{
  users = res.data
})
</script>

<template>
<div>
    <div i-twemoji:victory-hand text-4xl inline-block animate-shake-x animate-duration-5000 />
    <h3 text-2xl font-500>
      Hi,
    </h3>
    <div text-xl>{{ props.name }}!</div>

    <template v-if="users.length">
      <p text-sm my-4>
        <span op-50>Also as known as:</span>
        <ul>
          <li v-for="user in users" :key="user.id">
            <router-link :to="`/hi/${user.name}`" replace>
              {{ user.name }}
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
