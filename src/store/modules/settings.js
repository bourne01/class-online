import {getDepartmentList,addDepartment,editDepartment,delDepartment, 
    editMajor, delMajors,addMajor,getMajors,getSelector} from '../../api/settings'
import * as type from './other-mutations-type'

const state = {
    majSelector:[],//专业下拉列表
    depSelector:[],//学部下拉列表
    depList:[],//学部信息
    majorList:[],//专业信息
    isDepEditable:false,//是否处于部门编辑状态
    //curRow:{},//当前表格行    
}

const getters = {

}

const mutations = {
    [type.GET_DEPARTMENTS](state,params){
        state.depList = params;
    },
    [type.GET_MAJORS](state,params){
        state.majorList = params;
    },
    [type.IS_DEP_EDITABLE](state,params){
        state.isDepEditable = params;
    },
    /* [type.SET_CURRENT_ROW](state,params){
        state.curRow = params;
    } */
}

const actions = {
    
    //获取学部信息
    getDepList({commit},params){
        return new Promise((resolve,reject) => {
            getDepartmentList(params)
                .then(res => {
                    commit('GET_DEPARTMENTS',res.data.dataList);
                    resolve(res.data);
                })
                .catch(err => {
                    console.log(err);
                    reject(err)
                })
        })
    },
    //新增学部
    addDep({dispatch},params){
        return new Promise((resolve,reject) => {
            addDepartment(params)
                .then(res => {
                    dispatch('getDepList');
                    resolve(res.data);
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },
    //编辑学部
    editDep({dispatch},params){
        return new Promise((resolve,reject) => {
            editDepartment(params)
                .then(res => {
                    dispatch('getDepList');
                    resolve(res.data);
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },
    //删除学部
    delDep({dispatch},params){
        return new Promise((resolve,reject) => {
            delDepartment(params)
                .then(res => {
                    dispatch('getDepList');
                    resolve(res.data);
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },
    //获取专业信息
    getMajorList({commit},params){
        return new Promise((resolve,reject) => {
            getMajors(params.url,params.params)
                .then(res => {
                    console.log(res)
                    commit('GET_MAJORS',res.data.dataList);
                    resolve(res.data);
                })
                .catch(err => {
                    console.log(err);
                    reject(err)
                })
        })
    },
    //新增专业
    addMajor({dispatch},params){
        return new Promise((resolve,reject) => {
            addMajor(params)
                .then(res => {
                    // this.getMajorList({});
                    let url = 'maj!query4.action?';
                    dispatch('getMajorList',{url,params:{}});
                    resolve(res.data)
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },
    //编辑专业
    editMajor({dispatch},params){
        return new Promise((resolve,reject) => {
            editMajor(params)
                .then(res => {
                    let url = 'maj!query4.action?';
                    dispatch('getMajorList',{url,params:{}});
                    resolve(res.data)
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },
    //删除专业
    delMajor({dispatch},params){
        return new Promise((resolve,reject) => {
            delMajors(params)
                .then(res => {
                    let url = 'maj!query4.action?';
                    dispatch('getMajorList',{url,params:{}});
                    resolve(res.data)
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },    
    //按比例设置拟录人数
    setAdmitStudents({},params){
        return new Promise((resolve,reject) => {
            setAdmitStudents(params)
                .then(res => {
                    //this.getDepList({});
                    resolve(res.data)
                })
                .catch(err => {
                    console.log(err)
                    reject(err)
                })
        })
    },
}

export default {
    namespaced:true,
    state,
    getters,
    mutations,
    actions
}