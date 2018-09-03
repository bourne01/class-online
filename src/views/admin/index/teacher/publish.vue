<template>
    <div style="background-color:#f1f1f1;">
        <article>
            <section class="course-info">
                <header>课程信息</header>
                <div class="main">
                    <div class="course-type">
                        <label for=""><span>*</span>课程归类</label>
                        <div>
                            <el-select v-model="formInline.region" placeholder="学期">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                            <el-select v-model="formInline.region" placeholder="层次">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                            <el-select v-model="formInline.region" placeholder="年级">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                            <el-select v-model="formInline.region" placeholder="学科">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                        </div>
                    
                    </div>
                    <div class="course-name">
                        <label for=""><span>*</span></label>
                        <div style="display:inline-block">
                            <el-input 
                                v-model="formInline.region"
                                placeholder="请输入课程名称"></el-input></div>                
                    </div>             
                    <div class="course-label">
                        <label for=""><span>*</span>添加课程标签</label>
                        <div>
                            <el-input 
                                v-model="formInline.region"
                                placeholder="请输入课程标签"></el-input></div>                
                    </div>             
                    <div class="course-intro">
                        <label for=""><span>*</span>课程简介</label>
                        <quill-editor></quill-editor>
                    </div>
                </div>                
            </section>
            <section class="herald">
                <header>上传预告
                    <span>最多上传/导入3个视频，单个视频不超过500M，视频作品将会展示在作品队列首位</span>
                </header>
                <el-upload
                    class="upload-herald main"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-change="handleChange"
                    :file-list="fileList3">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                </el-upload>
            </section>
            <section class="cover">
                <header>上传封面
                     <span>最多上传/导入3个视频，单个视频不超过500M，视频作品将会展示在作品队列首位</span>
                </header>
                <el-upload
                    class="avatar-uploader main "
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </section>
            <section class="more">
                <header>更多信息</header>
                <div class="main">
                    <div class="is-open">
                        <label for="">是否公开</label>
                        <el-radio-group v-model="form.resource">
                            <el-radio label="是"></el-radio>
                            <el-radio label="否"></el-radio>
                        </el-radio-group>
                    </div>
                    <div class="student-wrap">
                        <label for="">指定学生</label>
                        <div>
                            <div class="students">
                                <el-button class="_class">三（2）班<i class="el-icon-close"></i></el-button>
                                <el-button @click="isPop=true"><i class="el-icon-plus"></i>增加学生</el-button>
                            </div>
                            <span>非指定学员不可看此课程</span>   
                        </div>                                             
                    </div>
                    <div class="teacher">
                        <label for="">授课教师</label>
                        <el-upload
                            action="https://jsonplaceholder.typicode.com/posts/"
                            list-type="picture-card"
                            class="teacher-avatar"
                            :on-preview="handlePictureCardPreview"
                            :on-remove="handleRemove">
                            <i class="el-icon-plus"></i>
                        </el-upload>
                        <el-dialog :visible.sync="dialogVisible">
                            <img width="100%" :src="dialogImageUrl" alt="">
                        </el-dialog>
                    </div>
                    <div class="publish-btn">
                        <button>发布课程</button>
                        <add-student :is-pop="isPop" @dialog-close="onDialogClose"></add-student>
                    </div>
                </div>
            </section>
        </article>
    </div>
    
</template>

<script>
import AddStudent from './add-student'
import QuillEditor from '../../../../components/common/quill-editor'
export default {
    components:{
        AddStudent,
        QuillEditor
    },
    data(){
        return{
            form:{},
            formInline:{},
            fileList3: [{
                name: 'food.jpeg',
                url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                }, {
                name: 'food2.jpeg',
                url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
            }],
            isPop:false,
        }
    },
    methods:{
        /**
         * 监听对话框关闭事件
         */
        onDialogClose(){
            this.isPop = false;
        }
    },
}
</script>
 
 <style>
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }    
    .teacher-avatar .el-upload--picture-card{
        width:68px;
        height:68px;
        line-height:68px;
    }
    .course-info .el-input__inner{
        background-color:#f1f1f1;
    } 
 </style>
 
 <style scoped>
    article{
        width:1000px;
        margin:0 auto;
        padding-top:20px;
        font-size:14px;
    }
    header{
        height: 58px;
        line-height: 58px;
        font-size:14px;
        color:#171a20;
        border-bottom:1px solid #f1f1f1;
        margin-bottom:35px;
        font-weight:bold;
        padding-left:40px;
    }
    header>span{
        font-size:12px;
        font-weight:500;
        margin-left:50px;
        color:#acadb0;
    }
    .course-info{        
        background-color:#fff;
    }
    .main{
        padding:0 40px 30px 40px;
    }
    .course-info .main>div{
        margin-bottom:40px;
        position: relative;
    }
    .course-info label{
        display:inline-block;
        margin-bottom:10px;
        font-size:14px;
        color:#171a20;
    }
    .course-type .el-select{
        width:185px;
        margin-right:20px;
    }
    .course-name{
        left:-4px;
        
    }    
    .course-name>div{
        width:900px;
    }
    .course-label{
        width:800px;
    }
    .course-intro{
        width:906px;
        margin-bottom:0!important;

    }
    .course-intro>label{
        margin-bottom:-4px;
    }
    label span{
        position:absolute;
        left:-15px;
        color:red;
    }
    .course-name label span{
        left:-12px;
    }
    .herald,.cover{
        margin-top:10px;
        background-color:#fff;
    }
    .upload-herald{        
        width:800px;
    }    
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
    .more{
        margin-top:10px;
        background-color:#fff;
    }
    .more header{
        margin-bottom:0;
    }
    .students{
        padding:20px;
        background-color:#f1f1f1;
    }
    .students .el-button{
        font-size:12px;
    }
    .students .el-icon-close{
        margin-left:20px;
    }
    .students .el-icon-close:hover{
        color: #409EFF;
        border-color: #c6e2ff;
        background-color: #ecf5ff;
        cursor: pointer;
    }
    .students .el-icon-plus{
        margin-right:5px;
    }
    ._class:hover{
        background: #fff;
        border: 1px solid #dcdfe6;
        color: #606266;
        cursor:default;
    }
    .more .main>div{margin-top:30px;}
    .more label{
        display:inline-block;
        width:70px;
    }
    .student-wrap{
        display:flex;
    }
    .student-wrap>div{
        display:inline-block;
        width:830px;
    }    
    .student-wrap>div>span{
        font-size:12px;
        font-weight:500;
        margin-left:20px;
        color:#acadb0;
    }
    .student-wrap .students{
        min-height:121px;
    }
    .teacher-avatar{
        display:inline-block;
    }
    .publish-btn button{
        margin-top:20px;
        margin-left:70px;
        height:44px;
        line-height:44px;
        width:155px;
        font-size:18px;
        color:#fff;
        outline:none;
        border:none;
        border-radius:4px;
        background:linear-gradient(to right,#74c756,#28d07e)
    }
 </style>
 