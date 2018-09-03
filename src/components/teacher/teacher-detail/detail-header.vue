<template>
    <div class="teacher-detail-header">
        <div class="tool-bar">
            <el-dropdown @command="onTitleCommand">
                <span class="el-dropdown-link">
                    {{title}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item 
                        v-for="(title,index) in titleList" :key="index" 
                        :command="title.key">{{title.name}}</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
        <div class="teacher-desk">
           <span>
               <label>人气</label>
               <br>
               <span>3466</span>
            </span>
           <span class="points">
               <label>积分</label>
               <br>
               <span>89</span>
            </span>
            <img :src="require('../../../assets/teacher/teacher-desk.jpg')" alt="">
           <span class="fans">
               <label>粉丝</label>
               <br>
               <span>1466</span>
            </span>
           <span class="followers">
               <label>关注</label>
               <br>
               <span>3466</span>
            </span>

        </div>
        <div class="teacher-info">
            <div class="avatar">
                <img :src="require('../../../assets/svg/avatar.svg')" alt="">
            </div>
            <div class="teacher-name">
                <p class="name">王老师</p>
                <p class="motto">这个行业没有捷径！细水长流方能水滴石穿</p>
            </div>
            <div class="basic-info">
                <span>
                    <label for="">
                            <img :src="require('../../../assets/svg/academic.svg')" alt="">学科：
                        </label>
                    <span>初一数学</span>
                </span>
                <span>
                    <label for="">
                            <img :src="require('../../../assets/svg/experience.svg')" alt="">教龄：
                        </label>
                    <span>22年</span>
                </span>
                <span>
                    <label for="">
                            <img :src="require('../../../assets/svg/school1.svg')" alt="">学校：
                        </label>
                    <span>瓯海中学</span>
                </span>
                <span>
                    <label for="">
                            <img :src="require('../../../assets/svg/title.svg')" alt="">职称：
                        </label>
                    <span>初一数学</span>
                </span>
            </div>
            <div>
                <button class="btn follow">关注</button>
                <button class="btn private-msg">私信</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            title:'教学职称',
            titleList:[
                {key:-1,name:'全部职称'},
                {key:1,name:'黄金糕'},
                {key:2,name:'狮子头'},
                {key:3,name:'螺蛳粉'},],
        }
    },
    methods:{
        onTitleCommand(command){
            for(let title of this.titleList){
                if(title.key === command){
                    this.title = title.name;
                }
            }
        }
    },
}
</script>

<style scoped>
    .tool-bar,.teacher-desk{
        width:1364px;
        margin:0 auto;
    }
    .tool-bar{
        height:116px;
        line-height:116px;
        display:flex;
        justify-content: flex-end;
        font-size:12px;
    }
    .teacher-desk{
        width:900px;
        margin:0 auto;
        display: flex;
        justify-content: space-between;
        align-items: flex-end;
        color:#fff;
    }
    .teacher-desk>span{
        padding-bottom:20px;
        line-height:1.5em;
        display:inline-block;
        width:100px;
        text-align:center;
    }
    .teacher-desk label{
        width:100px;
        display:inline-block;
    }
    .teacher-desk>span>span{
        font-size:24px;
        color:#fefefe;
        font-weight: bold;
    }
    .teacher .el-icon-arrow-down{
        color:#fff;
    }
    .teacher-info{
        
        background-color:#fff;
        text-align: center;
        padding-bottom:40px;
    }
    .avatar{
        text-align: center;
        margin-bottom:18px;
    }
    .avatar img{
        position: relative;
        top:-60px;
        width:120px;
        height:120px;
        border-radius:60px;
        box-sizing: border-box;
        border:2px solid #fff;
    }
    .basic-info{
        margin-top:20px;
    }
    .basic-info label{
        color:#acadb0;
    }
    .basic-info label img{
        width:22px;
        height:22px;
        vertical-align: middle;
    }
    .teacher-info .name{
        color:#171a20;
        font-size:24px;
        padding-bottom:10px;
    }
    .teacher-name{
        margin-top:-60px;
    }
    .btn{
        margin-top:34px;
        height:32px;
        line-height:32px;
        width:98px;
        text-align: center;
        border-radius:16px;
        font-size:16px;
        color:#585a60;
        border:1px solid #0a8dff;
        background-color:#fff;
    }
    .follow{
        margin-right:15px;
    }
    .private-msg{
        margin-left:15px;
    }
    .followed{
        border:none;
        color:#fff;
        background-color:#fc6934;}
</style>

