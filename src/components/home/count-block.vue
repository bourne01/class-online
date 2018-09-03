<template>
    <div class="count-block">
        <slot name="up"></slot>
        <slot name="middle"></slot>
        <slot name="down"></slot>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    .count-block{
        display:flex;
        flex-direction: column;
        justify-content: space-between;
        padding:20px 0 28px 38px;        
        border-radius: 5px;
        border:1px solid #e4e4e5;
        color:#585a60;
        font-size:14px;
        text-align: left;        
    }
</style>


