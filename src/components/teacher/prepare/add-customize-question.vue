<template>
    <el-dialog
        :visible.sync="isPop"
        width="930px"
        :modal-append-to-body="false"    
        @close="onClose"        
        class="add-question-dialog">
        <header slot="title">
            <span>自定义试题</span>
            <div class="banner-bg"></div>
        </header>
        <section>
            <el-row :gutter="20">
                <el-col :span="12">
                    <label for="" style="margin-bottom:10px;">我的分类</label>
                    <el-select class="type" placeholder="请选择知识点" v-model="keyPoint">
                        <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                        </el-option>
                    </el-select>
                </el-col>
                <el-col :span="12">
                    <label for="">新建类目</label>
                    <!-- <el-input class="type" v-model="type">
                        <span slot="prepend" v-if="true">{{type}}</span>
                    </el-input> -->
                    <div class="new-category">
                        <el-tag
                            :key="tag"
                            v-for="tag in newCategoryTags"
                            closable
                            :disable-transitions="false"
                            @close="handleClose(tag)">
                            {{tag}}
                        </el-tag>
                        <el-input
                            class="input-new-tag"
                            v-if="inputVisible"
                            v-model="inputValue"
                            ref="saveTagInput"
                            size="small"
                            @keyup.enter.native="handleInputConfirm"
                            @blur="handleInputConfirm"
                        >
                        </el-input>
                        <el-button v-else class="button-new-tag" size="small" @click="showInput">+ 新建</el-button>
                    </div>                    
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
                <!-- <quill-editor></quill-editor> -->
                <el-input type="textarea" placeholder="请输入..." class="question-content"></el-input>               
            </el-row>
            <el-row>
                <label for="">选项管理</label>
                <ul class="question-item-wrapper" @mouseout="onMouseout">
                    <li class="question-item" v-for="(item,idx) in questionItems" :key="idx">
                        <el-input v-if="itemNameIndex===idx" class="item-index" v-model="item.name"></el-input>
                        <span class="item-index" v-else @click="itemNameIndex=idx">{{item.name}}</span>
                        <el-input v-if="itemContentIndex===idx" class="item-content item-content-input" v-model="item.content"></el-input>
                        <span class="item-content" v-else @click="itemContentIndex=idx">{{item.content}}</span>
                        <el-button type="text" icon="el-icon-close" @click="removeItem(idx)"></el-button>
                    </li>             
                    <li class="add-item">
                        <el-button icon="el-icon-plus" type="text" @click="addItem">增加选项</el-button>
                    </li>       
                </ul>
            </el-row>
            <el-row>
                <label for="">正确答案</label>
                <div class="reference-answer">
                    <el-button 
                    v-for="(item,idx) in questionItems" :key="idx"
                    @click="refAnswer=item.name"
                    >{{item.name}}</el-button>
                </div>
            </el-row>
        </section>
        <footer>
            <button @click="onSubmit()">确定添加题目</button>
        </footer>
    </el-dialog>
</template>

<script>
/* import QuillEditor from '../../../components/common/quill-editor' */
export default {
    props:['is-pop'],
    components:{
        /* QuillEditor */
    },
    data(){
        return{
            selectedList:[],//答案选择列表
            type:'',
            newCategoryTags: [],
            inputVisible: false,
            inputValue: '',
            itemNameIndex:-1,
            itemContentIndex:-1,
            questionItems:[
                /* {name:'A',content:'我是张三'},
                {name:'B',content:'我是李四'},
                {name:'C',content:'我是王五'},
                {name:'D',content:'我是赵六'}, */],
            refAnswer:'',//参考答案
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
        },

        /**@function 鼠标离开选项区域，就退出编辑状态 */
        onMouseout(){
            this.itemNameIndex = -1;
            this.itemContentIndex = -1;
        },

        /**@function 关闭标签 */
        handleClose(tag) {
            this.newCategoryTags.splice(this.newCategoryTags.indexOf(tag), 1);
        },

        /**@function 点击新建按钮后，变成输入框 */
        showInput() {
            this.inputVisible = true;
            this.$nextTick(_ => {
            this.$refs.saveTagInput.$refs.input.focus();
            });
        },

        /**@function 监听键盘回车键，确定输入 */
        handleInputConfirm() {
            let inputValue = this.inputValue;
            if (inputValue) {
            this.newCategoryTags.push(inputValue);
            }
            this.inputVisible = false;
            this.inputValue = '';
        },

        /**
         * @function 监听删除选项事件，删除相应的选项
         * @param {选项序号} index 
         */
        removeItem(index){
            this.questionItems.splice(index,1);
        },

        /**
         * @function 监听添加选项事件
         */
        addItem(){
            if(this.questionItems.length > 8){
                this.$message.warning('选项数量不能超过8个');
                return;
            }
            this.questionItems.push({name:'A',content:'我是A选项内容'});
        },
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
    .add-question-dialog .el-textarea__inner{
        background-color:#f1f1f1;
        height:122px;
    }
    .item-index .el-input__inner,
    .item-content .el-input__inner{
        height:44px;
        line-height: 44px;
        padding-top:0;
        padding-bottom:0;
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
    .new-category{
        height: 40px;
        /* line-height: 40px; */
        background-color:#f1f1f1;
        border-radius: 4px;
        box-sizing: border-box;
        border: 1px solid #dcdfe6;
        padding: 3px 15px;
        margin-top:10px;
        
    }
    .el-tag + .el-tag {
        margin-left: 10px;
    }
    .button-new-tag {
        margin-left: 10px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
    .input-new-tag {
        width: 90px;
        margin-left: 10px;
        vertical-align: bottom;
    }
    .answer{
        height:72px;
        line-height:72px;
        border:1px solid #ccc;
        border-top:none;
        padding-left:30px;
        color:#262729;
    }    
    .question-content{
        margin-top:10px;    
        margin-bottom:30px;    
    }
    .question-item-wrapper{
        margin-top:20px;
    }    
    .question-item{
        display:flex;
        margin-bottom:10px;
    }    
    .question-item>span{
        background-color:#f4f4f4;
        border-radius:2px;
        /* display:inline-block; */
        height:44px;
        line-height:44px;
        
    }
    .item-index{
        width:76px;
        text-align:center;
        margin-right:4px;        
    }
    .item-content{
        padding-left:22px;
        width:502px;
        box-sizing:border-box;
        margin-right:4px;
    }
    .item-content-input{
        padding-left:0;
    }
    .reference-answer{
        margin-top:20px;
    }
    .reference-answer .el-button{
        height:44px;
        line-height:44px;
        padding:0;
        width:76px;
    }
    .add-item{
        border-radius:4px;
        border:2px dashed #D4D4D4;
        width:582px;
        height:44px;  
        line-height:44px;  
        text-align:center;        
        box-sizing:border-box;
    }
    .add-item .el-button{
        color:#ACADB0;
        font-size:16px;
    }
    /* .answer span{
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
    }  */
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


