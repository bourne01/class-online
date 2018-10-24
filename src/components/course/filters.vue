<template>
    <div class="filters">
        <div class="level filter">
            <label for="">层次：</label>
            <!-- <button class="btn">全部</button> -->
            <span 
                v-for="(item,idx) in levelList" 
                :key="idx"
                :class="{btn:idx===curLevelIndex}"
                @click="filterCourse(idx,'level')">{{item.name}}</span>
        </div>
        <div class="grade filter">
            <label for="">年级：</label>
            <template v-if="curLevelIndex === 0">
                <span class="btn">全部</span>
            </template>
            <template v-if="curLevelIndex === 2">
                <span 
                    v-for="(item,idx) in midGrades" :key="idx"
                    :class="{btn:idx===curMidGradeIndex}"
                    @click="filterCourse(idx,'middle')">
                    {{item.name}}</span>
            </template>
            <template v-if="curLevelIndex === 1">
                <span v-for="(item,idx) in eleGrades" :key="idx"
                    :class="{btn:idx===curEleGradeIndex}"
                    @click="filterCourse(idx,'elementary')">{{item.name}}</span>
            </template>
            <template v-if="curLevelIndex === 3">
                <span v-for="(item,idx) in highGrades" :key="idx"
                    :class="{btn:idx===curHighGradeIndex}"
                    @click="filterCourse(idx,'high')">{{item.name}}</span>
            </template>
            
        </div>
        <div class="course filter">
            <label for="">学科：</label>
            <span v-for="(item,idx) in courseList" :key="idx"
                :class="{btn:idx===curCourseIndex}"
                @click="filterCourse(idx,'course')">{{item.name}}</span>
        </div>
        <div class="type filter">
            <label for="">类型：</label>
            <span v-for="(item,idx) in categoryList" :key="idx"
                :class="{btn:idx===curCategoryIndex}"
                @click="filterCourse(idx,'category')">{{item.name}}</span>
        </div>
        <div class="search-bar filter">
            <label for="" style="width:3em;"></label>
            <el-input
                placeholder="请输入内容"
                suffix-icon="el-icon-search"
                v-model="search">
            </el-input>
            <el-select v-model="value" placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            value:'',
            search:'',
            options:{},
            levelList:[{id:-1,name:'全部'},{id:1,name:'小学'},{id:2,name:'初中'},{id:3,name:'高中'},],
            eleGrades:[{id:-1,name:'全部'},{id:1,name:'一年级'},{id:2,name:'二年级'},{id:3,name:'三年级'},
                    {id:4,name:'四年级'},{id:5,name:'五年级'},{id:6,name:'六年级'},],
            midGrades:[{id:-1,name:'全部'},{id:7,name:'七年级'},{id:8,name:'八年级'},{id:9,name:'九年级'},],
            highGrades:[{id:-1,name:'全部'},{id:1,name:'高一'},{id:2,name:'高二'},{id:3,name:'高三'},],
            courseList:[{id:-1,name:'全部'},{id:1,name:'语文'},{id:2,name:'数学'},{id:3,name:'英语'},],
            categoryList:[{id:-1,name:'全部'},{id:1,name:'任务课'},{id:2,name:'公开课'}],
            curLevelIndex:0,//当前层次数组下标，0为全部
            curEleGradeIndex:0,//当前小学年级数组下标，0为全部
            curMidGradeIndex:0,//当前初中年级数组下标，0为全部
            curHighGradeIndex:0,//当前高中年级数组下标，0为全部
            curCourseIndex:0,//当前课程数组下标，-1为全部
            curCategoryIndex:0,//当前课程类别数组下标，0为全部
        }
    },
    methods:{
        /**
         * @function 根据不同条件，过滤课程 
         * @param {所选条件在数组中的下标} index
         * @param {过滤条件类型} type
         */
        filterCourse(index,type){
            switch(type){
                case 'level':
                    this.curLevelIndex = index;
                    break;
                case 'elementary':
                    this.curEleGradeIndex = index;
                    break;
                case 'middle':
                    this.curMidGradeIndex = index;
                    break;
                case 'high':
                    this.curHighGradeIndex = index;
                    break;
                case 'course':
                    this.curCourseIndex = index;
                    break;
                case 'category':
                    this.curCategoryIndex = index;
                    break;
                default:
                    this.$message.error('发生错误，未知过滤条件')
            }
        }
    }
}
</script>

<style>
    .filters .el-input__icon{
        font-size: 20px;
    }
    .filters .el-input__inner{
        background-color:#f1f1f1;
    }
</style>

<style scoped>
    .filters{
        display: flex;
        flex-direction: column;
    }
    .filter{
        display:flex;
        margin-bottom:20px;

    }
    .filter:first-child{
        margin-top:20px;
    }
    .filter label{
        padding:5px 15px 5px 0;
        font-size:14px;
        color:#585a60;
    }
    .filter .btn{
        padding:5px 15px;
        color:#fff;
        font-size:12px;
        background-color:#fc6934;
        outline: none;
        border:none;
        cursor: pointer;
    }
    .filter span{
        padding:5px 15px;
        font-size:12px;
        color:#585a60;
        cursor: pointer;
    }
    .el-input{
        margin-right:20px;
    }
    .el-input,.el-select{
        width:25%;
    }
</style>

