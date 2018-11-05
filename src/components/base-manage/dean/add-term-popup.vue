<template>
    <div class="add-term">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="500px"				
            class="term-dialog"
            border
            @close="$emit('close-dialog');term={}"
            >
            <ul>
                <li>
                    <label for="">名称</label>
                    <el-input v-model="term.name"></el-input>
                </li>
                <li>
                    <label for="">日期</label>
                    <el-date-picker
                        v-model="term.rangeDate"
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
                        v-model="term.firstMon"
                        type="date"
                        placeholder="选择日期"
						value-format="yyyy-MM-dd">
                    </el-date-picker>   
                </li>
				<li>
                    <label for="">周数</label>
					<el-input-number v-model="term.weeks" :min="0" :max="30"></el-input-number>
                </li>				
				<li>
                    <label for="">当前学期</label>
                    <el-radio-group v-model="term.cur">
						<el-radio :label="1">是</el-radio>
						<el-radio :label="2">否</el-radio>
					</el-radio-group>
                </li>				
                <li>
                    <label for="">备注</label>
                    <el-input v-model="term.remark" type="textarea"></el-input>
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
			term:{},//学期对象
		}
	},
	computed:{
		...mapState('base',{curTerm:state => state.curRow}),		
		isShow:{
			get:function(){
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑学期";
					this.term = JSON.parse(JSON.stringify(this.curTerm));
					let rangeDate = [this.curTerm.startDate,this.curTerm.endDate];
					this.term.rangeDate = rangeDate;//给学期对象添加日期区间
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
				name:this.term.name,
				startDate:this.term.rangeDate[0],
				endDate:this.term.rangeDate[1],
				firstMon:this.term.firstMon,
				weeks:this.term.weeks,
				remark:this.term.remark
			}
			let action = addTerm;//默认执行添加学期接口方法
			if(this.isEdit){//编辑状态，执行修改学期
				action = editTerm;//编辑学期接口方法
				params.termId = this.term.termId;//添加学期Id
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
			this.term = {};//重置对象
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
    .term-dialog ul{
		width:420px;
		margin:30px auto;		
	}
	.term-dialog li{
		display: flex;
		align-items: center;
	}
	.term-dialog li>label{
		display: inline-block;
		width:90px;
        text-align: right;
        margin-right:10px;
	}
	.term-dialog li{
		margin-bottom:25px;
	}
	.term-dialog li:last-child{
		display:block;
        text-align: center;
	}
	.term-dialog .el-select,
    .term-dialog .el-input,
    .term-dialog .el-range-editor,
	.term-dialog .el-input-number,
	.term-dialog .el-radio-group{
		width:100%;
	}
	.term-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
  .add-term .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-term .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-term .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-term .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
</style>

