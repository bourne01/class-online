import Vue from 'vue'
import VueRouter from 'vue-router'
import Admin from './admin/admin'
import Teacher from './teacher/teacher'
Vue.use(VueRouter)
export default new VueRouter({
    routes:[
        ...Admin,
        ...Teacher,             
    ]
})