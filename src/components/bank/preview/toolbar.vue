<template>
    <div class="toolbar">
        <span><img :src="require('../../../assets/svg/previous.svg')" alt="">返回上一页</span>
        <div class="right">
            <button class="btn save">
                <img :src="require('../../../assets/svg/save-blue.svg')" alt="">保存试卷
            </button>
            <button class="btn continue"><i class="el-icon-circle-plus"></i>继续选题</button>
            <button class="btn clear"><i class="el-icon-delete"></i>清空选题</button>
        </div>
    </div>
</template>

<style scoped>
    .toolbar{
        display:flex;
        justify-content: space-between;
        line-height: 68px;
        height:68px;
    }
    .toolbar>span{
        color:#585a60;
        font-size:18px;
        cursor: pointer;
    }
    img{
        width:22px;
        height:22px;
        vertical-align: middle;
        position: relative;
        top:-1px;
        margin-right:5px;        
    }
    i{
        font-size:18px;
        margin-right:5px;
        position: relative;
        top:2px;
    }
    .btn{
        height:36px;
        line-height: 36px;
        border:none;
        outline: none;
        width:120px;
        border-radius:2px;
        margin-right:10px;
        cursor: pointer;
    }
    .save{
        background-color:#e0ecff;
        color:#2185ff;
    }
    .continue{
        color:#fa5b4a;
        background-color:#ffe8e0;
    }
    .clear{
        background-color:#f1f1f1;
        color:#585a60;
    }
</style>
