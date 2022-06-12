<script setup lang="ts">
import { computed } from 'vue'
import {Logos,InputEntry,PageView} from '@lair/components'
import { useRouter } from 'vue-router'
import {install,installHi,pageView} from '@lair/api'
import {useTimeAgo} from '@vueuse/core'

const name = $ref('')

const router = useRouter()

let count:number = $ref(0)
let time:any = $ref()

pageView().then(res=>{
  count = res.data.count
  time = useTimeAgo(computed(() => res.data.time)).value
})

function go(){
  if (name.length > 0){
    install(new installHi(name)).then(res=>{
      if(res.data === true){
        router.push(`/hi/${encodeURIComponent(name)}`)
      }
    })
  }
}
</script>

<template>
  <div>
    <Logos vite="/vite.svg" spring="/spring.svg" />
    <PageView :count="count" :date="time" />
    <InputEntry v-model:name="name" @go="go"/>
  </div>
</template>
