<template>
    <div>
        <ul class="course-wrap">
            <li class="course" v-for="index in 1" :key="index" v-if="!isNull">
                <div class="left">
                    <div class="course-cover" @click="goCourseDetail(index)">
                        <img src="http://static.smartisanos.cn/pr/img/video/video_03_cc87ce5bdb.jpg" alt="">
                    </div>
                    <div class="course-info">
                        <div>
                            <div class="course-name">{{course.topic}}</div>        
                            <div class="course-type">
                                <span>{{course.level}}</span>
                                <span>{{course.name}}</span>
                            </div >
                            <div class="course-intro">
                                本课程采用专题的形式，详细阐释和分析了西域美术中独具代表性的原始岩画、古代雕塑、绘画珍品、织物艺术、力美学以及…本课程采用专题的形式，详细阐释和分析了西域美术中独具代表性的原始岩画、古代雕塑、绘画珍品、织物艺术、力美学以及…本课程采用专题的形式，详细阐释和分析了西域美术中独具代表性的原始岩画、古代雕塑、绘画珍品、织物艺术、力美学以及…
                            </div>
                            <div class="course-creator"><label>创建者：</label>张老师</div>
                        </div>  
                        
                        <div class="interact">
                            <span>
                                <img :src="require('../../assets/svg/eye.svg')" alt="">
                                <span>{{course.visitNum}}</span>
                            </span>
                            <span>
                                <img :src="require('../../assets/svg/comment.svg')" alt="">
                                <span>{{course.commentNum}}</span>
                            </span>
                            <span>
                                <img :src="require('../../assets/svg/like.svg')" alt="">
                                <span>{{course.likeNum}}</span>
                            </span>
                        </div>             
                        <!-- <span class="teacher">
                            <img :src="require('../../assets/svg/avatar.svg')" alt="" class="avatar">  
                            <span class="span">{{course.teacher}}</span>
                            <span>{{course.issueTime}}</span>                      
                        </span> -->
                    </div>      
                </div>
                <div class="right">
                    <span class="latest-edition">2小时</span>
                    <div>
                        <span>{{12}}<br><label>章节</label></span>
                        <span>{{12}}<br><label>课堂</label></span>
                        <span>{{12}}<br><label>教师</label></span>
                    </div>
                </div>
                <div style="clear:both"></div>
            </li>
        </ul>
        <div class="no-course" v-if="isNull">暂无课程</div>
        <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            :page-size="pageSize"
            @current-change="onCurrentChange"
            v-if="!isNull">
        </el-pagination>
    </div>
</template>

<script>
export default {
    data(){
        return{
            isOpenCourse:true,//课程类型是否为公开课
            isNull:false,//无课程
            screenWidth:window.innerWidth ,//屏幕分辨率宽度
            isTeacher:'',
            isStudent:'',
            isAdmin:'',
            course:{
                topic:'中小学生思维导图',
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
            total:1,
            pageSize:10,
        }
    },
    computed:{
        n:function(){            
            if(this.screenWidth>=1366 && this.screenWidth<1440){
                return 3    
            }else if(this.screenWidth>=1440 && this.screenWidth<=1920){
                return 5
            }
        }
    },
    methods:{
        /**@function 跳转到课程详情 */
        goCourseDetail(course){
            console.log(course);
            this.$router.push('/admin-index/course-detail');
        },
        /**
         * @function 监听当前页码变化
         * @param {当前页码} pageValue
         */
        onCurrentChange(pageValue){
            console.log(pageValue);
        }
    },
    mounted(){
        //console.log(window.innerWidth || document.documentElement.clientWidth);
    }
}
</script>

<style scoped>
    .course-wrap{
        /* display:flex;
        justify-content: space-between; */
        background-color:#f4f4f4;
        width:1364px;
        margin:0 auto;
        padding:40px 0 20px 0;
        /* flex-flow: wrap; */
    }
    .course{
        padding:20px 0 20px 25px;
        background-color:#fff;
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
        width:450px;
        height:220px;        
        background-size:cover;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
        float:left;
    }
    .course-cover img{
        width:450px;
        height:220px;
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
        justify-content: space-between;
        font-size:12px;        
        float:left;
        margin-left:25px;
        height:220px;
        width:390px;
    }
    .course-info>span{
        /* padding-left:15px; */
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
    .course-intro{
        text-indent:2em;
        margin-top: 10px;
        line-height: 1.5;
        text-overflow: ellipsis;            
        max-height: 70px;
        overflow: hidden;
        color:#ACADB0;
        font-size:12px;
    }
    .course-creator{
        margin-top:10px;
        color:#585A60;
        font-size:12px;
    }
    .course-type span{
        padding:0 15px;
        height:22px;
        line-height: 22px;
        display:inline-block;
        background-color:#f1f1f1;
        margin-right:10px;
    }
    .course>div.right{
        
        text-align: right;
    }
    .latest-edition{
        padding-top:10px;
        padding-right:30px;
    }
    .right>div{
        display: flex;
        justify-content: space-around;
        align-items: center;
        float:right;
        height:200px;
        width:450px;
        position: relative;
        top:-10px;
    }
    .right>div>span{
        width:110px;
        text-align: center;
        display:inline-block;
        line-height:0.8;
        text-overflow: ellipsis;
        color:#171A20;
        font-size:32px;
    }
    .right label{
        font-size:12px;
        color:#585A60;
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
       margin-top:10px;
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
    .el-pagination{
        text-align:center;
        padding:20px 0;
    }
    .no-course{
        text-align: center;
        font-size:20px;
    }
</style>

