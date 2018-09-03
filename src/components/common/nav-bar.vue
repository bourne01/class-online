<template>
    <div>
        <ul class="nav-bar">
            <li class="nav-bar-item" >Logo</li>
            <li class="nav-bar-item" 
                :class="{active:actNav===0}"
                :style="{background:clickNav===0?'#000':''}" 
                @click="onClick(0)"
                @mouseover="OnMouseover(0)"
                @mouseout="onMouseout(0)"
                >
                <img :src="actNav===0?navActIcons[0]:navIcons[0]"><span>首页</span>
                <div class="indicator-bar"></div>
            </li>
            <li class="sub-nav-bar" :class="{active:actNav===1}">
                <div class="nav-bar-title" 
                    @click="onClick(1)"                                    
                    @mouseover="OnMouseover(1)"
                    :style="{background:clickNav===1?'#000':''}" 
                    >
                    <img :src="actNav===1?navActIcons[1]:navIcons[1]"><span>课程</span>
                    <div class="indicator-bar"></div>
                </div>
                <ul class="subitems">
                    <li class="nav-bar-item"
                        @mouseover="OnMouseover(11)"
                        @mouseout="actSubNav=-1" 
                        @click="onClick(11)"
                        :class="{subActive:actSubNav===11}"
                        :style="{background:actSubNav===11?'#f1f1f1':''}" 
                        >
                        <span>小学</span>
                    </li>
                    <li class="nav-bar-item"
                        @mouseover="OnMouseover(12)"
                        @mouseout="actSubNav=-1" 
                        @click="onClick(12)"
                        :class="{subActive:actSubNav===12}"
                        :style="{background:actSubNav===12?'#f1f1f1':''}" 
                        >
                        <span>初中</span>
                    </li>
                    <li class="nav-bar-item"
                        @mouseover="OnMouseover(13)"
                        @mouseout="actSubNav=-1" 
                        @click="onClick(13)"
                        :class="{subActive:actSubNav===13}"
                        :style="{background:actSubNav===13?'#f1f1f1':''}" 
                        >
                        <span>高中</span>
                    </li>
                </ul>
                <div class="indicator-bar"></div>
            </li>
            <li class="sub-nav-bar" :class="{active:actNav===2}">
                <div class="nav-bar-title" 
                    @click="onClick(2)"                                    
                    @mouseover="OnMouseover(2)"
                    :style="{background:clickNav===2?'#000':''}" 
                    >
                    <img :src="actNav===2?navActIcons[2]:navIcons[2]"><span>题库</span>
                    <div class="indicator-bar"></div>
                </div>
                <ul class="subitems">
                    <li class="nav-bar-item"
                        @mouseover="OnMouseover(21)"
                        @mouseout="actSubNav=-1" 
                        @click="onClick(21)"
                        :class="{subActive:actSubNav===21}"
                        :style="{background:actSubNav===21?'#f1f1f1':''}" 
                        >
                        <span>小学</span>
                    </li>
                    <li class="nav-bar-item"
                        @mouseover="OnMouseover(22)"
                        @mouseout="actSubNav=-1" 
                        @click="onClick(22)"
                        :class="{subActive:actSubNav===22}"
                        :style="{background:actSubNav===22?'#f1f1f1':''}" 
                        >
                        <span>初中</span>
                    </li>
                    <li class="nav-bar-item"
                        @mouseover="OnMouseover(23)"
                        @mouseout="actSubNav=-1" 
                        @click="onClick(23)"
                        :class="{subActive:actSubNav===23}"
                        :style="{background:actSubNav===23?'#f1f1f1':''}" 
                        >
                        <span>高中</span>
                    </li>
                </ul>
                <div class="indicator-bar"></div>
            </li>
            <li class="nav-bar-item" :class="{active:actNav===3}"
                @click="onClick(3)"
                @mouseover="OnMouseover(3)"
                @mouseout="onMouseout(3)"
                :style="{background:clickNav===3?'#000':''}" 
                >
                <img :src="actNav===3?navActIcons[3]:navIcons[3]"><span>教师</span>
                <div class="indicator-bar"></div>
            </li>
            <li class="nav-bar-item" :class="{active:actNav===4}"
                @click="onClick(4)"
                @mouseover="OnMouseover(4)"
                @mouseout="onMouseout(4)"
                :style="{background:clickNav===4?'#000':''}" 
                >
                <img :src="actNav===4?navActIcons[4]:navIcons[4]"><span>学生</span>
                <div class="indicator-bar"></div>
            </li>
            <li class="nav-bar-item" :class="{active:actNav===5}"
                @click="onClick(5)"
                @mouseover="OnMouseover(5)"
                @mouseout="onMouseout(5)"
                :style="{background:clickNav===5?'#000':''}" 
                >
                <img :src="actNav===5?navActIcons[5]:navIcons[5]"><span>我的</span>
                <div class="indicator-bar"></div>
            </li>                            
        </ul>
    </div>
</template>

<script>
export default {
    props:['btn-active'],
    components:{    
    },
    data(){
        return{
            subMenus:[false,false],
            navIcons:[//默认导航图标
                require('../../assets/svg/home.svg'),
                require('../../assets/svg/course.svg'),
                require('../../assets/svg/bank.svg'),
                require('../../assets/svg/teacher.svg'),
                require('../../assets/svg/student.svg'),
                require('../../assets/svg/avatar.svg'),],
            navActIcons:[//激活时导航图标
                require('../../assets/svg/home-active.svg'),
                require('../../assets/svg/course-active.svg'),
                require('../../assets/svg/bank-active.svg'),
                require('../../assets/svg/teacher-active.svg'),
                require('../../assets/svg/student-active.svg'),
                require('../../assets/svg/avatar-active.svg'),],
            actNav:-1,//初始时，被激活的导航图标-active
            clickNav:-1,
            actSubNav:-1,//初始时，课程被激活项
        }   
    },
    watch:{
        /**@function 一旦右侧按钮区域按钮激活，则导航激活样式失效 */
        btnActive:function(){
            console.log(this.btnActive);
            if(this.btnActive){//
                this.clickNav = -1;
                this.actNav = -1;
                this.actSubNav = -1;
            }
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
                    this.actNav = val;
                    break;
                case 11:
                    this.actSubNav = val;
                    break;
                case 12:
                    this.actSubNav = val;
                    break;
                case 13:
                    this.actSubNav = val;
                    break;
                case 2:
                    this.actNav = val;
                    break;
                case 21:
                    this.actSubNav = val;
                    break;
                case 22:
                    this.actSubNav = val;
                    break;
                case 23:
                    this.actSubNav = val;
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
            switch(val){
                case 1:
                    this.actNav = val;
                    break;
                case 11:
                    this.actSubNav = val;
                    break;
                case 12:
                    this.actSubNav = val;
                    break;
                case 13:
                    this.actSubNav = val;
                    break;
                case 2:
                    this.actNav = val;
                    break;
                case 21:
                    this.actSubNav = val;
                    break;
                case 22:
                    this.actSubNav = val;
                    break;
                case 23:
                    this.actSubNav = val;
                    break;
                default:
                    if(this.clickNav !== 0){
                        this.actNav = -1;
                    }
                    break;
            }
        },
        onClick(val){
            console.log(val);
            switch(val){
                case 0:
                    this.clickNav = val;
                    this.actNav = val;
                    break;
                case 1:
                    this.clickNav = val;
                    break;
                case 11:
                    this.clickNav = val;
                    break;
                case 12:
                    this.clickNav = val;
                    break;
                case 13:
                    this.clickNav = val;
                    break;
                case 2:
                    this.clickNav = val;
                    break;
                case 21:
                    this.clickNav = val;
                    break;
                case 22:
                    this.clickNav = val;
                    break;
                case 23:
                    this.clickNav = val;
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
}
</script>

<style scoped>
    .nav-bar{
        display:flex;
    }
    .nav-bar>li{
        width:110px;
        text-align: center;
        height:68px;
        line-height: 68px;
        font-size:16px;
        color:#acadb0;
        position: relative;
    }
    .nav-bar img{
        width:24px;
        height:24px;
        vertical-align: middle;
        margin-right: 10px;
    }
    .active span{
        color:#fff;
    }
    .active .indicator-bar{
        display:block;
        height:4px;
        width:110px;
        position:absolute;
        left:0;
        top:0;
        background:linear-gradient(to right,#8b62ff , #0a8dff);
    }
    .subitems{
        display:none;
        width:110px;
        position: absolute;
        top:68px;
        left:0;
        z-index:1;
        background-color:#fff;
        padding:10px 0;
    }
    .subitems span{
        color:#585a60;
        font-size:18px;
    }
    .active .subitems{
        display:block;
    }
    .subActive span{
        color:#366dd1;
    }
</style>


