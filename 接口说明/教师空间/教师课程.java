/** 教师课程 */

	/** 教师Id   */ private Integer thrId   ;
	/** 课程Id   */ private Integer couId   ;
	/** 权属类型 */ private Byte    type    ; //1自创 2共建 3任课
	/** 是否任课 */ private Byte    teach   ; //1不任课 2任务课 3公开课
	/** 记录状态 */ private Byte    state   ; //2正常 3关闭 4历史
	/** 教师姓名 */ private String  thrNm   ;
	/** 教师性别 */ private String  thrSex  ; //男/女
	/** 教师校区 */ private Integer schId   ;
	/** 教师部门 */ private Integer depId   ;
	/** 课程标题 */ private String  couTitle;
	/** 开课类型 */ private Byte    kkType  ; //1公开课 2任务课
	/** 课程类型 */ private Integer couType ; //1文化基础 9兴趣拓展 ...
	/** 课程学识 */ private Integer lrnId   ;
	/** 知识点Id */ private Integer knoId   ;
	/** 课程教材 */ private Integer tbkId   ;
	/** 课程学科 */ private Short   couSub  ; //1语文 2数学 ...
	/** 课程学级 */ private Byte    couLrv  ; //1小学 2初中 3高中 ...
	/** 课程级段 */ private Byte    couGra  ; //11小一 21初一 31高一 ...
	/** 课程专业 */ private Integer couMaj  ; //...
	/** 课程难度 */ private Byte    couLevel; //10容易 20普通 30较难 40困难 50特难

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：管理、教师(我的课程)
	 *
	 * URL：p/thrMyCou!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * thrId        可选   教师Id -- 管理
	 * couId        可选   课程Id
	 * type         可选   权属类型 1自创 2共建 3任课
	 * teach        可选   是否任课 1不任课 2任务课 3公开课
	 * state        可选   记录状态 2正常 3关闭 4历史
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[ThrMyCou]}
	 *
	 */

	//==================================================================================================================
	// 查询2
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询2
	 * 权限：管理、教师(我的课程)
	 *
	 * URL：p/thrMyCou!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * thrId        可选   教师Id -- 管理
	 * couId        可选   课程Id
	 * type         可选   权属类型 1自创 2共建 3任课
	 * teach        可选   是否任课 1不任课 2任务课 3公开课
	 * state        可选   记录状态 2正常 3关闭 4历史
	 * thrNm        可选   教师姓名
	 * thrSex       可选   教师性别 男/女
	 * schId        可选   教师校区
	 * depId        可选   教师部门
	 * couTitle     可选   课程标题
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
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_ThrMyCou]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：管理、教师(课程创建者)
	 *
	 * URL：p/thrMyCou!newRec.action
	 *
	 * 参数
	 * thrId  必需   教师Id
	 * couId  必需   课程Id
	 * type   可选   权属类型 1自创 2共建 3任课 -- 其中“1自创”只有管理员有权设置
	 * teach  可选   是否任课 1不任课 2任务课 3公开课
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{ThrMyCou}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改
	 * 权限：管理、教师(课程创建者)
	 *
	 * URL：p/thrMyCou!edit.action
	 *
	 * 参数
	 * thrId  必需   教师Id
	 * couId  必需   课程Id
	 * type   可选   权属类型 1自创 2共建 3任课 -- 其中“1自创”只有管理员有权设置
	 * teach  可选   是否任课 1不任课 2任务课 3公开课
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
	 * URL：p/thrMyCou!chState.action
	 *
	 * 参数
	 * thrId    必需   教师Id
	 * couId    必需   课程Id
	 * state    必需   状态值
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：删除
	 * 权限：管理 -------------- 只能删除：状态=4
	 * 权限：教师(课程创建者) -- 只能删除：状态=2
	 *
	 *
	 * URL：p/thrMyCou!del.action
	 *
	 * 参数
	 * thrId   必需   教师Id
	 * couId   必需   课程Id
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
