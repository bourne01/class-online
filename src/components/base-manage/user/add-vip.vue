<template>
    <div class="add-vip-info">     
        <el-dialog
            :title="title"
            :visible.sync="isShow"
            width="700px"				
            class="vip-info-dialog"
            border
            @close="$emit('close-dialog');"
            >
			<div class="vip-info-form">
				<el-row :gutter="20">
					<el-col :span="12" class="basic-info">
						<label for=""><span class="required">*</span>账号</label>
						<div>
							<el-input v-model="vipInfo.acc"></el-input>
						</div>
						<label for=""><span class="required">*</span>密码</label>
						<div>
							<el-input v-model="vipInfo.psw"></el-input>
						</div>
						<label for=""><span class="required">*</span>姓名</label>
						<div>
							<el-input v-model="vipInfo.name"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<el-upload
							ref="upload"
							class="avatar-uploader main"
							action="https://jsonplaceholder.typicode.com/posts/"
							:show-file-list="false"
							:auto-upload="false"
							:on-change="previewCover"
							:on-success="onCoverSuccess"
							:before-upload="onCoverBeforeLoad">
							<img v-if="coverUrl" :src="coverUrl" class="avatar">
							<i v-else class="el-icon-plus avatar-uploader-icon"></i>
						</el-upload>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for="">昵称</label>
						<div>
							<el-input v-model="vipInfo.nick"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">性别</label>
						<div class="gender">
							<el-radio-group v-model="vipInfo.sex">
								<el-radio :label="'男'">男</el-radio>
								<el-radio :label="'女'">女</el-radio>
							</el-radio-group>
						</div>
					</el-col>					
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for="">部门</label>
						<div>
							<el-select v-model="vipInfo.depId">
								<el-option v-for="item in depList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span class="required">*</span>验证码</label>
						<div>
							<el-input v-model="vipInfo.yzm"></el-input>
						</div>
					</el-col>					
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span></span>出生日期</label>
						<div>
							<el-date-picker
								v-model="vipInfo.birthday"
								type="date"
								placeholder="选择日期"
								value-format="yyyy-MM-dd">
							</el-date-picker>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span></span>手机码号</label>
						<div>
							<el-input v-model="vipInfo.mobile"></el-input>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">					
					<el-col :span="12">
						<label for="">电子邮箱</label>
						<div>
							<el-input v-model="vipInfo.email"></el-input>
						</div>
					</el-col>
					<el-col :span="12">
						<label for=""><span></span>联系地址</label>
						<div>
							<el-input v-model="vipInfo.address"></el-input>
						</div>
					</el-col>
				</el-row>
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span></span>证件类型</label>
						<div>
							<el-select v-model="vipInfo.cardType">
								<el-option v-for="item in cardTypeList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">证件号码</label>
						<div>
							<el-input v-model="vipInfo.cardNO"></el-input>
						</div>
					</el-col>
				</el-row>				
				<el-row :gutter="20">
					<el-col :span="12">
						<label for=""><span></span>密保问题</label>
						<div>
							<el-select v-model="vipInfo.question">
								<el-option v-for="item in questionList"
									:key="item.id"
									:label="item.name"
									:value="item.id">
								</el-option>
							</el-select>
						</div>
					</el-col>
					<el-col :span="12">
						<label for="">密保答案</label>
						<div>
							<el-input v-model="vipInfo.answer"></el-input>
						</div>
					</el-col>
				</el-row>				
				<el-row>					
					<el-col>
						<label for="">备注</label>
						<div>
							<el-input type="textarea" v-model="vipInfo.remark"></el-input>
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
import { addVip,eidtVip, downloadVipAvatar } from '../../../api/zone/zone.js'
import { getCodeList } from '../../../api/base/system';
export default {
	props:['is-pop','is-edit'],
    data(){
		return{
			title:'会员注册',
			coverUrl:'',
			cardTypeList:[],
			depList:[],
			questionList:[],
			vipInfo:{
				sex:'女',
			},//会员对象
			uploadForm:new FormData()//表单数据对象
		}
	},
	computed:{
		...mapState('base',{curVipInfo:state => state.curRow}),		
		isShow:{
			get:function(){
				/**获取证件类型列表 */
				getCodeList({cp:100,rp:1})
					.then(res => {
						this.cardTypeList = res.data.dataList;
					})				
				if(this.isEdit){//来自编辑按钮
					this.title = "编辑会员";
					this.vipInfo = JSON.parse(JSON.stringify(this.curVipInfo));
					this.coverUrl = "/p/p/mem!downPhoto.action?memId="+this.curVipInfo.memId;
					//downloadVipAvatar({memId:this.curVipInfo.memId})
				}
				return this.isPop;
			},
			set:function(val){}
		}
	},
	methods:{
		/**
         * @function 监听文件上传组件的文件变动事件,处理文件预览
         * @param {}
         */
        previewCover(file, fileList){
            let fileName = file.name;
            let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
            if (regex.test(fileName.toLowerCase())) {
                this.coverUrl = file.url;
            } else {
                this.$message.error('请选择图片文件');
            }  
        },
        /**
         * @function 监听预告文件上传成功时候
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onCoverSuccess(response,file, fileList){
        },
        /**
         * @function 监听文件开始上传前事件
         * @param {类别,1,preview 2,cover,3,avatar} type
         */
        onCoverBeforeLoad(file){          
            this.uploadForm.append('file',file);            
        },
		/**
		 * @function 监听确定按钮事件，执行新增或修改班级信息
		 */
		confirm(){
			console.log("confirm...");
			this.$refs.upload.submit();
			this.uploadForm.append('acc',this.vipInfo.acc);
            this.uploadForm.append('name',this.vipInfo.name);
            this.uploadForm.append('psw',this.vipInfo.psw);
            this.uploadForm.append('kkType',this.vipInfo.kkType);
            this.uploadForm.append('depId',this.vipInfo.depId);
            this.uploadForm.append('nick ',this.vipInfo.nick);
            this.uploadForm.append('sex ',this.vipInfo.sex);
            this.uploadForm.append('birthday ',this.vipInfo.birthday);
            this.uploadForm.append('cardType',this.vipInfo.cardType);
            this.uploadForm.append('cardNO',this.vipInfo.cardNO);
            this.uploadForm.append('mobile',this.vipInfo.mobile);
            this.uploadForm.append('email',this.vipInfo.email);
            this.uploadForm.append('address',this.vipInfo.address);
            this.uploadForm.append('yzm',this.vipInfo.yzm);
            this.uploadForm.append('question',this.vipInfo.question);
            this.uploadForm.append('answer',this.vipInfo.answer);
            this.uploadForm.append('remark',this.vipInfo.remark);

            let action = addVip;
            if(this.isEdit){
                action = eidtVip;
                this.uploadForm.append('memId',this.curVipInfo.memId)
            }
            action(this.uploadForm)
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
    .vip-info-form{
		width:620px;
		margin:25px auto;		
	}
	.vip-info-form label{
		margin-bottom:5px;
		display:inline-block;
	}
	.vip-info-form .el-row{
		margin-bottom:15px;
	}	
	.vip-info-form .required{
		color:red;
		margin-right:2px;
	}	
	.basic-info>div{
		margin-bottom:5px;
	}
	.vip-info-form .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
	.vip-info-form .el-radio-group {
		line-height: 40px;
		height: 40px;}
	.vip-info-form .avatar-uploader-icon{
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}
	.vip-info-dialog .el-select,
    .vip-info-dialog .el-input,
    .vip-info-dialog .el-range-editor,
	.vip-info-dialog .el-input-number,
	.vip-info-dialog .el-radio-group{
		width:100%;
	}
	.vip-info-dialog .confirm{
		height:38px;
		/* line-height:32px; */
		padding:0 40px;
		background:linear-gradient(to bottom right,#74c756,#28d07e);
        color:#fff;
        font-size:14px;  
	}
</style>

<style>
	.add-vip-info .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
	.add-vip-info .gender label{
		margin-bottom:0!important;
	}
  	.add-vip-info .el-dialog__header{             /*设置弹框的头部*/
		background-color:#2185ff;
		height: 20px;
		color:#707079; 
		margin:0px;
	}
	.add-vip-info .el-dialog__header .el-dialog__title{       /*设置头部的标题样式*/ 
		color:white;
		float: left;
		line-height:10px;
		margin-left:20px;
		font-size:16px;
		font-family:'MicrosoftYaHei';
	}
	.add-vip-info .el-dialog__headerbtn .el-dialog__close{      /*设置头部关闭的样式*/
		color:white;
		font-size:24px;
		margin-top:-30px;
	}
	.add-vip-info .el-dialog__body {                        /*设置弹框body内的内填充为0*/
		padding:15px;
		padding-bottom:10px;
		width:100%;
		box-sizing:border-box;
	}
	.add-vip-info .el-input__inner,
	.add-vip-info .el-textarea__inner{
		background-color:#f1f1f1;
	}
</style>

