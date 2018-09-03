<template>
    <div class="question">
        <ul>
            <li>1、(2015河南安阳模拟)已知函数f(x)=ax2+bx+c，且a>b>c，a+b+c=0，则(　　)</li>
            <li>A．∃x0∈(0，1)，使得f(x0)=0 </li>
            <li>B．∃x0∈(0，1)，使得f(x0)>0</li>
            <li>C．∀x∈(0，1)，都有f(x)>0  </li>
            <li>D．∀x∈(0，1)，都有f(x)<0 </li>
            <li>
                <span @click="onSelect(0)">
                    <img 
                        :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                        v-if="!selectedList[0]"
                    >
                    <img 
                        :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                        v-else
                    >A
                </span>  
                <span @click="onSelect(1)">
                    <img 
                        :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                        v-if="!selectedList[1]"
                    >
                    <img 
                        :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                        v-else
                    >B
                </span>  
                <span @click="onSelect(2)">
                    <img 
                        :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                        v-if="!selectedList[2]"
                    >
                    <img 
                        :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                        v-else
                    >C
                </span>  
                <span @click="onSelect(3)">
                    <img 
                        :src="require('../../../assets/svg/circle-blue.svg')" alt=""
                        v-if="!selectedList[3]"
                    >
                    <img 
                        :src="require('../../../assets/svg/circle-selected.svg')" alt=""
                        v-else
                    >D
                </span>    
            </li>
        </ul>
        <aside>
            <i class="el-icon-edit-outline"></i>
            <br>
            <i class="el-icon-delete"></i>
        </aside>
    </div>
</template>

<script>
export default {
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
        onSelect(index){
            this.selectedList = [];
            this.selectedList[index] = true;//第index选项被选中
        }
    }
}
</script>


<style scoped>
    .question{
        display: flex;
        justify-content: space-between;
    }
    ul{
        width:100%;
        border-right:1px solid #f1f1f1;
    }
    li{
        padding-left:70px;
        margin-bottom:20px;
    }
    li:first-child{
        padding-left:40px;
        font-weight: 600;
    }
    li:last-child{
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
    img{
        width:24px;
        height:24px;
        vertical-align:middle;
        position: relative;
        top:-2px;
    }      
    li:last-child>span{
        cursor: pointer;
        margin-right:60px;
    }
    aside{
        width:60px;
        align-self: center;
        text-align: center;
    }
    aside i{
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
