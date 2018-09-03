<template>
    <div>
        <nav>
            <span>关注的人</span>
            <div class="active-bar"></div>
        </nav>
        <div class="teacher" v-for="idx in 4" :key="idx">
            <div class="teacher-info">
                <div class="avatar">
                    <img :src="require('../../../assets/svg/avatar.svg')" alt="">
                </div>            
                <div class="basic-info">
                    <span class="name">王老师</span>
                    <span class="count">
                        <span>课程 &nbsp;22</span>&nbsp;&nbsp;|&nbsp;&nbsp;<span>学生&nbsp;256</span>  
                    </span>                              
                    <span>
                        <label for="">
                                <img :src="require('../../../assets/svg/academic.svg')" alt="">学科：
                        </label>
                        <span>初一数学</span>
                    </span>
                    <span>
                        <label for="">
                                <img :src="require('../../../assets/svg/experience.svg')" alt="">教龄：
                        </label>
                        <span>22年</span>
                    </span>
                    <span>
                        <label for="">
                                <img :src="require('../../../assets/svg/school1.svg')" alt="">学校：
                        </label>
                        <span>瓯海中学</span>
                    </span>
                    <span>
                        <label for="">
                                <img :src="require('../../../assets/svg/title.svg')" alt="">职称：
                        </label>
                        <span>初一数学</span>
                    </span>
                    <button class="btn follow">关注</button>
                </div>
            </div>
            <div class="course-covers">
                <img :src="require('../../../assets/course/course-default.jpg')" alt="">
                <img :src="require('../../../assets/course/course-default.jpg')" alt="">
                <i class="el-icon-more"></i>
            </div>      
        </div>
        
    </div>    
</template>

<script>
export default {
    
}
</script>

<style scoped>
    nav{
        height:78px;
        line-height:78px;
        color:#171a20;
        padding-left:48px;
        font-size:20px;
        background-color:#fff;
        position: relative;
        margin-bottom:20px;
    }
    .active-bar{
        position: absolute;
        height:4px;
        width:4.6em;
        left:41px;
        bottom:0;
        background:linear-gradient(to top,#8b62ff , #0a8dff);
    }
    .teacher{
        display:flex;
        justify-content: space-between;
        background-color:#fff;
        border-bottom:1px solid #f1f1f1;
    }
    .teacher-info{
        padding:30px;        
        display:flex;
        font-size:12px; 
    }
    .basic-info{
        display:flex;
        flex-direction: column;        
    }
    .avatar{
        width:88px;
        height:88px;
        margin-right:18px;
        border-radius:44px;
        border:1px solid #f1f1f1;
    }
    .name{
        color:#171a20;
        font-size:24px;
    }
    .count{
        color:#acadb0;
        font-size:14px;
        line-height: 2em;
    }
    .teacher-info label{
        color:#acadb0;
    }
    .teacher-info label img{
        width:22px;
        height:22px;
        vertical-align: middle;
        position: relative;
        left: -5px;
    }
    .course-covers{
        margin-top:50px;
        display:flex;
        height:154px;
    }
    .course-covers img{
        width:240px;
        height:154px;
        margin-right:10px;
        border-radius:5px;
        cursor: pointer;
    }
    .follow{
        margin-top:20px;
        height:32px;
        line-height:32px;
        width:98px;
        text-align: center;
        border-radius:16px;
        font-size:16px;
        color:#585a60;
        border:1px solid #0a8dff;
        background-color:#fff;
    }
    .followed{
        border:none;
        color:#fff;
        background-color:#fc6934;}
    .el-icon-more{
        align-self: center;
        transform: rotate(90deg);
        font-size:24px;
        color:#fc6934;
        margin-right:10px;
        cursor: pointer;
    }
    
</style>


