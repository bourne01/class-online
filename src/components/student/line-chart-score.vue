<template>
  <ve-line 
    :data="chartData" 
    :settings="chartSettings"
    :colors="colors"
    height="250px"
    width="527px"
    :extend="extend"></ve-line>
</template>

<script>
import VeLine from 'v-charts/lib/line.common'
export default {
    components:{
        VeLine,
    },
    data () {
        this.chartSettings = {
            metrics: ['本班成绩曲线', '年级成绩曲线'],
            xAxisType:'category',
            dimension: ['月份']
        },
        this.colors = ['#2185ff','#acadb0'],
        this.extend = {
            series: {
                label: {
                    normal: {
                    show: false
                    }
                },
                smooth:false,                
            },
            legend:{
                bottom:'20px',
            }
        }
        return {
        chartData: {
            columns: ['月份', '本班成绩曲线', '年级成绩曲线'],
            rows: [
            { '月份': '9月', '本班成绩曲线': 1393, '年级成绩曲线': 1093},
            { '月份': '10月', '本班成绩曲线': 3530, '年级成绩曲线': 3230},
            { '月份': '11月', '本班成绩曲线': 2923, '年级成绩曲线': 2623},
            { '月份': '12月', '本班成绩曲线': 1723, '年级成绩曲线': 1423},
            { '月份': '1月', '本班成绩曲线': 3792, '年级成绩曲线': 3492},
            ]
        }
        }
    }
}
</script>