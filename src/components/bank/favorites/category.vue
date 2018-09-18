<template>
    <div class="category">
        <ul>
              <li><h4>我的分类</h4></li>
              <li>高一数学</li>
              <li class="error">易错题</li>
              <li>学生为掌握知识</li>
              <li>高二数学</li>
        </ul>
              <div class="selected">
                      <div class="color-block"></div>
                      <div class="selected-block"></div>
              </div>
        <div class="create">
            创建收藏夹
        </div>
    </div>
</template>
<style scoped>
   .category{
       width: 293px;
       height: 608px;
       color: #585a60;
       font-size: 14px;
       position: relative;
   }
   ul{
        position: absolute;
        top: 38px;
        left: 30px;
        z-index: 10;
   }
   h4{
       font-size: 20px;
   }
   li{
       list-style: none;
       margin-bottom: 32px;
   }
   .error{
       color: #fa5b4a; 
   }
   .selected{
       position: absolute;
       top: 118px;
       left: 0;
       width: 283px;
       height: 48px;
   }
   .color-block{
       width: 4px;
       height: 48px;
       background: #fa5b4a;
       float: left;
   }
   .selected-block{
       width: 273px;
       height: 48px;
       background: #f8f8f8;
       float: right;
   }
   .create{
       width: 253px;
       height: 48px;
       border-radius: 8px;
       background: #f1f1f1;
       text-align: center;
       line-height: 48px;
       position: absolute;
       bottom: 20px;
       left: 20px;
   }
</style>