<template>
    <div>
        <my-header></my-header>     
        <section class="transition" @click="onClick">
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
import MyHeader from '../../../components/common/header'
import MyFooter from '../../../components/common/footer'
export default {
    components:{
        MyHeader,
        MyFooter,
    },
    methods:{
        /**@function 发送点击中部内容区域事件 */
        onClick(){            
            this.$root.bus.$emit('main-click')
        }
        
    }
}
</script>

<style scoped>
    .course-home{
        background-color:#171a20;
    }
    .transition{
        min-height:300px;
    }
    .my-footer{
        padding:40px 0;        
        min-height:300px;
        background-color:#171a20;
        /* position: fixed;
        bottom:0;
        width:100%; */
    }
</style>


