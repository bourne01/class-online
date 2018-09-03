<template>
    <div class="paper">
        <div class="left">
            <div class="title">2016年福建省厦门市中考数学试卷</div>
            <div class="paper-info">
                <span><img :src="require('../../assets/svg/eye.svg')" alt="">3032</span>
                <span><img :src="require('../../assets/svg/download.svg')" alt="">3032</span>
                <span><img :src="require('../../assets/svg/update-time.svg')" alt="">2018-09-20</span>
            </div>
        </div>
        <div class="right">
            <button class="download">
                <img :src="require('../../assets/svg/download-light-blue.svg')" alt="">
                <span>下载试卷</span>                
            </button>
            <button class="preview">
                <img :src="require('../../assets/svg/preview-light-green.svg')" alt="">
                <span>预览试卷</span>
            </button>
            <button class="favorite">
                <img :src="require('../../assets/svg/favorite-active.svg')" alt="">
                <span>已收藏</span>
            </button>
        </div>
        <label for="">
            <img :src="require('../../assets/bank/origin.png')" alt="">
        </label>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    .paper{
        padding:32px 40px;
        display:flex;
        justify-content: space-between;
        position: relative;
    }
    .title{
        font-size:24px;
        color:#585a60;
        margin-bottom:32px;
    }
    .paper-info{
        font-size:12px;
    }
    .paper-info>span{
        margin-right:56px;
        color:#acadb0;
    }
    .paper-info img{
        width:22px;
        height:22px;
        vertical-align: middle;
        position:relative;
        top:-2px;
        margin-right:5px;
    }
    .right{
        padding-top:24px;
    }
    .right button{
        outline: none;
        border:none;
        padding:8px 15px;
        border-radius:2px;
        margin-right:10px;
        color:#fff;
        cursor: pointer;
    }
    .right img{
        width:22px;
        height:22px;
        vertical-align: middle;
    }
    .right span{
        position: relative;
        top:3px;
    }
    button.download{
        background-color:#1988ff;
    }
    button.preview{
        background-color:#13b653;
    }
    button.favorite{
        background-color:#ffe8e0;
        color:#fa5b4a;
        margin-left:30px;
        margin-right:0;
    }
    label{
        position:absolute;
        top:0;
        left:0
    }
</style>

