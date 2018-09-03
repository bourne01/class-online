<template>
    <article>
        <work-tab class="work-tab"></work-tab>
        <div class="toolbar">
            <button class="bank"><i class="el-icon-plus"></i>选择题库题目</button>
            <button class="customize" @click="onCustomize"><i class="el-icon-plus"></i>自定义题目</button>
            <el-radio>公布答案</el-radio>
            <span>设置作业时间</span>
            <el-select>                
            </el-select>
        </div>
        <transition>
            <router-view></router-view>
        </transition>
    </article>
</template>

<script>
import WorkTab from './work-tab';
import StudentWork from './student-work'
export default {
    components:{
        WorkTab,
        StudentWork,
    },
    methods:{
        /**
         * @function 监听点击自定义试题按钮，然后向父组件传递点击事件
         */
        onCustomize(){
            this.$emit('customize-question');
        }
    },
}
</script>

<style scoped>
    article{
        background-color:#ffff;
    }
    .work-tab{
        border-bottom:1px solid #f1f1f1;
    }
    .toolbar{
        padding:20px 40px;
        border-bottom:1px solid #f1f1f1;
    }
    button{
        outline: none;
        border:none;
        border-radius: 20px;
        height:40px;
        line-height: 40px;
        padding:0 25px;
        margin-right:50px;
        cursor: pointer;
    }
    .bank{
        background-color:#fc6835;
        color:#fff;
    }
    .customize{
        background-color:#fff;
        color:#171a20;
        border-radius: 19px;
        border:1px solid #d4d4d4;
        margin-right:110px;
    }
    i.el-icon-plus{
        margin-right:5px;
    }
    .el-radio{
        margin-right:50px;
    }
    .toolbar>span{
        font-size:14px;
        margin-right:10px;
    }
</style>


