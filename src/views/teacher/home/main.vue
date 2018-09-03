<template>
    <div>
        <count-block></count-block>
        <el-row :gutter="33">
            <el-col :span="16">
                <active-rank></active-rank>
            </el-col>
            <el-col :span="8">
                <top-one></top-one>
            </el-col>
        </el-row>
        <pending-course></pending-course>
    </div>
</template>

<script>
import CountBlock from './count-block'
import ActiveRank from '../../../components/home/active-rank'
import TopOne from '../../../components/home/top-one'
import PendingCourse from '../../../components/home/pending-course'
export default {
    components:{
        CountBlock,
        ActiveRank,
        TopOne,
        PendingCourse,
    }
}
</script>

<style scoped>
    .el-row{
        margin:50px 0;
    }
</style>


