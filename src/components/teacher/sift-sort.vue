<template>
    <div class="sift-sort">
        <div class="sift">
            <label for="">筛选：</label>
            <el-dropdown @command="onTitleCommand">
                <span class="el-dropdown-link">
                    {{title}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item 
                        v-for="(title,index) in titleList" :key="index" 
                        :command="title.key">{{title.name}}</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-dropdown @command="onGradeCommand">
                <span class="el-dropdown-link">
                    {{grade}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item 
                        v-for="(grade,index) in gradeList" :key="index" 
                        :command="grade.key">{{grade.name}}</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-dropdown @command="onCourseCommand">
                <span class="el-dropdown-link">
                    {{course}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item 
                        v-for="(course,index) in courseList" :key="index" 
                        :command="course.key">{{course.name}}</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
        <div class="sort">
            <label for="">排序：</label>
                <el-dropdown>
                    <span class="el-dropdown-link">
                        请选排序<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>黄金糕</el-dropdown-item>
                        <el-dropdown-item>狮子头</el-dropdown-item>
                        <el-dropdown-item>螺蛳粉</el-dropdown-item>
                        <el-dropdown-item disabled>双皮奶</el-dropdown-item>
                        <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            title:'教学职称',
            grade:'授课年级',
            course:'所授课程',
            titleList:[
                {key:-1,name:'全部职称'},
                {key:1,name:'黄金糕'},
                {key:2,name:'狮子头'},
                {key:3,name:'螺蛳粉'},],
            gradeList:[
                {key:-1,name:'全部年级'},
                {key:1,name:'黄金糕'},
                {key:2,name:'狮子头'},
                {key:3,name:'螺蛳粉'},],
            courseList:[
                {key:-1,name:'全部课程'},
                {key:1,name:'黄金糕'},
                {key:2,name:'狮子头'},
                {key:3,name:'螺蛳粉'},]
        }
    },
    methods:{
        onTitleCommand(command){
            for(let title of this.titleList){
                if(title.key === command){
                    this.title = title.name;
                }
            }
        }
    },
}
</script>

<style scoped>
    .sift-sort{
        width:1364px;
        height:68px;
        line-height:68px;
        margin:0 auto;
        display:flex;
        justify-content: space-between;
        font-size:12px;
    }
    .sift-sort .el-dropdown-link{
        color:#171a20;
    }
    .sift-sort label{
        margin-right:25px;
        color:#acadb0;
    }
    .sift .el-dropdown{
        margin-right:40px;
    }
</style>

