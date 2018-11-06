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
							<el-select v-model="textbookContent.tbkGra" placeholder="请选择教材">
								<el-option v-for="item in gradeList"
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
						<label for="">章节类别</label>
						<div>
							<el-select v-model="textbookContent.tbkSecTp">
								<el-option v-for="item in levelList"
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
								<el-option v-for="item in levelList"
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
import { addTextbook, editTextbook, getCourseSyllabus } from '../../../api/course/course';
import { getCodeList } from '../../../api/base/system';
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增教材',
			textbookContent:{},//学期对象
			subjectList:[],//学科列表
			majorList:[],//专业列表
			levelList:[],//学级列表
			gradeList:[],//级段列表
			subjectList:[],//学科列表
		}
	},
	computed:{
		...mapState('base',{curTextbook:state => state.curRow}),		
		isShow:{
			get:function(){
				/**获取学科列表 */
				getCodeList({cp:2,rp:1})
					.then(res => {
						this.subjectList = res.data.dataList;
					})
				/**获取专业列表 */
				getCodeList({cp:3,rp:1})
					.then(res => {
						this.majorList = res.data.dataList;
					})
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
				/**获取课程大纲列表 */
				getCourseSyllabus()
					.then(res => {
						console.log(res)
						if(res.data.s){
							this.syllabusList = res.data.d;
						}
					})
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑教材";
					this.textbook-content = JSON.parse(JSON.stringify(this.curTextbook));
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
				tbkName:this.textbookContent.tbkName,
				tbkNO:this.textbookContent.tbkNO,
				tbkPress:this.textbookContent.tbkPress,
				tbkAuthor:this.textbookContent.tbkAuthor,
				pubDate:this.textbookContent.pubDate,
				tbkLrnId:this.textbookContent.tbkLrnId,
				tbkSub:this.textbookContent.tbkSub,
				tbkLrv:this.textbookContent.tbkLrv,
				tbkGra:this.textbookContent.tbkGra,
				tbkMaj:this.textbookContent.tbkMaj,
				remark:this.textbookContent.remark
			}
			let action = addTextbook;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editTextbook;
				params.tbkId = this.textbookContent.tbkId;
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
			this.textbook-content = {};
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
		width:520px;
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

