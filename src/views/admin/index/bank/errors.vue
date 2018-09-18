<template>
    <div class="errors">
        <point></point>
        <div class="bottom">
            <div class="left">
                <p>全部知识点</p>
                <knowledge-point></knowledge-point>
            </div>
            <div class="right" v-for="idx in 3" :key="idx">
                <question-by-point ></question-by-point>
                <div style="height:22px;"></div>
                <student-error></student-error>
            </div>
        </div>
    </div>
</template>

<script>
import MyClasses from '../../../../components/bank/errors/my-classes'
import Point from '../../../../components/bank/errors/point-count'
import StudentError from '../../../../components/bank/errors/student-error'
import QuestionByPoint from'../../../../components/bank/question-by-point'
import knowledgePoint from '../../../../components/bank/knowledge-point'

export default {
    components:{
        MyClasses,
        Point,
        StudentError,
        QuestionByPoint,
        knowledgePoint
    },
    
}
</script>

<style scoped>
    .errors{
        width: 1200px;        
    }
    .left{
        width: 263px;   
        background: white;   
        height: 898px;
         float: left;  
         margin-right: 11px;  
         margin-top: 10px;  
         padding-left: 30px; 
    }
    .left p{
        padding-left: 1px;
        padding-top: 31px;
        font-size: 14px;
        padding-bottom: 36px;
        color: #2185ff;
    }
    .right{        
        width: 896px;  
        background: white;  
         float: left;    
         padding-top: 42px;
         padding-bottom: 28px; 
         margin-top: 10px;      
    }
    .bottom{
        
    }
   
</style>