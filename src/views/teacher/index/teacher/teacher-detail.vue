<template>
    <div>
        <div class="detail-header">
            <detail-header></detail-header>
        </div>
        <div class="detail-main">
            <div>
                <div class="left">
                    <my-nav></my-nav>
                    <recent-visit></recent-visit>
                </div>
                <div class="right">
                    <transition name="fade" mode="out-in">
                        <router-view></router-view>
                    </transition>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import DetailHeader from '../../../../components/teacher/teacher-detail/detail-header'
import MyNav from '../../../../components/teacher/teacher-detail/my-nav'
import RecentVisit from '../../../../components/teacher/teacher-detail/recent-visit'
export default {
    components:{
        DetailHeader,
        MyNav,
        RecentVisit,
    }
}
</script>

<style scoped>
    .detail-header{
        background-color:#171a20
    }
    .detail-main{
        padding-top:29px;
        background-color:#f1f1f1;
    }
    .detail-main>div{
        width:1364px;
        margin:0 auto;
        display:flex;
    }
    .detail-main .left{
        margin-right:40px;
    }
    .detail-main .right{
        width:100%;
    }
</style>


