<template>
    <div>
        
        <div class="members" 
            :class="{active:hoverIdx===index}"
            @mouseover="hoverIdx=index"
            @mouseout="onMouseout"
            @click="onClick">          
            <div class="numone">                
                <div class="head-box">
                    <img :src="require('../../assets/student/avatar.png')" alt="">
                </div>
                <div class="introduce">
                    <h4>周庶</h4><span>
                        <img :src="require('../../assets/student/male.png')" alt="">
                    </span>
                    <p>ID 124633</p>
                </div>
            </div>
            <div class="indicator"></div>
        </div>
    </div>
   
</template>
<script>

export default {
    props:['index'],
    components:{

    },
    data(){
        return{
            hoverIdx:-1,
            clickIdx:-1
        }
    },
    methods:{
        /**@function 处理点击事件 */
        onClick(){
            this.clickIdx = this.index;
            this.$root.bus.$emit('click-student',this.index)
        },
        /**@function 处理鼠标离开事件 */
        onMouseout(){
            //非选中状态下，则重置hoverIdx实现指示条移动
            if(this.clickIdx == -1){
                this.hoverIdx = -1;
            }
        },
        /**@function 监听点击学生事件 */
        onClickStudent(idx){
            //点击自己,则忽略,否则，重置上一个选中项
            if(this.index!=idx){
                this.clickIdx = -1;
                this.hoverIdx = -1;
            }
            
        }
    },
    mounted(){
        this.$root.bus.$on('click-student',this.onClickStudent)
    }
}
</script>

<style scoped>    
    .members{
        /* width: 250px; */
        height: 80px;
        margin-bottom: 6px;
        background-color: #fff;
        position: relative;
    }
    .members:hover{
        background-color:#f3f3f6;
    }
    .indicator{
        display:none;
    }
    .active .indicator{
        display:block;
        position:absolute;
        left:0;
        top:0;
        width:4px;
        height: 80px;
        background-color: #fa5b4a;
    }
    .numone{
        width: 180px;
        height: 56px;
        padding-left: 30px;
        padding-top: 12px;
    }
    .circle-box,.head-box{
        float: left;
    }
    .numone .circle-box{
        display: block;
        width: 22px;
        height: 22px;
        margin-right: 20px;
        margin-top: 16px
    }
    .numone .head-box{
        display: block;
        width: 56px;
        height: 56px;
    }
    .numone span{
        display: block;
        width: 13px;
        height: 14px;
        margin-left: 40px;
        margin-top: 3px;
    }
    .numone .introduce{
        margin-left:10px;
        float: left;
        width: 70px;
        height: 38px;
        padding-top: 10px;
    }
    h4{
        float: left;
        color: #171a20;
        font-size: 16px;
    }
    p{
        line-height: 28px;
        color: #939aad;
        font-size: 14px;
    }
</style>