<template>
    <div class="top-one">
        <header>温州市瓯海区实验小学前汇校区</header>
        <ve-ring :data="chartData" :settings="chartSettings"></ve-ring>
    </div>
</template>

<script>
import VeRing from 'v-charts/lib/ring.common'
export default {
    components:{
        VeRing,
    },
     data () {
      this.chartSettings = {
        dimension: '日期',
        metrics: '访问用户',
        radius:['45%','65%'],
        label:{show:false},
        offsetY:180,
      }
      return {
        chartData: {
        columns: ['日期', '访问用户'],
        rows: [
            { '日期': '一年级', '访问用户': 1393 },
            { '日期': '二年级', '访问用户': 3530 },
            { '日期': '三年级', '访问用户': 2923 },
            { '日期': '四年级', '访问用户': 1723 },
            { '日期': '五年级', '访问用户': 3792 },
            { '日期': '六年级', '访问用户': 3992 },
          ]
        }
      }
    }
}
</script>

<style scoped>
    .top-one{
        padding:42px;
        border:1px solid #e4e4e5;
        height:308px;
        border-radius: 5px;
    }
    header{
        font-size:20px;
        font-weight: 600;
        text-align:center;
        padding-bottom:30px;
    }
</style>


