<template>
    <div class="add-resource">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="500px"				
            class="resource-dialog"
            border
            @close="$emit('close-dialog');resource={}"
            >
            <ul>
                <li>
                    <label for="">名称</label>
                    <el-input v-model="resource.name"></el-input>
                </li>
                <li>
                    <label for="">日期</label>
                    <el-date-picker
                        v-model="resource.rangeDate"
                        type="daterange"
                        range-separator="至"
                        start-placeholder="开学日期"
                        end-placeholder="结束日期"
						value-format="yyyy-MM-dd">
                    </el-date-picker>
                </li>
                <li>
                    <label for="">首周一日期</label>      
                    <el-date-picker
                        v-model="resource.firstMon"
                        type="date"
                        placeholder="选择日期"
						value-format="yyyy-MM-dd">
                    </el-date-picker>   
                </li>
				<li>
                    <label for="">周数</label>
					<el-input-number v-model="resource.weeks" :min="0" :max="30"></el-input-number>
                </li>				
				<li>
                    <label for="">当前学期</label>
                    <el-radio-group v-model="resource.cur">
						<el-radio :label="1">是</el-radio>
						<el-radio :label="2">否</el-radio>
					</el-radio-group>
                </li>				
                <li>
                    <label for="">备注</label>
                    <el-input v-model="resource.remark" type="textarea"></el-input>
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
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'新增学期',
			resource:{},//学期对象
		}
	},
	computed:{
		...mapState('base',{curTerm:state => state.curRow}),		
		isShow:{
			get:function(){
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑学期";
					this.resource = JSON.parse(JSON.stringify(this.curTerm));
					let rangeDate = [this.curTerm.startDate,this.curTerm.endDate];
					this.resource.rangeDate = rangeDate;//给学期对象添加日期区间
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
				name:this.resource.name,
				startDate:this.resource.rangeDate[0],
				endDate:this.resource.rangeDate[1],
				firstMon:this.resource.firstMon,
				weeks:this.resource.weeks,
				remark:this.resource.remark
			}
			let action = addTerm;//默认执行添加学期
			if(this.isEdit){//编辑状态，执行修改学期
				action = editTerm;
				params.termId = this.resource.termId;
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
			this.resource = {};
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
    .resource-dialog ul{
		width:420px;
		margin:30px auto;		
	}
	.resource-dialog li{
		display: flex;
		align-items: center;
	}
	.resource-dialog li>label{
		display: inline-block;
		width:90px;
        text-align: right;
        margin-right:10px;
	}
	.resource-dialog li{
		margin-bottom:25px;
	}
	.resource-dialog li:last-child{
		display:block;
        text-align: center;
	}
	.resource-dialog .el-select,
    .resource-dialog .el-input,
    .resource-dialog .el-range-editor,
	.resource-dialog .el-input-number,
	.resource-dialog .el-radio-group{
		width:100%;
	}
	.resource-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .add-resource .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-resource .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-resource .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-resource .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
</style>

