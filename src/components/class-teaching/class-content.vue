<template>
    <div class="class-content">
        <el-aside>
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

