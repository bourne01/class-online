<template>
    <div class="addcourse-content">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="600px"				
            class="course-content-dialog"
            border
            @close="$emit('close-dialog')"
            >
			<div class="course-content-form">
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span class="required">*</span>名称</label>
						<div>
							<el-input v-model="courseContent.couSecNm"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span class="required">*</span>类别</label>
						<div>
							<el-select v-model="courseContent.couSecTp">
								<el-option v-for="item in typeList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span class="required">*</span>课程名称</label>
						<div>
							<el-select v-model="courseContent.couId">
								<el-option v-for="item in courseList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">父章节</label>
						<div>
							<el-select v-model="courseContent.fatherId">
								<el-option v-for="item in courseContentList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span></span>章节顺序</label>
						<div>
							<el-input v-model="courseContent.order"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span></span>知识点</label>
						<div>
							<el-select v-model="courseContent.knoId">
								<el-option v-for="item in knowledagePointList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
				</el-row>				
				<el-row>
					<el-col style="text-align:center;margin-top:15px;">
						<el-button class="confirm" @click="confirm">确定</el-button>
					</el-col>
				</el-row>
			</div>
        </el-dialog>   
    </div>
</template>

<script>
import { xhrErrHandler } from '../../../utils/util';
import { mapActions, mapState } from 'vuex';
import { addCourseContent, editCourseContent, getKnowledgePoints, getCourseContents, getCourses } from '../../../api/course/course';
import { getCodeList } from '../../../api/base/system';
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增课程目录',
			courseContent:{},//当前目录对象
			courseContentList:[],//课程目录列表
			knowledagePointList:[],//知识点列表
			courseList:[],//课程列表
			typeList:[
				{id:1,name:'章'},
				{id:2,name:'节'},
				{id:3,name:'点'},
			],//章节类别 1章 2节 3点
		}
	},
	computed:{
		...mapState('base',{curCourseContent:state => state.curRow}),		
		isShow:{
			get:function(){
				/**获取知识点列表 */
				getKnowledgePoints()
					.then(res => {
						let tmp = JSON.stringify(res.data.d).replace(/knoId/g,'id');
						this.knowledagePointList = JSON.parse(tmp.replace(/knoName/g,'name'));
					});
				/**获取课程目录列表 */
				getCourseContents('couSec!.query.action',{})
					.then(res => {
						let tmp = JSON.stringify(res.data.d).replace(/couSecId/g,'id');
						this.courseList = JSON.parse(tmp.replace(/couSecNm/g,'name'));
					});
				/**获取课程目录 */
				getCourses('cou!query.action',{})
					.then(res => {
						let tmp = JSON.stringify(res.data.d).replace(/couId/g,'id');
						this.courseList = JSON.parse(tmp.replace(/couTitle/g,'name'));
					})
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑课程目录";
					this.courseContent = JSON.parse(JSON.stringify(this.curCourseContent));
				}
				return this.isPop;
			},
			set:function(val){}
		}
	},
	methods:{
		/**
		 * @function 监听确定按钮事件，执行新增或修改班级信息
		 */
		confirm(){
			let params = {
				knoId:this.courseContent.knoId,
				tbkSecId:this.courseContent.tbkSecId,
				fatherId:this.courseContent.fatherId,
				couSecNm:this.courseContent.couSecNm,
				couSecTp:this.courseContent.couSecTp,
				couId:this.courseContent.couId,
				order:this.courseContent.order,
			}
			let action = addCourseContent;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editCourseContent;
				params.couSecId = this.courseContent.couSecId;
			}
			action(params)
				.then(res => {
					if(res.data.s){
						this.$message.success('操作成功！')
						this.$root.bus.$emit('update-table');//通知学期表格组件刷新表格内容
					}else{
						this.$message.error(res.data.m)
					}/* else{
						this.$message.error('发生未知错误，请联系管理员！')
					} */
				})
				.catch(err => {
					xhrErrHandler(err,this.$router,this.$message);
				})
			this.courseContent = {};
			this.$emit('close-dialog');
		},
		/* ...mapActions('student',['getTerm']) */
	},
	created(){
		
	},
	mounted(){
	}
  };
</script>



<style scoped>
    .course-content-form{
		width:520px;
		margin:25px auto;		
	}
	.course-content-form label{
		margin-bottom:5px;
		display:inline-block;
	}
	.course-content-form .el-row{
		margin-bottom:15px;
	}	
	.course-content-form .required{
		color:red;
		margin-right:2px;
	}
	.course-content-dialog .el-select,
    .course-content-dialog .el-input,
    .course-content-dialog .el-range-editor,
	.course-content-dialog .el-input-number,
	.course-content-dialog .el-radio-group{
		width:100%;
	}
	.course-content-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .addcourse-content .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.addcourse-content .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.addcourse-content .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.addcourse-content .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
	.addcourse-content .el-input__inner,
	.addcourse-content .el-textarea__inner{
		background-color:#f1f1f1;
	}
</style>

