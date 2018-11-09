import http  from 'axios'

const proxyURL = '/p'
const baseURL = proxyURL+'/p'

/***********************************************************************************************
 * 课程---来自接口文件"课程.java"
 ***********************************************************************************************/

 /**
  * 查询课程
  * url:1、普通查询--- cou!query.action
  *     2、详细查询--- cou!query2.action
  */
 export const getCourses = (url,params) => {
    return http(`${baseURL}/${url}`,{params})
 }

 /**
  * 获取课程简介
  */
 export const getCourseBrief = (params) => {
     return http(`${baseURL}/cou!getBrief.action`,{params})
 }

 /**新增课程 */
 export const addCourse = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/cou!newRec.action`,
        data:params
    })
 }

 /**编辑课程 */
 export const editCourse = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/cou!edit.action`,
        data:params
    })
 }

 /**改变课程记录状态 */
 export const changeCourseState = (params) => {
    return http(`${baseURL}/cou!chState.action`,{params})
 }

 /**删除课程 */
 export const deleteCourse = (params) => {
    return http(`${baseURL}/cou!del.action`,{params})
 }

 /**上传课程封面 */
 export const uploadCourseCover = (params) => {
    return http({
        method:'post',
        url:`${baseURL}/cou!upImage.action`,
        data:params
    })
 }

 /**获取课程封面 */
 export const downloadVipAvatar = (params) => {
    return http(`${baseURL}/cou!downImage.action`,{params})
 }

 /***********************************************************************************************
 * 学识信息(课程考纲)---来自接口文件"学识信息.java"
 ***********************************************************************************************/

 /**查询学识信息 */
 export const getCourseSyllabus = (params) => {
    return http(`${baseURL}/learn!query.action`,{params})
 }

 /**
  * 获取课程简介
  */
 export const getCourseSyllabusBrief = (params) => {
    return http(`${baseURL}/learn!getBrief.action`,{params})
}

 /**新增学识信息 */
 export const addCourseSyllabus = (params) => {
    return http(`${baseURL}/learn!newRec.action`,{params})
 }

 /**编辑学识信息 */
 export const editCourseSyllabus = (params) => {
    return http(`${baseURL}/learn!edit.action`,{params})
 }

 /**修改教材信息记录状态 */
 export const changeCourseSyllabusState = (params) => {
    return http(`${baseURL}/learn!chState.action`,{params})
 }

 /**删除学识信息 */
 export const deleteCourseSyllabus = (params) => {
    return http(`${baseURL}/learn!del.action`,{params})
 }

 /****************************************************************************************************
 * 教材信息---来自接口文件"教材信息.java"
 ***************************************************************************************************/

 /**
  * 查询教材信息 
  */
 export const getTextbooks = (params) => {
    return http(`${baseURL}/tbk!query.action`,{params})
 }
 
 /**新增教材信息 */
 export const addTextbook = (params) => {
    return http(`${baseURL}/tbk!newRec.action`,{params})
 }

 /*修改教材信息 */
 export const editTextbook = (params) => {
    return http(`${baseURL}/tbk!edit.action`,{params})
 }

 /**修改教材信息记录状态 */
 export const changeTextbookState = (params) => {
    return http(`${baseURL}/tbk!chState.action`,{params})
 }

 /**删除教材信息 */
 export const deleteTextbook = (params) => {
    return http(`${baseURL}/tbk!del.action`,{params})
 }

 /****************************************************************************************************
 * 教材目录---来自接口文件"教材目录.java"
 ***************************************************************************************************/

 /**
  * 查询教材目录 
  */
 export const getTextbookContents = (params) => {
    return http(`${baseURL}/tbkSec!query.action`,{params})
 }
 
 /**新增教材目录 */
 export const addTextbookContent = (params) => {
    return http(`${baseURL}/tbkSec!newRec.action`,{params})
 }

 /*修改教材目录 */
 export const editTextbookContent = (params) => {
    return http(`${baseURL}/tbkSec!edit.action`,{params})
 }

 /**修改教材目录记录状态 */
 export const changeTextbookContentState = (params) => {
    return http(`${baseURL}/tbkSec!chState.action`,{params})
 }

 /**删除教材目录 */
 export const deleteTextbookContent = (params) => {
    return http(`${baseURL}/tbkSec!del.action`,{params})
 }
 
 /****************************************************************************************************
 * 知识点---来自接口文件"知识点.java"
 ***************************************************************************************************/

 /**
  * 查询知识点 
  */
 export const getKnowledgePoints = (params) => {
    return http(`${baseURL}/know!query.action`,{params})
 }
 
 /**新增知识点 */
 export const addKnowledgePoint = (params) => {
    return http(`${baseURL}/know!newRec.action`,{params})
 }

 /*修改知识点 */
 export const editKnowledgePoint = (params) => {
    return http(`${baseURL}/know!edit.action`,{params})
 }

 /**修改知识点记录状态 */
 export const changeKnowledgePointtState = (params) => {
    return http(`${baseURL}/know!chState.action`,{params})
 }

 /**删除知识点 */
 export const deleteKnowledgePoint = (params) => {
    return http(`${baseURL}/know!del.action`,{params})
 }

 /****************************************************************************************************
 * 课程资源---来自接口文件"课程资源.java"
 ***************************************************************************************************/

 /**
  * 查询课程资源 
  */
 export const getCourseResourse = (params) => {
    return http(`${baseURL}/know!query.action}`,{params})
 }
 
 /**新增课程资源 */
 export const addCourseResourse = (params) => {
    return http(`${baseURL}/know!newRec.action`,{params})
 }

 /*修改课程资源 */
 export const editCourseResourse = (params) => {
    return http(`${baseURL}/know!edit.action`,{params})
 }

 /**修改课程资源记录状态 */
 export const changeCourseResourseState = (params) => {
    return http(`${baseURL}/know!chState.action`,{params})
 }

 /**删除课程资源 */
 export const deleteCourseResourse = (params) => {
    return http(`${baseURL}/know!del.action`,{params})
 }
 
 /****************************************************************************************************
 * 课程目录---来自接口文件"课程目录.java"
 ***************************************************************************************************/

 /**
  * 查询课程目录 1、couSec!query.action
  *             2、couSec!query2.action
  */
 export const getCourseContents = (url,params) => {
    return http(`${baseURL}/${url}`,{params})
 }
 
 /**新增课程目录 */
 export const addCourseContent = (params) => {
    return http(`${baseURL}/couSec!newRec.action`,{params})
 }

 /*修改课程目录 */
 export const editCourseContent = (params) => {
    return http(`${baseURL}/couSec!edit.action`,{params})
 }

 /**修改课程目录记录状态 */
 export const changeCourseContentState = (params) => {
    return http(`${baseURL}/couSec!chState.action`,{params})
 }

 /**删除课程目录 */
 export const deleteCourseContent = (params) => {
    return http(`${baseURL}/couSec!del.action`,{params})
 }