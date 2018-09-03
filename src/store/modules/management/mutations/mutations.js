import * as types from '../mutations-type'
export default {
    [types.SET_MAJOR_STUDENT_LIST](state,params){
        state.majStudentList = params;
    },
    [types.SET_STUDENT_LIST](state,params){
        state.studentList = params;
    },
    [types.SET_TOTAL](state,params){
        state.total = params;
    },
    [types.SET_SEARCH_PARAMS](state,params){
        state.stuSearch = params;
    },
    [types.SET_CURRENT_STUDENT](state,params){
        state.curStudent = params;
    }
}