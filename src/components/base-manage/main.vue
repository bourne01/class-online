<template>
    <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item>{{curMenuTitle}}</el-breadcrumb-item>
            <el-breadcrumb-item>{{curMenuItem.name}}</el-breadcrumb-item>
        </el-breadcrumb>
        <div>
            <toolbar></toolbar>
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
import Toolbar from './toolbar'
import { mapState } from 'vuex';
export default {
    components:{Toolbar},
    computed:{
        ...mapState('base',{
            curMenuTitle:state => state.curMenuTitle,
            curMenuItem:state => state.curMenuItem,
        })
    }
}
</script>

<style scoped>
    
</style>

