<template>
    <ul>
        <li>
            <img :src="require('../../assets/bank/errors.png')" alt="">
            <br>我的错题</li>
        <li>
            <img :src="require('../../assets/bank/favorite.png')" alt="">
            <br>我的收藏</li>
        <li>
            <img :src="require('../../assets/bank/bank.png')" alt="">
            <br>我的题库</li>
        <li><img :src="require('../../assets/bank/paper.png')" alt="">
            <br>我的试卷</li>
    </ul>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    ul{
        height:496px;
        width:118px;
        background-color:#fff;
        padding-top:30px;
    }
    li{
        text-align: center;
        margin-bottom:60px;
        font-size:12px;
        color:#585160;
    }
</style>


