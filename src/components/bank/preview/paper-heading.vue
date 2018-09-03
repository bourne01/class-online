<template>
    <div class="heading">
        <div class="title">2018年8月3日高中数学组卷</div>
        <div>
            <span>
                <label for="">组卷时间：</label>
                <span>2018-09-20 10:30:18</span>
            </span>
            <span>
                <label for="学段：">高中：</label>
                <span>高中</span>
            </span>
            <span>
                <label for="">题数：</label>
                <span>共32题</span>
            </span>
        </div>
        <label for="" class="label">
            <img :src="require('../../../assets/bank/origin.png')" alt="">
        </label>
    </div>
</template>

<style scoped>
    .heading{
        height: 186px;
        position: relative;
        text-align: center;
        color:#616475;
        font-size:12px;
        background-color:#fff;
    }
    .title{
        padding-top:70px;
        
        margin-bottom:18px;
        font-size:32px;
        color:#171a20;
    }
    .label{
        position:absolute;
        top:0;
        left:0;
    }
</style>

