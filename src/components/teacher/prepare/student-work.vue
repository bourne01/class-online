<template>
    <ul>
        <li v-for="idx in 3" :key="idx">
            <question></question>
        </li>
    </ul>
</template>

<script>
import Question from './question'
export default {
    components:{
        Question,
    }
}
</script>

<style scoped>
    li{
        padding:40px 0;
        border-bottom:1px solid #f1f1f1;
    }
</style>

