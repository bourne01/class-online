<template>
    <div class="bank-tab">
        <ul class="tabs">
            <li>
                <el-dropdown @command="onTitleCommand">
                    <span class="el-dropdown-link">
                        {{title}}<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item 
                            v-for="(title,index) in titleList" :key="index" 
                            :command="title.key">{{title.name}}</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </li>
            <li @click="onClick(idx)"
                v-for="idx in 3" 
                :key=idx 
                :class="{active:actIndex===idx}">
                高{{idx}}班
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
            title:'教学职称',
            titleList:[
                {key:-1,name:'全部职称'},
                {key:1,name:'黄金糕'},
                {key:2,name:'狮子头'},
                {key:3,name:'螺蛳粉'},],
        };
    },
    methods: {
        /**@function 监听点击tab事件
         * @param {激活的标签序号} actIndex
         */
        onClick(actIndex) {
            this.actIndex = actIndex;
            /* let routerList = [
                            '/admin-index/bank/questions',
                            '/admin-index/bank/errors',
                            '/admin-index/bank/favorites',
                            '/admin-index/bank/mine'];
            this.$router.push(routerList[actIndex-1]); */
            
        },
        onTitleCommand(command){
            for(let title of this.titleList){
                if(title.key === command){
                    this.title = title.name;
                }
            }
        }
    },
    mounted(){
        //this.$router.push('/admin-index/bank/compre-question');
        //this.$router.push('/admin-index/bank/quesions');
    }
};
</script>

<style scoped>
    .bank-tab{
        background-color:#fff;
    }
    .tabs{
        width:1235px;
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
