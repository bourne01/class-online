<template>
    <div class="filters">
        <div>
            <div class="level filter">
                <label for="">学段：</label>
                <span>小学</span>
                <span>初中</span>
                <span>高中</span>
            </div>        
            <div class="course filter">
                <label for="">科目：</label>
                <span>语文</span>
                <span>数学</span>
                <span>英语</span>
                <span>物理</span>
                <span>化学</span>
            </div>
            <div class="year filter">
                <label for="">年份：</label>
                <span>全部</span>
                <span>2017</span>
                <span>2016</span>
                <span>2015</span>
                <span>2014</span>
            </div>
            <div class="textbook filter">
                <label for="">地区：</label>
                <span>天津</span>
                <span>河北</span>
                <span>山西</span>
                <span>内蒙古</span>
            </div>
        </div>        
        <div class="search-bar filter">
            <label for="" style="width:3em;"></label>            
            <el-select v-model="value" placeholder="请选择题型">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
            <el-select v-model="value" placeholder="请选择下载最多">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
            <el-input
                placeholder="请输入内容"
                suffix-icon="el-icon-search"
                v-model="search">
            </el-input>
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
        background-color:#fff;
        padding-left:20px;
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
    .el-select{
        width:15%;
        margin-right:40px;
    }
    .search-bar .el-input{
        width:40%;
    }
</style>

