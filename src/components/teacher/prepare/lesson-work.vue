<template>
    <article>
        <work-tab class="work-tab" @tab-index="onTabIndex"></work-tab>
        <div class="toolbar">
            <button class="bank"><i class="el-icon-plus"></i>选择题库题目</button>
            <button class="customize" @click="onCustomize"><i class="el-icon-plus"></i>自定义题目</button>
            <!-- <el-radio 
                v-model="lessonWork.isAnswerOpen" 
                @click.native="lessonWork.isAnswerOpen=!lessonWork.isAnswerOpen">公布答案</el-radio> -->
            <el-switch
                v-model="lessonWork.isAnswerOpen"                
                inactive-text="公布答案"
                active-color="#409EFF">
            </el-switch>
            <span>设置作业时间</span>
            <el-date-picker
                v-model="lessonWork.datetime"
                type="datetime"
                value-format="yyyy-MM-dd HH-mm-ss"
                placeholder="选择日期时间">
            </el-date-picker>
        </div>
        <student-work 
            :work-type="workTypes[workTypeIndex-1]"
            :question="lessonWork.question"
            ></student-work>
    </article>
</template>

<script>
import WorkTab from './work-tab';
import StudentWork from './student-work' 
export default {
    props:['lesson-work'],
    components:{
        WorkTab,
        StudentWork,
    },
    data(){
        return{
            workTypeIndex:-1,//作业类型下标
            workTypes:['before','on','after'],//作业类型，分课前、课中和课后三类
        }
    },
    methods:{
        /**
         * @function 监听点击自定义试题按钮，然后向父组件传递点击事件
         */
        onCustomize(){
            this.$emit('customize-question');
        },

        /**
         * @function 监听点击作业类型选项卡，获取类型对应的下标值
         */
        onTabIndex(index){
            this.workTypeIndex = index;
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
    .el-switch{
        margin-right:5px;
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


