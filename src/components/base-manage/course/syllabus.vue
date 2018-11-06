<template>
    <div class="term-table">
        <el-table 
            :data="syllabusList"
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
                prop="lrnName"                
                label="名称"
                max-width="120">
            </el-table-column>
            <el-table-column
                prop="lrnSubNm"
                label="学科"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="lrnLrvNm"
                label="学级"
                max-width="150">                
            </el-table-column>
            <el-table-column
                prop="lrnGraNm"
                label="级段"
                max-width="150">               
            </el-table-column>           
            <el-table-column
                prop="lrnMajNm"
                label="专业"
                max-width="150">               
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
                prop="lrnBrief"
                label="简介"
                max-width="150">
            </el-table-column>
            <el-table-column
                label="操作"
                max-width="180">
                <template slot-scope="scope">   <!--这是操作区域功能-->
                    <el-button type="text" @click="onEditClick(scope.row)">编辑</el-button>
                    <el-button
                    @click.native.prevent="deleteSyllabus(scope.row.lrnId)"
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
                    <el-checkbox @change="toggleSelection(syllabusList)" class="select-all">全选</el-checkbox>               <!---->
                    <el-button @click="deleteSyllabus()" icon="el-icon-delete" class="btn-delete">批量删除</el-button>
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
import { getCourseSyllabus, changeCourseSyllabusState, deleteCourseSyllabus } from '../../../api/course/course';
  export default {
    data() {
        return {
            syllabusList:[],
            pageSize:20,
            total:1,
            syllabusIds:'',
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
            let syllabusIds = [];
            for(let item of val){
                syllabusIds.push(item.lrnId);
            }
            this.syllabusIds = syllabusIds.toString();
        },
        /**
         * @function 监听点击编辑按钮事件，然后跳转到编辑弹窗
         * @param {班级Id} curSyllabus
         */
        onEditClick(curSyllabus){
            this['SET_CURRENT_ROW'](curSyllabus);
            this.$root.bus.$emit('edit-row','syllabus');
        },
        /**
         * @function 监听删除学期事件
         * @param {学期Id}syllabusId
         */
        deleteSyllabus(syllabusId){
            this.$confirm('确认删除课程大纲吗?', '提示', 
                {confirmButtonText: '确定',cancelButtonText: '取消',type: 'warning'})
                .then(async () => {
                    if(!syllabusId){//点击是批量删除按钮，学期要看this.syllabusIds，即来自表格左侧的选择行
                        syllabusId = this.syllabusIds.toString();
                    }
                    await changeCourseSyllabusState({lrnIds:syllabusId,state:4})
                            .catch(err => {
                                xhrErrHandler(err,this.$router,this.$message)
                            })
                    deleteCourseSyllabus({lrnIds:syllabusId})
                        .then((res) => {
                            if(res.data.s){
                                this.$message.success(res.data.m);
                                this.getSyllabusList();
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
                .catch((err) => {
                    console.log(err);
                    this.$message.info('已取消删除！')
                })
            
        },
        handleCurrentChange(val) {
            this.getSyllabusList((val-1)*this.pageSize,this.pageSize)
        },
        /**
         * @function 获取学期列表
         */
        getSyllabusList(start=0,limit=20){
            getCourseSyllabus({start,limit})
                .then(res => {
                    console.log(res)
                    if(res.data.s){
                        this.syllabusList = res.data.d;
                    }
                })
                .catch(err => {
                    xhrErrHandler(err,this.$router,this.$message)
                })
        }
    },
    mounted(){
        this.getSyllabusList();
        this.$root.bus.$on('update-table',() => {
            this.getSyllabusList();
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

