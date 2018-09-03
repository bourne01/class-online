<template>
    <el-dialog
        :visible.sync="isShow"
        width="726px"
        :modal-append-to-body="false"    
        @close="onClose"        
        class="add-student-dialog">
        <header slot="title">
            <span>添加学生</span>
            <div class="banner-bg"></div>
        </header>
        <section>
            <div class="left">
                <el-input
                    placeholder="输入关键字进行过滤"
                    v-model="filterText">
                </el-input>

                <el-tree
                    class="filter-tree"
                    :data="data2"
                    :props="defaultProps"
                    default-expand-all
                    :filter-node-method="filterNode"
                    ref="tree2">
                </el-tree>
            </div>
            <div class="right">
                <el-table
                    ref="multipleTable"
                    :data="tableData3"
                    tooltip-effect="dark"
                    style="width: 100%"
                    @selection-change="handleSelectionChange">
                    <el-table-column
                    type="selection"
                    width="55">
                    </el-table-column>
                    <el-table-column
                    label="日期"
                    width="120">
                    <template slot-scope="scope">{{ scope.row.date }}</template>
                    </el-table-column>
                    <el-table-column
                    prop="name"
                    label="姓名"
                    width="120">
                    </el-table-column>
                    <el-table-column
                    prop="address"
                    label="地址"
                    show-overflow-tooltip>
                    </el-table-column>
                </el-table>
            </div>
        </section>
        <footer>
            <span>已选：46人</span>
            <button>确定添加学生</button>
        </footer>
    </el-dialog>
</template>

<script>
export default {
    props:['is-pop'],
    data(){
        return{
             tableData3: [{
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-08',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-06',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-07',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
        multipleSelection: [],
         filterText: '',
        data2: [{
          id: 1,
          label: '一级 1',
          children: [{
            id: 4,
            label: '二级 1-1',
            children: [{
              id: 9,
              label: '三级 1-1-1'
            }, {
              id: 10,
              label: '三级 1-1-2'
            }]
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }, {
          id: 3,
          label: '一级 3',
          children: [{
            id: 7,
            label: '二级 3-1'
          }, {
            id: 8,
            label: '二级 3-2'
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
        }
    },
    computed:{
        isShow:{
            get:function(){
                return this.isPop;
            },
            set:function(val){
            }
        }
    },
    methods:{
        /**
         * 监听对话框关闭事件，然后向父组件传递关闭事件
         */
        onClose(){
            this.$emit('dialog-close')
        },
        /**
         * @function 过滤节点内容
         */
        filterNode(value,data){
            console.log(value,data);
        },
    }
}
</script>

<style>
    .add-student-dialog .el-dialog__close{
        font-size:18px;
    }
    .el-dialog__header{
        padding-bottom:14px;
        border-bottom:1px solid #f1f1f1;
    }
    .el-dialog__body{
        padding:0;
    }    
</style>

<style scoped>
    .add-student-dialog{
        font-size:18px;        
    }
    header>span{
        color:#2185ff;
    }
    .banner-bg{
        width:726px;
        height:6px;
        background-color:#2185ff;
        position:absolute;
        top:0;
        left:0;        
    }
    .left{
        width:280px;
        padding-top:20px;
        padding-right:20px;
        border-right:1px solid #f1f1f1;
    }
    .right{
        padding:20px 0 0 20px;
    }
    section{
        padding:0 20px;
        display:flex;
    }
    .el-tree{
        height:400px;
        overflow:auto;
    }
    footer{
        height: 65px;
        line-height: 65px;
        display: flex;
        justify-content: space-between;
        padding:0 20px;
        border-top:1px solid #f1f1f1;
    }
    footer button{
        height:32px;
        line-height:32px;
        width:126px;
        font-size:14px;
        background-color:#2185ff;
        outline:none;
        border:none;
        color:#fff;
        align-self: center;
    }
</style>


