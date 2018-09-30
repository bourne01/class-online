<template>
    <div class="student">
        <my-class class="my-class"></my-class>
        <div class="score">
            <div class="score-counting">
                <class-score></class-score>
                <student-score></student-score>
            </div>
            <div class="student-score">
                <ul>
                    <li class="total-student"> 班级人数</li>
                    <li>
                        <student-list v-for="idx in 15" :key="idx" :index=idx></student-list>
                    </li>
                </ul>
                <div class="right">
                    <div class="student-info">
                        <div class="left">
                            <img :src="require('../../../assets/student/avatar.png')" alt="">
                            <div class="student-info-txt">
                                <span>张小丽<img :src="require('../../../assets/student/female.png')" alt=""></span>
                                <span>ID:56464645</span>
                                <span class="contact">
                                    <span>手机号码：1354646464</span>
                                    <span>家长号码：1354646464</span>
                                </span>
                            </div>
                        </div>
                        <div class="right">
                            <el-button>私信</el-button>
                        </div>
                    </div>
                    <div class="student-score-chart">
                        <div>
                            <header>本学期高一(1)班语文平均成绩：<span>88.6</span>分</header>
                            <line-chart-score></line-chart-score>
                        </div>
                        <div>
                            <header>课堂反馈</header>
                            <histogram-chat-feedback></histogram-chat-feedback>
                        </div>
                    </div> 
                </div>
                
            </div>
        </div>
        
    </div>
</template>

<script>
import MyClass from '../../../components/student/my-classes'
import ClassScore from '../../../components/student/class-score'
import StudentScore from '../../../components/student/student-score'
import StudentList from '../../../components/student/student-list'
import HistogramChatFeedback from '../../../components/student/histogram-chart-feedback'
import LineChartScore from '../../../components/student/line-chart-score'
export default {
    components:{
        MyClass,
        ClassScore,
        StudentScore,
        StudentList,
        HistogramChatFeedback,
        LineChartScore
    },
    
}
</script>

<style scoped>
    .student{
        background-color: #f1f1f1;
        padding-bottom: 20px;
    }
    .score{
        margin:0 auto;
        width:1235px;
        margin-top:20px;
    }
    .score-counting{        
        background-color:#fff;
        padding:44px 98px 50px 98px;
        box-sizing: border-box;
    }
    .student-score{
        display:flex;
        background-color:#fff;
        margin-top:10px;
    }
    .student-score>ul{
        max-height:500px;
        overflow-y:auto;
        overflow-x: hidden;
        width:250px;
        box-sizing:border-box;
    }
    .student-score>.right{
        width:100%;
        padding-right:40px;
        padding-left:40px;
        border-left:1px solid #f1f1f1;
    }
    .student-score-chart{
        width:100%;
        display:flex;
        justify-content: space-between;
        
        margin-top:80px;
    }
    .student-info{        
        display:flex;
        justify-content: space-between;
        height:90px;
        line-height:90px;
    }
    .total-student{
        font-family: "PingFang-SC-Bold";
        color:#585a60;
        font-size:20px;
        text-align: center;
        margin-top:30px;
        margin-bottom:40px;
        font-weight: bold;
    }
    .student-info .left{
        display:flex;
        line-height: normal;
    }
    .student-info .left>img{
        line-height: normal;
        height:56px;
        width:56px;
        margin-top:20px;
    }
    .student-info-txt{
        margin-top:30px;
        display: flex;
        flex-direction: column;
        margin-left:10px;
    }
    .contact{
        margin-top:10px;
    }
    .contact>span{
        margin-right:30px;
    }
    .el-button{
        height:32px;
        line-height:32px;
        width:94px;
        padding:0;
        border-radius:16px;
        background-color:#2185ff;
        color:#fff;
    }
    header{
        font-size:16px;
        color:#585a60;
        /* font-family: "PingFang-SC-Bold"; */
        font-weight: bold;        
    }
    header>span{
        font-size:24px;
        color:#fa5b4a;        
    }
</style>


