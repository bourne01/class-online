<template>
    <article>
        <header>最近来访</header>
        <section class="teacher">
            <label for="">教师</label>
            <div class="visit-teacher">
                <span v-for="idx in 6" :key="idx">
                    <img :src="require('../../../assets/svg/avatar.svg')" alt="">
                    <br>
                    <span>朱老师</span>
                </span>
            </div>
        </section>
        <section class="student">
            <label for="">学生</label>
            <div class="visit-student">
                <span v-for="idx in 6" :key="idx">
                    <img :src="require('../../../assets/svg/avatar.svg')" alt="">
                    <br>
                    <span>朱老师</span>
                </span>
            </div>
        </section>
    </article>
</template>

<script>
export default {
    
}
</script>

<style scoped>
    article{
        width:282px;
        padding-left:30px;
        padding-bottom:30px;
        margin-bottom:40px;
        background-color:#fff;
        margin-top:20px;
        font-size:12px;
    }
    header{
        height:72px;
        line-height: 72px;
        font-size:20px;
        color:#171a20
    }
    label{
        font-size:16px;
        color:#acadb0;
    }
    img{
        width:78px;
        height:78px;
        border-bottom:10px;
        box-sizing: border-box;
        border-radius:39px;
        border:1px solid #f1f1f1;
    }
    .visit-teacher,.visit-student{
        margin-top:20px;
    }
    .visit-teacher>span,.visit-student>span{
        width:78px;
        display:inline-block;
        margin-right:10px;
        text-align: center;
        padding-bottom:30px;
    }
    .visit-teacher>span>span,
    .visit-teacher>span>span{
        color:#585a60
    }
    .student{
        margin-top:50px;
    }
</style>

