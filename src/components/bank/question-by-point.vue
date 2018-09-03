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
                        <img :src="require('../../assets/svg/analyse.svg')" alt="">
                        查看解析
                        </span>
                        <span>
                            <img :src="require('../../assets/svg/faovrite2.svg')" alt="">
                            收藏
                        </span>
                        <span>
                            <img :src="require('../../assets/svg/check-error.svg')" alt="">
                            纠错
                        </span>
                    </div>
                    <div>
                        <span>
                           <label for="">难易度：</label>容易
                        </span>
                        <span>|</span> 
                        <span>
                           <label for="">组卷次数：</label>1235
                        </span>
                        <span>|</span> 
                        <span>
                           <label for="">答对率：</label>285
                        </span>
                    </div>
                </div>
                <div class="right">
                    <button class="question-added">
                        <i class="el-icon-circle-plus"></i>加入组卷
                    </button>
                </div>
            </li>
        </ul>
    </div>
</template>

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
        padding-left:10px;
        margin-top:30px;
        margin-bottom:0;
        display:flex;
        line-height: 50px;
        height: 50px;
        justify-content: space-between;
    }
    .left img{
        width:22px;
        height:22px;
        vertical-align:middle;
        position: relative;
        top:-2px;
    }
    .left{
        display:flex;
        justify-content: space-between;
        width:690px;
        padding:0 20px;
        background-color:#f1f1f1;
    }
    .left>div>span{
        margin-right:10px;
    }
    .right{
        padding-right:20px;
    }
    .el-icon-circle-plus{
        margin-right:5px;
        font-size:18px;
        position: relative;
        top:2px;
    }
    .right button{
        height:50px;
        line-height:50px;
        text-align: center;
        border: none;
        outline: none;
        width:146px;
        background-color:#ffe8e0;
        color:#fa5b4a;
        border-radius:4px;
        border-radius:2px;
    }
    .question-added{
        background-color:#fa5b4a!important;
        color:#fff!important;
    }
</style>
