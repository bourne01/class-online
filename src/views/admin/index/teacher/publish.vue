<template>
    <div style="background-color:#f1f1f1;">
        <article>
            <section class="course-info">
                <header>课程信息</header>
                <div class="main">
                    <div class="course-type">
                        <label for=""><span>*</span>课程归类</label>
                        <div>
                            <el-select v-model="course.termName" placeholder="学期">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                            <el-select v-model="course.levelName" placeholder="层次">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                            <el-select v-model="course.gradeName" placeholder="年级">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                            <el-select v-model="course.category" placeholder="学科">
                                <el-option label="区域一" value="shanghai"></el-option>
                                <el-option label="区域二" value="beijing"></el-option>
                            </el-select>
                        </div>
                    
                    </div>
                    <div class="course-name">
                        <label for=""><span>*</span></label>
                        <div style="display:inline-block">
                            <el-input 
                                v-model="course.name"
                                placeholder="请输入课程名称"></el-input></div>                
                    </div>             
                    <div class="course-label">
                        <label for=""><span>*</span>添加课程标签</label>
                        <div>
                            <el-input 
                                v-model="course.label"
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
                    ref="preview"
                    class="upload-herald main"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :auto-upload="false"
                    :on-change="previewHerald"
                    :on-success="onHeraldSuccess"
                    :before-upload="onHeraldBeforeLoad"
                    :file-list="heraldList">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                </el-upload>
            </section>
            <section class="cover">
                <header>上传封面
                     <span>最多上传/导入3个视频，单个视频不超过500M，视频作品将会展示在作品队列首位</span>
                </header>
                <el-upload
                    ref="cover"
                    class="avatar-uploader main "
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false"
                    :auto-upload="false"
                    :on-change="previewCover"
                    :on-success="onCoverSuccess"
                    :before-upload="onCoverBeforeLoad">
                    <img v-if="coverUrl" :src="coverUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </section>
            <section class="more">
                <header>更多信息</header>
                <div class="main">
                    <div class="is-open">
                        <label for="">是否公开</label>
                            <el-radio-group v-model="course.isOpen">
                            <el-radio label="是"></el-radio>
                            <el-radio label="否"></el-radio>
                        </el-radio-group>
                    </div>
                    <div class="student-wrap">
                        <label for="">指定学生</label>
                        <div>
                            <div class="students">
                                <el-button class="_class" v-for="(class_,idx) in classList" :key="idx">
                                    三（2）班<i class="el-icon-close" @click.stop="onCloseClick('class',idx)"></i>
                                </el-button>
                                <el-button @click.stop="onAddClick('class')"><i class="el-icon-plus"></i>增加学生</el-button>
                            </div>
                            <span>非指定学员不可看此课程</span>   
                        </div>                                             
                    </div>
                    <div class="teacher">
                        <label for="">授课教师</label>                        
                        <div class="teacher-wrapper">
                            <div class="teacher-avatar" v-for="idx in teacherList" :key="idx" 
                                @mouseover="hoverIdx=idx" @mouseout="hoverIdx=-1">
                                <img :src="require('../../../../assets/svg/avatar.svg')" alt="">
                                <span>张老师</span>
                                <div class="teacher-delete" v-if="hoverIdx==idx" @click.stop="onCloseClick('teacher',idx)">
                                    <el-button icon="el-icon-delete" ></el-button>
                                </div>
                            </div>
                            <el-button icon="el-icon-plus" @click.stop="onAddClick('teacher')"></el-button>
                        </div>
                    </div>
                    <div class="publish-btn">
                        <button>发布课程</button>
                        <!-- <add-student :is-pop="isPop" @dialog-close="onDialogClose"></add-student> -->                        
                    </div>
                </div>
            </section>
            <my-dialog 
                :is-pop="isPop" 
                :type="type" 
                @dialog-close="onDialogClose"
                :current-list="JSON.stringify(currentList)"
                @selected="onDialogConfirm"></my-dialog>
        </article>
    </div>
    
</template>

<script>
import AddStudent from './add-student'
import QuillEditor from '../../../../components/common/quill-editor'
import MyDialog from './my-dialog'
export default {
    components:{
        AddStudent,
        QuillEditor,
        MyDialog
    },
    data(){
        return{
            form:{},
            uploadForm:new FormData(),//全局表单数据对象
            heraldList: [/* {
                name: 'food.jpeg',
                url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
            } */],
            isPop:false,
            course:{
                name:'',
                label:'',
                termName:'',
                levelName:'',
                gradeName:'',
                category:'',
                intro:'',
                isOpen:false,
                teacherName:'',
                students:[],
            },//课程对象
            coverUrl:'',//封面文件url
            dialogVisible:false,
            avatarUrl:'',
            hoverIdx:-1,//鼠标悬停于哪个教师头像上序号
            teacherList:['a','b'],//被添加的教师列表
            classList:['1','2'],//被添加的学生班级列表
            currentList:[],//当前列表
            type:'',
        }
    },
    methods:{
        /**
         * 监听对话框关闭事件
         */
        onDialogClose(){
            this.isPop = false;
        },
        /**
         * @function 监听选中事件
         */
        onDialogConfirm(){

        },
        /**
         * @function 监听添加教师或班级学生按钮事件
         * @param {类型:teacher,class} type
         */
        onAddClick(type){
            this.type = type;
            this.isPop = true;
        },
        /**
         * @function 监听删除教师或班级学生按钮事件
         * @param {类型:teacher,class} type
         * @param {序号:要删除项在数组中的下标} index
         */
        onCloseClick(type,index){
            if(type === 'teacher'){
                this.teacherList.splice(index,1);
            }else if(type === 'class'){
                this.classList.splice(index,1);
            }
        },
        /**
         * @function 检查输入是否为空
         */
        checkInputValue(){
            if(!course.termName){
                this.$message.error('课程名称不能为空');
                return;
            }
            if(!course.levelName){
                this.$message.error('课程所属的层次不能为空');
                return;
            }
            if(!course.gradeName){
                this.$message.error('课程所属年级不能为空');
                return;
            }
            if(!course.category){
                this.$message.error('课程类别不能为空');
                return;
            }
        },
        /**
         * @function 监听文件上传组件的文件变动事件,处理文件预览
         * @param {}
         */
        previewHerald(file, fileList){
            console.log(file);     
            console.log(fileList)       
        },
        /**
         * @function 监听预告文件上传成功时候
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onHeraldSuccess(response,file, fileList){
            console.log(response);
            console.log(file);     
            console.log(fileList)  
        },
        /**
         * @function 监听文件开始上传前事件
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onHeraldBeforeLoad(file){
            console.log(file);
        },
        /**
         * @function 监听文件上传组件的文件变动事件,处理文件预览
         * @param {}
         */
        previewCover(file, fileList){
            let fileName = file.name;
            let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
            if (regex.test(fileName.toLowerCase())) {
                this.coverUrl = file.url;
            } else {
                this.$message.error('请选择图片文件');
            }  
        },
        /**
         * @function 监听预告文件上传成功时候
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onCoverSuccess(response,file, fileList){
            console.log(response);
            console.log(file);     
            console.log(fileList)  
        },
        /**
         * @function 监听文件开始上传前事件
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onCoverBeforeLoad(file){
            console.log(file);
        },
        /**
         * @function 监听文件上传组件的文件变动事件,处理文件预览
         * @param {}
         */
        previewAvatar(file, fileList){
            let fileName = file.name;
            let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
            if (regex.test(fileName.toLowerCase())) {
                this.avatarUrl = file.url;
            } else {
                this.$message.error('请选择图片文件');
            }       
        },
        /**
         * @function 监听预告文件上传成功时候
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onAvatarSuccess(response,file, fileList){
            console.log(response);
            console.log(file);     
            console.log(fileList)  
        },
        /**
         * @function 监听文件开始上传前事件
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onAvatarBeforeLoad(file){
            console.log(file);
        },
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
    .teacher-avatar .el-upload-list__item{
        width:68px;
        height:68px;
        margin-bottom:0;
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
    .teacher label,
    .teacher .teacher-wrapper{
        float:left;
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
    /* .teacher-avatar{
        display:inline-block;
    }
    .teacher-names{
        padding-top:5px;
        clear:left;
        padding-left:70px;
    }
    .teacher-names>span{
        float:left;
        margin-right:8px;
        width:68px;
        text-align:center;
    } */
    .teacher-wrapper{
        display:flex;
        box-sizing: border-box;
        padding-left: 6px;
        flex-flow: wrap;
    }
    .teacher .el-button{
        height:50px;
        width:50px;
        padding:0;
        font-size:24px;
    }

    .teacher-avatar{
        text-align:center;
        width:50px;
        margin-right:15px;  
        margin-bottom:10px;    
        position: relative;
    }
    .teacher-delete{
        width:50px;
        height:50px;
        position:absolute;
        top:0;
        left:0;
        background:rgba(0,0,0,0.8);
    }
    .teacher-delete .el-button{
        background:transparent;
        color:#f1f1f1;
    }
    .teacher-avatar img{
        height:50px;
        width:50px;
        border-radius:4px;
        margin-bottom:5px;
    }
    .publish-btn{
        clear:both;
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
        background:linear-gradient(to right,#74c756,#28d07e);
        cursor: pointer;
    }
 </style>
 