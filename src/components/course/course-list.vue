<template>
    <div>
        <div class="course-wrap">
            <div class="course" v-for="(course,index) in courseList" :key="index" v-if="!isNull">
                <div class="course-cover" @click="goCourseDetail(course)">
                    <img src="http://static.smartisanos.cn/pr/img/video/video_03_cc87ce5bdb.jpg" alt="">
                </div>
                <div class="course-info">  
                    <span class="course-name">{{course.couTitle}}</span>        
                    <span class="course-type">
                        <label 
                            class="course-label"
                            :style="{background:course.kkType==1?'#22cb64':''}"
                            >{{course.kkType==1?'公开课':'任务课'}}</label>
                        <span>{{course.couGra|convertValueToName(grades)}}</span>
                        <span>{{course.couSub|convertValueToName(subjects)}}</span>
                    </span >
                    <span class="interact">
                        <span>
                            <img :src="require('../../assets/svg/eye.svg')" alt="">
                            <span>{{course.brwNum}}</span>
                        </span>
                        <span>
                            <img :src="require('../../assets/svg/comment.svg')" alt="">
                            <span>{{course.stuNum}}</span>
                        </span>
                        <span>
                            <img :src="require('../../assets/svg/like.svg')" alt="">
                            <span>{{course.likeNum}}</span>
                        </span>
                    </span>
                    <span>
                    </span>                
                    <span class="teacher">
                        <img :src="require('../../assets/svg/avatar.svg')" alt="" class="avatar">  
                        <span class="span">{{course.creName}}</span>
                        <span>{{course.creTime}}</span>                      
                    </span>
                </div>      
            </div>
        </div>
        <div class="no-course" v-if="isNull">暂无课程</div>
        <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            v-if="!isNull"
            :page-size="pageSize"
            @current-change="onCurrentChange">
        </el-pagination>
    </div>
</template>

<script>
import { mapMutations, mapActions, mapState } from 'vuex';
import { getCodeList } from '../../api/base/system';
export default {
    data(){
        return{
            isOpenCourse:true,//课程类型是否为公开课
            isNull:false,//无课程
            screenWidth:window.innerWidth ,//屏幕分辨率宽度
            isTeacher:'',
            isStudent:'',
            isAdmin:'',
            /* course:{
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
            }, *///课程对象
            pageSize:8,
            total:1,
            subjects:[],
            grades:[],
        }
    },
    computed:{
        ...mapState('course',{
            courseList:state => state.courseList
        })
    },
    filters:{
        convertValueToName:function(val,objList){
            for(let item of objList){
                if(item.id == val){
                    return item.name
                }
            }
            return '未知';
        }
    },
    methods:{
        ...mapActions('course',['getCourseList']),
        ...mapMutations('course',['SET_CURRENT_COURSE']),
        /**@function 跳转到课程详情 */
        goCourseDetail(course){
            this['SET_CURRENT_COURSE'](course);
            this.$router.push('/admin-index/course-detail');
        },
        /**
         * @function 监听当前页码变化事件
         * @param {当前页码} val
         */
        onCurrentChange(val){
            this.getCourseList(
                {url:'cou!query.action',
                 params:{
                    start:(val-1)*this.pageSize,
                    limit:this.pageSize}
                }
            )
        },
        /**
         * @function 同步获取下拉列表和课程列表
         */
        getBySync:async function(start=0,limit=this.pageSize){
            /**获取学科列表 */
			await getCodeList({cp:2,rp:1})
                .then(res => {
                    this.subjects = res.data.dataList;
                })
            /**获取级段列表 */
            await getCodeList({cp:5,rp:1})
                .then(res => {
                    this.grades = res.data.dataList;
                })
            let url = 'cou!query.action';
            this.getCourseList({url,params:{start,limit}})
                .then(res => {
                    console.log(res)
                    this.total = res.t;
                })
        }
    },
    created(){
       this.getBySync();
    },
    mounted(){
        //console.log(window.innerWidth || document.documentElement.clientWidth);
    }
}
</script>

<style scoped>
    .course-wrap{
        display:flex;
        justify-content: space-evenly;
        background-color:#f4f4f4;
        width:1364px;
        margin:0 auto;
        padding:40px 0 20px 0;
        flex-flow: wrap;
    }
    .course{
        margin-bottom:20px;
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
        width:312px;
        height:200px;        
        background-size:cover;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }
    .course-cover img{
        width:312px;
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
    .el-pagination{
        text-align:center;
        padding:20px 0;
    }
    .no-course{
        text-align: center;
        font-size:20px;
    }
</style>

