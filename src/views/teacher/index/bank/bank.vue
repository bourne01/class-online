<template>
    <article>
        <header>
            <bank-tab></bank-tab>
        </header>
        <section>
            <div class="left">
                <transition>
                    <router-view></router-view>
                </transition>
            </div>
            <aside>
                <my-aside class="my-aside"></my-aside>
            </aside>
        </section>
        <!-- <footer>    
            <my-footer></my-footer>
        </footer> -->
    </article>
</template>

<script>
import BankTab from '../../../../components/bank/bank-tab'
import MyAside from '../../../../components/bank/mine'
/* import MyFooter from '../../../../components/bank/footer' */
export default {
    components:{
        BankTab,
        MyAside,
        /* MyFooter */
    },    
}
</script>

<style scoped>
    article{
        background-color:#f1f1f1;
        position: relative;
    }
    section{
        width:1364px;
        margin:0 auto;
        margin-top:20px;
        display:flex;
        padding-bottom:20px;
        min-height:700px;
        
    }
    .left{
        width:1235px;
        margin-right:10px;
    }
    aside{position: relative;}
    .my-aside{
        position:absolute;
        top:0;
        left: 0;
    }
</style>


