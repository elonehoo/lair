import { ref } from 'vue'

export interface UseCounterOptions {
  min?: number
  max?: number
}

export function useCount(initialValue = Math.round(Math.random() * 20), options: UseCounterOptions = {}) {
  const count = ref(initialValue)

  const {
    max = Infinity,
    min = -Infinity,
  } = options

  const inc = (delta = 1) => count.value = Math.min(max, count.value + delta)
  const dec = (delta = 1) => count.value = Math.max(min, count.value - delta)
  const get = () => count.value
  const set = (val: number) => (count.value = val)
  const reset = (val = initialValue) => {
    initialValue = val
    return set(val)
  }

  return { count, inc, dec, get, set, reset }
}
