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
                <ul>
                    <li>
                        <div class="prepare-class">
                            <span>
                                <el-button icon="el-icon-plus" circle=""></el-button>
                                <br>
                                我要备课
                            </span>
                        </div>
                    </li>
                    <li v-for="idx in 3" :key="idx">
                        <course-class></course-class>
                    </li>
                </ul>
                <el-pagination
                    background
                    layout="prev, pager, next"
                    :total="total"
                    :page-size="pageSize"
                    @current-change="onCurrentChange"
                    v-if="!isNull">
                </el-pagination>
            </div>
            <div style="clear:both"></div>
            
        </div>
    </div>
</template>

<script>
import CourseInfo from '../../../../components/course/opencourse'
import CourseContent from '../../../../components/course/content'
import CourseTeacher from '../../../../components/course/teachers'
import CourseClass from '../../../../components/course/course-class'
export default {
    components:{
        CourseInfo,
        CourseContent,
        CourseTeacher,
        CourseClass
    },
    data(){
        return{
            total:100,
            pageSize:10,
            isNull:false
        }
    },
    methods:{
        /**
         * @function 监听当前页码变化
         * @param {当前页码} pageValue
         */
        onCurrentChange(pageValue){
            console.log(pageValue);
        }
    }
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
        margin-top:30px;
    }
    .sidebar{
        width:322px;
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
    .main ul{
        display:flex;
        justify-content: space-between;
        flex-wrap: wrap;
        margin-top:30px;
    }
    .main li{
        width:310px;
        margin-bottom:40px;
        box-sizing: border-box;
        height:365px;
    }
    .prepare-class{
        width:310px;
        height:365px;
        display: flex;
        align-items: center;
        border-radius:4px;
        background-color:#fff;
        justify-content: center;
        box-sizing: border-box;
    }
    .prepare-class .el-button{
        height:98px;
        width:98px;
        font-size:50px;
        color:#fff;
        background-color:#f1f1f1;
        margin-bottom:20px;
    }
    .prepare-class>span{
        display: inline-block;
        line-height:normal;
        font-size:18px;
        font-family:PingFang-SC-Regular;
        font-weight:bold;
        color:#ACADB0;
        text-align: center;
    }
    .main>.el-pagination{
        text-align: center;
        margin-bottom:20px;
        /* background-color:#fff; */
        padding:10px 0;
    }
</style>
