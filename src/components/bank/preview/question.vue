<template>
    <div class="question">
        <ul>
            <li>1、(2015河南安阳模拟)已知函数f(x)=ax2+bx+c，且a>b>c，a+b+c=0，则(　　)</li>
            <li>A．∃x0∈(0，1)，使得f(x0)=0 </li>
            <li>B．∃x0∈(0，1)，使得f(x0)>0</li>
            <li>C．∀x∈(0，1)，都有f(x)>0  </li>
            <li>D．∀x∈(0，1)，都有f(x)<0 </li>
            <li>
                <div class="left">
                    <div>
                        <span>
                            <img :src="require('../../../assets/svg/analyse-blue.svg')" alt="">
                            查看解析
                        </span>
                        <span>
                            <img :src="require('../../../assets/svg/check-error-blue.svg')" alt="">
                            纠错
                        </span>
                        <span>
                            <img :src="require('../../../assets/svg/error-blue.svg')" alt="">
                            删除
                        </span>
                    </div>                    
                </div>
                <div class="right">
                    <span>
                        <img :src="require('../../../assets/svg/move-up.svg')" alt="">上移
                    </span>
                    <span>
                        <img :src="require('../../../assets/svg/move-down.svg')" alt="">下移
                    </span>
                </div>      
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data(){
        return{
            
        }
    }
}
</script>


<style scoped>
    li{
        padding-left:40px;
        margin-bottom:20px;
    }
    li:first-child{
        padding-left:20px;
        font-weight: 600;
    }
    li:last-child{
        padding:0 20px;
        margin:0 auto;
        margin-top:30px;
        display:flex;
        line-height: 50px;
        height: 50px;
        justify-content: space-between;
        background-color:#e0ecff;
        width:846px;
    }
    img{
        width:22px;
        height:22px;
        vertical-align:middle;
        position: relative;
        top:-2px;
    }    
    .left>div>span{
        margin-right:20px;
    }    
    div>span{
        cursor: pointer;
        color:#2185ff;
    }
    .right span:first-child{
        margin-right:20px;
    }
</style>
