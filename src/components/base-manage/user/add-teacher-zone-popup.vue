<template>
    <div class="add-teacher">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="700px"				
            class="teacher-dialog"
            border
            @close="$emit('close-dialog');"
            >
			<div class="teacher-form">
				<el-row :gutter="20">					
					<el-col :span="12">
						<label for="">姓名</label>
						<div>
							<el-input v-model="teacher.thrNm"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">性别</label>
						<div class="gender">
							<el-radio-group v-model="teacher.thrSex">
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
							<el-input v-model="teacher.spaNm"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">会员</label>
						<div>
							<el-select v-model="teacher.memId">
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
							<el-select v-model="teacher.schId">
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
							<el-select v-model="teacher.depId">
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
						<label for="">入教时间</label>
						<div>
							<el-date-picker
								v-model="teacher.thrTime"
								type="date"
								placeholder="选择日期"
								value-format="yyyy-MM-dd">
							</el-date-picker>
						</div>		
					</el-col>
					<el-col :span="12">
						<label for="">职称</label>
						<div>
							<el-input v-model="teacher.jobLv"></el-input>
						</div>
					</el-col>					
				</el-row>
				<el-row :gutter="20">
					<el-col>
						<label for="">自我介绍</label>
						<div>
							<el-input type="textarea" v-model="teacher.myself"></el-input>
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
import { addTeacherZone, editTeacherZone, getVips } from '../../../api/zone/zone.js'
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增教师',
			coverUrl:'',
			vipList:[],
			depList:[],
			campusList:[],
			teacher:{//教师对象
				thr:'女',
				},
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
					this.title = "编辑会员";
					this.teacher = JSON.parse(JSON.stringify(this.curTeacher));
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
				memId:this.teacher.memId,
				thrNm:this.teacher.thrNm,
				thrSex:this.teacher.thrSex,
				thrTime:this.teacher.thrTime,
				schId:this.teacher.schId,
				depId:this.teacher.depId,
				spaNm:this.teacher.spaNm,
				myself:this.teacher.myself,
				jobLv:this.teacher.jobLv,
			}

            let action = addTeacherZone;
            if(this.isEdit){
                action = editTeacherZone;
                params.thrId = this.curTeacher.thrId;
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
    .teacher-form{
		width:620px;
		margin:25px auto;		
	}
	.teacher-form label{
		margin-bottom:5px;
		display:inline-block;
	}
	.teacher-form .el-row{
		margin-bottom:15px;
	}	
	.teacher-form .required{
		color:red;
		margin-right:2px;
	}	
	.basic-info>div{
		margin-bottom:5px;
	}
	.teacher-form .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
	.teacher-form .el-radio-group {
		line-height: 40px;
		height: 40px;}
	.teacher-form .avatar-uploader-icon{
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}
	.teacher-dialog .el-select,
    .teacher-dialog .el-input,
    .teacher-dialog .el-range-editor,
	.teacher-dialog .el-input-number,
	.teacher-dialog .el-radio-group{
		width:100%;
	}
	.teacher-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
	.add-teacher .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
	.add-teacher ..el-radio-group{
		display: inline;
	}
	.add-teacher .el-radio-group label{
		margin-bottom:0!important;
	}
  	.add-teacher .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-teacher .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-teacher .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-teacher .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
	.add-teacher .el-input__inner,
	.add-teacher .el-textarea__inner{
		background-color:#f1f1f1;
	}
</style>

