<template>
    <article>
        <header>
            <toolbar class="toolbar"></toolbar>
        </header>
        <section>
            <div>
               <paper-header></paper-header>
                <ul>
                    <li v-for="idx in 5" :key="idx">
                        <question></question>
                    </li>
                </ul> 
            </div>            
        </section>
    </article>
</template>

<script>
import Toolbar from '../../../../components/bank/preview/toolbar'
import PaperHeader from '../../../../components/bank/preview/paper-heading'
import Question from '../../../../components/bank/preview/question'
export default {
    components:{
        Toolbar,
        PaperHeader,
        Question,
    },    
}
</script>

<style scoped>
    .toolbar{
        width:1364px;
        margin:0 auto;
    }
    section{
        padding:20px;
        background-color:#f1f1f1;
    }
    section>div{
        width:926px;
        margin: 0 auto;
    }
    ul{
        padding-top:20px;
        border-top:1px solid #f1f1f1;
        background-color:#fff;
    }
    li{
        padding:20px 0;
    }
    li:hover{
        border:1px solid #2185ff;
    }
</style>

