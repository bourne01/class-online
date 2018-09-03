<template>
    <div class="course">
        <div class="course-cover" @click="goCourseDetail(params)"></div>
        <div class="course-info">  
            <span class="course-name">中小学生思维导图儿童训练营-暑...</span>        
            <span class="course-type">
                <label 
                    class="course-label"
                    :style="{background:isOpenCourse?'#22cb64':''}"
                    >{{isOpenCourse?'公开课':'任务课'}}</label>
                <span>小学</span>
                <span>语文</span>
            </span >
            <span class="interact">
                <span>
                    <img :src="require('../../assets/svg/eye.svg')" alt="">
                    <span>3564</span>
                </span>
                <span>
                    <img :src="require('../../assets/svg/comment.svg')" alt="">
                    <span>64</span>
                </span>
                <span>
                    <img :src="require('../../assets/svg/like.svg')" alt="">
                    <span>364</span>
                </span>
            </span>
            <span>
            </span>                
            <span class="teacher">
                <img :src="require('../../assets/svg/avatar.svg')" alt="" class="avatar">  
                <span class="span">王小羽</span>
                <span>4天前</span>                      
            </span>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            isOpenCourse:true,//课程类型是否为公开课
        }
    },
    methods:{
        /**@function 跳转到课程详情 */
        goCourseDetail(course){
            this.$router.push('/course/course-detail');
        }
    },
    mounted(){
    }
}
</script>

<style scoped>
    .course-wrap{
        display:flex;
        justify-content: space-between;
        background-color:#f4f4f4;
        width:1364px;
        margin:0 auto;
        padding:40px 0 20px 0;
    }    
    .course-cover{
        width:312px;
        height:200px;
        background-image:url('http://static.smartisanos.cn/pr/img/video/video_03_cc87ce5bdb.jpg');
        background-size:cover;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }
    .avatar{
        width:32px;
        height:32px;
        border-radius:20px;        
        background-color:#f4f4f4;
        vertical-align:middle;
        margin-right:5px;        
    }
    .course-info{
        display:flex;
        flex-direction: column;
        font-size:12px;        
        background-color:#fff;;
    }
    .course-info>span{
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
    }
    .course-type span{
        padding:0 15px;
        height:22px;
        line-height: 22px;
        display:inline-block;
        background-color:#f1f1f1;
        margin-left:15px;
    }
    .interact{
        margin-top:15px;
    }
    .interact img{
        width:22px;
        height:22px;
        vertical-align: middle;
    }
    .interact span{
        display:inline-block;
        height:22px;
        line-height: 22px;
        color:#ccc;
    }
    .course-name{        
       font-size:14px;
       margin-top:20px;
       margin-bottom:10px;
    }
    .teacher{
        margin-top:10px;
        padding:5px 0;
        border-top:1px solid #f4f4f4;
    }
    .level{
        margin:0 20px;
    }
    .no-course{
        text-align: center;
        font-size:20px;
    }
</style>

