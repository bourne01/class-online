<template>
    <div class="add-knowledgePoint">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="500px"				
            class="knowledgePoint-dialog"
            border
            @close="$emit('close-dialog');knowledgePoint={}"
            >
            <ul>
				<li>
                    <label for="">名称</label>      
                    <el-input v-model="knowledgePoint.knoName"></el-input>
                </li>
                <li>
                    <label for="">课程大纲</label>
                    <el-select v-model="knowledgePoint.lrnId">
						<el-option v-for="item in syllabusList"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li>
                <li>
                    <label for="">父节点</label>
                    <el-select v-model="knowledgePoint.fatherId">
						<el-option v-for="item in knowledgePointList"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li>
                <!-- <li>
                    <label for="">类型</label>
                    <el-select v-model="knowledgePoint.knoType">
						<el-option v-for="item in knowledgePointTypes"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li> -->
                
				<li>
                    <label for="">顺序</label>					
                    <el-input-number v-model="knowledgePoint.order" :min="1" :max="30"></el-input-number>
                </li>				
                <li>
                    <el-button class="confirm" @click="confirm">确定</el-button>
                </li>
            </ul>
        </el-dialog>   
    </div>
</template>

<script>
import { xhrErrHandler } from '../../../utils/util';
import { mapActions, mapState } from 'vuex';
import { addTerm, editTerm,getTerm } from '../../../api/base/dean.js'
import { addKnowledgePoint, editKnowledgePoint, 
		getCourseSyllabus, getKnowledgePoints } from '../../../api/course/course';
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增知识点',
			knowledgePoint:{},//知识点对象
			syllabusList:[],//课程大纲列表
			knowledgePointList:[],//课程大纲列表
			knowledgePointTypes:[],//知识点类型列表
			knowledgePointOrders:[],//知识点顺序列表
		}
	},
	computed:{
		...mapState('base',{curKnowledgePoint:state => state.curRow}),		
		isShow:{
			get:function(){
				/**获取课程大纲列表 */
				getCourseSyllabus()
					.then(res => {
						//转化对象属性名：lrnId-->id,lrnName-->name
						let tmp = JSON.stringify(res.data.d).replace(/lrnId/g,'id');
						this.syllabusList = JSON.parse(tmp.replace(/lrnName/g,'name'))
					})
				/**获取知识点列表 */
				getKnowledgePoints()
					.then(res => {
						let tmp = JSON.stringify(res.data.d).replace(/knoId/g,'id');
						this.knowledgePointList = JSON.parse(tmp.replace(/knoName/g,'name'));
					})
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑知识点";
					this.knowledgePoint = JSON.parse(JSON.stringify(this.curKnowledgePoint));
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
				lrnId:this.knowledgePoint.lrnId,
				fatherId:this.knowledgePoint.fatherId,
				knoName:this.knowledgePoint.knoName,
				knoType:this.knowledgePoint.knoType,
				order :this.knowledgePoint.order ,
			}
			let action = addKnowledgePoint;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editKnowledgePoint;
				params.knoId = this.knowledgePoint.knoId;
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
			this.knowledgePointId = {};
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
    .knowledgePoint-dialog ul{
		width:420px;
		margin:30px auto;		
	}
	.knowledgePoint-dialog li{
		display: flex;
		align-items: center;
	}
	.knowledgePoint-dialog li>label{
		display: inline-block;
		width:90px;
        text-align: right;
        margin-right:10px;
	}
	.knowledgePoint-dialog li{
		margin-bottom:25px;
	}
	.knowledgePoint-dialog li:last-child{
		display:block;
        text-align: center;
	}
	.knowledgePoint-dialog .el-select,
    .knowledgePoint-dialog .el-input,
    .knowledgePoint-dialog .el-range-editor,
	.knowledgePoint-dialog .el-input-number,
	.knowledgePoint-dialog .el-radio-group{
		width:100%;
	}
	.knowledgePoint-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .add-knowledgePoint .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-knowledgePoint .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-knowledgePoint .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-knowledgePoint .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
</style>

