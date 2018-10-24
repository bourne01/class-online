<template>
    <div>
        <header>
            <span>待审核课程 85</span>
            <span class="more-course">
                查看更多<i class="el-icon-arrow-right"></i>
            </span>
            </header>
        <div class="course-wrap">
            <div class="course" v-for="index in 4" :key="index" v-if="index<=maxCourses">
                <div class="course-cover"></div>
                <!-- <span class="watch-btn">立即查看<i class="el-icon-caret-right"></i></span>
                <label class="video-label" for="" v-if="isOpenCourse">公开课</label>   -->   
                <div class="course-info">  
                    <span class="course-name">中小学生思维导图儿童训练营-暑...</span>        
                    <span>
                        <label class="course-label">任务课</label>
                        <span class="level">小学</span>
                        <span>语文</span>
                    </span>                
                    <span class="teacher">
                        <img :src="require('../../assets/svg/avatar.svg')" alt="" class="avatar">  
                        <span class="span">王小羽</span>
                        <span>4天前</span>                      
                    </span>
                </div>      

            </div>            
        </div>
        
    </div>
</template>

<script>
export default {
    data(){
        return{
            isOpenCourse:true,
            maxCourses:3,//页面最大待批课程显示数量
        }
    },
    methods:{
        /**
         * @function 根据窗口大小，最多显示几门课程
         */
        setMaxCourses(){
            if(document.body.clientWidth < 1560){
                this.maxCourses = 3;
            }else{
                this.maxCourses = 4;
            }
        }
    },
    created(){
        window.onresize = () => {            
            this.setMaxCourses();
        }
    },
    mounted(){
        this.setMaxCourses();
    }
}
</script>

<style scoped>
    .course-wrap{
        display:flex;
        justify-content: space-between;
    }
    header{
        color:#585a60;
        font-size:20px;
        font-weight: 600;
        margin-bottom:20px;
        display: flex;
        justify-content: space-between;
    }
    .course-cover{
        width:270px;
        height:180px;
        background-image:url('http://static.smartisanos.cn/pr/img/video/video_03_cc87ce5bdb.jpg');
        background-size:cover;
        border-radius:5px;
    }
    .more-course{

    }
    .watch-btn{
        padding:5px 10px;
        border-radius: 50px;
        text-align: center;
        position:absolute;
        left:5%;
        bottom:5%;
        background-color:peru;
        color:#fff;
        font-size:14px;
    }
    .video-label{
        padding:5px;
        background-color:rgba(0, 0,0,0.5);
        position:absolute;
        right:5%;
        bottom:5%;
        font-size:14px;
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
        background-color:#f4f4f4;;
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
        background-color:blue;
    }
    .more-course{
        font-size:18px;
        color:#585a60;
        font-weight: normal;
        cursor: pointer;
    }
    .course-name{        
       font-size:14px;
       margin-top:20px;
       margin-bottom:10px;
    }
    .teacher{
        margin-top:10px;
        border-top:1px solid #fff;
    }
    .level{
        margin:0 20px;
    }
</style>

