import Vuex from 'vuex'
import Bank from './modules/bank/bank'
import Course from './modules/course/course'
import User from './modules/user/user'
import Teacher from './modules/teacher/teacher'
import Student from './modules/student/student'
import Home from './modules/home/home'

const isDev = process.env.NODE_ENV === 'development'
export default () => {
    return new Vuex.Store({
        strict:isDev,//不可在生产环境使用
        state:{},
        getters:{},
        mutations:{},
        actions:{}, 
        modules:{
            /* management:{
                namespaced:true,                
                state:manageState,
                actions,
                mutations,
                getters,
            },  */
            // settings:Settings,
            bank:Bank,
            user:User,
            teacher:Teacher,
            course:Course,
            student:Student,
            home:Home,
        }
    })
}