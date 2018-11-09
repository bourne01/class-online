<template>
    <div class="add-student">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="700px"				
            class="student-dialog"
            border
            @close="$emit('close-dialog');"
            >
			<div class="student-form">
				<el-row :gutter="20">					
					<el-col :span="12">
						<label for="">姓名</label>
						<div>
							<el-input v-model="student.stuNm"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">性别</label>
						<div class="gender">
							<el-radio-group v-model="student.stuSex">
								<el-radio :label="'男'">男</el-radio>
								<el-radio :label="'女'">女</el-radio>
							</el-radio-group>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">					
					<el-col :span="12">
						<label for=""><span class="required">*</span>空间名称</label>
						<div>
							<el-input v-model="student.spaNm"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">会员</label>
						<div>
							<el-select v-model="student.memId">
								<el-option v-for="item in vipList"
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
						<label for="">学校</label>
						<div>
							<el-select v-model="student.schId">
								<el-option v-for="item in campusList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">部门</label>
						<div>
							<el-select v-model="student.depId">
								<el-option v-for="item in depList"
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
						<label for="">学号</label>
						<div>
							<el-input v-model="student.stuNO"></el-input>
						</div>		
					</el-col>
					<el-col :span="12">
						<label for="">专业</label>
						<div>
							<el-input v-model="student.major"></el-input>
						</div>
					</el-col>					
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for="">年级</label>
						<div>
							<el-select v-model="student.year">
								<el-option v-for="item in gradeList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>		
					</el-col>
					<el-col :span="12">
						<label for="">班级</label>
						<div>
							<el-select v-model="student.claId">
								<el-option v-for="item in classList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>					
				</el-row>
				<el-row :gutter="20">
					<el-col>
						<label for="">自我介绍</label>
						<div>
							<el-input type="textarea" v-model="student.myself"></el-input>
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
import { addTeacherZone, editTeacherZone, addStudentZone, editStudentZone, getVips } from '../../../api/zone/zone.js'
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增学生',
			coverUrl:'',
			vipList:[],
			depList:[],
			campusList:[],
			student:{
				stuSex:'女',
			},//会员对象
		}
	},
	computed:{
		...mapState('base',{curTeacher:state => state.curRow}),		
		isShow:{
			get:function(){		
				/**获取会员列表 */
				getVips().then(res => {
					let tmp = JSON.stringify(res.data.d).replace(/memId/g,'id');
					this.vipList = JSON.parse(tmp.replace(/memNm/g,'name'))
				})		
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑学生";
					this.student = JSON.parse(JSON.stringify(this.curTeacher));
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
				memId:this.student.memId,
				stuNm:this.student.stuNm,
				stuSex:this.student.stuSex,
				schId:this.student.schId,
				depId:this.student.depId,
				spaNm:this.student.spaNm,
				myself:this.student.myself,
				major:this.student.major,
				year:this.student.year,
				claId:this.student.claId,
				stuNO:this.student.stuNO,
			}

            let action = addStudentZone;
            if(this.isEdit){
                action = editStudentZone;
                params.stuId = this.curTeacher.stuId;
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
    .student-form{
		width:620px;
		margin:25px auto;		
	}
	.student-form label{
		margin-bottom:5px;
		display:inline-block;
	}
	.student-form .el-row{
		margin-bottom:15px;
	}	
	.student-form .required{
		color:red;
		margin-right:2px;
	}	
	.basic-info>div{
		margin-bottom:5px;
	}
	.student-form .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
	.student-form .el-radio-group {
		line-height: 40px;
		height: 40px;}
	.student-form .avatar-uploader-icon{
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}
	.student-dialog .el-select,
    .student-dialog .el-input,
    .student-dialog .el-range-editor,
	.student-dialog .el-input-number,
	.student-dialog .el-radio-group{
		width:100%;
	}
	.student-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
	.add-student .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
	.add-student ..el-radio-group{
		display: inline;
	}
	.add-student .el-radio-group label{
		margin-bottom:0!important;
	}
  	.add-student .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-student .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-student .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-student .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
	.add-student .el-input__inner,
	.add-student .el-textarea__inner{
		background-color:#f1f1f1;
	}
</style>

