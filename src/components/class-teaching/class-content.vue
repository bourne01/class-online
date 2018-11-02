<template>
    <div class="class-content">
        <el-aside>
            <header>课程章节</header>
            <course-content></course-content>
        </el-aside>
        <el-main>
            <class-teacher></class-teacher>
            <ul>
                <li v-for="idx in 3" :key="idx">
                    <course-class></course-class>
                </li>
            </ul>
            <div style="clear:both"></div>
        </el-main>        

    </div>
</template>

<script>
import CourseContent from '../course/content'
import ClassTeacher from '../course/teachers'
import CourseClass from '../course/course-class'
export default {
    components:{
        CourseContent,
        CourseClass,
        ClassTeacher,
    }
}
</script>

<style scoped>
    .class-content{
        width:100%;
    }
    .class-content .el-aside{
        width:312px!important;
        float: left;
        min-height:600px;
        background-color:#fff;
        padding:0 30px 40px 30px;
        box-sizing: border-box;
    }
    .class-content .el-aside>header{
        height:58px;
        line-height:58px;
        font-size:18px;
        font-family:PingFang-SC-Regular;
        font-weight:bold;
        color:rgba(88,90,96,1);
    }
    .class-content .el-main{
        padding:0;
        width:1014px!important;
        float:right;
    }
    .class-content ul{
        display:flex;
        justify-content: space-between;
        flex-wrap: wrap;
        margin-top:30px;
    }
    .class-content li{
        width:312px;
        margin-bottom:20px;
    }
</style>

