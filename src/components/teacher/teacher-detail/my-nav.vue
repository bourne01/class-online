<template>
    <div>
        <ul>
            <li 
                :class="{active:actLi===1}"
                @click="actLi=1"
                >
                <router-link to="/admin-index/teacher-detail/course">我的课程</router-link>
                <div class="active-bar"></div></li>
            <li 
                :class="{active:actLi===2}"
                @click="actLi=2">
                <router-link to="/admin-index/teacher-detail/favorite">我的收藏</router-link>
                <div class="active-bar"></div></li>
            <li class="bank" 
                :class="{active:actLi===3}"
                @click="actLi=3">
                <router-link to="/admin-index/teacher-detail/bank">我的题库</router-link>
                <div class="active-bar"></div></li>
            <li class="follow" 
                :class="{active:actLi===4}"
                @click="actLi=4">
                <router-link to="/admin-index/teacher-detail/follow">我的关注</router-link>
                <div class="active-bar"></div></li>
            <li 
                :class="{active:actLi===5}"
                @click="actLi=5">
                <router-link to="/admin-index/teacher-detail/fans">我的粉丝</router-link>
                <div class="active-bar"></div></li>
            <li class="personal" 
                :class="{active:actLi===6}"
                @click="actLi=6">
                <router-link to="/admin-index/teacher-detail/personal">资料与账号</router-link>
                <div class="active-bar"></div></li>
        </ul>
    </div>
</template>

<script>
export default {
    data(){
        return{
            actLi:1,//默认激活的li
        }
    }
}
</script>

<style scoped>
    ul{
        padding-top:40px;
        padding-bottom:40px;
        width:312px;
        background-color:#fff;
    }
    li{
        position:relative;
        padding-top:5px;
        padding-bottom:5px;
    }
    .active .active-bar{
        
        position:absolute;
        left:0;
        top:0;
        width:4px;
        height:48px;
        background:linear-gradient(to top,#8b62ff , #0a8dff);

    }
    a{
        padding-left:50px;
        display:inline-block;
        width:100%;
        height:48px;
        line-height: 48px;
        text-decoration: none;
        color:#585a60;
    }
    .bank{
        border-bottom:1px solid #f1f1f1;
    }
    .personal{
        border-top:1px solid #f1f1f1;
    }
</style>


