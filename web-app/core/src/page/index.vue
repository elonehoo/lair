<script setup lang="ts">
import {Logos,InputEntry} from '@lair/components'
import { useRouter } from 'vue-router'

const name = $ref('')

const router = useRouter()

function go(){
  if (name.length > 0)
    router.push(`/hi/${encodeURIComponent(name)}`)
}
</script>

<template>
  <div>
    <Logos vite="/vite.svg" spring="/spring.svg" />
    <InputEntry v-model:name="name" @go="go"/>
  </div>
</template>
