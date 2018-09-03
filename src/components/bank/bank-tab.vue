<template>
    <div class="bank-tab">
        <ul class="tabs">
            <li @click="onClick(1)"
                :class="{active:actIndex===1}">综合试题
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(2)" 
                :class="{active:actIndex===2}">同步试题
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(3)" 
                :class="{active:actIndex===3}">自由组卷
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(4)" 
                :class="{active:actIndex===4}">试题库
                <div class="active-bar"></div>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
            actIndex:-1,//初始化时，鼠标悬停活动条显示那个标签下
            clickIndex:-1,//初始化时，鼠标点击活动条显示那个标签下
            isClick:false,//判断标签是否被点击
        };
    },
    methods: {
        /**@function 监听点击tab事件
         * @param {激活的标签序号} actIndex
         */
        onClick(actIndex) {
            this.actIndex = actIndex;
            let routerList = [
                            '/admin-index/bank/compre-question',
                            '/admin-index/bank/sync-question',
                            '/admin-index/bank/compose-paper',
                            '/admin-index/bank/papers'];
            this.$router.push(routerList[actIndex-1]);
            
        },
    }
};
</script>

<style scoped>
    .bank-tab{
        background-color:#fff;
    }
    .tabs{
        width:1364px;
        margin:0 auto;
    }
    .tabs li{
        height:68px;
        line-height:68px;
        font-size:18px;
        text-align: center;
        color:#585a60;
        display:inline-block;
        margin-right:48px;
        width:110px;
        position: relative;
        cursor: pointer;
    }
    .tab li:first-child{
        padding-left:20px;
    }
    .active .active-bar{
        display:inline-block;
    }
    .active-bar{
        display:none;
        height:4px;
        width:110px;
        position:absolute;
        bottom:0;
        left:0;
        background-color:#fc6835;
    }
    .active{
        color:#fc6835!important;
    }
</style>
