<template>
    <div class="count-blocks">
        <count-block style="width:14.5%;height:104px;"
            v-for="(item,index) in countBlocks" 
            :key="index"             
            @mouseover.native="actNum=index"
            @mouseout.native="actNum=-1"
            :class="{active:actNum===index}">
            <span slot="up" class="up" :class="{txtActive:actNum===index}">
                <img :src="index===actNum?countActBlocks[index].icon:item.icon" 
                    alt="">课程总数
            </span>
            <span slot="middle" class="mid" :class="{txtActive:actNum===index}">{{item.total}}</span>
            <span slot="down" class="down" :class="{txtActive:actNum===index}">今日上传课程{{item.onlineNum}}个</span>
        </count-block>
        <img :src="require('../../../assets/home/list.jpg')" class="list-pic" alt="" @click="switchMode">
    </div>
</template>

<script>
import CountBlock from '../../../components/home/count-block'
export default {
    components:{
        CountBlock
    },
    data(){
        return{
            actNum:1,
            countBlocks:[
                {icon:require('../../../assets/home/course.png'),total:246,onlineNum:123},
                {icon:require('../../../assets/home/teacher.png'),total:246,onlineNum:123},
                {icon:require('../../../assets/home/student.png'),total:246,onlineNum:123},
                {icon:require('../../../assets/home/school.png'),total:246,onlineNum:123},
                {icon:require('../../../assets/home/news.png'),total:246,onlineNum:123},],
            countActBlocks:[
                {icon:require('../../../assets/svg/course-white.svg')},
                {icon:require('../../../assets/svg/teacher-white.svg')},
                {icon:require('../../../assets/svg/student-white.svg')},
                {icon:require('../../../assets/svg/school-white.svg')},
                {icon:require('../../../assets/svg/news-white.svg')},],
            path:'',
        }
    },
    methods:{
        /**@function 切换显示模式 */
        switchMode(){
            console.log(this.path.indexOf('-icon'));
            if(this.path.indexOf('-icon') !== -1){      
                console.log('hi');          
                this.$router.push('/admin/main');
            }else{
                const {href} = this.$router.resolve({
                    name:'AdminIcon'
                })
                console.log(href);
                window.open(href,'_blank');
                //this.$router.push('/home-icon/main')
            }
        }
    },
    created(){
        this.path = this.$route.path;
    }
}
</script>

<style scoped>
    .count-blocks{
        display: flex;
        justify-content: space-between;
    }
    .list-pic{
        position:absolute;
        top:18px;
        left:20px;
        cursor: pointer;
    }
    .active{
        background:linear-gradient(to top right,#8b62ff , #0a8dff);
        color:#fff!important;
    }
    .txtActive{
        color:#fff!important;
    }
    .count-block .up{
        font-size:18px;
        color:#acadb0;
    }
    .count-block img{
        margin-right:5px;
        width:28px;
        vertical-align: middle;
        margin-bottom:8px;
    }   
    .mid{
        font-size:40px;
        color:#585a60;
        margin-bottom:22px;    
    }
    .down{
        color:#585a60;
        font-size:14px;
    }
</style>


