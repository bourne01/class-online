<template>
    <div>
        <header class="course-type">
            <course-tab @course-type="onCourseType"></course-tab>
            <div class="strip"></div>
        </header>   
        <section>
            <course-filter class="filter" :course-type="courseType"></course-filter>
        </section>
        <section>
            <course-list class="course-list" v-if="courseType==='compulsory'"></course-list>
            <opencourse-list class="course-list" v-else></opencourse-list>
        </section>
    </div>
</template>

<script>
import CourseFilter from '../../../../components/course/filters'
import CourseList from '../../../../components/course/course-list'
import OpencourseList from '../../../../components/course/opencourse-list'
import CourseTab from '../../../../components/course/course-tab'
export default {
    components:{
        CourseFilter,
        CourseList,
        CourseTab,
        OpencourseList
    },
    data(){
        return{
            courseType:'compulsory',//课程类型：任务课(compulsory)，公开课(open)
        }
    },
    methods:{
        /**
         * @function 监听来自子组件'course-tab'的课程类型切换事件
         * @param {课程类型：1,compulsory 2,open} type
         */
        onCourseType(type){
            this.courseType = type;
        }
    },
}
</script>

<style scoped>
    .course-type>.strip{
        height:20px;
        background-color:#f4f4f4;
    }

    .filter{
        margin:0 auto;
        width:1364px;
    }
    .course-list{
        min-height:300px;
        background-color:#f4f4f4;
    }
</style>


