<template>
    <article class="personal-info">
        <section class="basic-info">
            <header>
                <span>基本信息</span>
                <button class="save">保存</button>
            </header>
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="姓名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="ID">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>                             
                <el-form-item label="性别">
                    <el-radio-group v-model="form.resource">
                        <el-radio label="男"></el-radio>
                        <el-radio label="女"></el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="籍贯">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="任职">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="年级">
                    <el-form :inline="true" :model="formInline" class="demo-form-inline">
                        <el-form-item>
                            <el-input v-model="formInline.user" placeholder="年级"></el-input>
                        </el-form-item>
                        <el-form-item label="学科">
                            <el-input v-model="formInline.user" placeholder="学科名"></el-input>
                        </el-form-item>
                    </el-form>
                </el-form-item>
                <el-form-item label="签名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="简介">
                    <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>
            </el-form>
        </section>
        <section class="contact">
            <header><span>联系方式</span></header>
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="手机">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>    
            </el-form>                         
        </section>
    </article>
</template>

<script>
export default {
    data() {
      return {
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formInline:{},
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
}
</script>

<style>
    .personal-info .el-input__inner{
        width:322px;
        height: 42px;
        line-height: 42px;
        background-color:#f4f4f4;
    }
    .personal-info .el-textarea__inner{
        width:702px;
        background-color:#f4f4f4;
    }
</style>


<style scoped>
    article{
        background-color:#fff;
    }
    .basic-info,.contact{        
        padding:60px 60px 30px 50px;
        border-bottom:1px solid #f1f1f1;        
    }
    header{
        display:flex;
        justify-content: space-between;
        height:34px;
        line-height: 34px;
        margin-bottom:42px;
    }
    header span{
        font-size:18px;
        color:#171a20;
        font-weight: bold;
    }
    header button{
        height:34px;
        width:82px;
        font-size:16px;
        color:#fefefe;
        border-radius:3px;
        line-height: 34px;
        border:none;
        outline: none;
        background-color:#fb5e45;
        cursor: pointer;
    }
</style>


