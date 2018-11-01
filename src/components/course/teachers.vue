 <template>
     <div class="teachers">
         <header>
             <span>教师</span>
             <span class="more">共{{30}}位教师<img src="../../assets/svg/next.svg"> </span>
         </header>
         <div class="teacher-list">
             <ul>
                 <li v-for="(item,idx) in 4" :key="idx">
                    <img src="../../assets/svg/avatar.svg" alt="">
                    <span>
                    <span class="name">王老师<label>创建者</label></span>
                    <span class="school">瓯海区XXX实验小学</span>
                    <span class="course">
                        <span>小学</span>
                        <span>语文</span>
                    </span>
                </span>
                 </li>
             </ul>
         </div>
     </div>
 </template>
 

 <style scoped>
    .teachers{
        background-color:#fff;
        padding:0 30px;
    }
    .teachers>header{
        height:1.5em;
        display:flex;
        align-items: center;
        justify-content: space-between;
        font-size:18px;
        font-family:PingFang-SC-Regular;
        font-weight:400;
        color:rgba(88,90,96,1);
        
    }
    .teachers .more{
        font-size:12px;
    }
    .more>img{
        width:15px;
        vertical-align: middle;
        position: relative;
        top:-2px;
    }
    .teacher-list{
        padding:10px 0 30px 0;
    }
    .teacher-list img{
        width:68px;
        height:68px;
        border-radius: 34px;
        border:1px solid #f1f1f1;
    }
    .teachers ul{
        display:flex;
    }
    .teachers li{
        display:flex;
        margin-right:30px;
    }
    .teachers li>img{
        width:68px;
        height:68px;
        margin-right:20px;
    }
    .teachers li>span{
        display:flex;
        flex-direction: column;
        justify-content: space-between;
    }
    .teachers li .name{
        color:#000;
        font-size:16px;
    }
    .teachers .name label{
        margin-left:5px;
        font-size:12px;
        width:48px;
        height:18px;
        line-height:18px;
        text-align: center;
        background-color:#FF9000;   
        color:#fff;
        display: inline-block;
        letter-spacing: 0.04em;

    }
    .teachers .creator{
        background-color:#FF9000;
    }
    .teachers .admin{
        background-color:#4B78FF;
    }
    .teachers li .school{
        color:#585a60;
        font-size:12px;
    }
    .teachers .course span{
        padding:3px 10px;
        background-color:#f4f4f4;
        margin-right:10px;
        border-radius:2px;
        color:#585a60;
        font-size:12px;
    }
 </style>
 