<script setup lang="ts">
import {Error} from '@lair/pages'
import { useRouter } from 'vue-router'

const route = useRouter()

function back(){
  route.back()
}
</script>

<template>
<Error @back="back()"/>
</template>
