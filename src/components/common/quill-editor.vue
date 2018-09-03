<template>
    <div class="editor">        
        <div>
            <!-- 图片上传组件辅助-->
            <el-upload
                    class="avatar-uploader"
                    :action="serverUrl"
                    name="img"
                    :headers="header"
                    :show-file-list="false"
                    :on-success="uploadSuccess"
                    :on-error="uploadError"
                    :before-upload="beforeUpload">
            </el-upload>
        </div>
        <!-- style="margin-left:80px;height:45%;" -->
        <quill-editor    
            class="quill-editor"        
            v-model="detailContent"
            ref="myQuillEditor"
            :options="editorOption"
            >
        </quill-editor>                                     
    </div>
</template>

<script>
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import { quillEditor } from 'vue-quill-editor'
import http  from 'axios'
// 工具栏配置
const toolbarOptions = [
['bold', 'italic', 'underline', 'strike'],        // toggled buttons
['blockquote', 'code-block'],

[{'header': 1}, {'header': 2}],               // custom button values
[{'list': 'ordered'}, {'list': 'bullet'}],
[{'script': 'sub'}, {'script': 'super'}],      // superscript/subscript
[{'indent': '-1'}, {'indent': '+1'}],          // outdent/indent
[{'direction': 'rtl'}],                         // text direction

[{'size': ['small', false, 'large', 'huge']}],  // custom dropdown
[{'header': [1, 2, 3, 4, 5, 6, false]}],

[{'color': []}, {'background': []}],          // dropdown with defaults from theme
[{'font': []}],
[{'align': []}],
[/* 'link', */ 'image', 'video'],
/* ['clean']    */                                      // remove formatting button
]
http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
export default {
    components:{
        quillEditor
    },
    
    data(){
        return{
            data:null,
            actionUrl:'',
            brief:'',
            fileList:[],
            newsTitle:'',
            keywords:'',
            colType:'',
            colTypeList:[],
            isNew:true,
            imgUrl:'',
            quillUpdateImg: false, // 根据图片上传状态来确定是否显示loading动画，刚开始是false,不显示
            serverUrl: "imgFile",  // 这里写你要上传的图片服务器地址
            header: {token: sessionStorage.token},  // 有的图片服务器要求请求头需要有token之类的参数，写在这里
            detailContent: '', // 富文本内容
            editorOption: {
                placeholder: '请输入...',
                theme: 'snow',  // or 'bubble'
                modules: {
                    toolbar: {
                        container: toolbarOptions,  // 工具栏
                        handlers: {
                            'image': function (value) {
                                if (value) {
                                // 触发input框选择图片文件
                                    console.log('....')
                                    document.querySelector('.avatar-uploader input').click()
                                } else {
                                    this.quill.format('image', false);
                                }
                            }
                        }
                    }
                }
            }
        }
    },
    methods:{
        closeWin(){
            this.isNew = true;
            this.$emit('close')
        },
        /**图片上传获取，URL */
        onSuccess(res,file,fileList){
            if(res.success){
                this.imgUrl = res.url;
                this.$message('图片上传成功!')
            }else{
                this.$message(res.message)
            }
        },
        /**@function 保存新闻 */
        saveNews(){
            let url 
            let params = null;
            if(this.isNew){
                url = 'con!newRec.action';
                params = {
                    /* conId:this.news.conId, */
                    title:this.newsTitle,
                    brief:this.brief,
                    keywords:this.keywords,
                    /* strCont:this.detailContent, */
                    imgUrl:this.imgUrl,
                }
            }else{
                url = 'con!edit.action';                
                params = {
                    conId:this.news.conId,
                    title:this.newsTitle,
                    brief:this.brief,
                    keywords:this.keywords,
                    /* strCont:this.detailContent, */
                    imgUrl:this.imgUrl,
                }
            }
            
            http({
                    method:'post',
                    url,
                    data:{strCont:this.detailContent},
                    params,
                    })
                .then(res => {
                    if(this.isNew){
                        this.$message('新闻添加成功！')
                    }else{
                        this.$message('新闻修改成功！')
                    }
                    this.$root.bus.$emit('news-change')
                    this.closeWin();
                })
                .catch(err =>{
                        if(err.response.status == 401){
                            this.$message('登录超时，正在跳转...')
                            this.$router.push('/login')
                        }
                            
                    })
        },
         // 富文本图片上传前
            beforeUpload() {
                // 显示loading动画
                //this.quillUpdateImg = true
            },
            
            uploadSuccess(res, file) {
                // res为图片服务器返回的数据
                // 获取富文本组件实例
                console.log(res)
                let quill = this.$refs.myQuillEditor.quill
                // 如果上传成功
                if (res.success) {
                    // 获取光标所在位置
                    let length = quill.getSelection().index;
                    // 插入图片  res.info为服务器返回的图片地址
                    quill.insertEmbed(length, 'image', 'http://www.mattie-trade.com/'+res.url)
                    // 调整光标到最后
                    quill.setSelection(length + 1)
                } else {
                    this.$message.error('图片插入失败')
                }
                // loading动画消失
                //this.quillUpdateImg = false
            },
       
            // 富文本图片上传失败
            uploadError(err,file,fileList) {
                // loading动画消失
                //this.quillUpdateImg = false
                this.$message.error('图片插入失败：登录超时，请重新登录')
            }
    },
    mounted(){
        if(this.news){
            console.log(this.news)
            this.detailContent = this.news.strCont;
            this.brief = this.news.brief;
            this.newsTitle = this.news.title;
            this.keywords = this.news.keywords;
            if(this.news.imgUrl)
                this.fileList.push({name:'配图',url:this.news.imgUrl});
            this.isNew = false;
        }
        
    }
}
</script>

<style>
    .editor .ql-container{
        min-height:162px;
        background-color:#f1f1f1;
    }
</style>

<style  scoped>
    .quill-editor{
        min-height:228px;
    }
    /* .editor{
        width: 80%;
        height: 95%; 
        background: #f3f3f3;
        position: fixed;
        left: 10%;
        top: 1%;
        overflow: hidden;
        border: 1px solid #cccc;
        border-radius: 5px;
        padding: 0 20px 20px 20px;
        z-index: 999; 
    }  
    .ql-editor{
        height:350px!important; 
    }
    .toolbar{
        margin-top:10px;
        text-align: center;
        position: absolute;
        bottom:10px;
        left:40%;
    }
    .toolbar .el-button{
        margin-right:30px;
    } */
</style>
