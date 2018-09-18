<template>
    <article>
        <header>
            <bank-tab @has-subtab="onHasSubTab"></bank-tab>
            <my-classes class="my-classes" v-if="isClassErrors"></my-classes><!-- 只有在班级错题集下显示 -->
            <favorite-tab class="favorite-tab" v-if="isFavorite"></favorite-tab><!-- 只在我的收藏选项卡下显示 -->

        </header>
        <section>
            <div class="left">
                <transition>
                    <router-view></router-view>
                </transition>
            </div>
            <!-- <aside>
                <my-aside class="my-aside"></my-aside>
            </aside> -->
        </section>
        <!-- <footer>    
            <my-footer></my-footer>
        </footer> -->
    </article>
</template>

<script>
import BankTab from '../../../../components/bank/bank-tab'
import MyAside from '../../../../components/bank/mine'
import MyClasses from '../../../../components/bank/errors/my-classes'
import FavoriteTab from '../../../../components/bank/favorites/favorite-tab'
/* import MyFooter from '../../../../components/bank/footer' */
export default {
    components:{
        BankTab,
        MyAside,
        MyClasses,
        FavoriteTab
        /* MyFooter */
    },    
    data(){
        return{
            isFavorite:false,
            isClassErrors:false,
        }
    },
    methods:{
        /**@function 监听点击选项卡事件 */
        onHasSubTab(type,hasSubTab){
            //监听到点击班级错题集选项卡事件后的处理
            if(type === 'ClassErrors' && hasSubTab){
                this.isClassErrors = true;//显示班级错题集
                this.isFavorite = false;//隐藏我的收藏
            }
            ////监听到点击我的收藏选项卡事件后的处理                
            else if(type === 'Favorites' && hasSubTab){
                this.isFavorite = true;//显示我的收藏
                this.isClassErrors = false;//隐藏班级错题集
            }else{
                this.isFavorite = false;
                this.isClassErrors = false;
            }
        }
    }
}
</script>

<style scoped>
    article{
        background-color:#f1f1f1;
        position: relative;
    }
    section{
        width:1235px;
        margin:0 auto;
        margin-top:20px;
        display:flex;
        padding-bottom:20px;
        min-height:700px;
        
    }
    .my-classes,
    .favorite-tab{
        border-top:1px solid #f1f1f1;
    }
</style>


