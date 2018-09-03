<template>
    <div class="home">
        <el-header>Header</el-header>    
            <el-container>                    
                <el-aside>
                    <ul class="nav-bar">
                        <li class="nav-bar-item" >Logo</li>
                        <li class="nav-bar-item" 
                            :class="{active:actNav===0}"
                            :style="{background:clickNav===0?'#000':''}" 
                            @click="clickNav=0"
                            @mouseover="actNav=0"
                            @mouseout="actNav=-1">
                            <img :src="actNav===0?navActIcons[0]:navIcons[0]"><span>首页</span>
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="sub-nav-bar" :class="{active:actNav===1}">
                            <div class="nav-bar-title" 
                                @click="isOpen(1)"                                    
                                @mouseover="actNav=1"
                                :style="{background:actNav===1?'#000':''}" 
                                @mouseout="actNav=-1">
                                <img :src="actNav===1?navActIcons[1]:navIcons[1]"><span>课程</span>
                                <img 
                                    :src="subMenus[0]===true?require('../../../assets/svg/up.svg'):require('../../../assets/svg/down.svg')" 
                                    class="arrow-direction">
                            </div>
                            <ul class="subitems" :style="{display:subMenus[0]?'block':''}">
                                <li class="nav-bar-item"
                                    @mouseover="actCou=1"
                                    @mouseout="actCou=-1" 
                                    @click="clickNav=11"
                                    :style="{background:clickNav===11?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actCou===1}">
                                        </i><span :style="{color:actCou===1?'#fff':''}">小学</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actCou=2"
                                    @mouseout="actCou=-1" 
                                    @click="clickNav=12"
                                    :style="{background:clickNav===12?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actCou===2}">
                                        </i><span :style="{color:actCou===2?'#fff':''}">初中</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actCou=3"
                                    @mouseout="actCou=-1" 
                                    @click="clickNav=13"
                                    :style="{background:clickNav===13?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actCou===3}">
                                        </i><span :style="{color:actCou===3?'#fff':''}">高中</span>
                                    </span>
                                </li>
                            </ul>
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="sub-nav-bar" :class="{active:actNav===2}">
                                <div class="nav-bar-title" 
                                @click="isOpen(2)"                                    
                                @mouseover="actNav=2"
                                :style="{background:clickNav===2?'#000':''}" 
                                @mouseout="actNav=-1">
                                <img :src="actNav===2?navActIcons[2]:navIcons[2]"><span>题库</span>
                                <img 
                                    :src="subMenus[1]===true?require('../../../assets/svg/up.svg'):require('../../../assets/svg/down.svg')" 
                                    class="arrow-direction">
                            </div>
                            <ul class="subitems" :style="{display:subMenus[1]?'block':''}">
                                <li class="nav-bar-item"
                                    @mouseover="actBank=1"
                                    @mouseout="actBank=-1" 
                                    @click="clickNav=21"
                                    :style="{background:clickNav===21?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actBank===1}">
                                        </i><span :style="{color:actBank===1?'#fff':''}">小学</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actBank=2"
                                    @mouseout="actBank=-1" 
                                    @click="clickNav=22"
                                    :style="{background:clickNav===22?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actBank===2}">
                                        </i><span :style="{color:actBank===2?'#fff':''}">初中</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actBank=3"
                                    @mouseout="actBank=-1" 
                                    @click="clickNav=23"
                                    :style="{background:clickNav===23?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actBank===3}">
                                        </i><span :style="{color:actBank===3?'#fff':''}">高中</span>
                                    </span>
                                </li>
                            </ul>
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="nav-bar-item" :class="{active:actNav===3}"
                            @click="clickNav=3"
                            @mouseover="actNav=3"
                            :style="{background:clickNav===3?'#000':''}" 
                            @mouseout="actNav=-1">
                            <img :src="actNav===3?navActIcons[3]:navIcons[3]"><span>教师</span>
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="nav-bar-item" :class="{active:actNav===4}"
                            @click="clickNav=4"
                            @mouseover="actNav=4"
                            :style="{background:clickNav===4?'#000':''}" 
                            @mouseout="actNav=-1">
                            <img :src="actNav===4?navActIcons[4]:navIcons[4]"><span>学生</span>
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="nav-bar-item" :class="{active:actNav===5}"
                            @click="clickNav=5"
                            @mouseover="actNav=5"
                            :style="{background:clickNav===5?'#000':''}" 
                            @mouseout="actNav=-1">
                            <img :src="actNav===5?navActIcons[5]:navIcons[5]"><span>我的</span>
                            <div class="indicator-bar"></div>
                        </li>                            
                    </ul>
                    <div class="btn-publish">
                        <i class="el-icon-upload"></i>发布课程
                    </div>                            
                </el-aside>                
                <el-main>
                    <transition name="fade" mode="out-in">
                        <router-view></router-view>
                    </transition>            
                </el-main>         
        </el-container>
    </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
    components:{    
    },
    data(){
        return{
            subMenus:[false,false],
            navIcons:[//默认导航图标
                require('../../../assets/svg/home.svg'),
                require('../../../assets/svg/course.svg'),
                require('../../../assets/svg/bank.svg'),
                require('../../../assets/svg/teacher.svg'),
                require('../../../assets/svg/student.svg'),
                require('../../../assets/svg/avatar.svg'),],
            navActIcons:[//激活时导航图标
                require('../../../assets/svg/home-active.svg'),
                require('../../../assets/svg/course-active.svg'),
                require('../../../assets/svg/bank-active.svg'),
                require('../../../assets/svg/teacher-active.svg'),
                require('../../../assets/svg/student-active.svg'),
                require('../../../assets/svg/avatar-active.svg'),],
            actNav:-1,//初始时，被激活的导航图标-active
            clickNav:-1,
            isClick:false,//判断鼠标是否有点击导航项
            actCou:-1,//初始时，课程被激活项
            actBank:-1,//初始时，题库被激活项
        }   
    },
    methods:{
       /*  ...mapActions('election',['getCourseList']),
        ...mapActions('user',['getUserInfo']), */
        OnMouseover(val){
            console.log(val);
            switch(val){
                case 0:
                    this.actNav = val;
                    break;
                case 1:
                    this.actSubNav1 = val;
                    break;
                case 2:
                    this.actSubNav2 = val;
                    break;
                case 3:
                    this.actNav = val;
                    break;
                case 4:
                    this.actNav = val;
                    break;
                case 5:
                    this.actNav = val;
                    break;
            }
            console.log(val);
        },
        onMouseout(val){
            //console.log(val)
            this.actNav = -1;
        },
        onClick(val){

        },
        /**@function 监听是否打开子菜单事件 */
        isOpen(val){
            console.log(val);
            switch(val){
                case 0:
                    break;
                case 1:
                    this.$set(this.subMenus,0,!this.subMenus[0]);
                    break;
                case 2:
                    this.$set(this.subMenus,1,!this.subMenus[1]);
                    break;
            }
        }

    },
    created(){

    },
    mounted(){
        /* this.getUserInfo()
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.log(err);
            })
        let params = {url:'selCou!query2.action',params:{}}        
        this.getCourseList(params)
            .then(res => {
                console.log(res)
            })
            .catch(err => {
                console.log(err);
            }) */
    }
}
</script>
<style>
    
</style>

<style scoped>
    .home,.el-container{
        /* height:100%;         */
    }
    .el-row{
        height:calc(100% - 88px);
    }
    .nav-bar-item{
        height:90px;
        line-height:90px;
        text-align:center;
        position: relative;
    }
    .sub-nav-bar{
        position: relative;
    }
    .el-col-2,.el-col-22{
        /* height:100%; */
    }
    .el-header{
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        height:88px!important;
    }
    .el-main{
        /* height:100%; */
        background-color: #fff;
        padding:44px 92px;
        position: relative;
    }    
    .subitems{
        text-indent: 2em;        
    }   
    .indicator-bar{
        width:6px;
        height:90px;
        position:absolute;
        left:0;
        top:0;
        background-color:#2185ff;
        display:none;
    }
    .active .indicator-bar{
        display:block;
    }
     .is-opened .indicator-bar{
        display:block;
    }
    .nav-bar-item img,.sub-nav-bar img{
        width:28px;
        vertical-align: middle;
        margin-right:15px;
    }
    .nav-bar-item span,.sub-nav-bar span{
        color:#98999e;
        font-size:18px;
        position: relative;
        top:3px;
    }
    .nav-bar-title{
        line-height:90px;
        height:90px;
        text-align:center;
        /* position: relative; */
    }
    .nav-bar-item:hover,.nav-bar-title:hover{
        background-color:#000;
    }
    .active span{
        color:#fff;
    }
    .arrow-direction{
        position:absolute;
        right:20px;
        top:40px;
        width:20px!important;
    }
    .subitems{
        display:none;
    }
    .subitems span{
        color:#98999e;
    }  
    .dot{
        border-radius:6px;
        width:6px;
        height:6px;
        background-color:#fff;
        display:inline-block;
        position: relative;
        top:-3px;
        margin-right:10px;
    }
    .circle{
        border-radius:5px;
        width:5px;
        height:5px;
        border:1px solid #98999e;
        display:inline-block;
        position: relative;
        top:-3px;
        margin-right:10px;
    } 
    .el-aside {
        background-color: #252834;
        position: relative;
        text-align: center;
        line-height: 180px;
        /* width:100%!important; */
        width:200px!important;
        /* height:100%; */
    }    
    .btn-publish{            
        height:48px;
        width:168px;  
        background:linear-gradient(to right,#8b62ff , #0a8dff);
        color:#fff;
        border-radius:24px;
        font-size:18px;
        line-height:48px;
        margin:0 auto;
        margin-top:90px; 
    }
    .btn-publish:hover{
        background:linear-gradient(to right,#9b62ff , #1a8dff);
        cursor: pointer;
    }
    .el-icon-upload{
        margin-right:5px;
    }
    
</style>