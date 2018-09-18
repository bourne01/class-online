<template>
    <article>
        <filters :is-filter="true">           
        </filters>
        <section>
            <aside>
                <knowledge-tree></knowledge-tree>
            </aside>
            <div class="main">
                <table>
                    <thead>
                        <tr>
                            <th rowspan="2" class="first-col">已选知识点（3）</th>
                            <th class="second-col">题目数</th>
                            <th>单选</th>
                            <th>多选</th>
                            <th>填空</th>
                            <th>解答</th>
                        </tr>
                        <tr>
                            <th class="th-bg">30</th>
                            <th class="th-bg">30</th>
                            <th class="th-bg">30</th>
                            <th class="th-bg">30</th>
                            <th class="th-bg">30</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="idx in 5" :key="idx">
                            <td>
                                <div  class="first-td"><span>一次函数性质</span><i class="el-icon-close"></i></div></td>
                            <td>33</td>                         
                            <td>
                                <el-input-number
                                    v-model="num" 
                                    size="small"
                                    controls-position="right" @change="handleChange" :min="1" :max="10"></el-input-number>
                                <span>/58</span>
                            </td>                         
                            <td>
                                <el-input-number
                                    v-model="num" 
                                    size="small"
                                    controls-position="right" @change="handleChange" :min="1" :max="10"></el-input-number>
                            </td>                         
                            <td>
                                <el-input-number
                                    v-model="num" 
                                    size="small"
                                    controls-position="right" @change="handleChange" :min="1" :max="10"></el-input-number>
                            </td>                         
                            <td>
                                <el-input-number
                                    v-model="num" 
                                    size="small"
                                    controls-position="right" @change="handleChange" :min="1" :max="10"></el-input-number>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="bottom">
                    <div class="tip">
                        <div class="triangle"></div>
                        <span>请先从左侧选择要考察的知识点</span>
                    </div>
                    <button>进入组卷</button>
                </div>
            </div>
        </section>
    </article>
</template>

<script>
import Filters from '../filters'
import KnowledgeTree from '../knowledge-point'
import Question from '../question-by-point'
import MyFooter from '../footer'
export default {
    components:{
        Filters,
        KnowledgeTree,
        Question,
        MyFooter,
    },
    data(){
        return{
            num:0,
        }
    },
    destroyed(){
        document.querySelector('.footer').style.position = 'absolute';
    },
    mounted(){
        //document.querySelector('.footer').style.position = 'fixed';
    }
    
}
</script>

<style>
    .main table .el-input-number--small{
        width:90px;
    }
</style>

<style scoped>
    header{
        height:58px;
        line-height:58px;
        padding-left:20px;
        padding-right:20px;
        display: flex;
        justify-content: space-between;
        margin-bottom:10px;
        background-color:#fff;
    }
    .count{
        color:#fa5b4a;
    }
    .plus-txt{
        color:#2185ff;
    }
    button{
        outline: none;
        border:none;
        color:#fff;
        font-size:12px;
        height:36px;
        line-height:36px;
        text-align:center;
        width:118px;
        border-radius:2px;
        background:#fa5b4a;
    }
    section{
        margin-top:10px;
        display:flex;
    }
    aside{
        width:299px;
        min-height:898px;
        background-color:#fff;
        margin-bottom:78px;
        margin-right:10px;
    }
    .main{
        width:926px;        
        margin-bottom:78px;
    }
    table{
        background-color:#fff;
        width:100%;
        border-collapse:collapse;
        font-size:14px;
    }
    thead{
        background-color:#72adf6;
        color:#fff;
        
    }
    .first-td{
        display:flex;
        justify-content:space-between;
    }
    .first-col{
        width:270px;
    }
    .second-col{
        width:72px;
    }
    thead tr{
        height:48px;
    }
    tbody tr{
        height:70px;
    }
    th,td{
        border:1px solid #f1f1f1;
        text-align:center;
        vertical-align:middle;
        padding:0 10px;
        box-sizing:border-box;
    }
    .th-bg{
        background-color:#c6defb!important;
    }
    th{
        border:1px solid #5d99e3;
    }
    .first-td{
    }
    thead tr:first-child th{
        border-top:0;
        
    }
    thead tr:nth-child(2) th{
        /* width:72px!important; */
    }
    tbody tr:last-child td{
        border-bottom:0;
    }
    tr td:first-child,tr th:first-child{
        border-left:0;
        
    }
    tr td:last-child,tr th:last-child{
        border-right:0;
    }
    td>span{
        color:#acadb0;
        margin-left:10px;
    }
    .el-icon-close{
        color:#fa5b4a;
        font-size:20px;
    }
    .el-icon-close:hover{
        background-color:#f4f4f4;
    }
    .tip{
        width:254px;
        height:36px;
        line-height:36px;
        text-align:center;
        color:#acadb0;
        font-size:12px;
        background-color:#fff;
        position: relative;
    }
    .bottom{
        display:flex;
        justify-content:space-between;
        margin-top:30px;
    }
    .triangle{
        height:0;
        width:0;
        border-right:8px solid #fff;
        border-left:0 solid transparent;
        border-top:5px solid transparent;
        border-bottom:5px solid transparent;
        position:absolute;
        top:13px;
        left:-8px;
    }
</style>


