<template>
    <div class="course-home">
        <my-header></my-header>     
        <section class="transition">
            <transition name="fade" mode="out-in">
                <router-view></router-view>
            </transition>
        </section>
        <footer class="my-footer">
            <my-footer ></my-footer>
        </footer>
        
    </div>
</template>

<script>
import MyHeader from '../components/common/header'
import MyFooter from '../components/common/footer'
export default {
    components:{
        MyHeader,
        MyFooter,
    }
}
</script>

<style scoped>
    .course-home{
        background-color:#171a20;
    }
    .transition{
        /* width:1364px;
        margin:0 auto; */
    }
    .my-footer{
        padding:40px 0;        
        min-height:300px;
    }
</style>


