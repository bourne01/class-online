<template>
    <div class="add-syllabus">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="500px"				
            class="syllabus-dialog"
            border
            @close="$emit('close-dialog');syllabus={}"
            >
            <ul>
                <li>
                    <label for=""><span class="required">*</span>名称</label>
                    <el-input v-model="syllabus.lrnName"></el-input>
                </li>
                <li>
                    <label for="">学科</label>
                    <el-select v-model="syllabus.lrnSub">
						<el-option v-for="item in subjects"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li>
                <li>
                    <label for="">学级</label>      
                    <el-select v-model="syllabus.lrnLrv">
						<el-option v-for="item in levels"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li>
				<li>
                    <label for="">级段</label>
					 <el-select v-model="syllabus.lrnGra">
						<el-option v-for="item in grades"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li>				
				<li>
                    <label for="">专业</label>
					<el-select v-model="syllabus.lrnMaj">
						<el-option v-for="item in majors"
						 :key="item.id"
						 :label="item.name"
						 :value="item.id">
						</el-option>
					</el-select>
                </li>				
                <li>
                    <label for="">简介</label>
                    <el-input v-model="syllabus.lrnBrief" type="textarea"></el-input>
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
import { addCourseSyllabus,editCourseSyllabus, getCourseSyllabusBrief } from '../../../api/course/course.js'
import { getCodeList } from '../../../api/base/system';
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增大纲',
			syllabus:{},//学期对象
			subjects:[],//学科列表
			levels:[],//学级列表，小学、初中和高中
			grades:[],//小学一，初中一
			majors:[],//专业列表
		}
	},
	computed:{
		...mapState('base',{curSyllabus:state => state.curRow}),		
		isShow:{
			get:function(){
				/**获取学科列表 */
				getCodeList({cp:2,rp:1})
					.then(res => {
						this.subjects = res.data.dataList;
					})
				/**获取专业列表 */
				getCodeList({cp:3,rp:1})
					.then(res => {
						this.majors = res.data.dataList;
					})
				/**获取学级列表 */
				getCodeList({cp:4,rp:1})
					.then(res => {
						this.levels = res.data.dataList;
					})
				/**获取级段列表 */
				getCodeList({cp:5,rp:1})
					.then(res => {
						this.grades = res.data.dataList;
					})
					
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑大纲";
					this.syllabus = JSON.parse(JSON.stringify(this.curSyllabus));
					/**获取大纲简介 */	
					getCourseSyllabusBrief({lrnId:this.syllabus.lrnBrief})
						.then(res => {
							this.syllabus.lrnBrief = res.data.m;
						})				
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
				lrnName:this.syllabus.lrnName,
				lrnSub:this.syllabus.lrnSub,
				lrnLrv:this.syllabus.lrnLrv,
				lrnGra:this.syllabus.lrnGra,
				lrnMaj:this.syllabus.lrnMaj,
				lrnBrief:this.syllabus.lrnBrief
			}
			let action = addCourseSyllabus;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editCourseSyllabus;
				params.lrnId = this.syllabus.lrnId ;
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
			this.syllabus = {};
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
	.required{
		color:red;
	}
    .syllabus-dialog ul{
		width:420px;
		margin:30px auto;		
	}
	.syllabus-dialog li{
		display: flex;
		align-items: center;
	}
	.syllabus-dialog li>label{
		display: inline-block;
		width:90px;
        text-align: right;
        margin-right:10px;
	}
	.syllabus-dialog li{
		margin-bottom:25px;
	}
	.syllabus-dialog li:last-child{
		display:block;
        text-align: center;
	}
	.syllabus-dialog .el-select,
    .syllabus-dialog .el-input,
    .syllabus-dialog .el-range-editor,
	.syllabus-dialog .el-input-number,
	.syllabus-dialog .el-radio-group{
		width:100%;
	}
	.syllabus-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .add-syllabus .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-syllabus .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-syllabus .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-syllabus .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
</style>

