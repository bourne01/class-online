<template>
    <div>
        <!-- 我是收藏夹。。。 -->
        
        <div class="my-category">
            <category></category>
        </div>
        <div class="right">
            <questionbypoint></questionbypoint>
        </div>
        <div class="time">
            <my-time></my-time>
        </div>
    </div>
</template>

<script>
import Questionbypoint from '../../../../components/bank/question-by-point';
import Category from '../../../../components/bank/favorites/category';
import MyTime from '../../../../components/bank/favorites/time';
export default {
    components:{
        Questionbypoint,
        Category,
        MyTime
    },
    
}
</script>
<style scoped>
     .my-category{
         height: 608px;
         background: white;
         float: left;
     }
     .right{
         background: white;
         float: left;
         margin-left: 11px;
         padding-top: 40px;
     }
     .time{
         height: 70px;
         float: left;
         background: white;
         margin-left: 11px;
     }
</style>



