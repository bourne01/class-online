<template>
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)" :style="{minHeight}">
        <el-menu :default-openeds="['1']">
            <el-submenu index="1">
                <template slot="title"><i class="el-icon-message"></i>基础教务</template>
                <el-menu-item :index="item.id" 
                    v-for="(item,idx) in deanList" :key="idx"
                    @click="onClick('基础教务',item)">{{item.name}}                   
                </el-menu-item>
            </el-submenu>
            <el-submenu index="2">
                <template slot="title"><i class="el-icon-menu"></i>基础系统</template>
                <el-menu-item :index="item.id"
                    v-for="(item,idx) in sysList" :key="idx"
                    @click="onClick('基础系统',item)">{{item.name}}
                </el-menu-item>
            </el-submenu>
            <el-submenu index="3">
                <template slot="title"><i class="el-icon-setting"></i>用户空间</template>
                <el-menu-item :index="item.id"
                    v-for="(item,idx) in userZones" :key="idx"
                    @click="onClick('用户空间',item)">{{item.name}}
                </el-menu-item>
            </el-submenu>
            <el-submenu index="4">
                <template slot="title"><i class="el-icon-setting"></i>课程基础</template>
                <el-menu-item :index="item.id"
                    v-for="(item,idx) in courseList" :key="idx"
                    @click="onClick('课程基础',item)">{{item.name}}
                </el-menu-item>
            </el-submenu>
        </el-menu>
    </el-aside>
</template>

<script>
import { mapMutations } from 'vuex';
export default {
    data(){
        return{
            deanList:[//教务基础列表
                {id:'1-1',name:'作息表',alias:'time-table'},
                {id:'1-2',name:'入学年份',alias:'join-year'},
                {id:'1-3',name:'学期信息',alias:'term'},
                {id:'1-4',name:'小组信息',alias:'team'},
                {id:'1-5',name:'教学场地',alias:'teach-site'},
                {id:'1-6',name:'校区学生',alias:'campus-student'},
                {id:'1-7',name:'班级信息',alias:'class'},
                {id:'1-8',name:'班级学生',alias:'class-student'},
                {id:'1-9',name:'部门信息',alias:'department'},
                {id:'1-10',name:'部门成员',alias:'dep-member'},
            ],
            sysList:[//系统基础列表
                {id:'2-1',name:'用户组',alias:'user-group'},
                {id:'2-2',name:'用户组权限',alias:'group-permission'},
                {id:'2-3',name:'权限定义',alias:'permission-definition'},
                {id:'2-4',name:'系统任务',alias:'system-task'},
                {id:'2-5',name:'配置信息',alias:'settings'},
                /* {id:'2-6',name:'列表数据',alias:'selector'}, */
                {id:'2-7',name:'文件信息',alias:'file-info'},                
            ],
            userZones:[//用户空间列表
                {id:'3-1',name:'会员信息',alias:'vip-info'},
                {id:'3-2',name:'会员文件',alias:'vip-file'},
                {id:'3-3',name:'教师空间',alias:'teacher-zone'},
                {id:'3-4',name:'学生空间',alias:'student-zone'},
            ],
            courseList:[//课程基础列表
                {id:'4-1',name:'课程大纲',alias:'syllabus'},
                {id:'4-2',name:'知识点',alias:'knowledge-point'},
                {id:'4-3',name:'课本教材',alias:'textbook'},
                {id:'4-4',name:'教材目录',alias:'textbook-content'},
                {id:'4-5',name:'课程目录',alias:'course-content'},
                {id:'4-6',name:'课程资源',alias:'resource'},
            ],
            minHeight:(document.documentElement.clientHeight - 68 - 380) + 'px',//左侧导航条最小高度
        }
    },
    methods:{
        ...mapMutations('base',['SET_CURRENT_MENU_ITEM','SET_CURRENT_MENU_TITLE']),
        /**
         * @function 监听点击导航列表项事件，然后跳转到相应页面
         * @param {导航分类名称} navTitle
         * @param {导航列表项对象} navItem
         */
        onClick(navTitle,navItem){
            this['SET_CURRENT_MENU_ITEM'](navItem);
            this['SET_CURRENT_MENU_TITLE'](navTitle);
            this.$router.push('/admin-index/base/'+navItem.alias);
        },
    },
    created(){
        /**初始化 当期菜单标题和菜单项 */
        this['SET_CURRENT_MENU_ITEM']({id:'1-3',name:'学期信息',alias:'term'},);
        this['SET_CURRENT_MENU_TITLE']('基础教务');
    }
}
</script>
