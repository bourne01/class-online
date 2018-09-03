<template>
    <article>
        <filters :is-all="true">            
            <template slot="button">
                <button>一键智能组卷</button>
            </template>
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
import Filters from '../../../../../components/bank/filters'
import KnowledgeTree from '../../../../../components/bank/knowledge-point'
import Question from '../../../../../components/bank/question-by-point'
import MyFooter from '../../../../../components/bank/footer'
export default {
    components:{
        Filters,
        KnowledgeTree,
        MyFooter,
        Question,
    },
    methods:{
        /**监听滚动条事件，处理相应的事件 */
        handleScroll () {
            //网页被卷去的高即被遮挡的区域高度
            let scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop
            //网页正文全文高
            let scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
            //网页可见区域高(包括边线的宽) 
            let clientHeight = document.documentElement.clientHeight || document.body.clientHeight;
            /**
             * 当三者差值大于等于380px是，试题统计条为固定显示在网页底部，反之，以绝对定位方式显示在网页页脚上部
             */
            if((scrollHeight - scrollTop - clientHeight)>380){//380为网页footer区域高度值，单位为px
                document.querySelector('.footer').style.position = 'fixed';
            }else{
                document.querySelector('.footer').style.position = 'absolute';
            }
            /**
             * 当被卷去的高度大于136px时，右侧工具条固定显示，反之，以绝对定位显示
             */
            if(scrollTop>136){
                let aside = document.querySelector('.my-aside');
                let clientWidth = document.body.clientWidth || document.documentElement.clientWidth;
                aside.style.position = 'fixed';
                aside.style.left = ((clientWidth-1364)/2 + 1245).toString()+'px';
            }else{
                let aside = document.querySelector('.my-aside');
                aside.style.position = 'absolute';
                aside.style.left = 0;
            }
        },
    },
    mounted(){
       // console.log('comprehensive...');
        //注册滚动事件
        window.addEventListener('scroll', this.handleScroll);
        document.querySelector('.footer').style.position = 'fixed';
    },
    destroyed(){
        document.querySelector('.footer').style.position = 'absolute';
        //window.removeEventListener('scroll',()=>{})
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
        background:linear-gradient(to bottom right,#74c756,#28d07e)
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


