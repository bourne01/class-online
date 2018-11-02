<template>
    <article class="course-player">
        <header class="course-name">
            <span @click="goBack">
                <img :src="require('../../assets/svg/previous.svg')" alt="">
                <span>计算机课程</span>
            </span>
        </header>
        <section>
            <d-player :options="options"
              @play="play"
              ref="player"
              class="player">
            </d-player>
            <article class="video-info">
                <header>第一章 第2课 Sublime Text代码</header>
                <section class="section1">
                    <label for="">主讲教师：王老师(瓯海区实验小学)</label>
                    <span>
                        <label for="">开设时间：2017-02-13 12：15</label>
                        <label for="">更新时间：2017-02-13 12：15</label>
                    </span>
                    <span class="course-type">
                        <button>任务课</button>
                        <button>小二</button>
                        <button>语文</button>
                    </span>
                </section>
                <section class="knowledge-points">
                    <header>本节知识点：</header>
                    <ul>
                        <li>知识点001</li>
                        <li>知识点002</li>
                        <li>知识点003</li>
                        <li>知识点004</li>
                        <li>知识点005</li>
                    </ul>
                </section>
                <section class="btn-section">
                    <button class="btn apply">报名学习</button>
                    <button class="btn forcast">查看预告</button>
                </section>
                <section class="interact-section">
                    <span class="interact">
                        <span>
                            <img :src="require('../../assets/svg/eye.svg')" alt="">
                            <span>3564</span>
                        </span>
                        <span>
                            <img :src="require('../../assets/svg/comment.svg')" alt="">
                            <span>64</span>
                        </span>
                        <span>
                            <img :src="require('../../assets/svg/like.svg')" alt="">
                            <span>364</span>
                        </span>
                    </span>
                    <span class="setting">
                        <span class="favorite" @click="isFavorite=!isFavorite">
                            <img 
                                :src="isFavorite?require('../../assets/svg/favorite.svg'):
                                                require('../../assets/svg/favorite-active.svg')" alt=""
                                >
                                <span>收藏</span>
                        </span>
                        <img :src="require('../../assets/svg/setting.svg')" alt=""></span>
                </section>
            </article>
        </section>
        
    </article>
</template>

<script>
import VueDPlayer from 'vue-dplayer'
import 'vue-dplayer/dist/vue-dplayer.css'
export default {
    components: {
        'd-player': VueDPlayer
    },
    data(){
        return{
            options: {
                video: {
                    url: 'http://static.smartisanos.cn/common/video/t1-ui.mp4',
                    pic: 'http://static.smartisanos.cn/pr/img/video/video_03_cc87ce5bdb.jpg'
                },
                autoplay: false,
                theme:'#000',
                contextmenu: [
                    /* {
                        text: 'GitHub',
                        link: 'https://github.com/MoePlayer/vue-dplayer'
                    } */
                ]
            },
            lesson:{},//上课内容对象
            player: null,
            isFavorite:false,
                
        }
    },
    methods: {
        /**@function 返回上一页 */
        goBack(){
            history.go(-1);
        },
        play() {
            console.log('play callback')
        }
    },
    mounted(){
        this.player = this.$refs.player.dp;//初始化播放器
        this.$root.bus.$on('play-lesson',(lesson) => {
            this.lesson = lesson;
            /**
             * 此处设置视频播放地址 
             */
            this.player.play();
        })
    },
    destroyed(){
        this.$root.bus.$off('play-lesson');
    }    
}
</script>

<style scoped>
    .course-player{      
        width:1364px;
        margin:0 auto;  
    }
    .course-name{        
        height:90px;
        line-height: 90px;
        background-color:#171a20;
        color:#fff;
        font-size:24px;        
    }
    .course-name img{
        width:24px;
        height:24px;
        vertical-align: middle;
        position: relative;
        top:-2px;
    }
    .course-name>span{
      cursor: pointer;  
    }
    .course-player>section{
        display:flex;
    }
    .player{
        width:848px;
    }
    .video-info{
        width:476px;
        padding-left:40px;
        background-color:#20242e;
        display:flex;
        flex-direction: column; 
        color:#fff;
        font-size:12px;
        position: relative;
    } 
    .video-info>header{
        margin-top:26px;
        margin-bottom:20px;
        font-size:24px;
        color:#fff;
    }
    .video-info .section1{
        display:flex;
        flex-direction: column;
    }
    .section1 label{
        margin-bottom:10px;
    }
    .course-type{
        margin-top:18px;
        margin-bottom:32px;
    }
    .course-type button{
        outline: none;
        border:none;
        border-radius:2px;
        color:#585a56;
        font-size:12px;
        margin-right:10px;
        background-color:#f4f4f4;
        height:25px;
        line-height:25px;
        padding:0 10px;
    }
    .course-type button:first-child{
        color:#fff;
        background-color:#366dd1;
    }
    .knowledge-points header{
        color:#616475;
        margin-bottom:12px;
    }
    .knowledge-points ul{
        display:flex;
        flex-direction: column;
    }
    .knowledge-points li{
        padding:5px 0 5px 20px;
        margin-bottom:2px;
        color:#acadb0;
        background-color:#262a35;
        border-radius: 2px;
    }
    .btn-section{
        margin-top:30px;
    }
    .btn{
        height:45px;
        line-height:45px;
        text-align: center;
        color:#fff;
        font-size:18px;
        outline: none;
        width:138px;
        border-radius: 2px;
        cursor: pointer;
    }
    .apply{
        background-color:#fc6c2e;
        margin-right:50px;
        border:none;
    }
    .forcast{
        border:1px solid #22cb64;
        background-color: transparent;
    }
    .interact-section{
        width:100%;
        box-sizing: border-box;
        padding:0 20px 0 40px;
        position: absolute;
        bottom:20px;
        right:0px;
        display:flex;
        justify-content: space-between;        
    }    
    .interact img{
        width:22px;
        height:22px;
        vertical-align: middle;
    }
    .interact span{
        display:inline-block;
        height:22px;
        line-height: 22px;
        margin-right:20px;
        color:#acadb0;
    }
    .favorite{
        cursor: pointer;
    }
    .favorite span{
        position: relative;
        top:-5px;
        margin-right:20px;
        font-size:12px;
        /* vertical-align: middle; */
    }   
    .setting img{
        width:22px;
        height:22px;
        cursor: pointer;
    }
    </style>

