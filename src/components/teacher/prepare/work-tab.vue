<template>
    <div class="work-tab">
        <ul class="tabs">
            <li @click="onClick(1)"
                :class="{active:actIndex===1}">课前作业
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(2)" 
                :class="{active:actIndex===2}">课中作业
                <div class="active-bar"></div>
            </li>
            <li @click="onClick(3)" 
                :class="{active:actIndex===3}">课后作业
                <div class="active-bar"></div>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
            actIndex:1,//初始化时，鼠标悬停活动条显示那个标签下
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
                            '/admin-index/prepare/work/:1',
                            '/admin-index/prepare/work/:2',
                            '/admin-index/prepare/work/:3',];
            this.$router.push(routerList[actIndex-1]);            
        },
    }
};
</script>

<style scoped>
    .work-tab{
        display:flex;
        justify-content: space-between;
    }
    .tabs li{
        height:90px;
        line-height:90px;
        font-size:20px;
        text-align: center;
        display:inline-block;
        margin-right:90px;
        width:120px;
        position: relative;
        cursor: pointer;
    }
    .tabs li:first-child{
        margin-left:20px;
    }
    .active .active-bar{
        display:inline-block;
    }
    .active-bar{
        display:none;
        height:4px;
        width:124px;
        position:absolute;
        bottom:0;
        left:0;
        background-color:#fc6835;
    }
    .active{
        color:#fc6835!important;
    }
</style>
