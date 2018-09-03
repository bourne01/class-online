<template>
    <el-dialog
        :visible.sync="isPop"
        width="930px"
        :center="left"
        :modal-append-to-body="false"    
        @close="onClose"        
        class="add-question-dialog">
        <header slot="title">
            <span>自定义试题</span>
            <div class="banner-bg"></div>
        </header>
        <section>
            <label for="">课程归类</label>
            <el-row :gutter="20">
                <el-col :span="6">
                    <el-select></el-select>
                </el-col>
                <el-col :span="6">
                    <el-select></el-select>
                </el-col>
                <el-col :span="6">
                    <el-select></el-select>
                </el-col>
                <el-col :span="6">
                    <el-select></el-select>
                </el-col>
            </el-row>
            
            <el-row :gutter="20">
                <el-col :span="12">
                    <label for="" style="margin-bottom:10px;">我的分类</label>
                    <el-select class="type"></el-select>
                </el-col>
                <el-col :span="12">
                    <label for="">新建类目</label>
                    <el-input class="type" v-model="type">
                        <span slot="prepend" v-if="true">{{type}}</span>
                    </el-input>
                </el-col>
            </el-row>
            <label for="">标题</label>
            <el-row>
                <el-col>
                    <el-input placeholder="请输入标题"></el-input>
                </el-col>
            </el-row>
            <el-row>
                <label for="">题目内容</label>
                <quill-editor></quill-editor>
                <div class="answer">
                    <label for="">标准答案</label>
                    <span @click="onSelect(0)">
                        <img 
                            :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                            v-if="!selectedList[0]"
                        >
                        <img 
                            :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                            v-else
                        >A
                    </span>  
                    <span @click="onSelect(1)">
                        <img 
                            :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                            v-if="!selectedList[1]"
                        >
                        <img 
                            :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                            v-else
                        >B
                    </span>  
                    <span @click="onSelect(2)">
                        <img 
                            :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                            v-if="!selectedList[2]"
                        >
                        <img 
                            :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                            v-else
                        >C
                    </span>  
                    <span @click="onSelect(3)">
                        <img 
                            :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                            v-if="!selectedList[3]"
                        >
                        <img 
                            :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                            v-else
                        >D
                    </span>  
                </div>
            </el-row>
        </section>
        <footer>
            <button @click="onSubmit()">确定添加学生</button>
        </footer>
    </el-dialog>
</template>

<script>
import QuillEditor from '../../../components/common/quill-editor'
export default {
    props:['is-pop'],
    components:{
        QuillEditor
    },
    data(){
        return{
            selectedList:[],//答案选择列表
            type:'',
        }
    },
    computed:{
        isShow:{
            get:function(){
                return this.isPop;
            },
            set:function(val){
                this.isPop = val;
            }
        }
    },
    methods:{
        /**
         * 监听对话框关闭事件，然后向父组件传递关闭事件
         */
        onClose(){
            this.$emit('dialog-close')
        },
        /**
         * 监听对话框提交事件，然后向父组件传递关闭事件
         */
        onSubmit(){
            this.$emit('dialog-close')
        },
        /**
         * @function 监听答案选择事件
         * @param {index} 答案序号
         */
        onSelect(index){
            this.selectedList = [];
            this.selectedList[index] = true;//第index选项被选中
        }
    }
}
</script>

<style>
    .add-question-dialog .el-dialog__close{
        font-size:18px;
    }
    .add-question-dialog .el-dialog__header{
        padding-bottom:14px;
        border-bottom:1px solid #f1f1f1;
    }
    .add-question-dialog .el-dialog__body{
        padding:0;
    }    
    .add-question-dialog .el-input__inner{
        background-color:#f1f1f1;
    }
</style>

<style scoped>
    .add-question-dialog{
        font-size:18px;        
    }
    header>span{
        color:#2185ff;
    }
    .banner-bg{
        width:930px;
        height:6px;
        background-color:#2185ff;
        position:absolute;
        top:0;
        left:0;        
    }
    section{
        padding:30px 40px 0 40px;
    }
    .el-row{
        margin-top:10px;
        margin-bottom:30px;
    }
    .el-select{
        width:100%;
    }
    .type{
        margin-top:10px;
    }
    .answer{
        height:72px;
        line-height:72px;
        border:1px solid #ccc;
        border-top:none;
        padding-left:30px;
        color:#262729;
    }
    .answer span{
        margin-right:60px;
        font-size:18px;
    }
    .answer label{
        margin-right:30px;
        font-size:12px;
    }
    .answer img{
        width:24px;
        height:24px;
        vertical-align:middle;
        position: relative;
        top:-2px;
    } 
    footer{
        height: 65px;
        line-height: 65px;
        padding:0 20px;
        text-align:right;
        border-top:1px solid #f1f1f1;
    }
    footer button{
        height:32px;
        line-height:32px;
        width:126px;
        font-size:14px;
        border-radius: 3px;
        color:#fff;
        background:linear-gradient(to right,#6bc85b,#31cf79);
        outline:none;
        border:none;
        align-self: center;
        cursor: pointer;
    }
</style>


