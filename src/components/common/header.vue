<template>
    <div class="header">
        <div class="header-content">
            <nav-bar :btn-active="actNum!=-1" v-if="isShow"></nav-bar><!-- 告知NavBar组件右侧按钮是否激活 -->
            <el-autocomplete
                popper-class="my-autocomplete"
                v-model="state3"
                :fetch-suggestions="querySearch"
                placeholder="请输入内容"
                @select="onSelect"
                class="search" 
                v-show="!isShow"
                ref="search"  
                >
                <i
                    class="el-icon-search el-input__icon"
                    slot="suffix"
                    @click="onIconClick('search')">
                </i>
                <i
                    class="el-icon-close el-input__icon"
                    slot="prefix"
                    @click="onIconClick('close')">
                </i>
                <template slot-scope="{ item }">
                    <div class="name">{{ item.value }}</div>
                    <!-- <span class="addr">{{ item.address }}</span> -->
                </template>
            </el-autocomplete>            
            <div class="btn-wrap">
                <!-- <el-input class="search" v-if="isSearch"></el-input> -->
                <i class="el-icon-search search-btn" 
                    @click="onIconClick('_search')"
                    v-if="isShow"
                    :class="{active:actNum===0}"
                    @mouseover="onMouseOver(0)"
                    @mouseout="actNum=-1"
                    :style="{background:actNum===0?'#000':''}">
                    <div class="indicator-bar"></div>
                </i>
                <i 
                    class="el-icon-upload"
                    :class="{active:actNum===1}"
                    @mouseover="onMouseOver(1)"
                    @mouseout="actNum=-1"
                    :style="{background:actNum===1?'#000':''}">
                    <div class="indicator-bar"></div></i>
                <i 
                    class="el-icon-bell"
                    :class="{active:actNum===2}"
                    @mouseover="onMouseOver(2)"
                    @mouseout="actNum=-1"
                    :style="{background:actNum===2?'#000':''}">
                    <div class="indicator-bar"></div>
                </i>
                <div class="avatar" 
                    :class="{active:actNum===3}"
                    @mouseover="onMouseOver(3)"
                    :style="{background:actNum===3?'#000':''}"
                    >
                    <img :src="require('../../assets/svg/avatar.svg')" alt="">
                    <div class="indicator-bar"></div>
                    <ul @mouseover="isUlOver=true" @mouseout="isUlOver=false">
                        <li>个人中心</li>
                        <li>我的关注</li>
                        <li>我的课程</li>
                        <li>我的收藏</li>
                        <li>资料与账号</li>
                        <li>退出</li>
                    </ul>
                </div>
            </div>
        </div>        
    </div>    
</template>

<script>
import NavBar from './nav-bar'
export default {
    components:{
        NavBar,
        
    },
    data(){
        return{
            isSearch:false,//点击搜索按钮，显示搜索框
            isUlOver:false,//鼠标悬浮于ul上
            isShow:true,
            actNum:-1,//功能按钮悬停激活
            //isActive:false,//点击头像，true则显示下拉菜单，false则隐藏下拉菜单
            restaurants: [],
            state3: ''
        }
    },
    methods:{
        /**@function 监听鼠标悬浮于头像事件 */
        onMouseOver(val){
            this.actNum = val;
        },
        /**@function 监听点击关闭或搜索icon按钮事件 
         * @param {icon类型,type的值为'close'和'search'} type
        */
        onIconClick(type){
            console.log(type);
            if(type === 'close')
                this.isShow = true;
            else if(type === '_search'){
                this.isShow = false;
                /* console.log(this.$refs.search);
                this.$refs.search.focus(); */
            }
        },
        querySearch(queryString, cb) {
            var restaurants = this.loadAll();
            console.log(restaurants);
            var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
        // 调用 callback 返回建议列表的数据
        cb(results);
        },
        createFilter(queryString) {
            return (restaurant) => {
            return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
            };
        },
        onSelect(){
            console.log('Select');
        },
        loadAll() {
            return [
            { "value": "三全鲜食（北新泾店）", "address": "长宁区新渔路144号" },
            { "value": "Hot honey 首尔炸鸡（仙霞路）", "address": "上海市长宁区淞虹路661号" },
            { "value": "新旺角茶餐厅", "address": "上海市普陀区真北路988号创邑金沙谷6号楼113" },          
            ];
        },
    mounted() {
        
    }
    }
    
}
</script>
<style>
    .header .el-input__inner{
        background-color:#171a20;
        border-top-right-radius:2px;
        border-bottom-right-radius:2px;
        color:#fff;
        outline: none;
        border:none;
        height:50px;
        padding-left:40px;
    }
    .search .el-icon-search,
    .search .el-icon-close{
        font-size:16px;
        color:#fff;        
    }
    .my-autocomplete li {
        line-height: normal;
        padding:10px 0 10px 30px;
        }

    .name {
        text-overflow: ellipsis;
        overflow: hidden;
        color: #585a60;
        font-size:16px;
    }
    .my-autocomplete li:hover .name{
         color: #366dd1;
    }     
  

</style>


<style scoped>
    .header{
        background-color:#262835;

    }
    .header-content{
        width:1364px;
        margin:0 auto;
        display:flex;
    }
    .btn-wrap{
        width:100%;
        display:flex;
        justify-content: flex-end;
    }
    .search{
        margin-top:9px;
        width:580px;        
/*         height:68px;
        line-height: 68px; */
        position: relative;
    } 
    /* .el-icon-close{
        margin-top:9px;
        background-color:#171a20;
        height:50px;
        line-height:50px;
        margin-left:200px;
        padding-left:10px;
        font-size:18px;
        display:inline-block;
        color:#fff;
        border-top-left-radius:2px;
        border-bottom-left-radius:2px;
    } */
    /* .el-icon-search, */
    .search-btn,
    .el-icon-upload,
    .el-icon-bell{
        height:68px;
        width:68px!important;
        line-height: 68px;
        text-align: center;
        color:#fff;
        display:inline-block;
        font-size:18px;
        position: relative;
    }
    .avatar{
        width:85px;
        height:68px;
        line-height:68px;
        text-align: center;
        position: relative;
    }
    .avatar img{
        width:44px;
        height:44px;
        border-radius:22px;
        background-color:#fff;
        margin-top:12px;
    }
    .active .indicator-bar{
        display:block;
        height:4px;
        width:100%;
        position:absolute;
        left:0;
        top:0;
        background:linear-gradient(to right,#8b62ff , #0a8dff);
    }
    .avatar ul{
        padding:10px 0;
        display:none;
        background-color:#fff;
        color:#f1f1f1;
        position:absolute;
        bottom:-356px;
        right:0;
        width:160px;
        z-index: 1;
    }
    .avatar li{
        height:56px;
        font-size:18px;
        color:#585a60;
    }
    .avatar li:hover{
        color:#366dd1;
        background-color:#f1f1f1;
    }
    .active ul{
        display:block;
    }
</style>
