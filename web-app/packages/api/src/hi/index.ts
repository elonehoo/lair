import {basicHttp} from '../config'
import { installHi } from './entity/installHi'

/**
 * Insert the user's name into the database
 * @param entity Store the entity class that goes into the database
 * @returns Returns the json data sent by the server
 */
export function install(entity:installHi){
  return basicHttp.request({
    url:'http://localhost:8080/item/hi/',
    method:'POST',
    data:entity
  })
}

/**
 * Get the number of views and the time of the last view
 * @returns Returns the json data sent by the server
 */
export function pageView(){
  return basicHttp.request({
    url:'http://localhost:8080/item/hi/',
    method:'GET'
  })
}

/**
 * Get all the views
 * @returns Returns the json data sent by the server
 */
export function all(){
  return basicHttp.request({
    url:'http://localhost:8080/item/hi/all',
    method:'GET'
  })
}
