<template>
    <div class="score-distribution">
        <header>
            <span>10月份</span>考试成绩分布情况
        </header>
        <ve-bar 
            :data="chartData" 
            :settings="chartSettings"
            height="150px"
            width="308px"
            :extend="extend"
            class="ve-bar"></ve-bar>
    </div>    
</template>

<script>
import VeBar from 'v-charts/lib/bar.common'
export default {
    components:{
        VeBar,
    },
    data () {
        this.chartSettings = {
            dimension: ['分数区间'],
            metrics: ['学生人数']
        },
        this.extend = {
            legend:{
                show:false,
            },
            grid:{
                top:20,
                bottom:20,
            }
        }
        return {
            chartData: {
            columns: ['分数区间', '学生人数'],
            rows: [
                { '分数区间': '90分以上 10人', '学生人数': 10},
                { '分数区间': '80分至89分', '学生人数': 18},
                { '分数区间': '70分至79分', '学生人数': 8},
                { '分数区间': '60分至69', '学生人数': 7},
                { '分数区间': '60以下', '学生人数': 4},
            ]
            }
        }
    }
}
</script>

<style scoped>
    .score-distribution{
       /*  border:1px solid #d4d4d4; */
        position:relative;
    }
    header{
        font-size:16px;
        color:#585a60;
        height:44px;
        line-height:44px;
        text-align:center;
        position:absolute;
        top:44px;
        background-color:#f8f8f8;
        border:1px solid #d4d4d4;
        width:308px;
    }
    header>span{
        color:#2185ff;
    }
    .ve-bar{
        top:89px;
        border:1px solid #d4d4d4;
    }
</style>