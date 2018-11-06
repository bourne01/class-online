/** 课程目录 */

	/** 课程章节Id */ private Integer couSecId;
	/** 课程Id     */ private Integer couId   ;
	/** 识识点Id   */ private Integer knoId   ;
	/** 教材章节   */ private Integer tbkSecId;
	/** 父结点Id   */ private Integer fatherId;
	/** 课程章节名 */ private String  couSecNm;
	/** 课程章节类 */ private Byte    couSecTp; //1章 2节 3点
	/** 章节顺序   */ private Double  order   ;
	/** 章节状态   */ private Byte    state   ; //2正常 3关闭 4历史
	/** 知识点名称 */ private String  knoName ;
	/** 教材章节名 */ private String  tbkSecNm;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：无限制
	 *
	 * URL：p/couSec!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * couSecId     可选   课程章节Id
	 * couId        可选   课程Id
	 * knoId        可选   识识点Id
	 * tbkSecId     可选   教材章节
	 * fatherId     可选   父结点Id  0代表查根级(第1级)结点
	 * couSecNm     可选   课程章节名
	 * couSecTp     可选   课程章节类 1章 2节 3点
	 * order        可选   章节顺序
	 * state        可选   章节状态 2正常 3关闭 4历史
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 * doTp         可选   1=查询所有子结点(包含自身)、2=查询所有子结点(不含自身)，默认不查子结点 -- 指定couSecId查询时有效
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[CouSection]}
	 *
	 */

	//==================================================================================================================
	// 查询2
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询2
	 * 权限：无限制
	 *
	 * URL：p/couSec!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * couSecId     可选   课程章节Id
	 * couId        可选   课程Id
	 * knoId        可选   识识点Id
	 * tbkSecId     可选   教材章节
	 * fatherId     可选   父结点Id
	 * couSecNm     可选   课程章节名
	 * couSecTp     可选   课程章节类 1章 2节 3点
	 * order        可选   章节顺序
	 * state        可选   章节状态 2正常 3关闭 4历史
	 * knoName      可选   知识点名称
	 * tbkSecNm     可选   教材章节名
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_CouSection]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：管理、课程创建者、课程共建人员
	 *
	 * URL：p/couSec!newRec.action
	 *
	 * 参数
	 * couId     必需   课程Id
	 * knoId     可选   识识点Id
	 * tbkSecId  可选   教材章节
	 * fatherId  可选   父结点Id
	 * couSecNm  必需   课程章节名
	 * couSecTp  必需   课程章节类 1章 2节 3点
	 * order     可选   章节顺序
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{CouSection}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改
	 * 权限：管理、课程创建者、课程共建人员
	 *
	 * URL：p/couSec!edit.action
	 *
	 * 参数
	 * couSecId  必需   课程章节Id
	 * knoId     可选   识识点Id
	 * tbkSecId  可选   教材章节
	 * fatherId  可选   父结点Id
	 * couSecNm  可选   课程章节名
	 * couSecTp  可选   课程章节类 1章 2节 3点
	 * order     可选   章节顺序
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
	 * URL：p/couSec!chState.action
	 *
	 * 参数
	 * couSecIds   必需   课程章节Id 多个用“,”隔开
	 * state       必需   状态值
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：删除  有“教案、课堂”的课程章节不能删除
	 * 权限：管理 ----------------------- 只能删除：状态=4
	 * 权限：课程创建者、课程共建人员 --- 只能删除：状态=2 + 其它必要条件
	 *
	 * URL：p/couSec!del.action
	 *
	 * 参数
	 * couSecId   必需   课程章节Id 多个用“,”隔开
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
