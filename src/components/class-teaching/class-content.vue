<template>
    <article>
        <header class="header" @mousemove="actNum=0" @mouseout="-1" v-if="curRole=='student'">
            <span>预告&nbsp;&nbsp;开设时间：2017-02-13 12：20</span>
            <span>
                <button class="btn" v-if="actNum===0">开始学习</button>
                <!-- <img :src="require('../../assets/svg/playback.svg')" alt="" v-else> -->
                <img :src="require('../../assets/svg/lock.svg')" alt="" v-else>
                <span class="time">35:03</span>
            </span>
        </header>
        <section v-for="sec in 2" :key="sec">
            <header class="chapter">
                <span>第{{sec}}章 软件的应用</span>
                <!-- <el-button icon="el-icon-plus">添加课程</el-button> -->
            </header>
            <ul>
                <li 
                    v-for="idx in 3" :key="idx" 
                    @mouseover="onMouseover(sec,idx)"
                    @mouseout="actNum=-1">
                    <span>第{{idx}}节 软件的应用-{{idx}}</span>
                    <span>
                        <span v-if="curRole=='student'">
                            <button class="btn" v-if="actNum==='li'+sec+idx">开始学习</button>
                            <img :src="require('../../assets/svg/playback.svg')" alt="" v-else>
                            <span class="time" v-if="curRole=='student'">35:03</span>
                        </span>
                        <span v-else>
                            <span class="course-state" v-if="couState==='1'">进行中</span>
                            <img :src="require('../../assets/svg/playback.svg')" alt="" v-else>
                            <span class="prepare-lesson" @click="goPrepareLess()">备课</span>
                        </span>

                    </span>
                </li>        
                <li>
                    <!-- <el-button icon="el-icon-plus">创建章节</el-button> -->
                </li>        
            </ul>
        </section>        
    </article>
</template>

<script>
import {getCurrentUser} from '../../utils/util.js'
export default {
    data(){
        return{
            actNum:-1,//
            curRole:'',//当前角色
            couState:'1',//课程状态(已上，正在上，未上)
        }
    },
    methods:{
        /**@function 监听鼠标悬停事件 */
        onMouseover(idx1,idx2){
            this.actNum = 'li'+idx1+idx2;
        },

        /**
         * @function 跳转到备课页面
         * @param {} 
         */
        goPrepareLess(){
            this.$router.push({name:'PrepareLesson',query:{}});
        },

    },
    mounted(){
        this.curRole = getCurrentUser(this.$route.path);
    }
}
</script>

<style scoped>
    article{
        background-color:#fff;
        margin-right:20px;
    }
    header{
        padding-left:60px;
        color:#585a60;
        font-size:16px;
        height:68px;
        line-height:68px;
        padding-right:55px;
        display:flex;
        justify-content: space-between;
        border-bottom:1px solid #f1f1f1;
    }
    article img{
        height:22px;
        width:22px;
        display:inline-block;
        margin-right:40px;
        vertical-align: middle;
    }
    .time{
        font-size:14px;
        color:#acadb0;
    }
    li{
        height:68px;
        line-height:68px;
        border-bottom: 1px solid #f1f1f1;
        padding:0 55px 0 60px;
        color:#585a60;
        display:flex;
        justify-content: space-between;
    }
    .chapter{
        padding-left:40px;
        color:#2185ff;
    }
    li:hover{
        color:#171a20;
        background-color:#f9f9f9;
    }
    li:hover .time{
        color:#171a20;
    }
    li:last-child{
        justify-content: center;
    }
    .btn{
        height:36px;
        line-height:36px;
        width:98px;
        text-align: center;
        outline: none;
        border:none;
        color:#fff;
        background-color:#fc6835;
        font-size:16px;
        border-radius:3px;
        margin-right:40px;
        font-weight: 'MicrosoftYaHei'
    }
    .course-state{
        background-color:#fff;
        color:#22cb64;
        font-size:16px;
        margin-right:40px;
    }
    .prepare-lesson{
        color:#366dd1;
        font-size:16px;
        cursor: pointer;
    }
    .el-button{
        height:36px;
        line-height:36px;
        padding:0;
        width:122px;
        color:#fc6c2e;
        border:1px solid #fc6c2e;
        align-self: center;
        border-radius:2px;
        background-color:#fff;
        font-size:16px;
    }
</style>

