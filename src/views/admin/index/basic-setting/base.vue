<template>
    <el-container class="base">
        <el-aside>
            <sidebar></sidebar>
        </el-aside>
        <el-main>
            <basic-main></basic-main>
        </el-main>
        
    </el-container>
</template>

<script>
import Sidebar from '../../../../components/basic-setting/sidebar'
import BasicMain from '../../../../components/basic-setting/main'
export default {
    components:{
        Sidebar,
        BasicMain
    },
}
</script>

<style scoped>
    .base .el-aside{
        width:200px!important;
    }
    .base .el-main{
        
    }
</style>

