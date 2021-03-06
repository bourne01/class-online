/** 课程 */

	/** 课程Id     */ private Integer   couId   ;
	/** 课程标题   */ private String    couTitle;
	/** 课程封面   */ private String    couImage; //URL地址
	/** 关键字     */ private String    keyword ;
	/** 开课类型   */ private Byte      kkType  ; //1公开课 2任务课
	/** 课程类型   */ private Integer   couType ; //1文化基础 9兴趣拓展 ...
	/** 课程学识   */ private Integer   lrnId   ;
	/** 知识点Id   */ private Integer   knoId   ;
	/** 课程教材   */ private Integer   tbkId   ;
	/** 课程学科   */ private Short     couSub  ; //1语文 2数学 ...
	/** 课程学级   */ private Byte      couLrv  ; //1小学 2初中 3高中 ...
	/** 课程级段   */ private Byte      couGra  ; //11小一 21初一 31高一 ...
	/** 课程专业   */ private Integer   couMaj  ; //...
	/** 课程难度   */ private Byte      couLevel; //10容易 20普通 30较难 40困难 50特难
	/** 创建者Id   */ private Integer   creId   ; //教师Id
	/** 创建者名   */ private String    creName ;
	/** 创建时间   */ private Timestamp creTime ;
	/** 更新时间   */ private Timestamp updTime ;
	/** 课程状态   */ private Byte      state   ; //2正常 3关闭 4历史
	/** 审核状态   */ private Byte      auState ; //2未审核 4不通过 6待审核 9已审核
	/** 课程积分   */ private Byte      couPoint;
	/** 课程评价   */ private Byte      eval    ; //五星(10-50)
	/** 课程点赞   */ private Integer   likeNum ;
	/** 浏览次数   */ private Integer   brwNum  ;
	/** 学习人数   */ private Integer   stuNum  ;
	/** 结业人数   */ private Integer   finNum  ;
	/** 学识名称   */ private String    lrnName ;
	/** 知识点名称 */ private String    knoName ;
	/** 教材名称   */ private String    tbkName ;
	/** 课程简介   */ private String    couBrief;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：无限制
	 *
	 * URL：p/cou!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * couId        可选   课程Id
	 * couTitle     可选   课程标题
	 * couImage     可选   课程封面 URL地址
	 * keyword      可选   关键字
	 * kkType       可选   开课类型 1公开课 2任务课
	 * couType      可选   课程类型 1文化基础 9兴趣拓展 ...
	 * lrnId        可选   课程学识
	 * knoId        可选   知识点Id
	 * tbkId        可选   课程教材
	 * couSub       可选   课程学科 1语文 2数学 ...
	 * couLrv       可选   课程学级 1小学 2初中 3高中 ...
	 * couGra       可选   课程级段 11小一 21初一 31高一 ...
	 * couMaj       可选   课程专业 ...
	 * couLevel     可选   课程难度 10容易 20普通 30较难 40困难 50特难
	 * creId        可选   创建者Id
	 * creName      可选   创建者名
	 * state        可选   课程状态 2正常 3关闭 4历史
	 * auState      可选   审核状态 2未审核 4不通过 6待审核 9已审核
	 * couPoint     可选   课程积分
	 * likeNum      可选   课程点赞
	 * eval         可选   课程评价 五星(10-50)
	 * brwNum       可选   浏览次数
	 * stuNum       可选   学习人数
	 * finNum       可选   结业人数
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[Course]}
	 *
	 */

	//==================================================================================================================
	// 查询2
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询2
	 * 权限：无限制
	 *
	 * URL：p/cou!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * couId        可选   课程Id
	 * couTitle     可选   课程标题
	 * couImage     可选   课程封面 URL地址
	 * keyword      可选   关键字
	 * kkType       可选   开课类型 1公开课 2任务课
	 * couType      可选   课程类型 1文化基础 9兴趣拓展 ...
	 * lrnId        可选   课程学识
	 * knoId        可选   知识点Id
	 * tbkId        可选   课程教材
	 * couSub       可选   课程学科 1语文 2数学 ...
	 * couLrv       可选   课程学级 1小学 2初中 3高中 ...
	 * couGra       可选   课程级段 11小一 21初一 31高一 ...
	 * couMaj       可选   课程专业 ...
	 * couLevel     可选   课程难度 10容易 20普通 30较难 40困难 50特难
	 * creId        可选   创建者Id 教师Id
	 * creName      可选   创建者名
	 * state        可选   课程状态 2正常 3关闭 4历史
	 * auState      可选   审核状态 2未审核 4不通过 6待审核 9已审核
	 * couPoint     可选   课程积分
	 * eval         可选   课程评价 五星(10-50)
	 * likeNum      可选   课程点赞
	 * brwNum       可选   浏览次数
	 * stuNum       可选   学习人数
	 * finNum       可选   结业人数
	 * lrnName      可选   学识名称
	 * knoName      可选   知识点名称
	 * tbkName      可选   教材名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_Course]}
	 *
	 */

	//==================================================================================================================
	// 获取课程简介
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：获取课程简介
	 * 权限：无限制
	 *
	 * URL：p/cou!getBrief.action
	 *
	 * 参数
	 * couId   必需   课程Id
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"简介内容"}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：教师
	 *
	 * URL：p/cou!newRec.action
	 *
	 * 参数
	 * couTitle     必需   课程标题
	 * couImage     可选   课程封面 URL地址
	 * keyword      可选   关键字
	 * kkType       可选   开课类型 1公开课 2任务课
	 * couType      可选   课程类型 1文化基础 9兴趣拓展 ...
	 * lrnId        可选   课程学识
	 * knoId        可选   知识点Id
	 * tbkId        可选   课程教材
	 * couSub       可选   课程学科 1语文 2数学 ...
	 * couLrv       可选   课程学级 1小学 2初中 3高中 ...
	 * couGra       可选   课程级段 11小一 21初一 31高一 ...
	 * couMaj       可选   课程专业 ...
	 * couLevel     可选   课程难度 10容易 20普通 30较难 40困难 50特难
	 * auState      可选   审核状态 2未审核 6待审核
	 * couPoint     可选   课程积分
	 * couBrief     可选   课程简介
	 * file         可选   课程封面（文件）
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{Course}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改
	 * 权限：管理、课程创建者、课程共建人员
	 *
	 * URL：p/cou!edit.action
	 *
	 * 参数
	 * couId        必需   课程Id
	 * couTitle     可选   课程标题
	 * couImage     可选   课程封面 URL地址
	 * keyword      可选   关键字
	 * kkType       可选   开课类型 1公开课 2任务课
	 * couType      可选   课程类型 1文化基础 9兴趣拓展 ...
	 * lrnId        可选   课程学识
	 * knoId        可选   知识点Id
	 * tbkId        可选   课程教材
	 * couSub       可选   课程学科 1语文 2数学 ...
	 * couLrv       可选   课程学级 1小学 2初中 3高中 ...
	 * couGra       可选   课程级段 11小一 21初一 31高一 ...
	 * couMaj       可选   课程专业 ...
	 * couLevel     可选   课程难度 10容易 20普通 30较难 40困难 50特难
	 * auState      可选   审核状态 2未审核 6待审核
	 * couPoint     可选   课程积分
	 * couBrief     可选   课程简介
	 * file         可选   课程封面（文件）
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 修改记录状态
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改记录状态
	 * 权限：
	 *
	 * URL：p/cou!chState.action
	 *
	 * 参数
	 * couIds   必需   课程Id 多个用“,”隔开
	 * state    必需   状态值
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 课程审核（变更审核状态）
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：课程审核（变更审核状态）
	 * 权限：
	 *
	 * URL：p/cou!chAudit.action
	 *
	 * 参数
	 * couIds    必需   课程Id 多个用“,”隔开
	 * auState   必需   审核状态  2未审核 4不通过 6待审核 9已审核
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：删除  有“教案、课堂”的课程不能删除
	 * 权限：管理 -------- 只能删除：状态=4
	 * 权限：课程创建者 -- 只能删除：状态=2 + 未过审核（开启自动审核除外）
	 *
	 * URL：p/cou!del.action
	 *
	 * 参数
	 * couId   必需   课程Id
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 上传课程封面
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：上传课程封面
	 * 权限：管理、课程创建者、课程共建人员
	 *
	 * URL：p/cou!upImage.action
	 *
	 * 参数
	 * couId   必需   课程Id
	 * file    可选   课程封面（文件）
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 获取课程封面
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：获取课程封面
	 * 权限：无限制
	 *
	 * URL：p/cou!downImage.action
	 *
	 * 参数
	 * couId   必需   课程Id
	 * doTp    可选   获取类型：1=标准图、默认=缩略图
	 * ignUrl  可选   1=忽略URL，默认=优先返回URL
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：图片文件 或 {"s":true,"m":"url"}
	 *
	 */

	//==================================================================================================================
