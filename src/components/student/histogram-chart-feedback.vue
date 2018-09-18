<template>
    <ve-histogram 
        :data="chartData" 
        :settings="chartSettings"
        height="230px"
        width="229px"
        :extend="extend"
        ></ve-histogram>
</template>

<script>
import VeHistogram from 'v-charts/lib/histogram.common'
export default {
    components:{
        VeHistogram,
    },
    data () {
        this.chartSettings = {
            metrics: ['知识点数量',],
            dimension: ['知识点']
        },
        this.extend = {
            grid:{                
                bottom:40
            },
            legend:{
                bottom:0,
            }
        }
        return {
            chartData: {
            columns: ['知识点', '知识点数量'],
            rows: [
                { '知识点': '已掌握', '知识点数量': 139,},
                { '知识点': '未掌握', '知识点数量': 353,},
                { '知识点': '已掌握', '知识点数量': 292,},
                { '知识点': '未掌握', '知识点数量': 172,},
                { '知识点': '已掌握', '知识点数量': 379,},
                { '知识点': '未掌握', '知识点数量': 459,}
            ]
            }
        }
    }
}
</script>