<template>
    <div>
        <header class="course-type">
            <course-tab></course-tab>
            <div class="strip"></div>
        </header>   
        <section>
            <course-filter class="filter"></course-filter>
        </section>
        <section>
            <course-list class="course-list"></course-list>
        </section>
    </div>
</template>

<script>
import CourseFilter from '../../../../components/course/filters'
import CourseList from '../../../../components/course/course-list'
import CourseTab from '../../../../components/course/course-tab'
export default {
    components:{
        CourseFilter,
        CourseList,
        CourseTab
    }
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


