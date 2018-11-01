<template>
    <article>
        <section class="comment">
            <el-input type="textarea"></el-input>
            <div class="publish-btn">
                <span><i class="el-icon-picture-outline"></i>图片</span>
                <button class="btn">发布</button>
            </div>
            <el-upload
                action="https://jsonplaceholder.typicode.com/posts/"
                list-type="picture-card"
                :on-preview="handlePictureCardPreview"
                :on-remove="handleRemove">
                <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
                <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
        </section>
        <section class="comment">
            <ul class="comment-list">
                <li v-for="idx in 5" :key="idx">
                    <img :src="require('../../assets/svg/avatar.svg')" alt="" class="avatar">
                    <article>
                        <header>王同学</header>
                        <p>
                            来说说温州的人情世故吧。除了出生不是在温州，我的前十九年人生都是在温州度过的。
                            鹿城区人士，讲标准温州话，现在最好的朋友也都是温州人。
                            但是我又自认和典型的温州人很不一样，
                            所以可能可以从一个不是温州人的角度来讲一些非常温州人的东西，
                            以此做一点对这个问题的补充。
                        </p>
                        <footer>
                            <span>
                                <span class="time">2018-02-12 16:30</span>
                                <span class="comment-icons">
                                    <span 
                                        class="reply-icon"
                                        @mouseover="comOverIdx=idx"
                                        @mouseout="comOverIdx=-1"
                                        @click="comIdx=idx"
                                        >
                                        <img 
                                            
                                            :src="comOverIdx===idx?
                                                require('../../assets/svg/comment-active.svg'):
                                                require('../../assets/svg/comment.svg')" alt=""
                                            >0
                                    </span>
                                    <span
                                        @mouseover="comOverLikedIdx=idx"
                                        @mouseout="comOverLikedIdx=-1" 
                                        @click="onLike(idx)">
                                        <img
                                            :src="likedList[idx]===idx||comOverLikedIdx===idx?
                                                require('../../assets/svg/liked.svg'):
                                                require('../../assets/svg/like.svg')
                                                " alt=""
                                            >0
                                    </span>
                                </span>
                            </span>
                            <div class="comment-action" :style="{display:comIdx===idx?'block':'none'}">
                                <el-input type="textarea"></el-input>
                                <div class="submit">
                                    <span>还可以输入200字</span>
                                    <button class="btn">提交</button>
                                </div>
                            </div>
                        </footer>
                        <ul class="reply" :style="{display:comIdx===idx?'block':'none'}">
                            <li v-for="inIdx in 3" :key="inIdx">
                                <div class="reply-txt">
                                    <label for="">王同学：</label>
                                    <span>还可以输入200字还可以输入200字还可以输入200字</span>
                                </div>
                                <footer>
                                    <span>
                                        <span class="time">2018-02-12 16:30</span>
                                        <span class="comment-icons">
                                            <span 
                                                class="reply-icon"
                                                @mouseover="repOverIdx='rep'+idx+inIdx"
                                                @mouseout="repOverIdx=-1"
                                                @click="repIdx='rep'+idx+inIdx"
                                                >
                                                <img 
                                                    :src="repOverIdx==='rep'+idx+inIdx?
                                                        require('../../assets/svg/comment-active.svg'):
                                                        require('../../assets/svg/comment.svg')" alt=""
                                                >0    
                                            </span>
                                            <span
                                                @mouseover="repOverLikedIdx='rep'+idx+inIdx"
                                                @mouseout="repOverLikedIdx=-1" 
                                                @click="onLike('rep'+idx+inIdx)"
                                                >
                                                <img
                                                    :src="likedList['rep'+idx+inIdx]==='rep'+idx+inIdx||repOverLikedIdx==='rep'+idx+inIdx?
                                                        require('../../assets/svg/liked.svg'):
                                                        require('../../assets/svg/like.svg')
                                                        " alt=""
                                                    >0
                                            </span>
                                        </span>
                                    </span>
                                    <div 
                                        class="comment-action" 
                                        :style="{display:repIdx==='rep'+idx+inIdx?'block':'none'}">
                                        <el-input type="textarea"></el-input>
                                        <div class="submit">
                                            <span>还可以输入200字</span>
                                            <button class="btn">提交</button>
                                        </div>
                                    </div>
                                </footer>   
                            </li>
                        </ul>
                    </article>
                </li>
            </ul>
        </section>
    </article>
</template>

<script>
export default {
    data(){
        return{
            comIdx:-1,//评论列表序号(点击)
            comOverIdx:-1,//评论列表序号(悬停)
            repIdx:-1,//回复评论列表序号(点击)
            repOverIdx:-1,//回复评论列表序号(悬停)
            comOverLikedIdx:-1,//评论列表序号(点击,用于点赞)
            repOverLikedIdx:-1,//回复评论列表序号(悬停，用于点赞)
            likedList:[],//判断是否已经点赞，如果有值则已点赞
        }
    },
    methods:{
        /**@function 监听点赞事件 
         * @param {序号} val
        */
        onLike(val){            
            if(this.likedList[val]){
                this.$message({
                    message:'您已点过赞'
                })
            }else{
                this.likedList[val] = val;
            }
        }
    }
}
</script>

<style scoped>
    .comment{
        background-color:#fff;
        margin-right:20px;
        padding:40px;    
        margin-bottom:10px;
        font-size:12px;
    }
    .comment-list>li{
        display:flex;
        margin-bottom:26px;
    }
    .avatar{
        height:48px;
        width:48px;
        margin-right:20px;
    }
    .comment-list header{
        color:#366dd1;
        margin-bottom:10px;
    }
    .comment-list p{
        line-height: 1.5em;
        color:#585a60;
        margin-bottom:10px;
    }
    .comment-action{
        background-color:#f1f1f1;
        padding:10px;
    }
    .comment-action .el-textarea{
        margin-bottom:10px;
    }
    .comment-action .submit{
        text-align: right;
    }
    .submit>span{
        color:#585a60;
    }
    .submit .btn{
        margin-left:10px;
    }
    footer>span{
        display: flex;
        justify-content: space-between;
        color:#acadb0;
    }
    .reply-icon{
        margin-right:30px;
    }
    footer img{
        width:22px!important;
        height:22px!important;
        vertical-align: middle;
        margin-right:5px;
    }
    .btn{
        height:32px;
        line-height:32px;
        width:76px;
        cursor: pointer;
        color:#fff;
        background-color:#24cb65;
        border:none;
        outline: none;
        border-radius:3px;
    }
    .publish-btn{
        margin-top:10px;
        margin-bottom:20px;
        display:flex;
        justify-content: space-between;

    }
    .publish-btn .el-icon-picture-outline{
        font-size:30px;
        margin-right:10px;
        vertical-align: sub;
        color:#acadb1;
    }
    .publish-btn span{
        font-size:16px;
        color:#585860;
    }
    .reply{
        margin-top:10px;
    }
    .reply li{
        padding:15px 10px;
        display:block;
        background-color:#f1f1f1;
        margin-bottom:10px;
    }
    .reply-txt{
        line-height: 1.5em;
        margin-bottom:20px;
    }
    .reply .comment-action{        
        padding-left:0;
        padding-right:0;
    }
</style>


