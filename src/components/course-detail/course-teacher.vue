<template>
    <article>
        <header>
            <span>授课老师</span>
        </header>
        <ul>
            <li v-for="index in 4" :key="index">
                <img :src="require('../../assets/svg/avatar.svg')" alt="">
                <span>
                    <span class="name">王老师</span>
                    <span class="school">瓯海区XXX实验小学</span>
                    <span class="course">
                        <span>小学</span>
                        <span>语文</span>
                    </span>
                </span>
            </li>
        </ul>
    </article>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    article{
        background-color:#ffff;
        padding-left:30px;
        padding-top:30px;
        padding-bottom:30px;
        width:366px;
        border-radius: 3px;
        min-height:100px;
    }
    header>span{
        font-size:20px;
        color:#171a20;
        font-family: 'MicrosoftYaHei';
    }
    ul{
        margin-top:30px;
    }
    li{
        display:flex;
        margin-bottom:20px;
    }
    li>img{
        width:68px;
        height:68px;
        margin-right:20px;
    }
    li>span{
        display:flex;
        flex-direction: column;
        justify-content: space-between;
    }
    li .name{
        color:#000;
        font-size:18px;
    }
    li  .school{
        color:#585a60;
        font-size:12px;
    }
    .course span{
        padding:3px 10px;
        background-color:#f4f4f4;
        margin-right:10px;
        border-radius:2px;
        color:#585a60;
        font-size:12px;
    }
</style>

