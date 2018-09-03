import { getAdmitStudents,getApplyStudents,getEmulateStudents,getStudents } from '../../../../api/management'
export default {
    getAdmitStudents({commit},params){
        return new Promise((resolve,reject) => {
            console.log(params);
            getAdmitStudents(params)
                .then(res => {
                    commit('SET_MAJOR_STUDENT_LIST',res.data.dataList);
                    resolve(res.data);
                })
                .catch(err => {
                    reject(err);
                })
        })
    },
    getApplyStudents({commit},params){
        return new Promise((resolve,reject) => {
            getApplyStudents(params)
                .then(res => {
                    let data = res.data.dataList
                    /**更改JSON对象属性名 */
                    data = JSON.parse(JSON.stringify(data).replace(/stuName/g,"name"));
                    data = JSON.parse(JSON.stringify(data).replace(/stuSex/g,"sex"));
                    data = JSON.parse(JSON.stringify(data).replace(/stuIdCardNO/g,"idCardNO"));
                    data = JSON.parse(JSON.stringify(data).replace(/stuScore/g,"score"));
                    data = JSON.parse(JSON.stringify(data).replace(/stuHireCode/g,"hireCode"));                    
                    commit('SET_MAJOR_STUDENT_LIST',data);
                    resolve(res.data);
                })
                .catch(err => {
                    reject(err);
                })
        })
    },
    getEmulateStudents({commit},params){
        return new Promise((resolve,reject) => {
            getEmulateStudents(params)
                .then(res => {
                    commit('SET_MAJOR_STUDENT_LIST',res.data.dataList);
                    resolve(res.data);
                })
                .catch(err => {
                    reject(err);
                })
        })
    },
    getStudents({commit},params){
        return new Promise((resolve,reject) => {
            getStudents(params)
                .then(res => {
                    commit('SET_TOTAL',res.data.total)
                    commit('SET_STUDENT_LIST',res.data.dataList);
                    resolve(res.data);
                })
                .catch(err => {
                    reject(err);
                })
        })
    },
        
}