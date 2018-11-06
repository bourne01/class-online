<template>
    <div class="toolbar">
        <el-button icon="el-icon-plus" @click="onClick(curMenuItem.alias)">
            新增</el-button>
        <add-term-pop 
            :is-pop="isTermPop"
            v-if="isTermPop" 
            @close-dialog="onCloseDialog"
            :is-edit="isEdit"></add-term-pop>
        <add-teach-site-pop 
            :is-pop="isTeachSitePop"
            v-if="isTeachSitePop"  
            @close-dialog="onCloseDialog"
            :is-edit="isEdit"></add-teach-site-pop>
        <add-syllabus-pop 
            :is-pop="isSyllabusPop" 
            v-if="isSyllabusPop" 
            @close-dialog="onCloseDialog"
            :is-edit="isEdit"></add-syllabus-pop>
        <add-knowledge-point-pop 
            :is-pop="isKnowledgePointPop" 
            v-if="isKnowledgePointPop" 
            @close-dialog="onCloseDialog"
            :is-edit="isEdit"></add-knowledge-point-pop>
        <add-textbook-pop 
            :is-pop="isTextbookPop" 
            v-if="isTextbookPop" 
            @close-dialog="onCloseDialog"
            :is-edit="isEdit"></add-textbook-pop>
        <add-textbook-content-pop 
            :is-pop="isTextbookContentPop" 
            v-if="isTextbookContentPop" 
            @close-dialog="onCloseDialog"
            :is-edit="isEdit"></add-textbook-content-pop>
    </div>
</template>

<script>
import AddTermPop from './dean/add-term-popup'
import AddTeachSitePop from './dean/add-teach-site-popup'
import AddSyllabusPop from './course/add-syllabus-popup'
import AddKnowledgePointPop from './course/add-knowledge-point-popup'
import AddTextbookPop from './course/add-textbook-popup'
import AddTextbookContentPop from './course/add-textbook-content-popup'
import { mapState } from 'vuex';
export default {
    components:{
        AddTermPop,
        AddTeachSitePop,
        AddSyllabusPop,
        AddKnowledgePointPop,
        AddTextbookPop,
        AddTextbookContentPop,
    },
    data(){
        return{
            isEdit:false,//是否来自编辑事件
            isTermPop:false,
            isEnrollGradePop:false,
            isTimeTablePop:false,
            isTeamPop:false,
            isTeachSitePop:false,
            isCampusStudentPop:false,
            isClassPop:false,
            isClassStudentPop:false,
            isDepartmentPop:false,
            isDepMemberPop:false,
            isSyllabusPop:false,
            isKnowledgePointPop:false,  
            isResourcePop:false,   
            isTextbookPop:false,       
            isTextbookContentPop:false,       
        }
    },
    computed:{
        ...mapState('base',{
            curMenuItem: state => state.curMenuItem,
        }),
    },
    methods:{
        /**
         * @function 监听新增按钮事件，然后打开对话框
         * @param {菜单项名称} itemName
         */
        onClick(itemName){
            console.log(itemName)
            switch(itemName){
                case 'term':
                    this.isTermPop = true;
                    break;
                case 'teach-site':
                    this.isTeachSitePop = true;
                    break;
                case 'syllabus':
                    this.isSyllabusPop = true;
                    break;
                case 'knowledge-point':
                    this.isKnowledgePointPop = true;
                    break;
                case 'resource':
                    this.isResourcePop = true;
                    break;
                case 'textbook':
                    this.isTextbookPop = true;
                    break;
                case 'textbook-content':
                    this.isTextbookContentPop = true;
                    break;
            }
        },
        /**
         * @function 监听来自弹窗组件关闭事件
         */
        onCloseDialog(){
            this.isTermPop = false;
            this.isEdit = false;
            this.isTeachSitePop = false;
            this.isSyllabusPop = false;
            this.isKnowledgePointPop = false;
            this.isResourcePop = false;
            this.isTextbookPop = false;
            this.isTextbookContentPop = false;
            console.log('Edit...',this.isEdit);
        }
    },
    mounted(){
        /**@function 监听来自表格中的编辑行事件 */
        this.$root.bus.$on('edit-row',(name) => {
            console.log(name);
            this.onClick(name);
            this.isEdit = true;
        });
    },
    destroyed(){
        this.$root.bus.$off('edit-row');
    }
}
</script>

<style scoped>
    .toolbar{
        margin-top:10px;
        border-top:1px solid #f1f1f1;
        padding:10px 20px;
    }
    .el-button{
        color:#fff;
        font-size:16px;
        padding-top:0;
        padding-bottom:0;
        height:38px;
        line-height:38px;
        background:linear-gradient(to bottom right,#74c756,#28d07e)
    }
</style>


