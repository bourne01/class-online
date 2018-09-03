<template>
    <div style="background-color:#171a20;">
        <course-player></course-player>
        <course-tab></course-tab>
        <div class="container-bg">
            <div class="container">
                <div class="left">
                    <transition name="fade" mode="out-in">
                    <router-view></router-view>
                    </transition>  
                </div>                
                <div class="right">
                    <course-teacher></course-teacher>
                    <other-course></other-course>
                </div>
            </div>
        </div>        
    </div>        
</template>

<script>
import CoursePlayer from '../../../../components/course-detail/course-player'
import CourseTab from '../../../../components/course-detail/course-tab'
import CourseTeacher from '../../../../components/course-detail/course-teacher'
import OtherCourse from '../../../../components/course-detail/other-course'
export default {
    components:{
        CoursePlayer,
        CourseTab,
        CourseTeacher,
        OtherCourse,
    }
    
}
</script>

<style scoped>
    .container-bg{
        background-color:#f1f1f1;
    }
    .container{
        display:flex;
        justify-content: space-between;
        width:1364px;
        margin:0 auto;
        padding-top:20px;
        padding-bottom:20px;
    }
    .left{
        width:988px;
    }

</style>


