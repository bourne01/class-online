<template>
    <div class="student-table">
        <el-table 
            :data="studentList"
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
                prop="stuNm"                
                label="姓名"
                max-width="120">
            </el-table-column>
            <el-table-column
                prop="stuSex"
                label="性别"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="schNm"
                label="学校"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="depNm"
                label="部门"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="spaNm"
                label="空间名称"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="claNm"
                label="班级"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="stuNO"
                label="学号"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="major"
                label="专业"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="exp"
                label="经验"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="level"
                label="等级"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="credit"
                label="学分"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="state"
                label="状态"
                max-width="50">
            </el-table-column>
            <el-table-column
                prop="stuTo"
                label="去向"
                max-width="100">
            </el-table-column>
            <el-table-column
                prop="visit"
                label="访问计数"
                max-width="100">
            </el-table-column>
            <el-table-column
                label="操作"
                width="100"
                fixed="right">
                <template slot-scope="scope">   <!--这是操作区域功能-->
                    <el-button type="text" @click="onEditClick(scope.row)">编辑</el-button>
                    <el-button
                    @click.native.prevent="removeStudentZone(scope.row.stuId)"
                    type="text"
                    size="small"
                    icon="el-icon-delete">                
                    </el-button>
                </template>
            </el-table-column>
            </el-table>
            <div class="table-footer">
                <div class="batch-action">
                    <!-- <el-button @click="toggleSelection(studentList)">全选</el-button> -->
                    <el-checkbox @change="toggleSelection(studentList)" class="select-all">全选</el-checkbox>               <!---->
                    <el-button @click="removeStudentZone()" icon="el-icon-delete" class="btn-delete">批量删除</el-button>
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
import { changeStudentZoneState, deleteStudentZone, getStudentZone } from '../../../api/zone/zone';
  export default {
    data() {
        return {
            studentList:[],
            pageSize:20,
            total:1,
            studentIds:'',
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
            let curStudentStates = [,'否','是']
            if(type === 'state'){
                return termStates[val];
            }else{
                return curStudentStates[val];
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
            let studentIds = [];
            for(let item of val){
                studentIds.push(item.stuId);
            }
            this.studentIds = studentIds.toString();
            console.log(this.studentIds);
        },
        /**
         * @function 监听点击编辑按钮事件，然后跳转到编辑弹窗
         * @param {班级Id} curStudent
         */
        onEditClick(curStudent){
            this['SET_CURRENT_ROW'](curStudent);
            this.$root.bus.$emit('edit-row','student-zone');
        },
        /**
         * @function 监听删除学期事件
         * @param {教师空间Id} stuId
         */
        removeStudentZone(stuId){
            this.$confirm('确认删除学生空间吗?', '提示', 
                {confirmButtonText: '确定',cancelButtonText: '取消',type: 'warning'})
                .then(async () => {
                    if(!stuId){//点击是批量删除按钮，学期要看this.termIds，即来自表格左侧的选择行
                        stuId = this.studentIds.toString();
                    }
                    await changeStudentZoneState({stuIds:stuId,state:3})
                            .catch(err => {
                                xhrErrHandler(err,this.$router,this.$message)
                            })
                    deleteStudentZone({stuIds:stuId})
                        .then((res) => {
                            if(res.data.s){
                                this.$message.success(res.data.m);
                                this.getStudentList();
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
                .catch(err => {
                    console.log(err);
                    this.$message.info('已取消删除！')
                })
            
        },
        handleCurrentChange(val) {
            this.getStudentList((val-1)*this.pageSize,this.pageSize)
        },
        /**
         * @function 获取学期列表
         */
        getStudentList(start=0,limit=20){
            let url = "stu!query2.action";
            getStudentZone(url,{start,limit})
                .then(res => {
                    console.log(res)
                    if(res.data.s){
                        this.studentList = res.data.d;
                    }
                })
                .catch(err => {
                    xhrErrHandler(err,this.$router,this.$message)
                })
        }
    },
    mounted(){
        this.getStudentList();
        this.$root.bus.$on('update-table',() => {
            this.getStudentList();
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
    .student-table th{       /*  表头字体居中 */
        text-align: center;
        background-color: #E9EEF3;
        font-family:'MicrosoftYaHei';
    }
    .student-table .el-icon-delete{
        color:#ff7a7b;
        font-size:16px;
    }
    .student-table td{
        text-align:center;
    }
    .student-table .btn-delete{
		height:38px;
		/* line-height:32px; */
		padding:0 20px;
        color:#fa5b4a;
        font-size:14px;  
        margin-left:10px;
	}
</style>

