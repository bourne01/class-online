<template>
    <div class="fans">
        <nav>
            <ul>
                <li 
                    :class="{active:actLi===1}"
                    @click="actLi=1">
                    <span>教师</span>
                    <div class="bar-wrap">
                        <div class="active-bar"></div>
                    </div>
                    
                </li>
                <li 
                    :class="{active:actLi===2}"
                    @click="actLi=2">
                    <span>学生</span>
                    <div class="active-bar"></div>
                </li>
            </ul>
        </nav>
        <section class="teachers">
    
        </section>
        <section class="students">
            <div class="my-student">
                <header>我的学生(46)</header>
                <div class="student-list">
                    <div class="student"  v-for="idx in 10" :key="idx">
                        <div class="basic-info">
                            <img class="avatar" :src="require('../../../assets/svg/avatar.svg')" alt="">
                            <div>
                                <span class="name">张小丽</span>
                                <br>
                                <span class="student-number">ID：20180901</span>
                            </div>
                        </div>
                        <div class="school">
                            <label for="">
                                    <img :src="require('../../../assets/svg/school1.svg')" alt="">学校：
                            </label>
                            <span>瓯海中学</span>
                        </div>
                        <div class="grade">
                            <label for="">
                                    <img :src="require('../../../assets/svg/title.svg')" alt="">职称：
                            </label>
                            <span>初一数学</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="other-student">
                <header>其它学生(416)</header>
                <div class="student-list">
                    <div class="student"  v-for="idx in 10" :key="idx">
                        <div class="basic-info">
                            <img class="avatar" :src="require('../../../assets/svg/avatar.svg')" alt="">
                            <div>
                                <span class="name">张小丽</span>
                                <br>
                                <span class="student-number">ID：20180901</span>
                            </div>
                        </div>
                        <div class="school">
                            <label for="">
                                    <img :src="require('../../../assets/svg/school1.svg')" alt="">学校：
                            </label>
                            <span>瓯海中学</span>
                        </div>
                        <div class="grade">
                            <label for="">
                                    <img :src="require('../../../assets/svg/title.svg')" alt="">职称：
                            </label>
                            <span>初一数学</span>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <el-pagination
            background
            layout="prev, pager, next"
            :total="1000">
        </el-pagination>
    </div>    
</template>
<script>
export default {
    components:{
    },
    data(){
        return{
            actLi:-1,
        }
    }
    
}
</script>

<style scoped>
    .fans{
        padding-bottom:40px;
    }
    nav{
        background-color:#fff;
    }
    nav li{
        height:78px;
        line-height:78px;
        color:#171a20;        
        font-size:20px;       
        display:inline-block;
        width:130px;
        text-align: center;
    }
    .bar-wrap{
        width:100%;
    }
    .active .active-bar{
        position: relative;
        top:-4px;
        height:4px;        
        background:linear-gradient(to top,#8b62ff , #0a8dff);
        margin:0 auto;
        width:2.6em;
    }  
    .students,.teachers{
        font-size:12px;
    } 
    .student,.teacher{
        padding:30px 0 30px 40px;
        background-color:#fff;
        width:253px;
        box-sizing: border-box;
        border-left:1px solid #f1f1f1;
        border-bottom:1px solid #f1f1f1;
    }
    .student-list{
        display:flex;
        flex-flow: row wrap;
    }
    .students header,
    .teachers header{
        color:#585a60;
        font-size:18px;
        height:28px;
        padding-left:56px;
        padding-top:20px;
    }
    .student label,
    .teacher label{
        color:#acadb0;
    }
    .student img,
    .teacher img{
        width:22px;
        height:22px;
        vertical-align: middle;
    }
    .basic-info{
        display:flex;
        margin-bottom:15px;
    }
    .basic-info>div{     
        align-self: center;
    }
    .avatar{
        width:68px!important;
        height:68px!important;
        border-radius:34px;
        border:1px solid #f1f1f1;
        box-sizing: border-box;
        margin-right:18px;
    }
    .name{
        color:#171a20;
        font-size:20px;
    }
    .student-number{
        color:#585a60;
        line-height: 1.7em;
    }
    .school,grade{
        line-height: 1.5em;
    }
    .el-pagination{
        text-align: center;
        margin-top:30px;
    }
</style>


