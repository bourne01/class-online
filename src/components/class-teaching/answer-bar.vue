<template>
    <ve-bar 
        :data="chartData" 
        :settings="chartSettings"
        height="180px"
        width="520px"
        :extend="extend"></ve-bar>
</template>

<script>
import VeBar from 'v-charts/lib/bar.common'
export default {
    components:{
        VeBar
    },
    data () {
        this.chartSettings = {
            metrics: ['答题学生'],
            dataOrder: {
                label: '答题学生',
                order: 'desc'
            }
        }
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
            columns: ['选项', '答题学生'],
            rows: [
                { '选项': 'A', '答题学生': 1393 },
                { '选项': 'B', '答题学生': 3530 },
                { '选项': 'C', '答题学生': 2923 },
                { '选项': 'D', '答题学生': 1723 },
            ]
            }
        }
    }
}
</script>