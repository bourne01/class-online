<template>
    <div class="course-tab">
        <ul class="tabs">
            <!-- <li @click="onClick(1)"
                :class="{active:actIndex===1}">课程介绍
                <div class="active-bar"></div>
            </li> -->
            
            <li @click="onClick(1)" 
                :class="{active:actIndex===1}">课程目录
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(2)" 
                :class="{active:actIndex===2}">课堂作业
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(3)" 
                :class="{active:actIndex===3}">学员讨论
                <div class="active-bar"></div>
            </li>
        </ul>
        <img :src="require('../../assets/svg/share.svg')" alt="">
    </div>
</template>

<script>
import {getCurrentUser} from '../../utils/util.js'
export default {
    data() {
        return {
            actIndex:1,//初始化时，鼠标悬停活动条显示那个标签下
            clickIndex:-1,//初始化时，鼠标点击活动条显示那个标签下
            isClick:false,//判断标签是否被点击
            curRole:'',//当前用户角色(可能的取值：admin,teacher,user)
        };
    },
    methods: {
        /**@function 监听点击tab事件
         * @param {激活的标签序号} actIndex
         */
        onClick(actIndex) {
            this.actIndex = actIndex;
            let routerList = [
                            /* '/'+this.curRole+'-index/class-teaching/course-desc', */
                            '/'+this.curRole+'-index/class-teaching/class-content',
                            '/'+this.curRole+'-index/class-teaching/class-task',                            
                            '/'+this.curRole+'-index/class-teaching/class-comment'];
            this.$router.push(routerList[actIndex-1]);            
        },
    },
    mounted(){
        this.curRole = getCurrentUser(this.$route.path);
    }
};
</script>

<style scoped>
    .course-tab{
        display:flex;
        justify-content: space-between;
        width:1364px;
        margin:0 auto;  
    }
    .tabs li{
        height:90px;
        line-height:90px;
        font-size:20px;
        text-align: center;
        color:#fff;
        display:inline-block;
        margin-right:90px;
        width:124px;
        position: relative;
        cursor: pointer;
    }
    .tab li:first-child{
        padding-left:20px;
    }
    .active .active-bar{
        display:inline-block;
    }
    .active-bar{
        display:none;
        height:4px;
        width:124px;
        position:absolute;
        bottom:0;
        left:0;
        background-color:#fc6835;
    }
    .active{
        color:#fc6835!important;
    }
    .course-tab img{
        width:22px;
        height:22px;
        align-self: center;
        padding-right:20px;
        cursor: pointer;
    }
</style>
