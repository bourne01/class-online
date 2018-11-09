<template>
    <div class="add-textbook-content">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="500px"				
            class="textbook-content-dialog"
            border
            @close="$emit('close-dialog')"
            >
			<div class="textbook-content-form">
				<el-row :gutter="20">
					<el-col>
						<label for=""><span class="required">*</span>教材</label>
						<div>
							<el-select v-model="textbookContent.tbkId" placeholder="请选择教材">
								<el-option v-for="item in textbookList"
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
						<label for=""><span class="required">*</span>章节名称</label>
						<div>
							<el-input v-model="textbookContent.tbkSecNm"></el-input>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col>
						<label for="">父节点</label>
						<div>
							<el-select v-model="textbookContent.fatherId">
								<el-option v-for="item in textbookContentList"
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
						<label for="">章节类别</label>
						<div>
							<el-select v-model="textbookContent.tbkSecTp">
								<el-option v-for="item in chapterSectionTypes"
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
						<label for="">章节顺序</label>
						<div>
							<el-input v-model="textbookContent.order"></el-input>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col>
						<label for="">教材大纲</label>
						<div>
							<el-select v-model="textbookContent.knoId">
								<el-option v-for="item in syllabusList"
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
import { addTextbook, editTextbook, getCourseSyllabus, getTextbooks, getTextbookContents, addTextbookContent, editTextbookContent } from '../../../api/course/course';
import { getCodeList } from '../../../api/base/system';
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增教材',
			textbookContent:{},//教材目录对象
			textbookContentList:{},//教材目录列表
			textbookList:[],//教材列表
			syllabusList:[],//大纲列表
			chapterSectionTypes:[
					{id:1,name:'章'},
					{id:2,name:'节'},
					{id:3,name:'点'},
					]
		}
	},
	computed:{
		...mapState('base',{curTextbook:state => state.curRow}),		
		isShow:{
			get:function(){
				/**获取教材列表 */
				getTextbooks()
					.then(res => {
						let tmp = JSON.stringify(res.data.d).replace(/tbkId/g,'id');
						this.textbookList = JSON.parse(tmp.replace(/tbkName/g,'name'));
					})
				/**获取教材目录列表 */
				getTextbookContents()
					.then(res => {
						let tmp = JSON.stringify(res.data.d).replace(/tbkSecId/g,'id');
						this.textbookContentList = JSON.parse(tmp.replace(/tbkSecNm/g,'name'));
					})
				/**获取课程大纲列表 */
				getCourseSyllabus()
					.then(res => {
						console.log(res)
						if(res.data.s){
							let tmp = JSON.stringify(res.data.d).replace(/lrnId/g,'id');
							this.syllabusList = JSON.parse(tmp.replace(/lrnName/g,'name'));
						}
					})
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑教材";
					this.textbookContent = JSON.parse(JSON.stringify(this.curTextbook));
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
				tbkId:this.textbookContent.tbkId,
				tbkSecNm:this.textbookContent.tbkSecNm,
				tbkSecTp:this.textbookContent.tbkSecTp,
				fatherId:this.textbookContent.fatherId,
				order:this.textbookContent.order,
				knoId:this.textbookContent.knoId,
				tbkSub:this.textbookContent.tbkSub,
			}
			let action = addTextbookContent;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editTextbookContent;
				params.tbkSecId = this.textbookContent.tbkSecId;
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
			this.textbookContent = {};
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
    .textbook-content-form{
		width:420px;
		margin:25px auto;		
	}
	.textbook-content-form label{
		margin-bottom:5px;
		display:inline-block;
	}
	.textbook-content-form .el-row{
		margin-bottom:15px;
	}	
	.textbook-content-form .required{
		color:red;
		margin-right:2px;
	}
	.textbook-content-dialog .el-select,
    .textbook-content-dialog .el-input,
    .textbook-content-dialog .el-range-editor,
	.textbook-content-dialog .el-input-number,
	.textbook-content-dialog .el-radio-group{
		width:100%;
	}
	.textbook-content-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .add-textbook-content .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-textbook-content .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-textbook-content .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-textbook-content .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
	.add-textbook-content .el-input__inner,
	.add-textbook-content .el-textarea__inner{
		background-color:#f1f1f1;
	}
</style>

