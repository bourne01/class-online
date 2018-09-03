<template>
    <div class="rank">
        <el-row>
            <el-col :span="7">
                <h3 class="rank-text">各校活跃度排名</h3>
            </el-col>
            <el-col :span="13" class="btn-wrapper">
                <button class="elementary btn" @click="onBtnClick(1)" :class="{btnActive:btnActNum===1}">小学</button>
                <button class="middle btn" @click="onBtnClick(2)" :class="{btnActive:btnActNum===2}">初中</button>
                <button class="high btn" @click="onBtnClick(3)" :class="{btnActive:btnActNum===3}">高中</button>
            </el-col>
        </el-row>
        <el-row class="horizontal-dashed">
            <el-col :span="7">
                <label for="">温州市瞿溪小学教育集团学校崇文校区</label>
            </el-col>
            <el-col :span="13">
                <el-row>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                </el-row>
                <div class="total count-bar"></div>
                <div class="online count-bar"></div>
            </el-col>
            <el-col :span="4">
                <span class="quantity"><i>98%</i> / 2654人</span>
            </el-col>
        </el-row>
        <el-row class="horizontal-dashed">
            <el-col :span="7">
                <label for="">温州市瞿溪小学教育集团学校崇文校区</label>
            </el-col>
            <el-col :span="13">
                <el-row>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                </el-row>
                <div class="total count-bar"></div>
                <div class="online count-bar"></div>
            </el-col>
            <el-col :span="4">
                <span class="quantity"><i>98%</i> / 2654人</span>
            </el-col>
        </el-row>
        <el-row class="horizontal-dashed">
            <el-col :span="7">
                <label for="">温州市瞿溪小学教育集团学校崇文校区</label>
            </el-col>
            <el-col :span="13">
                <el-row>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                </el-row>
                <div class="total count-bar"></div>
                <div class="online count-bar"></div>
            </el-col>
            <el-col :span="4">
                <span class="quantity"><i>98%</i> / 2654人</span>
            </el-col>
        </el-row>
        <el-row class="horizontal-dashed">
            <el-col :span="7">
                <label for="">温州市瞿溪小学教育集团学校崇文校区</label>
            </el-col>
            <el-col :span="13">
                <el-row>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                </el-row>
                <div class="total count-bar"></div>
                <div class="online count-bar"></div>
            </el-col>
            <el-col :span="4">
                <span class="quantity"><i>98%</i> / 2654人</span>
            </el-col>
        </el-row>
        <el-row class="horizontal-dashed">
            <el-col :span="7">
                <label for="">温州市瞿溪小学教育集团学校崇文校区</label>
            </el-col>
            <el-col :span="13">
                <el-row>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                    <el-col :span="4" class="vertical-dashed"></el-col>
                </el-row>
                <div class="total count-bar"></div>
                <div class="online count-bar"></div>
            </el-col>
            <el-col :span="4">
                <span class="quantity"><i>98%</i> / 2654人</span>
            </el-col>
        </el-row>
        <el-row >            
            <el-col :span="13" :offset="7" class="scale">
                <el-row>
                    <el-col :span="4"><span>500</span></el-col>
                    <el-col :span="4"><span>1000</span></el-col>
                    <el-col :span="4"><span>1500</span></el-col>
                    <el-col :span="4"><span>2000</span></el-col>
                    <el-col :span="4"><span>2500</span></el-col>
                    <el-col :span="4"><span>3000</span></el-col>
                </el-row>
            </el-col>
        </el-row>
        <el-row class="rank-bottom">            
            <el-col :span="13" :offset="7">
                <div>
                    <span class="dot blue-dot"></span>
                    <label for="" class="active-label">活跃人数</label>
                    <span class="dot grey-dot"></span>
                    <label for="">学校总人数</label>
                </div>                
            </el-col>
            <el-col :span="4">
                <router-link to="more" class="rank-more">
                    查看更多<i class="el-icon-arrow-right"></i>
                </router-link>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    props:[],
    data(){
        return{
            btnActNum:1,//默认激活的中小学阶段按钮,为小学
        }
    },
    methods:{
        /**
         * @function 监听切换中小学按钮事件 
         * @param {val --1为小学、2为初中、3为高中}
         * */   
        onBtnClick(val){
            switch(val){
                case 1:
                    this.btnActNum = 1;
                    break;
                case 2:
                    this.btnActNum = 2;
                    break;
                case 3:
                    this.btnActNum = 3;
                    break;
            }
        }
    }
}
</script>

<style scoped>
    .rank{
        padding:36px 0;
        border:1px solid #e4e4e5;
        height:320px;
        border-radius: 5px;
    }
    .rank .el-row:first-child{
        margin-bottom:20px;
    }
    .el-col{
        height:30px;
        line-height: 30px;
        position: relative;
    }
    .el-col-7{
        text-align: right;
        line-height: 1em;
    }
    .el-col-7 label{
        font-size:12px;
        color:#585a60
    }
    .rank .el-col-4{
        text-align: right;
        padding-right:1em;
    }
    .rank-text{
        font-size:20px;
        color:#585a60;
        line-height:30px;
    }
    .btn-wrapper{
        display:flex;
        justify-content: space-around;
    }
    .btn{
        outline: 0;
        height:32px;
        line-height: 32px;
        border-radius:16px;
        padding:0 30px;
        border:1px solid #87c7ff;
        background-color:#fff;
        font-size:18px;
    }
    .btnActive{
        background-color:#fc6a32;
        color:#fff;
        border: 1px solid #fc6a32;
    }
    .horizontal-dashed{
        border-bottom:1px dashed #e4e4e5;
        border-top:1px dashed #e4e4e5;
    }
    .vertical-dashed{
        border-left:1px dashed #e4e4e5;     
        border-right:1px dashed #e4e4e5;
    }
    .quantity{
        font-size:12px;
        color:#585a60;
    }
    .count-bar{
        height:8px;
        border-radius:4px;
        position:absolute;
        top:11px;
        left:1%;
    }
    .total{
        width:98%;
        background-color:#ececec;       
        
    }
    .online{
        width:90%;
        background-color:#2385ff;
    }
    .rank-bottom{
        margin-top:10px;
    }
    .scale span{
        color:#acadb0;
        font-size:12px;
    }
    .dot{
        display:inline-block;
        border-radius:6px;
        width:12px;
        height:12px;
        margin-right:10px;
    }
    .blue-dot{
        background-color:#2385ff;
    }
    .grey-dot{
        background-color:#ececec;
    }
    .rank-bottom label{
        font-size:12px;
        color:#585a60;
    }
    .active-label{
        margin-right:40px;
    }
    .rank-more{
        color:#585a60;
        text-decoration: none;
        font-size:12px;
    }
</style>


