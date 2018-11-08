
import * as type from './mutations-type'
import { getCourses } from '../../../api/course/course';
import { xhrErrHandler } from '../../../utils/util'

const state = {
    courseList:[],//课程列表
    currentCourse:{},//当前课程对象
    classList:[],//课堂列表及多少节课
    currenClass:{},//当前课堂
}

const mutations = {
    [type.GET_COURSE_LIST](state,params){
        state.courseList = params
    },
    [type.SET_CURRENT_COURSE](state,params){
        state.currentCourse = params
    },
    [type.GET_CLASS_LIST](state,params){
        state.classList = params
    },
    [type.SET_CURRENT_CLASS](state,params){
        state.currenClass = params
    },
}

const getters = {
    
}

const actions = {
    /**@function 获取课程列表 */
    getCourseList({commit},params){
        return new Promise((resolve,reject) => {
            getCourses(params.url,params.params)
                .then(res => {
                    commit('GET_COURSE_LIST',res.data.d);
                    resolve(res.data);
                })
                .catch(err => {
                    reject(err)
                    xhrErrHandler(err,this.$router,this.$message)
                })
        })
    }
}


export default {
    namespaced:true,
    state,     
    getters,     
    mutations,     
    actions 
}