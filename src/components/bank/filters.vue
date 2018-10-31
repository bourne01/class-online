<template>
    <div class="filters">
        <div v-if="!isFilter">
            <div class="level filter">
                <label for="">学段：</label>
                <span 
                    v-if="isAll"
                    @click="onClick('Level',-1)"
                    :class="{active:levIdx==-1}"
                >全部</span>
                <span 
                    v-for="(level,idx) in levList" 
                    :key="idx"
                    @click="onClick('Level',idx)"
                    :class="{active:levIdx==idx}"
                    >{{level}}</span>                
            </div>        
            <div class="course filter">
                <label for="">学科：</label>
                <span 
                    v-if="isAll"
                    @click="onClick('Course',-1)"
                    :class="{active:couIdx==-1}"
                >全部</span>
                <span 
                    v-for="idx in 4" 
                    :key="idx"
                    @click="onClick('Course',idx)"
                    :class="{active:couIdx==idx}">{{'语文'}}</span>
            </div>
            <div class="version filter">
                <label for="">版本：</label>
                <span 
                    v-if="isAll"
                    @click="onClick('Version',-1)"
                    :class="{active:verIdx==-1}"
                >全部</span>
                <span 
                    v-for="idx in 4" 
                    :key="idx"
                    @click="onClick('Version',idx)"
                    :class="{active:verIdx==idx}">{{verList[idx]}}</span>
            </div>
            <div class="textbook filter">
                <label for="">课本：</label>
                <span 
                    v-if="isAll"
                    @click="txtIdx=-1"
                    :class="{active:txtIdx==-1}"
                >全部</span>
                <span 
                    v-for="idx in 4" 
                    :key="idx"
                    @click="onClick('Textbook',idx)"
                    :class="{active:txtIdx==idx}">{{txtList[idx]}}</span>
            </div>
        </div>        
        <div class="search-bar filter">
            <label for="" style="width:3em;"></label>            
            <el-select v-model="value" placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
            <el-select v-model="value" placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
            <el-select v-model="value" placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
            </el-select>
            <slot name="button"></slot>
        </div>
    </div>
</template>

<script>
export default {
    props:['is-all','is-filter'],
    data(){
        return{
            couIdx:-1,
            levIdx:-1,
            levList:['小学','初中','高中'],
            verList:['七年级上册','七年级下册','八年级上册','八年级下册'],//教材版本
            txtList:['人教版','北师大版','浙教版','苏教版'],//教材
            verIdx:-1,
            txtIdx:-1,
            value:'',
            search:'',
            options:{},
        }
    },
    methods:{
        /**
         * @function 监听过滤点击事件，然后做相应处理
         * @param {type} 过滤条件名称
         * @param {index} 在本名称下的序号
         */
        onClick(type,index){
            switch(type){
                case 'Course':
                    this.couIdx = index;
                    /**其它处理写于此处 */
                    break;
                case 'Level':
                    this.levIdx = index;
                    /**其它处理写于此处 */
                    break;
                case 'Version':
                    this.verIdx = index;
                    /**其它处理写于此处 */
                    break;
                case 'Textbook':
                    this.txtIdx = index;
                    /**其它处理写于此处 */
                    break;
            }
        }
    },
}
</script>

<style>
    .filters .el-input__inner{
        background-color:#f1f1f1;
    }
</style>

<style scoped>
    .filters{
        display: flex;
        flex-direction: column;
        background-color:#fff;
        padding-left:20px;
    }
    .filter{
        display:flex;
        margin-bottom:20px;

    }
    .filter:first-child{
        margin-top:20px;
    }
    .filter label{
        padding:5px 15px 5px 0;
        font-size:14px;
        color:#585a60;
    }
    .filter .btn{
        padding:5px 15px;
        color:#fff;
        font-size:12px;
        background-color:#fc6934;
        outline: none;
        border:none;
    }
    .filter span{
        padding:5px 15px;
        font-size:12px;
        color:#585a60;
        cursor: pointer;
    }
    .el-select{
        width:15%;
        margin-right:40px;
    }
    .active{
        background-color:#fa5b4a;
        color:#fff!important;
        border-radius:2px;
    }
</style>

