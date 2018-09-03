<template>
    <article>
        <filters>         
        </filters>
        <section>            
            <ul>
                <li v-for="idx in 5" :key="idx">
                    <paper></paper>
                </li>
            </ul>
        </section>
    </article>
</template>

<script>
import Filters from '../../../../../components/bank/paper-filters'
import Paper from '../../../../../components/bank/paper'
export default {
    components:{
        Filters,        
        Paper,
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
        background:linear-gradient(to top,#74c756,#28d07e)
    }
    section{
        margin-top:10px;
        background-color:#fff;
    }   
    li{
        border-bottom:1px solid #f1f1f1;
    }
</style>


