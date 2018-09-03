<template>
    <div>
        <nav>
            <ul>
                <li 
                    :class="{active:actLi===1}"
                    @click="actLi=1">
                    <span>全部</span>
                    <div class="bar-wrap">
                        <div class="bar all"></div>
                    </div>
                    
                </li>
                <li 
                    :class="{active:actLi===2}"
                    @click="actLi=2">
                    <span>公开课(2)</span>
                    <div class="bar open"></div>
                </li>
                <li 
                    :class="{active:actLi===3}"
                    @click="actLi=3">
                    <span>任务课(36)</span>
                    <div class="bar routine"></div>
                </li>
            </ul>
        </nav>
        <div class="course-wrap">
            <course class="course" v-for="idx in 9" :key="idx"></course>
        </div>
    </div>    
</template>
<script>
import Course from '../../common/course'
export default {
    components:{
        Course,
    },
    data(){
        return{
            actLi:-1,
        }
    }
    
}
</script>

<style scoped>
    nav{
        background-color:#fff;
        margin-bottom:20px;
    }
    nav li{
        height:78px;
        line-height:78px;
        color:#171a20;        
        font-size:20px;        
        
        display:inline-block;
        width:130px;
        text-align: center;
    }
    .bar-wrap{
        width:100%;
    }
    .active .bar{
        position: relative;
        top:-4px;
        height:4px;        
        background:linear-gradient(to top,#8b62ff , #0a8dff);
        margin:0 auto;
    }
    .all{
        width:2.6em;
    }
    .open{
        width:5.6em;
    }
    .routine{
        width:5.6em;
    }
    .course-wrap{
        display: flex;
        justify-content: space-between;
        flex-flow: row wrap;
        align-content: flex-start;
    }
    .course{
        width:312px;
        margin-bottom:40px;
    }
</style>


