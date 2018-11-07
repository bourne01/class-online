import http  from 'axios'

const proxyURL = '/p'
const baseURL = proxyURL+'/p'

/***********************************************************************************************
 * 会员信息---来自接口文件"会员信息.java"
 ***********************************************************************************************/

 /**查询VIP信息 */
 export const getVips = (params) => {
    return http(`${baseURL}/mem!query.action`,{params})
 }

 /**新增会员 */
 export const addVip = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/mem!newRec.action`,
        data:require('qs').stringify(params)
    })
 }

 /**编辑VIP信息 */
 export const eidtVip = (params) => {
    return http(`${baseURL}/mem!edit.action`,{params})
 }

 /**改变VIP纪律状态 */
 export const changeVipState = (params) => {
    return http(`${baseURL}/mem!chState.action`,{params})
 }

 /**删除Vip信息 */
 export const deleteVip = (params) => {
    return http(`${baseURL}/mem!del.action`,{params})
 }

 /**上传会员照片 */
 export const uploadVipAvatar = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/mem!upPhoto.action`,
        data:require('qs').stringify(params)
    })
 }

 /**获取会员照片 */
 export const downloadVipAvatar = (params) => {
    return http(`${baseURL}/mem!downPhoto.action`,{params})
 }

 /**重置密码 */
 export const resetVipPassword = (params) => {
    return http(`${baseURL}/mem!resetPsw.action`,{params})
 }

 /***********************************************************************************************
 * 会员文件---来自接口文件"会员文件.java"
 ***********************************************************************************************/

 /**上传文件 */
 export const uploadVipFile = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/memFile!upFile.action`,
        data:require('qs').stringify(params)
    })
 }

 /**下载文件 */
 export const downloadVipFile = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/memFile!downFile.action`,
        data:require('qs').stringify(params)
    })
 }

 /**查询文件 */
 export const getVipFile = (params) => {
    return http(`${baseURL}/memFile!query.action`,{params})
 }

 /**新增文件 */
 export const addVipFile = (params) => {
    return http(`${baseURL}/memFile!newRec.action`,{params})
 }

 /**编辑文件 */
 export const editVipFile = (params) => {
    return http(`${baseURL}/memFile!edit.action`,{params})
 }

 /**删除文件 */
 export const deleteVipFile = (params) => {
    return http(`${baseURL}/memFile!del.action`,{params})
 }

 /****************************************************************************************************
 * 学生空间---来自接口文件"学生空间.java"
 ***************************************************************************************************/

 /**
  * 查询学生空间 1、一般查询接口地址：stu!query.action
  *             2、详细查询接口地址：stu!query2.action
  */
 export const getStudentZone = (url,params) => {
    return http(`${baseURL}/${url}`,{params})
 }
 
 /**新增、申请学生空间 */
 export const addStudentZone = (params) => {
    return http(`${baseURL}/stu!newRec.action`,{params})
 }

 /*修改学生空间 */
 export const editStudentZone = (params) => {
    return http(`${baseURL}/stu!edit.action`,{params})
 }

 /**修改学生空间记录状态 */
 export const changeStudentZoneState = (params) => {
    return http(`${baseURL}/stu!chState.action`,{params})
 }

 /**删除学生空间 */
 export const deleteStudentZone = (params) => {
    return http(`${baseURL}/stu!del.action`,{params})
 }

 /****************************************************************************************************
 * 教师空间---来自接口文件"教师空间.java"
 ***************************************************************************************************/

 /**
  * 查询教师空间 1、一般查询接口地址：thr!query.action
  *             2、详细查询接口地址：thr!query2.action
  */
 export const getTeacherZone = (url,params) => {
    return http(`${baseURL}/${url}`,{params})
 }
 
 /**新增、申请教师空间 */
 export const addTeacherZone = (params) => {
    return http(`${baseURL}/thr!newRec.action`,{params})
 }

 /*修改教师空间 */
 export const editTeacherZone = (params) => {
    return http(`${baseURL}/thr!edit.action`,{params})
 }

 /**修改教师空间记录状态 */
 export const changeTeacherZoneState = (params) => {
    return http(`${baseURL}/thr!chState.action`,{params})
 }

 /**删除教师空间 */
 export const deleteTeacherZone = (params) => {
    return http(`${baseURL}/thr!del.action`,{params})
 }