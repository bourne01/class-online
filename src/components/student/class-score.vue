<template>
    <div>
        <header>本学期高一(1)班语文平均成绩：<span>88.6</span>分</header>
        <div class="chart-wrapper">
            <line-chart-score></line-chart-score>
            <bar-chart></bar-chart>
        </div>
        
    </div>
</template>

<script>
import LineChartScore from './line-chart-score'
import BarChart from './bar-chart-score'
export default {
    components:{
        LineChartScore,
        BarChart,
    },
}
</script>

<style scoped>
    header{
        font-size:20px;
        color:#585a60;
        /* font-family: "PingFang-SC-Bold"; */
        font-weight: bold;
        text-align: center;
    }
    header>span{
        font-size:32px;
        color:#fa5b4a;        
    }
    .chart-wrapper{
        display:flex;
        justify-content: space-between;
    }
</style>

