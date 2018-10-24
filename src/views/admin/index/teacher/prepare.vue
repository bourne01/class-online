<template>
    <article>
        <header>
            <tool-bar class="toolbar"></tool-bar>
        </header>
        <lesson class="lesson" :lesson="lesson"></lesson>
        <div class="margin"></div>
            <lesson-work class="lesson-work" 
                @customize-question="isPop=true"
                :lesson-work="lessonWork"></lesson-work>
        <footer>
            <label for="">是否公开</label>
            <!-- <el-radio>是</el-radio>
            <el-radio>否</el-radio> -->
            <el-radio-group v-model="lessonWork.isQuestionOpen">
                <el-radio :label="true">是</el-radio>
                <el-radio :label="false">否</el-radio>
            </el-radio-group>
            <button>提交</button>
        </footer>
        <question-dialog :is-pop="isPop" @dialog-close="onDialog"></question-dialog>
    </article>
</template>

<script>
import ToolBar from '../../../../components/teacher/prepare/toolbar'
import Lesson from '../../../../components/teacher/prepare/lesson'
import LessonWork from '../../../../components/teacher/prepare/lesson-work'
import QuestionDialog from '../../../../components/teacher/prepare/add-customize-question'
export default {
    components:{
        ToolBar,
        Lesson,
        LessonWork,
        QuestionDialog
    },
    data(){
        return{
            isPop:false,
            lesson:{//备课对象
                checkList:[],//知识点列表
                title:'',//备课主题
                label:'',//备课标签
                },
            lessonWork:{//本次备课的学生作业
                isAnswerOpen:false,//作业是否公开
                question:[],//题目对象列表
                isQuestionOpen:false,
            }
        }
    },
    methods:{
        /**监听来自子组件自定义试题对话框的关闭或提交事件 */
        onDialog(){
            this.isPop = false;
            console.log('I M Component Father.');
        }
    },
    created(){
        this.$root.bus.$on('edit-question',(question) => {
            this.isPop = true;
        });
    }
    
}
</script>

<style scoped>
    article{
        background-color:#f1f1f1;
    }
    .toolbar{
        width:1000px;
        margin:0 auto;
    }
    .lesson,.lesson-work{
        width:1000px;
        margin:0 auto;
    }
    .margin{
        padding-bottom:20px;
    }
    footer{
        box-sizing: border-box;
        width:1000px;
        margin:0 auto;
        border-top:1px solid #f1f1f1;
        background-color:#fff;
        padding:40px;
    }
    label{
        margin-right:80px;
    }
    button{
        width:120px;
        height:40px;
        line-height:40px;
        text-align: center;
        outline: none;
        border:none;
        display:block;
        margin-top:40px;
        border-radius: 3px;
        color:#fff;
        font-size:18px;
        background:linear-gradient(to right,#6bc85b,#31cf79);
        cursor: pointer;
    }
</style>


