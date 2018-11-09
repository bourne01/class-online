<template>
    <div class="add-textbook">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="600px"				
            class="textbook-dialog"
            border
            @close="$emit('close-dialog');textbook={}"
            >
			<div class="textbook-form">
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span class="required">*</span>名称</label>
						<div>
							<el-input v-model="textbook.tbkName"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">编号</label>
						<div>
							<el-input v-model="textbook.tbkNO"></el-input>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span></span>出版社</label>
						<div>
							<el-input v-model="textbook.tbkPress"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">出版日期</label>
						<div>
							<el-date-picker
								v-model="textbook.pubDate"
								type="date"
								placeholder="选择日期"
								value-format="yyyy-MM-dd">
							</el-date-picker>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span></span>作者</label>
						<div>
							<el-input v-model="textbook.tbkAuthor"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span></span>课程大纲</label>
						<div>
							<el-select v-model="textbook.tbkLrnId">
								<el-option v-for="item in syllabusList"
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
						<label for=""><span></span>学级</label>
						<div>
							<el-select v-model="textbook.tbkLrv">
								<el-option v-for="item in levelList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">学科</label>
						<div>
							<el-select v-model="textbook.tbkSub">
								<el-option v-for="item in subjectList"
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
						<label for="">级段</label>
						<div>
							<el-select v-model="textbook.tbkGra">
								<el-option v-for="item in gradeList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span></span>专业</label>
						<div>
							<el-select v-model="textbook.tbkMaj">
								<el-option v-for="item in majorList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
				</el-row>
				<el-row>					
					<el-col>
						<label for="">备注</label>
						<div>
							<el-input type="textarea" v-model="textbook.remark"></el-input>
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
			textbook:{},//学期对象
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
					this.textbook = JSON.parse(JSON.stringify(this.curTextbook));
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
				tbkName:this.textbook.tbkName,
				tbkNO:this.textbook.tbkNO,
				tbkPress:this.textbook.tbkPress,
				tbkAuthor:this.textbook.tbkAuthor,
				pubDate:this.textbook.pubDate,
				tbkLrnId:this.textbook.tbkLrnId,
				tbkSub:this.textbook.tbkSub,
				tbkLrv:this.textbook.tbkLrv,
				tbkGra:this.textbook.tbkGra,
				tbkMaj:this.textbook.tbkMaj,
				remark:this.textbook.remark
			}
			let action = addTextbook;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editTextbook;
				params.tbkId = this.textbook.tbkId;
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
			this.textbook = {};
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
    .textbook-form{
		width:520px;
		margin:25px auto;		
	}
	.textbook-form label{
		margin-bottom:5px;
		display:inline-block;
	}
	.textbook-form .el-row{
		margin-bottom:15px;
	}	
	.textbook-form .required{
		color:red;
		margin-right:2px;
	}
	.textbook-dialog .el-select,
    .textbook-dialog .el-input,
    .textbook-dialog .el-range-editor,
	.textbook-dialog .el-input-number,
	.textbook-dialog .el-radio-group{
		width:100%;
	}
	.textbook-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .add-textbook .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-textbook .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-textbook .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-textbook .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
	.add-textbook .el-input__inner,
	.add-textbook .el-textarea__inner{
		background-color:#f1f1f1;
	}
</style>

