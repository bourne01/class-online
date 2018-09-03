<template>
    <div class="filters">
        <div class="level filter">
            <label for="">层次：</label>
            <button class="btn">全部</button>
            <span>小学</span>
            <span>初中</span>
            <span>高中</span>
        </div>
        <div class="grade filter">
            <label for="">年级：</label>
            <button class="btn">全部</button>
            <span>一年级</span>
            <span>二年级</span>
            <span>三年级</span>
            <span>四年级</span>
            <span>五年级</span>
            <span>六年级</span>
        </div>
        <div class="course filter">
            <label for="">学科：</label>
            <button class="btn">全部</button>
            <span>语文</span>
            <span>数学</span>
            <span>英语</span>
            <span>物理</span>
            <span>化学</span>
            <span>生物</span>
        </div>
        <div class="type filter">
            <label for="">类型：</label>
            <button class="btn">全部</button>
            <span class="">任务课</span>
            <span class="open-course">公开课</span>
        </div>
        <div class="search-bar filter">
            <label for="" style="width:3em;"></label>
            <el-input
                placeholder="请输入内容"
                suffix-icon="el-icon-search"
                v-model="search">
            </el-input>
            <el-select v-model="value" placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>

        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            value:'',
            search:'',
            options:{},
        }
    }
}
</script>

<style>
    .filters .el-input__inner{
        background-color:#f1f1f1;
    }
</style>

<style scoped>
    .filters{
        display: flex;
        flex-direction: column;
    }
    .filter{
        display:flex;
        margin-bottom:20px;

    }
    .filter:first-child{
        margin-top:20px;
    }
    .filter label{
        padding:5px 15px 5px 0;
        font-size:14px;
        color:#585a60;
    }
    .filter .btn{
        padding:5px 15px;
        color:#fff;
        font-size:12px;
        background-color:#fc6934;
        outline: none;
        border:none;
    }
    .filter span{
        padding:5px 15px;
        font-size:12px;
        color:#585a60
    }
    .el-input{
        margin-right:20px;
    }
    .el-input,.el-select{
        width:25%;
    }
</style>

