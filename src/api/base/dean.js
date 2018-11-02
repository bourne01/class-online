import http from 'axios'

const proxyURL = '/p'
const baseURL = proxyURL+'/p'

/****************************************************************************************************
 * 作息时间表---来自接口文件"作息时间标.java"
 ***************************************************************************************************/

 /**查询作息时间表 */
 export const getTimeTable = (params) => {
    return http(`${baseURL}/timeTab!query.action`,{params})
 }
 
 /**新增作息时间表 */
 export const addTimeTable = (params) => {
    return http(`${baseURL}/timeTab!newRec.action`,{params})
 }

 /*修改作息时间表 */
 export const editTimeTable = (params) => {
    return http(`${baseURL}/timeTab!edit.action`,{params})
 }

 /**修改作息时间表记录状态 */
 export const changeTimeTableState = (params) => {
    return http(`${baseURL}/timeTab!chState.action`,{params})
 }

 /**删除作息时间表 */
 export const deleteTimeTable = (params) => {
    return http(`${baseURL}/timeTab!del.action`,{params})
 }

/****************************************************************************************************
 * 入学年级---来自接口文件"入学年级.java"
 ***************************************************************************************************/

 /**查询入学年级 */
 export const getEnrollGrade = (params) => {
    return http(`${baseURL}/jye!query.action`,{params})
 }
 
 /**新增入学年级 */
 export const addEnrollGrade = (params) => {
    return http(`${baseURL}/jye!newRec.action`,{params})
 }

 /*修改入学年级 */
 export const editEnrollGrade = (params) => {
    return http(`${baseURL}/jye!edit.action`,{params})
 }

 /**修改入学年级记录状态 */
 export const changeEnrollGradeState = (params) => {
    return http(`${baseURL}/jye!chState.action`,{params})
 }

 /**删除入学年级 */
 export const deleteEnrollGrade = (params) => {
    return http(`${baseURL}/jye!del.action`,{params})
 }

/****************************************************************************************************
 * 学期信息---来自接口文件"学期信息.java"
 ***************************************************************************************************/

 /**查询学期信息 */
 export const getTerm = (params) => {
    return http(`${baseURL}/term!query.action`,{params})
 }
 
 /**新增学期信息 */
 export const addTerm = (params) => {
    return http(`${baseURL}/term!newRec.action`,{params})
 }

 /*修改学期信息 */
 export const editTerm = (params) => {
    return http(`${baseURL}/term!edit.action`,{params})
 }

 /**修改学期信息记录状态 */
 export const changeTermState = (params) => {
    return http(`${baseURL}/term!chState.action`,{params})
 }

 /**删除学期信息 */
 export const deleteTerm = (params) => {
    return http(`${baseURL}/term!del.action`,{params})
 }

/****************************************************************************************************
 * 小组信息---来自接口文件"小组信息.java"
 ***************************************************************************************************/

 /**查询小组信息 */
 export const getTeam = (params) => {
    return http(`${baseURL}/team!query.action`,{params})
 }
 
 /**新增小组信息 */
 export const addTeam = (params) => {
    return http(`${baseURL}/team!newRec.action`,{params})
 }

 /*修改小组信息 */
 export const editTeam = (params) => {
    return http(`${baseURL}/team!edit.action`,{params})
 }

 /**修改小组信息记录状态 */
 export const changeTeamState = (params) => {
    return http(`${baseURL}/team!chState.action`,{params})
 }

 /**删除小组信息 */
 export const deleteTeam = (params) => {
    return http(`${baseURL}/team!del.action`,{params})
 }

/****************************************************************************************************
 * 教学场地---来自接口文件"教学场地.java"
 ***************************************************************************************************/

 /**查询教学场地 */
 export const getTeachSite = (params) => {
    return http(`${baseURL}/rom!query.action`,{params})
 }
 
 /**新增教学场地 */
 export const addTeachSite = (params) => {
    return http(`${baseURL}/rom!newRec.action`,{params})
 }

 /*修改教学场地 */
 export const editTeachSite = (params) => {
    return http(`${baseURL}/rom!edit.action`,{params})
 }

 /**修改教学场地记录状态 */
 export const changeTeachSiteState = (params) => {
    return http(`${baseURL}/rom!chState.action`,{params})
 }

 /**删除教学场地 */
 export const deleteTeachSite = (params) => {
    return http(`${baseURL}/rom!del.action`,{params})
 }

/****************************************************************************************************
 * 校区学生---来自接口文件"校区学生.java"
 ***************************************************************************************************/

 /**查询校区学生 */
 export const getCampusStudent = (params) => {
    return http(`${baseURL}/schStu!query.action`,{params})
 }
 
 /**新增校区学生 */
 export const addCampusStudent = (params) => {
    return http(`${baseURL}/schStu!newRec.action`,{params})
 }

 /*修改校区学生 */
 export const editCampusStudent = (params) => {
    return http(`${baseURL}/schStu!edit.action`,{params})
 }

 /**修改校区学生记录状态 */
 export const changeCampusStudentState = (params) => {
    return http(`${baseURL}/schStu!chState.action`,{params})
 }

 /**删除校区学生 */
 export const deleteCampusStudent = (params) => {
    return http(`${baseURL}/schStu!del.action`,{params})
 }

/****************************************************************************************************
 * 班级信息---来自接口文件"班级信息.java"
 ***************************************************************************************************/

 /**查询班级信息 */
 export const getClass = (params) => {
    return http(`${baseURL}/cla!query.action`,{params})
 }
 
 /**新增班级信息 */
 export const addClass = (params) => {
    return http(`${baseURL}/cla!newRec.action`,{params})
 }

 /*修改班级信息 */
 export const editClass = (params) => {
    return http(`${baseURL}/cla!edit.action`,{params})
 }

 /**修改班级信息记录状态 */
 export const changeClassState = (params) => {
    return http(`${baseURL}/cla!chState.action`,{params})
 }

 /**删除班级信息 */
 export const deleteClass = (params) => {
    return http(`${baseURL}/cla!del.action`,{params})
 }

/****************************************************************************************************
 * 班级学生---来自接口文件"班级学生.java"
 ***************************************************************************************************/

 /**查询班级学生 */
 export const getClassStudent = (params) => {
    return http(`${baseURL}/claStu!query.action`,{params})
 }
 
 /**
  * 新增班级学生:1、添加单个学生，接口地址：claStu!newRec.action
  *             2、批量添加学生，接口地址：claStu!batSave.action
  */
 export const addClassStudent = (url,params) => {
    return http(`${baseURL}/${url}`,{params})
 }

 /*修改班级学生 */
 export const editClassStudent = (params) => {
    return http(`${baseURL}/claStu!edit.action`,{params})
 }

 /**修改班级学生记录状态 */
 export const changeClassStudentState = (params) => {
    return http(`${baseURL}/claStu!chState.action`,{params})
 }

 /**删除班级学生 */
 export const deleteClassStudent = (params) => {
    return http(`${baseURL}/claStu!del.action`,{params})
 }
 
/****************************************************************************************************
 * 部门信息---来自接口文件"部门信息.java"
 ***************************************************************************************************/

 /**查询班级信息 */
 export const getDepartment = (params) => {
    return http(`${baseURL}/dep!query.action`,{params})
 }
 
 /**新增班级信息 */
 export const addDepartment = (params) => {
    return http(`${baseURL}/dep!newRec.action`,{params})
 }

 /*修改班级信息 */
 export const editDepartment = (params) => {
    return http(`${baseURL}/dep!edit.action`,{params})
 }

 /**修改班级信息记录状态 */
 export const changeDepartmentState = (params) => {
    return http(`${baseURL}/dep!chState.action`,{params})
 }

 /**删除班级信息 */
 export const deleteDepartment = (params) => {
    return http(`${baseURL}/dep!del.action`,{params})
 }
 
/****************************************************************************************************
 * 部门成员---来自接口文件"部门成员.java"
 ***************************************************************************************************/

 /**查询部门成员 */
 export const getDepartmentMember = (params) => {
    return http(`${baseURL}/dep!query.action`,{params})
 }
 
 /**
 * 新增部门成员:1、添加单个部门成员，接口地址：depMem!newRec.action
 *             1、添加单个部门成员，接口地址：depMem!batSave.action
 */
export const addDepartmentMembert = (url,params) => {
   return http(`${baseURL}/${url}`,{params})
}

 /*修改部门成员 */
 export const editDepartmentMember = (params) => {
    return http(`${baseURL}/dep!edit.action`,{params})
 }

 /**修改部门成员记录状态 */
 export const changeDepartmentMemberState = (params) => {
    return http(`${baseURL}/dep!chState.action`,{params})
 }

 /**删除部门成员 */
 export const deleteDepartmentMember = (params) => {
    return http(`${baseURL}/dep!del.action`,{params})
 }