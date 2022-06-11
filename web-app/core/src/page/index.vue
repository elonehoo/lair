<script setup lang="ts">
import {ref} from 'vue'
import {Logos,InputEntry} from '@lair/components'

const name = ref('')
</script>

<template>
  <div>
    <Logos vite="/vite.svg" spring="/spring.svg" />
    <InputEntry v-model:name="name"/>
  </div>
</template>
