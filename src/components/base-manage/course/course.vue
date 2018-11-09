<template>
    <div class="textbook-table">
        <el-table 
            :data="courseList"
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
                prop="couTitle"                
                label="名称"
                max-width="120">
            </el-table-column>
            <el-table-column
                prop="kkType"
                label="开课类型"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.kkType|convertValueToName(courseCataList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="couType"
                label="课程类型"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.kkType|convertValueToName(courseTypeList)}}
                </template>
            </el-table-column>            
            <el-table-column
                prop="lrnName"
                label="课程大纲"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="tbkName"
                label="教材名称"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="knoName"
                label="知识点"
                max-width="150">
            </el-table-column>           
            <el-table-column
                prop="couSub"
                label="学科"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couSub|convertValueToName(subjectList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="couLrv"
                label="学级"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couLvr|convertValueToName(courseTypeList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="couGra"
                label="级段"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couGra|convertValueToName(gradeList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="couMaj"
                label="专业"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couMaj|convertValueToName(majorList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="couLevel"
                label="难度"
                max-width="150">
                <template slot-scope="scope">
                    {{scope.row.couLevel|convertValueToName(courseDifficultyList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="creName"
                label="创建者"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="couPoint"
                label="积分"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="eval"
                label="评价"
                width="150">
                <template slot-scope="scope">
                    <el-rate v-model="scope.row.eval"></el-rate>
                </template>
            </el-table-column>
            <el-table-column
                prop="brwNum"
                label="浏览数"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="stuNum"
                label="学员数"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="likeNum"
                label="点赞数"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="finNum"
                label="结业数"
                max-width="150">
            </el-table-column>
            <el-table-column
                prop="state"
                label="状态"
                width="80"
                fixed="right">
                <template slot-scope="scope">
                    {{scope.row.state|convertValueToName(courseStateList)}}
                </template>
            </el-table-column>
            <el-table-column
                prop="auState"
                label="审核状态"
                width="80"
                fixed="right">
                <template slot-scope="scope">
                    {{scope.row.auState|convertValueToName(courseAuthList)}}
                </template>
            </el-table-column>
            <el-table-column
                label="操作"
                width="100"
                fixed="right">
                <template slot-scope="scope">   <!--这是操作区域功能-->
                    <el-button type="text" @click="onEditClick(scope.row)">编辑</el-button>
                    <el-button
                    @click.native.prevent="removeCourse(scope.row.couId)"
                    type="text"
                    size="small"
                    icon="el-icon-delete">                
                    </el-button>
                </template>
            </el-table-column>
            </el-table>
            <div class="table-footer">
                <div class="batch-action">
                    <!-- <el-button @click="toggleSelection(courseList)">全选</el-button> -->
                    <el-checkbox @change="toggleSelection(courseList)" class="select-all">全选</el-checkbox>               <!---->
                    <el-button @click="removeCourse()" icon="el-icon-delete" class="btn-delete">批量删除</el-button>
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
import { deleteTextbook, getTextbooks, changeTextbookState, changeCourseState, deleteCourse } from '../../../api/course/course';
import { getCodeList } from '../../../api/base/system';
  export default {
    data() {
        return {
            pageSize:20,
            total:1,
            couIds:'',
            URL:'cou!query2.action',
            syllabusList:[],
            courseCataList:[//开课类型列表
                {id:1,name:'公开课'},
                {id:2,name:'任务课'},
            ],
            courseTypeList:[//课程类型 1 9兴趣拓展 ...
                {id:1,name:'文化基础'},
                {id:9,name:'兴趣拓展'},
            ],
            subjectList:[],//学科列表
            gradeList:[],//学级列表
            majorList:[],//专业列表
            courseStateList:[//课程状态列表
                {id:2,name:'正常'},
                {id:3,name:'关闭'},
                {id:2,name:'历史'},
            ],
            courseAuthList:[//课程审核状态列表
                {id:2,name:'未审核'},
                {id:3,name:'不通过'},
                {id:4,name:'待审核'},
                {id:5,name:'已审核'},
            ],
            courseDifficultyList:[//课程难度列表
                {id:10,name:'容易'},
                {id:20,name:'普通'},
                {id:30,name:'较难'},
                {id:40,name:'困难'},
                {id:50,name:'特难'},
                ],
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
    computed:{
        ...mapState('course',{
            courseList:state => state.courseList
        })
    },
    methods:{
        ...mapMutations('course',['SET_CURRENT_COURSE']),
        ...mapActions('course',['getCourseList']),
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
            let couIds = [];
            for(let item of val){
                couIds.push(item.couId);
            }
            this.couIds = couIds.toString();
        },
        /**
         * @function 监听点击编辑按钮事件，然后跳转到编辑弹窗
         * @param {班级Id} curCourse
         */
        onEditClick(curCourse){
            this['SET_CURRENT_COURSE'](curCourse);
            this.$router.push({path:'/admin-index/publish',query:{isEdit:true}});//跳转发布课程页
        },
        /**
         * @function 监听删除学期事件
         * @param {学期Id} courseId
         */
        removeCourse(courseId){
            this.$confirm('确认删除该学期吗?', '提示', 
                {confirmButtonText: '确定',cancelButtonText: '取消',type: 'warning'})
                .then(async () => {
                    if(!courseId){//点击是批量删除按钮，学期要看this.termIds，即来自表格左侧的选择行
                        courseId = this.couIds.toString();
                    }
                    await changeCourseState({couIds:courseId,state:4})//改变状态，以便删除
                            .catch(err => {
                                xhrErrHandler(err,this.$router,this.$message)
                            })
                    deleteCourse({couId:courseId})
                        .then((res) => {
                            if(res.data.s){
                                this.$message.success(res.data.m);
                                this.getCourses();
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
            this.getCourses((val-1)*this.pageSize,this.pageSize);
        },
        /**
         * @function 获取学期列表
         * @param {记录开始的位置} start
         * @param {总共请求多少条纪律} limit
         */
        getCourses(start=0,limit=20){
            this.getCourseList({url:this.URL,params:{start,limit}})                
        },
        /**
         * @function 通过获取列表数据
         */
        getSeletorBysync:async function(){
            /**获取学科列表 */
            await getCodeList({cp:2,rp:1})
                .then(res => {
                    this.subjectList = res.data.dataList;
                })
            /**获取专业列表 */
            await getCodeList({cp:3,rp:1})
                .then(res => {
                    this.majorList = res.data.dataList;
                })
            /**获取学级列表 */
            await getCodeList({cp:4,rp:1})
                .then(res => {
                    this.levelList = res.data.dataList;
                })
            /**获取级段列表 */
            await getCodeList({cp:5,rp:1})
                .then(res => {
                    this.gradeList = res.data.dataList;
                })
        }
    },
    mounted(){
        this.getSeletorBysync();
        this.getCourses();
    },
    destroyed(){
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
    .textbook-table th{       /*  表头字体居中 */
        text-align: center;
        background-color: #E9EEF3;
        font-family:'MicrosoftYaHei';
    }
    .textbook-table .el-icon-delete{
        color:#ff7a7b;
        font-size:16px;
    }
    .textbook-table td{
        text-align:center;
    }
    .textbook-table .btn-delete{
		height:38px;
		/* line-height:32px; */
		padding:0 20px;
        color:#fa5b4a;
        font-size:14px;  
        margin-left:10px;
	}
</style>

