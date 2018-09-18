<template>
    <div class="student-error">
        <img src="../../../assets/bank/student-avatar.jpg"/>
        <img src="../../../assets/bank/student-avatar.jpg"/>
        <img src="../../../assets/bank/student-avatar.jpg"/>
        <img src="../../../assets/bank/student-avatar.jpg"/>
        <a href="javaScript:;">更多  ＞</a>
    </div>
</template>

<style scoped>

    .student-error{
        height: 40px;
        width: 812px;
        margin-left: 42px;
    }
    img{
        width: 40px;
        height: 40px;
        border-radius: 50%;
        margin-right: 10px;
        float: left;
    }
    a{
        line-height: 40px;
        font-size: 12px;
        color: #585a60;
        float: right;
        text-decoration: none;
    }
</style>

<script>
import QuestionByPoint from'../../components/bank/question-by-point'


export default {
    components:{
        QuestionByPoint,

    },
    
}
