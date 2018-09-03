<template>
    <div class="toolbar">
        <span><img :src="require('../../../assets/svg/previous.svg')" alt="">返回上一页</span>
        <div class="right">            
            <button class="btn print"><i class="el-icon-printer"></i>打印试卷</button>
            <button class="btn save">
                <img :src="require('../../../assets/svg/save-blue.svg')" alt="">保存试卷
            </button>
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
        margin-right:30px;
        cursor: pointer;
    }
    .save{
        background-color:#e0ecff;
        color:#2185ff;
    }
    .print{
        color:#14b653;
        background-color:#d3f5e0;
    }
    
</style>
