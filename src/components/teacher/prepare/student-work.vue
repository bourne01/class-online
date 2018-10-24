<template>
    <ul class="student-work">
        <li v-for="idx in 3" :key="idx">
            <div class="question">
                <ul>
                    <li>1、(2015河南安阳模拟)已知函数f(x)=ax2+bx+c，且a>b>c，a+b+c=0，则(　　)</li>
                    <li>A．∃x0∈(0，1)，使得f(x0)=0  </li>
                    <li>B．∃x0∈(0，1)，使得f(x0)>0</li>
                    <li>C．∀x∈(0，1)，都有f(x)>0  </li>
                    <li>D．∀x∈(0，1)，都有f(x)&lt;0 </li>
                    <li>
                        <span @click="onSelect(idx,0)">
                            <img 
                                :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                                v-if="!selectedList[idx][0]"
                            >
                            <img 
                                :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                                v-else
                            >A
                        </span>  
                        <span @click="onSelect(idx,1)">
                            <img 
                                :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                                v-if="!selectedList[idx][1]"
                            >
                            <img 
                                :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                                v-else
                            >B
                        </span>  
                        <span @click="onSelect(idx,2)">
                            <img 
                                :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                                v-if="!selectedList[idx][2]"
                            >
                            <img 
                                :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                                v-else
                            >C
                        </span>  
                        <span @click="onSelect(idx,3)">
                            <img 
                                :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                                v-if="!selectedList[idx][3]"
                            >
                            <img 
                                :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                                v-else
                            >D
                        </span>    
                    </li>
                </ul>
                <aside>
                    <i class="el-icon-edit-outline" @click="onClick('edit',idx)"></i>
                    <br>
                    <i class="el-icon-delete" @click="onClick('delete')"></i>
                </aside>
            </div>
        </li>
    </ul>
</template>

<script>
/* import Question from './question' */
export default {
    props:['work-type','question'],
    components:{
        /* Question, */
    }, 
    data(){
        return{
            selectedList:[],//答案选择列表
        }
    },
    methods:{
        /**
         * @function 监听答案选择事件
         * @param {index} 答案序号
         */
        onSelect(index1,index2){
            let maxItems = 4;  
            for(let i=0;i<maxItems;i++)//初始本题中所有选项为未选中  
                this.selectedList[index1][i] = false;        
            this.$set(this.selectedList[index1],index2,true)//第index选项被选中
        },

        /**
         * @function 监听编辑或删除事件
         * @param {操作类型} type
         */
        onClick(type,idx){
            if(type === 'edit'){
                this.$root.bus.$emit('edit-question',this.question[idx])
            }
        },
    },
    created(){
        /**@function 初始化一个二维数组 */
        for(let i=0;i<4;i++)
            this.selectedList.push([])
    }
}
</script>

<style scoped>
    .student-work>li{
        padding:40px 0;
        border-bottom:1px solid #f1f1f1;
    }
    .question{
        display: flex;
        justify-content: space-between;
    }
    .question ul{
        width:100%;
        border-right:1px solid #f1f1f1;
    }
    .question li{
        padding-left:70px;
        margin-bottom:20px;
        line-height:1.5em;
    }
    .question li:first-child{
        padding-left:40px;
        font-weight: 600;
        
    }
    .question li:last-child{
        margin-left:40px;
        margin-top:30px;
        padding-left:20px;
        line-height: 50px;
        height: 50px;
        background-color:#f6f6f6;
        width:816px;
        color:#2185ff;
        border-radius: 25px;
        margin-bottom:0;
    }
    .question img{
        width:24px;
        height:24px;
        vertical-align:middle;
        position: relative;
        top:-2px;
    }      
    .question li:last-child>span{
        cursor: pointer;
        margin-right:60px;
    }
    .question aside{
        width:60px;
        align-self: center;
        text-align: center;
    }
    .question aside i{
        cursor: pointer;
    }
    .el-icon-edit-outline{
        margin-bottom:30px;
        color:#acadb0;
    }
    .el-icon-edit-outline:hover{
        color:#2185ff;
    }
    .el-icon-delete{
        color:#2185ff;
    }
    .el-icon-delete:hover{
        color:#fc6835;
    }
    i{
        font-size:18px;
    }
</style>
