<template>
    <article>
        <header>
            <span>相关课程</span>
            <router-link to="#" class="more-course">更多<i class="el-icon-arrow-right"></i></router-link>
        </header>
        <ul>
            <li v-for="index in 4" :key="index" v-if="false">
                <img :src="require('../../assets/svg/avatar.svg')" alt="">
                <div class="course-name">中小学生思维导图儿童训练营-暑...</div>        
                <div class="course-type">
                    <label 
                        class="course-label"
                        :style="{background:isOpenCourse?'#22cb64':''}"
                        >{{isOpenCourse?'公开课':'任务课'}}</label>
                    <span>小学</span>
                    <span>语文</span>
                </div >
            </li>
            <li>
                <no-data>暂无相关课程</no-data>
            </li>
        </ul>
    </article>
</template>

<script>
import NoData from '../common/no-data'
export default {
    components:{
        NoData
    },
    
}
</script>

<style scoped>
    article{
        background-color:#ffff;
        padding-left:30px;
        padding-top:30px;
        padding-bottom:30px;
        width:366px;
        border-radius: 3px;
        margin-top:20px;
        min-height:100px;
    }
    header{
        display:flex;
        justify-content: space-between;
        width:310px;
    }
    header>span{
        font-size:20px;
        color:#171a20;
        font-family: 'MicrosoftYaHei';
    }
    .more-course{
        font-size:16px;
        color:#585a60;
        text-decoration: none;
    }
    ul{
        margin-top:30px;
    }    
    li>img{
        width:310px;
        height:200px;
        margin-bottom:20px;
    }  
    li{
        margin-bottom:30px;
    }
    .course-name{
        font-size:16px;
        color:#585a60;
        margin-bottom:10px;
        padding-left:15px;
    }
    .course-type{
        padding-left:15px;
    }
    .course-label{
        width:48px;
        height:22px;
        line-height: 22px;
        display:inline-block;
        color:#fff;
        text-align:center;
        background-color:#366dd1;
        font-size:12px;
    }
    .course-type span{
        padding:0 15px;
        height:22px;
        line-height: 22px;
        display:inline-block;
        background-color:#f1f1f1;
        margin-left:15px;
        font-size:12px;
    }
</style>

