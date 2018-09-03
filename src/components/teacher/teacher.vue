<template>
    <div class="teacher">
        <div class="teacher-info">
            <img class="avatar" :src="require('../../assets/svg/avatar.svg')" alt="">
            <div>
                <div class="name">王老师</div>
                <div class="count"><span>课程&nbsp;22</span>|<span>学生&nbsp;256</span></div>
                <el-row>
                    <el-col :span="12">
                        <label for="">
                            <img :src="require('../../assets/svg/academic.svg')" alt="">学科：
                        </label>
                        <span>初一数学</span>
                    </el-col>
                    <el-col :span="12">
                        <label for="">
                            <img :src="require('../../assets/svg/experience.svg')" alt="">教龄：
                        </label>
                        <span>22年</span>
                    </el-col>
                    <el-col :span="12">
                        <label for="">
                            <img :src="require('../../assets/svg/school1.svg')" alt="">学校：
                        </label>
                        <span>瓯海中学</span>
                    </el-col>
                    <el-col :span="12">
                        <label for="">
                            <img :src="require('../../assets/svg/title.svg')" alt="">职称：
                        </label>
                        <span>初一数学</span>
                    </el-col>
                </el-row>
                <div class="follow" 
                    @click="isFollowed=!isFollowed" 
                    :class="{followed:isFollowed}">关注</div>
            </div>
        </div>
        <div class="course-covers">
            <img :src="require('../../assets/svg/course.svg')" alt="">
            <img :src="require('../../assets/svg/course.svg')" alt="">
            <img :src="require('../../assets/svg/course.svg')" alt="">
            <i class="el-icon-more"></i>
        </div>
        
    </div>
</template>

<script>
export default {
    data(){
        return{
            isFollowed:false,
        }
    }
}
</script>

<style scoped>
    .teacher{
        width:1364px;
        height:216px;
        margin:0 auto;
        display:flex;
        justify-content: space-between;
        background-color:#fff;
        padding-left:30px;
        padding-top:40px;
        border-bottom:1px solid #f1f1f1;
    }
    .teacher-info{
        display:flex;
        font-size:12px;
    }
    .avatar{
        width:88px;
        height:88px;
        margin-right:18px;
    }
    .name{
        color:#171a20;
        font-size:24px;
        margin-bottom:14px;
    }
    .count{
        color:#585a20;
        font-size:16px;
        margin-bottom:18px;
    }
    .el-col{
        line-height:1.5em;
    }
    label{
        color:#acadb0;
    }
    label img{
        width:22px;
        height:22px;
        vertical-align: middle;
    }
    .el-col span{
        color:#585a60;
    }
    .course-covers{
        display:flex;
        height:154px;
    }
    .course-covers img{
        width:240px;
        height:154px;
        margin-right:10px;
        border:1px solid #f84412;
        border-radius:5px;
    }
    .follow{
        margin-top:34px;
        height:32px;
        line-height:32px;
        width:98px;
        text-align: center;
        border-radius:16px;
        font-size:16px;
        color:#585a60;
        border:1px solid #0a8dff;
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
    }
</style>
