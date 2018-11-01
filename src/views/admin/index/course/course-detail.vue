<template>
    <div class="course-detail">
        <header>
            <span class="back">
                <img src="../../../../assets/svg/previous.svg" alt="">返回
            </span>
            <el-button round class="follow">关注</el-button>
        </header>
        <course-info class="course"></course-info>
        <div class="container">
            <div class="sidebar">
                <course-content></course-content>
            </div>
            <div class="main">
                <course-teacher></course-teacher>
            </div>
            <div style="clear:both"></div>
        </div>
    </div>
</template>

<script>
import CourseInfo from '../../../../components/course/opencourse'
import CourseContent from '../../../../components/course/content'
import CourseTeacher from '../../../../components/course/teachers'
export default {
    components:{
        CourseInfo,
        CourseContent,
        CourseTeacher
    },
}
</script>


<style scoped>
    .course-detail{
        background-color:#f1f1f1;
    }
    .course-detail>header{
        width:1364px;
        margin:0 auto;
        display:flex;
        justify-content: space-between;
        align-items: center;
        height:68px;
        border-bottom:1px solid #f1f1f1;
        background-color:#fff;
    }
    .back img{
        width:20px;
        margin-right:10px;
        vertical-align: middle;
        position: relative;
        top:-2px;
    }
    .back span{
        font-size:18px;
        font-family:'PingFang-SC-Regular';
        color:#585A60;
    }
    .follow{
        height:32px;
        line-height: 32px;
        padding:0;
        width:98px;
        background:linear-gradient(45deg,rgba(250,88,79,1),rgba(252,108,46,1));
        border-radius:16px;
        color:#fff;
    }
    .course{
        width: 1364px;
        margin: 0 auto;
        box-sizing: border-box;
    } 
    .container{
        min-height:600px;
        width: 1364px;
        margin: 0 auto;
        margin-top:40px;
    }
    .sidebar{
        width:312px;
        min-height:600px;
        float:left;
        border-radius:4px;
        background-color:#fff;
    }
    .main{
        min-height:600px;
        width:1014px;
        float:right;
    }   
</style>
