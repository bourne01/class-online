
/**
 * @function 异步请求出错处理程序
 * @param {异步请求出错对象} err 
 * @param {注册在全局上的router对象} router 
 * @param {注册在Vue.prototype上弹窗方法} message 
 */
export const xhrErrHandler = (err,router,message) => {
    console.log(err);
    if(err.response){
        let status = err.response.status;
        if(status === 401){
            message.error('权限错误,您还没有登录')
            router.push('/login')
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