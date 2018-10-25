<template>
    <div class="toolbar">
        <span @click="goBack">
            <img :src="require('../../../assets/svg/previous.svg')" alt="">返回上一页</span>
        <div class="right">            
            <button class="btn">草稿自动保存</button>
        </div>
    </div>
</template>

<script>
export default {
    methods:{
        /**@function 回退到上一页 */
        goBack(){
            console.log('ahfahfah');
            history.go(-1)
        }
    }
}
</script>


<style scoped>
    .toolbar{
        display:flex;
        justify-content: space-between;
        line-height: 68px;
        height:68px;
    }
    .toolbar>span{
        color:#585a60;
        font-size:12px;
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
    .btn{
        height:36px;
        line-height: 36px;
        border:none;
        outline: none;
        border-radius:2px;
        margin-right:30px;
        cursor: pointer;
        background-color:transparent; 
        color:#2185ff;
    }    
    
</style>
