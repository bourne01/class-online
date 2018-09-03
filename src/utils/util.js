/**
 * @function Ajax请求出错处理
 * @param {Ajax错误对象} err 
 * @param {Element 消息提示组件对象} msgbox 
 */
export const xhrErrHandler = (err,msgbox) => {
    console.log(err);
    if(err.response){
        let status = err.response.status;
        console.log(status);
        if(status === 401){
            msgbox('您还没有登录','权限错误',/* {center:true} */)
        }else if(status === 404){
            
        }else if(status === 500 || status === 501){
            console.log('网络异常，稍后重试！')
        }
    }
}

/**
 * @function 判断当前访问来自哪里或谁
 * @param {当前路由地址} path
 * @return {Admin/Teacher/Student} user
 */
export const getCurrentUser = (path) => {
    let user = undefined;
    if(path.indexOf('admin-index') != -1){
        user = 'admin';
    }else if(path.indexOf('teacher-index') != -1){
        user = 'teacher';
    }else if(path.indexOf('student-index') != -1){
        user = 'student';
    }
    return user;
}