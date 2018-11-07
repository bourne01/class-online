<template>
    <div class="term-table">
        <el-table 
            :data="vipList"
            max-height="625"
            border
            ref="multipleTable"
            @selection-change="handleSelectionChange"
            >
            <el-table-column
				type="selection"
				min-width="55">
			</el-table-column>
            <el-table-column
                prop="name"                
                label="姓名"
                max-width="100">
            </el-table-column>
            <el-table-column
                prop="acc"
                label="账号"
                max-width="100">
            </el-table-column>
            <el-table-column
                prop="nick"
                label="昵称"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="sex"
                label="性别"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="email"
                label="邮箱"
                max-width="100">
            </el-table-column>
            <el-table-column
                prop="mobile"
                label="手机"
                max-width="100">
            </el-table-column>
            <el-table-column
                prop="address"
                label="地址"
                max-width="100">
            </el-table-column>
            <el-table-column
                prop="remark"
                label="备注"
                max-width="150"
                show-overflow-tooltip>
            </el-table-column>
            <el-table-column
                prop="state"
                label="状态"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.state|convertValueToName('state')}}
                </template>
            </el-table-column>
            <el-table-column
                label="操作"
                max-width="100"
                fixed="right"
                >
                <template slot-scope="scope">   <!--这是操作区域功能-->
                    <el-button type="text" @click="onEditClick(scope.row)">编辑</el-button>
                    <el-button
                    @click.native.prevent="removeVip(scope.row.memId)"
                    type="text"
                    size="small"
                    icon="el-icon-delete">                
                    </el-button>
                </template>
            </el-table-column>
            </el-table>
            <div class="table-footer">
                <div class="batch-action">
                    <!-- <el-button @click="toggleSelection(vipList)">全选</el-button> -->
                    <el-checkbox @change="toggleSelection(vipList)" class="select-all">全选</el-checkbox>               <!---->
                    <el-button @click="removeVip()" icon="el-icon-delete" class="btn-delete">批量删除</el-button>
                </div>
                <el-pagination
                    @current-change="handleCurrentChange"
                    :page-size="pageSize"
                    layout="total, prev, pager, next"
                    :total="total"
                    style="margin-top:20px;">
                </el-pagination>
            </div>
    </div>
</template>
<script>
import {mapActions,mapState, mapMutations} from 'vuex'
import { xhrErrHandler } from '../../../utils/util';
import { getTerm, changeTermState, removeVip } from '../../../api/base/dean';
import { getVips, deleteVip, changeVipState } from '../../../api/zone/zone';
  export default {
    data() {
        return {
            vipList:[],
            pageSize:20,
            total:1,
            memIds:'',
        }
    },
    filters:{
        /**@function 去掉时间部分 */
        filterTime:function(val){
            if(val){
                return val.split(' ')[0];
            }{
                return '未知'
            }
        },
        /**
         * @function 把数字转换成对应的文字
         * @param {类型：当前学期，学期状态} type
         */
        convertValueToName(val,type){
            let termStates = [,,'正常'];
            let curTermStates = [,'否','是']
            if(type === 'state'){
                return termStates[val];
            }else{
                return curTermStates[val];
            }
        }
    },
    methods:{
        ...mapMutations('base',['SET_CURRENT_ROW']),
        /**
         * @function 监听全选复选框事件，实现全选与全取消功能
         */
        toggleSelection(rows) {
            if (rows) {
                rows.forEach(row => {
                    this.$refs.multipleTable.toggleRowSelection(row);
                });
            } else {
                this.$refs.multipleTable.clearSelection();
            }
        },
        /**
         * @function 监听复选框选中或取消事件
         * @param {学期记录} val
         */
        handleSelectionChange(val) {
            let memIds = [];
            for(let item of val){
                memIds.push(item.memId);
            }
            this.memIds = memIds.toString();
            console.log(this.memIds);
        },
        /**
         * @function 监听点击编辑按钮事件，然后跳转到编辑弹窗
         * @param {班级Id} curVip
         */
        onEditClick(curVip){
            this['SET_CURRENT_ROW'](curVip);
            this.$root.bus.$emit('edit-row','vip-info');
        },
        /**
         * @function 监听删除学期事件
         * @param {学期Id} memId
         */
        removeVip(memId){
            this.$confirm('确认删除会员吗?', '提示', 
                {confirmButtonText: '确定',cancelButtonText: '取消',type: 'warning'})
                .then(async () => {
                    if(!memId){//点击是批量删除按钮，学期要看this.termIds，即来自表格左侧的选择行
                        memId = this.memIds.toString();
                    }
                    await changeVipState({memIds:memId,state:4})
                            .catch(err => {
                                xhrErrHandler(err,this.$router,this.$message)
                            })
                    deleteVip({memIds:memId})
                        .then((res) => {
                            if(res.data.s){
                                this.$message.success(res.data.m);
                                this.getVipList();
                            }else{  
                                this.$message.error(res.data.m);
                            }/* else{
                                console.log(res.data.m);
                                this.$message.error('发生未知类型错误，请联系管理员')
                            } */
                        })
                        .catch(err => {
                            xhrErrHandler(err,this.$router,this.$message)
                        })
                })
                .catch(() => {
                    this.$message.info('已取消删除！')
                })
            
        },
        handleCurrentChange(val) {
            this.getVipList((val-1)*this.pageSize,this.pageSize)
        },
        /**
         * @function 获取学期列表
         */
        getVipList(start=0,limit=20){
            getVips({start,limit})
                .then(res => {
                    console.log(res)
                    if(res.data.s){
                        this.vipList = res.data.d;
                    }
                })
                .catch(err => {
                    xhrErrHandler(err,this.$router,this.$message)
                })
        }
    },
    mounted(){
        this.getVipList();
        this.$root.bus.$on('update-table',() => {
            this.getVipList();
        })
    },
    destroyed(){
        this.$root.bus.$off('update-table');
    }
        
}
</script>

<style scoped>
    .table-footer{
        margin-top:10px;
        padding-left:20px;
        box-sizing: border-box;
        height:80px;
        display:flex;
        justify-content: space-between;
        align-items: center;
    }
    
</style>
<style>
    .term-table th{       /*  表头字体居中 */
        text-align: center;
        background-color: #E9EEF3;
        font-family:'MicrosoftYaHei';
    }
    .term-table .el-icon-delete{
        color:#ff7a7b;
        font-size:16px;
    }
    .term-table td{
        text-align:center;
    }
    .term-table .btn-delete{
		height:38px;
		/* line-height:32px; */
		padding:0 20px;
        color:#fa5b4a;
        font-size:14px;  
        margin-left:10px;
	}
</style>

