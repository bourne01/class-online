import http from 'axios'

const proxyURL = '/p';
const baseURL = proxyURL+'/p'

/************************************************************************************************
 * 编码信息---来自接口文件"列表数据.java"
 ************************************************************************************************/

 /**获取各种字典编码信息列表 */
 export const getCodeList = (params) => {
     return http(`${baseURL}/webDat!codeList.action`,{params});
 }

 /**获取学期列表 */
 export const getTermList = (params) => {
     return http(`${baseURL}/webDat!termList.action`,{params});
 }

/************************************************************************************************
 * 文件信息 ---来自接口文件"文件信息.java"
 ************************************************************************************************/

 /**获取文件信息  */
 export const getFileInfo = (params) => {
     return http(`${baseURL}/fileInf!query.action`,{params});
 }

 /**新增文件信息 */
 export const addFileInfo = (params) => {
     return http(`${baseURL}/fileInf!newRec.action`,{params});
 }

 /**修改文件信息  */
 export const editFileInfo = (params) => {
     return http(`${baseURL}/fileInf!edit.action`,{params});
 }

 /**删除文件信息 */
 export const deleteFileInfo = (params) => {
     return http(`${baseURL}/fileInf!del.action`,{params});
 }

/************************************************************************************************
 * 权限定义 ---来自接口文件"权限定义.java"
 ************************************************************************************************/

 /**获取权限信息  */
 export const getPermission = (params) => {
     return http(`${baseURL}/pow!query.action`,{params});
 }

 /**新增文件信息 */
 export const addPermission = (params) => {
     return http(`${baseURL}/pow!newRec.action`,{params});
 }

 /**修改文件信息  */
 export const editPermission = (params) => {
     return http(`${baseURL}/pow!edit.action`,{params});
 }

 /**删除文件信息 */
 export const deletePermission = (params) => {
     return http(`${baseURL}/pow!del.action`,{params});
 }

/************************************************************************************************
 * 用户登录 ---来自接口文件"用户登录.java"
 ************************************************************************************************/

 /**用户登录  */
 /* export const login = (params) => {
     return http({
         method:'post',
         url:`${baseURL}/login.action`,
         data:require('qs').stringify(params)
     })
 } */
 export const login = (params) => {
     return http(`${baseURL}/login.action`,{params})
 }

 /**获取我的信息 */
 export const getMyInfo = (params) => {
     return http(`${baseURL}/login!myInf.action`,{params});
 }

 /**注销当前登录  */
 export const logout = (params) => {
     return http(`${baseURL}/login!logout.action`,{params});
 }

/************************************************************************************************
 * 用户组 ---来自接口文件"用户组.java"
 ************************************************************************************************/

 /**获取用户组 */
 export const getUserGroup = (params) => {
     return http(`${baseURL}/usg!query.action`,{params});
 }

 /**新增用户组  */
 export const addUserGroup = (params) => {
     return http(`${baseURL}/usg!newRec.action`,{params});
 }

 /**修改用户组 */
 export const editUserGroup = (params) => {
     return http(`${baseURL}/usg!edit.action`,{params});
 }

 /**删除用户组  */
 export const deleteUserGroup = (params) => {
     return http(`${baseURL}/usg!del.action`,{params});
 }

/************************************************************************************************
 * 用户组权限 ---来自接口文件"用户组权限.java"
 ************************************************************************************************/

 /**获取用户组权限 */
 export const getUserGroupPermission = (params) => {
     return http(`${baseURL}/usgPow!query.action`,{params});
 }

 /**新增用户组权限  */
 export const addUserGroupPermission = (params) => {
     return http(`${baseURL}/usgPow!newRec.action`,{params});
 }

 /**修改用户组权限 */
 export const editUserGroupPermission = (params) => {
     return http(`${baseURL}/usgPow!edit.action`,{params});
 }

 /**删除用户组权限  */
 export const deleteUserGroupPermission = (params) => {
     return http(`${baseURL}/usgPow!del.action`,{params});
 }

/************************************************************************************************
 * 系统任务 ---来自接口文件"系统任务.java"
 ************************************************************************************************/

 /**获取系统任务 */
 export const getSystemTask = (params) => {
     return http(`${baseURL}/task!query.action`,{params});
 }

 /**新增系统任务  */
 export const addSystemTask = (params) => {
     return http(`${baseURL}/task!newRec.action`,{params});
 }

 /**修改系统任务 */
 export const editSystemTask = (params) => {
     return http(`${baseURL}/task!edit.action`,{params});
 }

 /**修改系统任务记录状态 */
 export const changeSystemTaskState = (params) => {
     return http(`${baseURL}/task!chState.action`,{params});
 }

 /**删除系统任务  */
 export const deleteSystemTask = (params) => {
     return http(`${baseURL}/task!del.action`,{params});
 }

 /************************************************************************************************
 * 系统配置信息 ---来自接口文件"配置信息.java"
 ************************************************************************************************/

 /**查询配置信息 */
 export const getSystemSettings = (params) => {
    return http(`${baseURL}/conf!query.action`,{params});
}

/**获取时间戳  */
export const getTimeStamp = (params) => {
    return http(`${baseURL}/conf!getTs.action`,{params});
}