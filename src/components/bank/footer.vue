<template>
    <div class="footer">
        <div>
            <ul>
                <li>
                    <label for="">单选题：</label>
                    <span>2题</span>
                    <i class="el-icon-remove"></i>
                </li>
                <li>
                    <label for="">单选题：</label>
                    <span>2题</span>
                    <i class="el-icon-remove"></i>
                </li>
                <li>
                    <label for="">单选题：</label>
                    <span>2题</span>
                    <i class="el-icon-remove"></i>
                </li>
                <li>
                    <label for="">单选题：</label>
                    <span>2题</span>
                    <i class="el-icon-remove"></i>
                </li>
            </ul>
            <div class="right">
                <span>已选（3）道题</span>
                <button>进入组卷</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    mounted(){
        console.log('footer is mounting...');
    }
}
</script>

<style scoped>
    .footer{
        position: fixed;;
        bottom:0;
        left:0;
        width:100%;
        height:68px;
        line-height: 68px;
        background-color:#fff;
        z-index:9999;
    }
    .footer>div{
        width:1340px;
        margin:0 auto;
        padding:0 20px;
        display:flex;
        justify-content: space-between;
    }
    li{
        display:inline-block;
        font-size:12px;
        color:#171a20;
        margin-right:40px;
    }
    .el-icon-remove{
        color:#fa5b4a;
        margin-left:5px;
    }
    .right span{
        color:#fa5b4a;
        font-size:14px;
    }
    .right button{
        width:118px;
        height:36px;
        text-align:center;
        margin-left:40px;
        font-size:12px;
        color:#fff;
        outline: none;
        border:none;
        background:linear-gradient(to bottom right,#74c756,#28d07e);
        border-radius:2px;
    }
</style>

