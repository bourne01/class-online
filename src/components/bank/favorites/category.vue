<template>
    <div class="category">
        <ul>
            <li class="title"><h4>我的分类</h4></li>            
            <li 
                v-for="(item,idx) in categories" :key="idx" 
                @mouseover="onMouseover(idx)"
                @mouseout="hover={}"
                @click="actIndex=idx"
                :class="{active:actIndex==idx}">
                {{categories[idx]}}
            </li>
        </ul>
        <div class="create">
            创建收藏夹
        </div>
        <div class="color-block" :style="hover"></div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            index:0,
            hover:{},
            actIndex:-1,
            categories:['高一数学','易错题','学生为掌握知识','高二数学'],
        }
    },
    methods:{
        /**
         * @function 监听鼠标悬停事件
         */
        onMouseover(idx){
            this.index = idx;
            this.hover = {
                display:'block',
                top:74 + 46*idx + 'px',
            }
        }
    }
}
</script>


<style scoped>
    .category{
        width: 293px;
        height: 608px;
        color: #585a60;
        font-size: 14px;
        position: relative;
    }
    ul{
        width: 100%;
        /* padding-left: 30px;
        padding-top: 38px; */
        box-sizing: border-box;
    }
    h4{
        font-size: 20px;
    }
    .title{
        padding-top:38px;
        margin-bottom:16px;
    }
    li:not(.title){
        list-style: none;
        height:46px;
        line-height:46px;
    }
    li{
        padding-left: 30px;
        box-sizing: border-box;
    }   
    .color-block{
        width: 4px;
        height: 46px;
        background: #fa5b4a;
        display: none;
        position: absolute;
    }
    .create{
        width: 253px;
        height: 48px;
        border-radius: 8px;
        background: #f1f1f1;
        text-align: center;
        line-height: 48px;
        position: absolute;
        bottom: 20px;
        left: 20px;
    }
    .active{
        background: #f8f8f8;
        color: #fa5b4a; 
    }
</style>