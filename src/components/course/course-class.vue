<template>
    <div class="course-class">
        <div class="course-class-cover" @click="goCourseDetail()">
            <img src="http://static.smartisanos.cn/pr/img/video/video_03_cc87ce5bdb.jpg" alt="">
        </div>
        <div class="course-class-info">  
            <span class="course-class-name">{{lesson.topic}}</span>
            <span class="course-class-label">
                <label for="">小学</label>
                <label for="">语文</label>
            </span>       
            <span class="interact" v-if="isClassBegin">
                <span>
                    <img :src="require('../../assets/svg/eye.svg')" alt="">
                    <span>{{lesson.visitNum}}</span>
                </span>
                <span>
                    <img :src="require('../../assets/svg/comment.svg')" alt="">
                    <span>{{lesson.commentNum}}</span>
                </span>
                <span>
                    <img :src="require('../../assets/svg/like.svg')" alt="">
                    <span>{{lesson.likeNum}}</span>
                </span>
            </span>
            <span class="interact begin-time" v-else>
                开课时间：{{'2018-12-18 08:30'}}
            </span>
            <span class="teacher" v-if="isMyClass">
                <span>
                    <el-button type="text">编辑</el-button>
                    <el-button type="text">删除</el-button>
                </span>
                <span class="lastest-edition">{{'4前天'}}</span>
            </span>                
            <span class="teacher" v-else>
                <span>
                    <img :src="require('../../assets/svg/avatar.svg')" alt="" class="avatar">  
                    <span class="span">{{lesson.teacher}}</span>    
                </span>                
                <span>{{lesson.issueTime}}</span>                      
            </span>
        </div>      
    </div>        
</template>

<script>
import { mapMutations } from 'vuex'
export default {
    props:[''],
    data(){
        return{
            isOpenCourse:true,//课程类型是否为公开课
            isNull:false,//无课程
            isTeacher:'',
            isStudent:'',
            isAdmin:'',
            isClassBegin:false,//是否已经开课
            isMyClass:false,//是否是我的课
            lesson:{
                topic:'中小学生思维导图中小学生思维导图中小学生思维导图',
                level:'小学',
                name:'语文',
                isOpenCourse:false,
                visitNum:2544,
                commentNum:736,
                likeNum:555,
                avatar:'ulr',
                teacher:'王小羽',
                issueTime:'4天前',
                cover:'url'
            },//课程对象
        }
    },

    methods:{
        ...mapMutations('course',['SET_CURRENT_CLASS']),
        /**@function 跳转到课程详情 */
        goCourseDetail(){
            this['SET_CURRENT_CLASS'](this.lesson);
            let curRouterName = this.$router.history.current.name;
            if(curRouterName === 'ClassContent'){
                this.$root.bus.$emit('play-lesson',this.lesson)
            }else{
                this.$router.push('/admin-index/class-teaching');
            }
        }
    },
    mounted(){
        //console.log(window.innerWidth || document.documentElement.clientWidth);
    }
}
</script>

<style scoped>
    .course-class{
        margin-bottom:20px;
    }
    .course-class-cover{
        width:310px;
        height:200px;        
        background-size:cover;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }
    .course-class-cover img{
        width:310px;
        height:200px;
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
    .course-class-info{
        display:flex;
        flex-direction: column;
        font-size:12px;        
        background-color:#fff;
        height:165px;
        box-sizing: border-box;
    }
    .course-class-info>span{
        padding-left:15px;
    }
    .course-class-label>label{
        padding:0 15px;
        height:22px;
        line-height: 22px;
        display:inline-block;
        text-align:center;
        font-size:12px;
        font-family:SimSun;
        font-weight:400;
        color:rgba(88,90,96,1);
        background:rgba(244,244,244,1);
        margin-right:10px;
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
    .course-class-name{        
       font-size:14px;
       margin-top:20px;
       margin-bottom:10px;
       line-height:1.2;
    }
    .teacher{
        margin-top:10px;
        padding:15px 0;
        border-top:1px solid #f4f4f4;
        display:flex;
        justify-content: space-between;
        align-items: center;
        padding-right:15px;
    }
    .teacher .el-button{
        font-size:12px;
        font-family:SimSun;
        font-weight:400;
        color:rgba(172,173,176,1);
    }
    .level{
        margin:0 20px;
    }
    .el-pagination{
        text-align:center;
        padding:20px 0;
    }
    .no-course-class{
        text-align: center;
        font-size:20px;
    }
</style>

