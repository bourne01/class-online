<template>
    <article>
        <section>
            <header>
                第二章：第2节 光和色的关系_1
            </header>
            <div class="prepare-knowledge-point">
                <div>请选择知识点备课</div>                
                <el-checkbox-group v-model="checkList" :fill="fill" :text-color='fill'>
                    <ul>
                        <li v-for="idx in 3" :key=idx>
                            <el-checkbox :label="'知识点000'+idx"></el-checkbox>
                        </li>
                    </ul>
                </el-checkbox-group>
            </div>            
            <el-upload
                class="upload"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-change="handleChange"
                :file-list="fileList3">
                <button><i class="el-icon-plus"></i>点击上传课件</button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>    
            <div class="title">
                <span class="star">*</span>
                <label for="">标题</label>
                <el-input>标题</el-input>
            </div>    
            <div class="label">
                <label for="">标签</label>
                <el-input>课程标签</el-input>
            </div>    
        </section>
    </article>
</template>

<script>
export default {
    data(){
        return{
            checkList:[],
            fill:'red'
        }
    }
}
</script>

<style>
    .prepare-knowledge-point .is-checked .el-checkbox__inner{
        background-color:#22cb64;
        border-color:#22cb64;
    }
    .prepare-knowledge-point .is-checked .el-checkbox__label{
        background-color:#22cb64;
        margin-left:10px;
        padding-right:30px;
        color:#171a20;
        font-size:12px;
    }
    .prepare-knowledge-point .el-checkbox__label{
        background-color:#d4d4d4;
        margin-left:10px;
        padding-right:30px;
        color:#171a20;
        font-size:12px;
        border-radius:2px;
    }
    .title .el-input__inner,
    .label .el-input__inner{
        background-color:#f1f1f1;
    }
</style>

<style scoped>
    article{
        background-color:#fff;
    }
    header{
        height:50px;
        line-height:50px;
        font-size:16px;
        color:#585a60;
        padding:0 40px;
        border-bottom:1px solid #f1f1f1;
    }
    .prepare-knowledge-point{
        padding:30px 40px;
    }
    .prepare-knowledge-point>div{
        font-size:12px;
        color:#585a60;
    }
    .prepare-knowledge-point ul{
        margin-top:12px;
    }
    .prepare-knowledge-point li{
        margin-bottom:10px;
    }
    .upload{
        padding:0 40px;
        margin-bottom:20px;
    }
    .el-upload button{
        outline:none;
        border:none;
        background-color:#f1f1f1;
        height:40px;
        line-height:40px;
        width:472px;
        border-radius:20px;
        cursor: pointer;
        font-size:12px;
        color:#585a60;
    }
    i.el-icon-plus{
        color:#2185ff;
        margin-right:5px;
        font-size:14px;        
    }
    .title{
        position:relative;
        padding:0 40px;
        color:#585a60;
    }
    .star{
        position:absolute;
        left:30px;
        color:red;
    }
    .el-input{
        margin-top:10px;
        width:906px;
        display:block;
    }
    .label{
        margin-top:30px;
        padding:0 40px;
        color:#585a60;
        padding-bottom:60px;
    }
</style>
