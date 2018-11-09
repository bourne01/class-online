<template>
    <div class="course-resource-table">
        <el-table 
            :data="courseContentList"
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
                prop="couSecNm"                
                label="名称"
                max-width="120">
            </el-table-column>
            <el-table-column
                prop="couSecTp"
                label="类别"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couSecTp|convertValueToName(typeList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="couId"
                label="课程"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couId|convertValueToName(courseList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="order"
                label="顺序"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="tbkSecNm"
                label="教材章节"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="knoName"
                label="知识点"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="fatherId"
                label="父节点"
                max-width="150">
            </el-table-column>            
            <el-table-column
                prop="state"
                label="状态"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.state|convertValueToName(stateList)}}
                </template>
            </el-table-column>
            <el-table-column
                label="操作"
                max-width="180">
                <template slot-scope="scope">   <!--这是操作区域功能-->
                    <el-button type="text" @click="onEditClick(scope.row)">编辑</el-button>
                    <el-button
                    @click.native.prevent="removeCourseContent(scope.row.couSecId)"
                    type="text"
                    size="small"
                    icon="el-icon-delete">                
                    </el-button>
                </template>
            </el-table-column>
            </el-table>
            <div class="table-footer">
                <div class="batch-action">
                    <!-- <el-button @click="toggleSelection(courseContentList)">全选</el-button> -->
                    <el-checkbox @change="toggleSelection(courseContentList)" class="select-all">全选</el-checkbox>               <!---->
                    <el-button @click="removeCourseContent()" icon="el-icon-delete" class="btn-delete">批量删除</el-button>
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
import { changeCourseContentState, deleteCourseContent, getCourseContents,getCourses } from '../../../api/course/course';
  export default {
    data() {
        return {
            courseContentList:[],//课程目录列表
            pageSize:20,
            total:1,
            courseContentIds:'',
            URL:'couSec!query2.action',
            typeList:[
				{id:1,name:'章'},
				{id:2,name:'节'},
				{id:3,name:'点'},
            ],//章节类别 1章 2节 3点
            stateList:[
                {id:2,name:'正常'},
                {id:3,name:'锁定'},
                {id:4,name:'历史'},
            ],//课程目录状态
            courseList:[],//课程列表
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
         * @param {列表} arrayList
         */
        convertValueToName(val,arrayList){
            for(let item of arrayList){
                if(item.id == val){
                    return item.name
                }
            }
            return '未知'
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
            let courseContentIds = [];
            for(let item of val){
                courseContentIds.push(item.courseContentId);
            }
            this.courseContentIds = courseContentIds.toString();
            console.log(this.courseContentIds);
        },
        /**
         * @function 监听点击编辑按钮事件，然后跳转到编辑弹窗
         * @param {班级Id} cruTextbook
         */
        onEditClick(cruTextbook){
            this['SET_CURRENT_ROW'](cruTextbook);
            this.$root.bus.$emit('edit-row','course-content');
        },
        /**
         * @function 监听删除学期事件
         * @param {学期Id} courseContentId
         */
        removeCourseContent(courseContentId){
            this.$confirm('确认删除该学期吗?', '提示', 
                {confirmButtonText: '确定',cancelButtonText: '取消',type: 'warning'})
                .then(async () => {
                    if(!courseContentId){//点击是批量删除按钮，学期要看this.termIds，即来自表格左侧的选择行
                        courseContentId = this.courseContentIds.toString();
                    }
                    await changeCourseContentState({couSecIds:courseContentId,state:4})//改变状态，以便删除
                            .catch(err => {
                                xhrErrHandler(err,this.$router,this.$message)
                            })
                    deleteCourseContent({couSecIds:courseContentId})
                        .then((res) => {
                            if(res.data.s){
                                this.$message.success(res.data.m);
                                this.getCourseContentList();
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
        /**
         * @function 监听页面当前页码变化事件
         * @param {当前页码} val
         */
        handleCurrentChange(val) {
            this.getCourseContentList((val-1)*this.pageSize,this.pageSize)
        },
        /**
         * @function 获取学期列表
         * @param {记录开始的位置} start
         * @param {总共请求多少条纪律} limit
         */
        getCourseContentList(start=0,limit=20){
            getCourseContents(this.URL,{start,limit})
                .then(res => {
                    console.log(res)
                    if(res.data.s){
                        this.courseContentList = res.data.d;
                    }
                })
                .catch(err => {
                    xhrErrHandler(err,this.$router,this.$message)
                })
        }
    },
    mounted(){
        getCourses('cou!query.action',{})
            .then(res => {
                let tmp = JSON.stringify(res.data.d).replace(/couId/g,'id');
                this.courseList = JSON.parse(tmp.replace(/couTitle/g,'name'))
            })
        this.getCourseContentList();
        this.$root.bus.$on('update-table',() => {
            this.getCourseContentList();
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
    .course-resource-table th{       /*  表头字体居中 */
        text-align: center;
        background-color: #E9EEF3;
        font-family:'MicrosoftYaHei';
    }
    .course-resource-table .el-icon-delete{
        color:#ff7a7b;
        font-size:16px;
    }
    .course-resource-table td{
        text-align:center;
    }
    .course-resource-table .btn-delete{
		height:38px;
		/* line-height:32px; */
		padding:0 20px;
        color:#fa5b4a;
        font-size:14px;  
        margin-left:10px;
	}
</style>

