<template>
    <div>
        <ul class="course-wrap">
            <li>
                <opencourse></opencourse>
            </li>
        </ul>
        <div class="no-course" v-if="isNull">暂无课程</div>
        <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            :page-size="pageSize"
            @current-change="onCurrentChange"
            v-if="!isNull">
        </el-pagination>
    </div>
</template>

<script>
import Opencourse from './opencourse'
export default {
    components:{
        Opencourse,
    },
    data(){
        return{
            isOpenCourse:true,//课程类型是否为公开课
            isNull:false,//无课程
            isTeacher:'',
            isStudent:'',
            isAdmin:'',
            total:1,
            pageSize:10,
        }
    },
    methods:{
        /**
         * @function 监听当前页码变化
         * @param {当前页码} pageValue
         */
        onCurrentChange(pageValue){
            console.log(pageValue);
        }
    },
    mounted(){
        //console.log(window.innerWidth || document.documentElement.clientWidth);
    }
}
</script>

<style scoped>
    .course-wrap{
        /* display:flex;
        justify-content: space-between; */
        background-color:#f4f4f4;
        width:1364px;
        margin:0 auto;
        padding:40px 0 20px 0;
        /* flex-flow: wrap; */
    }
    .el-pagination{
        text-align:center;
        padding:20px 0;
    }
    .no-course{
        text-align: center;
        font-size:20px;
    }
</style>

