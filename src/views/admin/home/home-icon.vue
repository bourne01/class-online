<template>
    <div class="home">
            <!-- <el-container>                    
                <el-aside> -->
            <div class="container">
                <div class="aside">
                    <ul class="nav-bar">
                        <li class="nav-bar-item" >Logo</li>
                        <li class="nav-bar-item" 
                            :class="{active:actNav===0}"
                            :style="{background:clickNav===0?'#000':''}" 
                            @click="onClick(0)"
                            @mouseover="OnMouseover(0)"
                            @mouseout="actNav=-1">
                            <img :src="actNav===0?navActIcons[0]:navIcons[0]">
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="sub-nav-bar" :class="{active:actNav===1}">
                            <div class="nav-bar-title" 
                                @click="isOpen(1)"                                    
                                @mouseover="OnMouseover(1)"
                                :style="{background:actNav===1?'#000':''}" 
                                @mouseout="actNav=-1">
                                <img :src="actNav===1?navActIcons[1]:navIcons[1]">                                
                            </div>
                            <ul class="sub-items" :style="{display:actSubNav===1?'block':''}">
                                <li class="nav-bar-item"
                                    @mouseover="actCou=1"
                                    @mouseout="actCou=-1"
                                    @click="onClick(11)"                                     
                                    :style="{background:clickNav===11?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actCou===1}">
                                        </i><span :style="{color:actCou===1?'#fff':''}">小学</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actCou=2"
                                    @mouseout="actCou=-1" 
                                    @click="onClick(12)"
                                    :style="{background:clickNav===12?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actCou===2}">
                                        </i><span :style="{color:actCou===2?'#fff':''}">初中</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actCou=3"
                                    @mouseout="actCou=-1" 
                                    @click="onClick(13)"
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
                                @mouseover="OnMouseover(2)"
                                :style="{background:clickNav===2?'#000':''}" 
                                @mouseout="actNav=-1">
                                <img :src="actNav===2?navActIcons[2]:navIcons[2]">                                
                            </div>                     
                            <ul class="sub-items" :style="{display:actSubNav===2?'block':''}">
                                <li class="nav-bar-item"
                                    @mouseover="actBank=1"
                                    @mouseout="actBank=-1" 
                                    @click="onClick(21)"
                                    :style="{background:clickNav===21?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actBank===1}">
                                        </i><span :style="{color:actBank===1?'#fff':''}">小学</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actBank=2"
                                    @mouseout="actBank=-1" 
                                    @click="onClick(22)"
                                    :style="{background:clickNav===22?'#000':''}" 
                                    >
                                    <span><i class="circle" :class="{dot:actBank===2}">
                                        </i><span :style="{color:actBank===2?'#fff':''}">初中</span>
                                    </span>
                                </li>
                                <li class="nav-bar-item"
                                    @mouseover="actBank=3"
                                    @mouseout="actBank=-1" 
                                    @click="onClick(23)"
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
                            @mouseover="OnMouseover(3)"
                            :style="{background:clickNav===3?'#000':''}" 
                            @mouseout="actNav=-1">
                            <img :src="actNav===3?navActIcons[3]:navIcons[3]">
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="nav-bar-item" :class="{active:actNav===4}"
                            @click="clickNav=4"
                            @mouseover="OnMouseover(4)"
                            :style="{background:clickNav===4?'#000':''}" 
                            @mouseout="actNav=-1">
                            <img :src="actNav===4?navActIcons[4]:navIcons[4]">
                            <div class="indicator-bar"></div>
                        </li>
                        <li class="nav-bar-item" :class="{active:actNav===5}"
                            @click="clickNav=5"
                            @mouseover="OnMouseover(5)"
                            :style="{background:clickNav===5?'#000':''}" 
                            @mouseout="actNav=-1">
                            <img :src="actNav===5?navActIcons[5]:navIcons[5]">
                            <div class="indicator-bar"></div>
                        </li>                            
                    </ul>
                    <div class="btn-publish">
                        <i class="el-icon-plus"></i>
                    </div>                            
               <!--  </el-aside>  -->       
               </div>        
                <el-main @click.native="onClick('Main')">
                    <transition name="fade" mode="out-in">
                        <router-view></router-view>
                    </transition>            
                </el-main>         
        <!-- </el-container> -->
        </div>
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
            actSubNav:-1,
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
                    this.actSubNav = -1;
                    break;
                case 1:
                    this.actNav = val;
                    this.actSubNav = val;
                    break;
                case 2:
                    this.actNav = val;
                    this.actSubNav = val;
                    break;
                case 3:
                    this.actNav = val;
                    this.actSubNav = -1;
                    break;
                case 4:
                    this.actNav = val;
                    this.actSubNav = -1;
                    break;
                case 5:
                    this.actNav = val;
                    this.actSubNav = -1;
                    break;
            }
            console.log(val);
        },
        onMouseout(val){
            //console.log(val)
            this.actNav = -1;
        },
        onClick(val){
            console.log(val)
            switch(val){
                case 0:
                    this.clickNav = val;                    
                    break;
                case 1:
                    this.clickNav = val;                    
                    break;
                case 11:
                    this.clickNav = val;  
                    this.actSubNav = -1;                  
                    break;
                case 12:
                    this.clickNav = val;  
                    this.actSubNav = -1;                  
                    break;
                case 13:
                    this.clickNav = val;
                    this.actSubNav = -1;                    
                    break;
                case 2:
                    this.clickNav = val;                    
                    break;
                case 21:
                    this.clickNav = val;
                    this.actSubNav = -1;                    
                    break;
                case 22:
                    this.clickNav = val; 
                    this.actSubNav = -1;                   
                    break;
                case 23:
                    this.clickNav = val;
                    this.actSubNav = -1;                    
                    break;
                case 3:
                    this.clickNav = val;
                    break;
                case 4:
                    this.clickNav = val;
                    break;
                case 5:
                    this.clickNav = val;
                    break;
                case 'Main':
                    this.actSubNav = -1;
                    break;
            }
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
    .container{
        display:flex;
    }
    .aside{
        
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
    .indicator-bar{
        width:4px;
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
        right: 5px;
        top: 38px;
        width:20px!important;
    }
    .sub-items{
        display:none;
        color:#98999e;
        position:absolute;
        top: 10px;
        right: -110px;
        width: 100px;
        background-color:#252834;
        border-radius:5px;
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
    .aside {
        background-color: #252834;
        position: relative;
        text-align: center;
        line-height: 180px;
        /* width:100%!important; */
        width:90px!important;
        /* height:100%; */
        z-index:1;
    }    
    .btn-publish{            
        height:40px;
        width:40px;  
        background:linear-gradient(to right,#8b62ff , #0a8dff);
        color:#fff;
        border-radius:24px;
        font-size:18px;
        line-height:40px;
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