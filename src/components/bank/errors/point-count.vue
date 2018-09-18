<template>
    <div class="point">
        <h2>班级知识点掌握统计</h2>
        <div class="chart">
            <div class="title">
                <ul class="chart-series">
                    <div><li><p>函数的概念与函数的表示方法</p></li></div>
                    <div><li><p>函数的定义域及求法</p></li></div>
                    <div><li><p>函数的解析式及求法</p></li></div>
                    <div><li><p>函数的值域及求法</p></li></div>
                    <div><li><p>函数的概念与函数的表示方法</p></li></div>
                </ul>
            </div>
            <div class="column">
                <table>
                    <tbody>
                        <tr v-for="idx in 5" :key="idx">
                            <td style="border-left: 0px;"></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td style="border-right: 0px;"></td>
                        </tr>
                    </tbody>
                </table> 
            </div>
       <!--  <statistics-bar></statistics-bar> -->
       <counting-bar></counting-bar>
        </div>
        <div class="completion-rate">
            <p>10%</p>
            <p>20%</p>
            <p>30%</p>
            <p>40%</p>
            <p>50%</p>
            <p>60%</p>
            <p>70%</p>
            <p>80%</p>
            <p>90%</p>
            <p>100%</p>
        </div>
        <div class="unfinished">
            <div></div>
            <p>为掌握知识点</p>
            <a href="javaScript:;">查看更多  ></a>
        </div>
    </div>
</template>

<script>
import CountingBar from './counting-bar'
export default {
    components:{
        CountingBar,
        
    },
    
}
</script>

<style scoped>
    td{
        width: 75px;
        height: 37px;
        border: 1px dashed #e4e4e5;
    }
    .point{
        height: 418px;
        background: white;
        margin-top: 0px;
    }
    h2{
        padding-top: 45px;
        padding-bottom: 36px;
        margin-left: 36px;
        font-size: 22px;
        
    }
    .chart{
        width: 1009px;
        height: 195px;
        margin: 0 auto;
    }
    .chart .title{
        width: 242px;
        float: left;
    }
    .chart-series{
        border-top: 1px dashed #e4e4e5;
        border-right: 1px dashed #e4e4e5;
        height: 190px;
    }
    .chart-series li{
        list-style:initial;
        font-size:1px;
        float: right;  
    }
    .chart-series div{
        border-bottom: 1px dashed #e4e4e5;
        height: 37px;
    }
    .chart-series li p{
        line-height: 37px;
        margin-right: 19px;
        font-size: 12px;
        color: #585a60;
    }
    .column{
        float: left;
        width: 766px;
        height: 192px;
    }
    tr{
        position: relative;
        width: 766px;
    }
    .completion-rate{
        margin-left: 333px;
        height: 30px;
    }
    .completion-rate p{
        float: left;
        line-height: 30px;
        margin-right: 50px;
        color: #585a60;
        font-size: 8px;
    }
    .unfinished{
        margin-top: 24px;
        margin-left: 340px;
        width: 660px;
    }
    .unfinished div{
        width: 12px;
        height: 12px;
        background: #fc6c2e;
        border-radius: 50%;
        margin-right: 6px;
        float: left;
    }
    .unfinished p{
        float: left;
        color: #585a60;
    }
    .unfinished a{
        float: right;
        color: #585a60;
        text-decoration: none;
    }
     
</style>


