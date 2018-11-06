<template>
    <div class="term-table">
        <el-table 
            :data="termList"
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
                prop="tbkName"                
                label="教材名称"
                max-width="120">
            </el-table-column>
            <el-table-column
                prop="startDate"
                label="开学日期"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.startDate|filterTime}}
                </template>
            </el-table-column>
            <el-table-column
                prop="endDate"
                label="结束日期"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.endDate|filterTime}}
                </template>
            </el-table-column>
            <el-table-column
                prop="firstMon"
                label="首个周一日期"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.firstMon|filterTime}}
                </template>
            </el-table-column>
            <el-table-column
                prop="weeks"
                label="周数"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="cur"
                label="当前学期"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.cur|convertValueToName('current')}}
                </template>
            </el-table-column>
            <el-table-column
                prop="state"
                label="学期状态"
                max-width="150">
                <template slot-scope="scope">
                    {{arr[scope.row.state]}}
                </template>
            </el-table-column>
            <el-table-column
                label="操作"
                max-width="180">
                <template slot-scope="scope">   <!--这是操作区域功能-->
                    <el-button type="text" @click="onEditClick(scope.row)">编辑</el-button>
                    <el-button
                    @click.native.prevent="deleteTerm(scope.row.termId)"
                    type="text"
                    size="small"
                    icon="el-icon-delete">                
                    </el-button>
                </template>
            </el-table-column>
            </el-table>
            <div class="table-footer">
                <div class="batch-action">
                    <!-- <el-button @click="toggleSelection(termList)">全选</el-button> -->
                    <el-checkbox @change="toggleSelection(termList)" class="select-all">全选</el-checkbox>               <!---->
                    <el-button @click="deleteTerm()" icon="el-icon-delete" class="btn-delete">批量删除</el-button>
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
import { getTerm, changeTermState, deleteTerm } from '../../../api/base/dean';
  export default {
    data() {
        return {
            termList:[],
            pageSize:20,
            total:1,
            termIds:'',
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
            let termIds = [];
            for(let item of val){
                termIds.push(item.termId);
            }
            this.termIds = termIds.toString();
            console.log(this.termIds);
        },
        /**
         * @function 监听点击编辑按钮事件，然后跳转到编辑弹窗
         * @param {班级Id} curTerm
         */
        onEditClick(curTerm){
            this['SET_CURRENT_ROW'](curTerm);
            this.$root.bus.$emit('edit-row','term');
        },
        /**
         * @function 监听删除学期事件
         * @param {学期Id} termId
         */
        deleteTerm(termId){
            this.$confirm('确认删除该学期吗?', '提示', 
                {confirmButtonText: '确定',cancelButtonText: '取消',type: 'warning'})
                .then(async () => {
                    if(!termId){//点击是批量删除按钮，学期要看this.termIds，即来自表格左侧的选择行
                        termId = this.termIds.toString();
                    }
                    await changeTermState({termIds:termId,state:4})
                            .catch(err => {
                                xhrErrHandler(err,this.$router,this.$message)
                            })
                    deleteTerm({termIds:termId})
                        .then((res) => {
                            if(res.data.s){
                                this.$message.success(res.data.m);
                                this.getTermList();
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
            this.getTermList((val-1)*this.pageSize,this.pageSize)
        },
        /**
         * @function 获取学期列表
         */
        getTermList(start=0,limit=20){
            getTerm({start,limit})
                .then(res => {
                    console.log(res)
                    if(res.data.s){
                        this.termList = res.data.d;
                    }
                })
                .catch(err => {
                    xhrErrHandler(err,this.$router,this.$message)
                })
        }
    },
    mounted(){
        this.getTermList();
        this.$root.bus.$on('update-table',() => {
            this.getTermList();
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

