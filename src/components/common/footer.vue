<template>
    <div class="footer">
        <nav>
            <div class="nav-links">
                <router-link to="" class="nav-link">移动版</router-link>
                <router-link to="" class="nav-link">关于我们</router-link>
                <router-link to="" class="nav-link">加入站酷</router-link>
                <router-link to="" class="nav-link">用户协议</router-link>
                <router-link to="" class="nav-link">企业服务</router-link>
                <router-link to="" class="nav-link">帮助中心</router-link>
                <router-link to="" class="nav-link">联系我们</router-link>
            </div>
            <span>
                <img :src="require('../../assets/course/wechat.jpg')" alt="">
                <img :src="require('../../assets/course/weibo.png')" alt="">
            </span>
        </nav>
        <div class="copyright"></div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    .footer{
        height:252px;        
        width:1364px;
        margin:0 auto;
    }
    nav{
        display: flex;
        justify-content: space-between;
    }
    nav span{
        height:126px;
        line-height: 126px;
    }
    nav img{
        margin-left:37px;
    }
    .nav-link{
        display: inline-block;
        height:126px;
        line-height: 126px;
        margin-right:40px;
        text-decoration: none;
        font-size:14px;
        color:#c6c7c9; 
    }
</style>


