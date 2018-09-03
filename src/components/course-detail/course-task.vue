<template>
    <article>
        <header>
            <button class="btn"
                @click="onClick('before')"
                :class="{active:type==='before'}">课前作业</button>
            <button class="btn"
                @click="onClick('in')"
                :class="{active:type==='in'}">课中作业</button>
            <button class="btn"
                @click="onClick('after')"
                :class="{active:type==='after'}">课后作业</button>
        </header>
        <section class="choice">
            <ul class="questions">
                <li v-for="idx in 2" :key="idx">                        
                    <ul class="question">
                        <li>1、(2015河南安阳模拟)已知函数f(x)=ax2+bx+c，且a>b>c，a+b+c=0，则(　　)</li>
                        <li>A．∃x0∈(0，1)，使得f(x0)=0 </li>
                        <li>B．∃x0∈(0，1)，使得f(x0)>0</li>
                        <li>C．∀x∈(0，1)，都有f(x)>0  </li>
                        <li>D．∀x∈(0，1)，都有f(x)<0 </li>
                        <li class="answer-items" v-if="isOkay">
                            <span @click="onSelect(idx,1)">
                                <img 
                                    :src="selItems[idx]==1?
                                        require('../../assets/svg/selected.svg'):
                                        require('../../assets/svg/choice.svg')">A
                            </span>
                            <span @click="onSelect(idx,2)">
                                <img 
                                    :src="selItems[idx]==2?
                                        require('../../assets/svg/selected.svg'):
                                        require('../../assets/svg/choice.svg')">B
                            </span>
                            <span @click="onSelect(idx,3)">
                                <img 
                                    :src="selItems[idx]==3?
                                        require('../../assets/svg/selected.svg'):
                                        require('../../assets/svg/choice.svg')">C
                            </span>
                            <span @click="onSelect(idx,4)">
                                <img 
                                    :src="selItems[idx]==4?
                                        require('../../assets/svg/selected.svg'):
                                        require('../../assets/svg/choice.svg')">D
                            </span>
                        </li>
                        <li class="answer-items" v-else>
                            <span class="error"><i class="el-icon-error"></i><span>我的答案：A</span></span>
                            <span class="success"><i class="el-icon-success"></i><span>正确答案：B</span></span>
                            <span class="info" @click="index=idx">
                                <img :src="require('../../assets/svg/analyse2.svg')" alt="">
                                <span>查看解析</span>
                            </span>
                            <article class="analysis" :style="{display:index===idx?'block':'none'}">
                                <header>
                                    <div class="title-bar"></div>
                                    <div class="analysis-txt">
                                        <lable>本题解析</lable>
                                        <i class="el-icon-close" @click="index=-1"></i>
                                    </div>
                                </header>
                                <section>

                                </section>
                            </article>

                        </li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- <section class="fill-in"></section> -->
        <section class="objective">
            <div class="question">3、设计一个程序，其功能为：能将输入的公里数换算成里和米。</div>
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
        <section class="objective">
            <div class="question">4、设计一个程序，其功能为：能将输入的公里数换算成里和米。</div>
            <el-upload
                class="upload-demo"
                action="https://jsonplaceholder.typicode.com/posts/"
                :on-change="handleChange"
                :file-list="fileList3">
                <div slot="tip" class="el-upload__tip">上传文件最大为5M</div>
                <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
        </section>
    </article>
</template>

<script>
export default {
    data(){
        return{
            type:'before',//默认课前作业激活
            dialogImageUrl: '',
            dialogVisible: false,
            isOkay:true,
            selItems:[],
            index:-1,//题目序号
        }
    },
    methods:{
        /**@function 监听课程作业按钮事件
         * @param {按钮类型，课前，课中，课后} type
         */
        onClick(type){
            this.type = type;
        },
        handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      /**@function 监听选择题点击事件 
       * @param {题目序号} idx
       * @param {选项序号} type
      */
      onSelect(idx,type){
          this.$set(this.selItems,idx,type)
      }

    }
}
</script>

<style scoped>
    article{
        background-color:#fff;
        margin-right:20px;
    }
    header{
        padding-left:60px;
        height:68px;
        line-height: 68px;
        border-bottom:1px solid #f1f1f1;
    }
    section{
        padding-left:40px;
        padding-bottom:20px;
    }
    .btn{
        outline: none;
        border:none;
        font-size:20px;
        color:#585a60;
        font-family: 'MicrosoftYaHei';
        margin-right:120px;
        background-color:#fff;
        cursor: pointer;
    }
    .active{
        color:#fc6835;
    }
    .questions>li{
        padding:40px 0;
        border-bottom:1px solid #f1f1f1;
        color:#585a60;
        font-size:14px;
    }
    .question>li{
        padding:15px 0 15px 30px;
        margin-right:50px;
    }
    .question>li:first-child{
        padding-left:0;
        font-size:16px;
        color:#171a20;
        font-weight:600;
        line-height: 1.5em;
    }
    .answer-items{
        margin-top:20px;
        padding-left:0!important;
        font-size:16px;        
        border-radius: 5px;
        background-color:#f1f1f1;
        position: relative;
    }
    .answer-items span:first-child{
        margin-left:30px;
    }
    .answer-items .error{
        color:#fa584f;
    }
    .answer-items .success{
        color:#24cb65;
    }
    .answer-items .info{
        color:#2185ff;
    }
    .answer-items .el-icon-error,
    .answer-items .el-icon-success,
    .answer-items .el-icon-info{
        margin-right:8px;
    }
    .answer-items span{
        margin-right:50px;
        display:inline-block;
    }
    .answer-items img{
        width:22px;
        height:22px;        
        vertical-align: sub;
    }
    .objective .question{
        margin-top:40px;
        margin-bottom:40px;
    }
    .analysis{
        width:605px;        
        position: absolute;
        top:-10px;
        left:100px;
    }
    .analysis header{
        padding:0;
        height:74px;
        border-bottom:transparent;        
    }
    .analysis .title-bar{
        height:6px;
        background-color:#2185ff;
    }
    .analysis-txt{
        height:68px;
        line-height:68px;
        font-size:18px;
        color:#2185ff;
        padding-left:40px;
        padding-right:40px;
        display:flex;
        justify-content: space-between;
        border-left:1px solid #f1f1f1;
        border-right:1px solid #f1f1f1;
    }
    .analysis-txt .el-icon-close{
        align-self: center;
        font-size:24px;
        color:#585a60;
    }
    .analysis-txt .el-icon-close:hover{
        background-color:#f1f1f1;
        border-radius:1px;
    }
    .analysis section{
        border:1px solid #f1f1f1;
        min-height:300px;
    }
</style>

