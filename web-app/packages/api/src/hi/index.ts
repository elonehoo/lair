import {basicHttp} from '../config'
import { installHi } from './entity/installHi'

export function install(entity:installHi){
  return basicHttp.request({
    url:'http://localhost:8080/item/hi/',
    method:'POST',
    data:entity
  })
}

export function pageView(){
  return basicHttp.request({
    url:'http://localhost:8080/item/hi/',
    method:'GET'
  })
}

export function all(){
  return basicHttp.request({
    url:'http://localhost:8080/item/hi/all',
    method:'GET'
  })
}
