import http  from 'axios'

const proxyURL = '/p'
const baseURL = proxyURL+'/p'
/***********************************************************************************
 * 下拉列表
 ***********************************************************************************/
/**
 * 学部下拉列表
 */
export const getSelector = (params) => {
    return http(`${baseURL}/baseWebDat`,{params})
} 
/***********************************************************************************
 * 学部管理
 ***********************************************************************************/
/**
 * @function 查询学部
 */
export const getDepartmentList = (params) => {
    return http(`${baseURL}/dep!query.action`,{params});
}
 /** @function 新增学部
 */
export const addDepartment = (params) => {
    return http(`${baseURL}/dep!newRec.action`,{params});
}
/**
 * @function 编辑学部(包含更改学部状态)
 */
export const editDepartment = (params) => {
    return http(`${baseURL}/dep!edit.action`,{params});
}
/**
 * @function 删除学部
 */
export const delDepartment = (params) => {
    return http(`${baseURL}/dep!del.action`,{params});
}
/***********************************************************************************
 * 招生专业设置
 ***********************************************************************************/
/**
 * @function 查询专业设置
 */
export const getMajors = (url,params) => {
    return http(`${baseURL}/${url}`,{params});
}
/**
 * @function 新增专业设置
 */
export const addMajor = (params) => {
    return http(`${baseURL}/maj!newRec.action`,{params});
}
/**
 * @function 编辑专业设置(包含更改专业状态)
 */
export const editMajor = (params) => {
    return http(`${baseURL}/maj!edit.action`,{params});
}
/**
 * @function 删除专业设置
 */
export const delMajors = (params) => {
    return http(`${baseURL}/maj!del.action`,{params});
}
/**
 * @function 按比例设置拟录人数
 */
export const setAdmitStudents = (params) => {
    return http(`${baseURL}/maj!ratioStu.action`,{params})
}
/***********************************************************************************
 * 报名时间设置
 ***********************************************************************************/
/**
 * @function 查询报名时间
 */
export const getEnrollTime = (params) => {
    return http(`${baseURL}/signSet!query.action`,{params});
}
/**
 * @function 编辑报名设置（包含修改任务状态）
 */
export const editEnrollTime = (params) => {
    return http(`${baseURL}/signSet!edit.action`,{params});
}
/**
 * @function 清除报名生的“录取失败”状态
 */
export const clearFailedAdmissionState = (params) => {
    return http(`${baseURL}/signSet!clearFailState.action`,{params});
}
