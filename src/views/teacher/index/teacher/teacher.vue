<template>
    <div class="teacher">
        <div class="sift-sort">
            <sift-sort></sift-sort>
        </div>
        <teacher v-for="idx in 5" :key="idx"></teacher>
        <el-pagination
            background
            layout="prev, pager, next"
            :total="50">
        </el-pagination>

    </div>
</template>

<script>
import SiftSort from '../../../../components/teacher/sift-sort'
import Teacher from '../../../../components/teacher/teacher'
export default {
    components:{
        SiftSort,
        Teacher,
    }
}
</script>

<style>
/*     .teacher .el-pagination button,
    .teacher .el-pagination li{
        background-color:#fff!important;
        color:#585a60!important;
    } */
</style>


<style scoped>
    .teacher{
        background-color:#f1f1f1;
        padding-bottom:90px;
    }
    .sift-sort{
        background-color:#fff;
        margin-bottom:40px;
    }
    .el-pagination{
        text-align: center;
        margin-top:100px;
    }
</style>


