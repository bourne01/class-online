<template>
    <div>
        <section>
            <course-filter class="filter"></course-filter>
        </section>
        <section>
            <course-list class="course-list"></course-list>
        </section>
    </div>
</template>

<script>
import CourseFilter from './filters'
import CourseList from './course-list'
export default {
    components:{
        CourseFilter,
        CourseList,
    }
}
</script>

<style scoped>
    .filter{
        margin:0 auto;
        width:1364px;
    }
    .course-list{
        min-height:300px;
        background-color:#f4f4f4;
    }
</style>


