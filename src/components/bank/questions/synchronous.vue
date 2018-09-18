<template>
    <article>
        <filters>           
        </filters>
        <section>
            <aside>
                <knowledge-tree></knowledge-tree>
            </aside>
            <div class="main">
                <header>
                    <span>
                        共<span class="count">3550</span>道相关知识点试题
                    </span>
                    <span class="plus-txt">将此页试题加入组卷</span>
                </header>
                <ul>
                    <li v-for="idx in 5" :key="idx">
                        <question></question>
                    </li>
                </ul>
            </div>
        </section>
        <my-footer></my-footer>
    </article>
</template>

<script>
import Filters from '../filters'
import KnowledgeTree from '../knowledge-point'
import Question from '../question-by-point'
import MyFooter from '../footer'
export default {
    components:{
        Filters,
        KnowledgeTree,
        Question,
        MyFooter,
    },
    destroyed(){
        document.querySelector('.footer').style.position = 'absolute';
    },
    mounted(){
        document.querySelector('.footer').style.position = 'fixed';
    }
    
}
</script>

<style scoped>
    header{
        height:58px;
        line-height:58px;
        padding-left:20px;
        padding-right:20px;
        display: flex;
        justify-content: space-between;
        margin-bottom:10px;
        background-color:#fff;
    }
    .count{
        color:#fa5b4a;
    }
    .plus-txt{
        color:#2185ff;
    }
    button{
        outline: none;
        border:none;
        color:#fff;
        font-size:12px;
        padding:0 20px;
        border-radius:2px;
        background:linear-gradient(to top,#74c756,#28d07e)
    }
    section{
        margin-top:10px;
        display:flex;
    }
    aside{
        width:299px;
        min-height:898px;
        background-color:#fff;
        margin-bottom:78px;
        margin-right:10px;
    }
    .main{
        width:926px;        
        margin-bottom:78px;
    }
    .main ul{
        padding-top:10px;
        background-color:#fff;
    }
    .main li{
        padding:20px 0;
    }
    .main li:hover{
        border:1px solid #2185ff;
        box-sizing: border-box;
    }
</style>


