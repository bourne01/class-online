<template>
    <div style="background-color:#f1f1f1;">
        <article>         
            <section class="course-info">
                <header>
                    <el-radio-group v-model="course.kkType">
                        <el-radio :label="1">公开课</el-radio>
                        <el-radio :label="2">任务课</el-radio>
                    </el-radio-group>
                </header>
                <div class="main">
                    <div class="course-type">
                        <label for=""><!-- <span>*</span> -->课程教材</label>                        
                        <el-row :gutter="40">
                            <el-col :span="12">
                                <el-select v-model="course.lrnId" placeholder="请选择课程大纲">
                                    <el-option v-for="item in syllabusList"
                                        :label="item.name"
                                        :value="item.id"
                                        :key="item.id"></el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="12">
                                <el-row :gutter="20">
                                    <el-col :span="12">
                                        <el-select v-model="course.tbkId" placeholder="请选择课程教材">
                                            <el-option v-for="item in textbookList "
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                        </el-select>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-select v-model="course.gradeName" placeholder="请选择知识点">
                                            <el-option v-for="item in knowledgePointList "
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                            </el-select>
                                    </el-col>
                                </el-row>
                            </el-col>
                        </el-row>                    
                    </div>
                    <div class="course-type">
                        <label for=""><!-- <span>*</span> -->课程归类</label>                        
                        <el-row :gutter="40">
                            
                            <el-col :span="12">
                                <el-row :gutter="20">
                                    <el-col :span="12">
                                        <el-select v-model="course.couLrv" placeholder="请选择学级">
                                            <el-option v-for="item in levelList"
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                            </el-select>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-select v-model="course.couGra" placeholder="请选择级段">
                                            <el-option v-for="item in gradeList"
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                            </el-select>
                                    </el-col>
                                </el-row>
                            </el-col>
                            <el-col :span="12">
                                <el-row :gutter="20">
                                    <el-col :span="12">
                                        <el-select v-model="course.couSub" placeholder="请选择学科">
                                            <el-option v-for="item in subjectList"
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                        </el-select>
                                    </el-col>
                                    <el-col :span="12">
                                        <el-select v-model="course.couType" placeholder="请选择课程类型">
                                            <el-option v-for="item in courseTypeList"
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                        </el-select>
                                    </el-col>
                                </el-row>                                
                            </el-col>
                        </el-row>                    
                    </div>
                    <div class="course-name">
                        <label for=""><span>*</span>课程名称</label>
                        <div style="display:inline-block">
                            <el-input 
                                v-model="course.couTitle"
                                placeholder="请输入课程名称"></el-input></div>                
                    </div>             
                    <div class="course-label">
                        <label for=""><!-- <span>*</span> -->添加关键字</label>
                        <div>
                            <el-input 
                                v-model="course.keyword"
                                placeholder="请输入课程关键字"></el-input></div>                
                    </div>             
                    <div class="course-label">
                        <label for="">课程难度</label>
                        <el-row>
                            <el-col :span="12">
                                <el-row :gutter="20">
                                    <el-col :span="12">
                                        <el-select 
                                            v-model="course.couLevel" placeholder="请选择课程难度"
                                            @change="onChange('difficult')">
                                            <el-option v-for="item in courseDifficultyList"
                                                :label="item.name"
                                                :value="item.id"
                                                :key="item.id"></el-option>
                                        </el-select>
                                    </el-col>  
                                    <el-col :span="12">
                                        <el-input v-model="course.couPoint">11</el-input>
                                    </el-col>  
                                </el-row> 
                            </el-col>
                            
                        </el-row> 
                    </div>                                 
                    <div class="course-intro">
                        <label for=""><!-- <span>*</span> -->课程简介</label>
                        <!-- <quill-editor></quill-editor> -->
                        <div>
                            <el-input type="textarea" v-model="course.couBrief"></el-input>
                        </div>
                    </div>
                </div>                
            </section>
            <!-- <section class="herald">
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
            </section> -->
            <section class="cover">
                <header>上传封面
                        <span>最多上传/导入3个视频，单个视频不超过500M，视频作品将会展示在作品队列首位</span>
                </header>
                <el-upload
                    ref="upload"
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
                <!-- <div class="teacher">
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
                    </div> -->
                <div class="publish-btn">
                    <button @click="createCourse">发布课程</button>
                    <!-- <add-student :is-pop="isPop" @dialog-close="onDialogClose"></add-student> -->                        
                </div>
            </section>
            <!-- <section class="more">
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
                    </div>
                </div> 
            </section>-->
            <!-- <my-dialog 
                :is-pop="isPop" 
                :type="type" 
                @dialog-close="onDialogClose"
                :current-list="JSON.stringify(currentList)"
                @selected="onDialogConfirm"></my-dialog> -->
               
        </article>
    </div>
    
</template>

<script>
/* import AddStudent from './add-student'
import QuillEditor from '../../../../components/common/quill-editor'
import MyDialog from './my-dialog' */
import { getCourseSyllabus,getKnowledgePoints,getTextbooks, addCourse
        } from '../../../../api/course/course.js'
import { getCodeList } from '../../../../api/base/system.js'
import { mapState } from 'vuex';
import { xhrErrHandler } from '../../../../utils/util.js';
export default {
    components:{
       /*  AddStudent,
        QuillEditor,
        MyDialog */
    },
    data(){
        return{            
            syllabusList:[],//大纲列表
            textbookList:[],//教材列表
            knowledgePointList:[],//知识点列表
            levelList:[],//学级列表
            gradeList:[],//级段列表
            subjectList:[],//学科列表
            courseTypeList:[
                {id:1,name:'文化基础'},
                {id:9,name:'兴趣拓展'},
                ],//课程类型列表
            courseDifficultyList:[//课程难度列表
                {id:10,name:'容易'},
                {id:20,name:'普通'},
                {id:30,name:'较难'},
                {id:40,name:'困难'},
                {id:50,name:'特难'},
                ],
            /*heraldList: [ {
                name: 'food.jpeg',
                url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
            } ],*/
            isPop:false,
            isEdit:false,//当前是不是编辑课程模式
            course:{//课程对象
                 kkType:2,
            },//课程对象
            coverUrl:'',//封面文件url
            /* dialogVisible:false,
            avatarUrl:'',
            hoverIdx:-1,//鼠标悬停于哪个教师头像上序号
            teacherList:['a','b'],//被添加的教师列表
            classList:['1','2'],//被添加的学生班级列表
            currentList:[],//当前列表
            type:'', */
        }
    },
    computed:{
        ...mapState('course',{
            curCourse:state => state.currentCourse
        })
    },
    methods:{
        /**
         * @function 监听下拉菜单值改变事件
         * @param {下拉菜单类型：1 difficult,2...} type
         */
        onChange(type){
            this.course.couPoint = this.course.couLevel;
        },
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
            if(!this.course.couTitle){
                this.$message.error('课程名称不能为空');
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
            let uploadForm = new FormData();//表单数据对象
            uploadForm.append('file',file);
            uploadForm.append('couTitle',this.course.couTitle);
            uploadForm.append('keyword',this.course.keyword);
            uploadForm.append('kkType',this.course.kkType);
            uploadForm.append('couType',this.course.couType);
            uploadForm.append('lrnId ',this.course.lrnId);
            uploadForm.append('knoId ',this.course.knoId);
            uploadForm.append('tbkId ',this.course.tbkId);
            uploadForm.append('couSub',this.course.couSub);
            uploadForm.append('couLrv',this.course.couLrv);
            uploadForm.append('couGra',this.course.couGra);
            uploadForm.append('couLevel',this.course.couLevel);
            uploadForm.append('couPoint',this.course.couPoint);
            uploadForm.append('couBrief',this.course.couBrief);


            console.log(uploadForm);
            let action = addCourse;
            if(this.isEdit){
                action = editCourse;
                uploadForm.append('couId',this.curCourse.couId)
            }
            addCourse(uploadForm)
                .then(res => {
                    console.log(res);
                })
                .catch(err => {
                    xhrErrHandler(err,this.$router,this.$message);
                })
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
        /**
         * @function 监听发布课程事件
         */
        createCourse(){
            console.log('fajfaljfla')
            this.checkInputValue();          
            this.$refs.upload.submit();
        }
    },
    created(){
        this.isEdit = this.$route.query.isEdit;
        /**获取课程大纲 */
        getCourseSyllabus()
            .then(res => {
                if(res.data.s){
                    //改变对象属性名称：lrnId-->id,lrnName-->name
                    let tmp = JSON.stringify(res.data.d).replace(/lrnId/g,'id');
                    this.syllabusList = JSON.parse(tmp.replace(/lrnName/g,'name'));
                }else{
                    this.$message.error(res.data.m);
                }
            })
        /**获取课程大纲 */
        getKnowledgePoints()
            .then(res => {
                if(res.data.s){
                    let tmp = JSON.stringify(res.data.d).replace(/knoId/g,'id');
                    this.knowledgePointList = JSON.parse(tmp.replace(/knoName/g,'name'));
                }else{
                    this.$message.error(res.data.m);
                }
            })
        /**获取课程大纲 */
        getTextbooks()
            .then(res => {
                if(res.data.s){
                    let tmp = JSON.stringify(res.data.d).replace(/tbkId/g,'id');
                    this.textbookList = JSON.parse(tmp.replace(/tbkName/g,'name'));
                }else{
                    this.$message.error(res.data.m);
                }
            })
        /**获取学科列表 */
        getCodeList({cp:2,rp:1})
            .then(res => {
                this.subjectList = res.data.dataList;
            })
        /**获取专业列表 */
        /* getCodeList({cp:3,rp:1})
            .then(res => {
                this.majorList = res.data.dataList;
            }) */
        /**获取学级列表 */
        getCodeList({cp:4,rp:1})
            .then(res => {
                this.levelList = res.data.dataList;
            })
        /**获取级段列表 */
        getCodeList({cp:5,rp:1})
            .then(res => {
                this.gradeList = res.data.dataList;
            })
    }
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
    .course-intro .el-textarea__inner{
        background-color:#f1f1f1;
        min-height:100px!important;
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
    .el-radio-group>label{
        margin-bottom:0!important;
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
        width:100%;
        margin-right:20px;
    }
    .course-name{
        left:-4px;
        
    }    
    .course-name>div{
        width:100%;
    }
    .course-label{
        width:100%;
    }
    .course-intro{
        width:100%;
        margin-bottom:0!important;
    }
    .course-intro>label{
        margin-bottom:10px;
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
    .teacher{
        margin-left:40px;
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
        padding-bottom:40px;
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
 