
<template>
 <div>
    <div class="counting-bar" v-for="idx in 5" :key="idx" :id="'count'+idx">
        <div class="details" :id="'details'+idx">
            <p>未掌握人数：23人</p>
            <p>男生：20人</p>
            <p>女生：3人</p>
            <div style="margin-top:5px;">
                <img class="first" src='../../../assets/bank/student-avatar.jpg'/>
                <img class="second" src='../../../assets/bank/student-avatar.jpg'/>
                <img class="third" src='../../../assets/bank/student-avatar.jpg'/>
            </div>
        </div>
    </div> 
 </div>
</template>

<style scoped>

.counting-bar{
        width: 620px;
        margin: 30px;
        top: 14px;
        border-radius: 18px;
        left: 220px;
        height: 8px;
        background: -webkit-linear-gradient(left,#fa584f,#fc6c2e);
        position: relative;
    }
    .details{
        position: absolute;
        border-radius: 18px;
        width: 142px;
        height: 142px;
        padding-top: 20px;
        background: black;
        opacity: 0.7;
        top: 0px;
        left: 630px;
        display: none;
        
    }
    .details p{
        color: white;
        margin-bottom: 13px;
        margin-left: 20px;
        font-size: 12px;
    }
    .details img{
        width: 40px;
        height: 40px;
        border-radius: 50%;
        border: 2px solid white;
        position: absolute;
        
    }
    .first{
         left: 18px;;
    }
    .second{
        left: 48px;
    }
    .third{
        left: 78px;
    }
</style>

<script>
    window.onload=function(){
        for(let i=1;i<6;i++){
            let count = document.getElementById('count'+i);
            let  details= document.getElementById('details'+i);

            count.onmousemove=function(){
                details.style.display='block';
                
            }
            count.onmouseout=function(){
                details.style.display='none';
            }
        } 
    }
</script>





