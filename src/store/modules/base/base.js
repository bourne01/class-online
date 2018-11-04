import * as type from './mutations-type'

const state = {
    curMenuTitle:'',//左侧导航区，当前菜单标题名称
    curMenuItem:{},//当前菜单项对象
    curRow:{},//当前表格行对象
}

const mutations = {
    [type.SET_CURRENT_MENU_ITEM](state,params){
        state.curMenuItem = params;
    },
    [type.SET_CURRENT_MENU_TITLE](state,params){
        state.curMenuTitle = params;
    },
    [type.SET_CURRENT_ROW](state,params){
        state.curRow = params;
    },
}

const getters = {
    
}

const actions = {


}


export default {
    namespaced:true,
    state,     
    getters,     
    mutations,     
    actions 
}