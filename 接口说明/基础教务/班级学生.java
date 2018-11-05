/** 班级学生 */

	/** 班级Id     */ private Integer   claId    ;
	/** 学生Id     */ private Integer   stuId    ;
	/** 学生类型   */ private Byte      stuType  ; //1普通 10旁听
	/** 学生状态   */ private Byte      stuState ; //1待审核 2正常 4离开 5请出 6黑名单
	/** 入班日期   */ private Date      joinDate ;
	/** 离班日期   */ private Date      leaveDate;
	/** 所属小组Id */ private Integer   teamId   ;
	/** 显示顺序   */ private Integer   order    ;
	/** 会员Id     */ private Long      memId    ;
	/** 学生姓名   */ private String    stuNm    ;
	/** 学生性别   */ private String    stuSex   ; //男/女
	/** 学生校区   */ private Integer   schId    ;
	/** 学生部门   */ private Integer   depId    ;
	/** 学号       */ private String    stuNO    ;
	/** 空间名称   */ private String    spaNm    ;
	/** 自我介绍   */ private String    myself   ;
	/** 学生年级   */ private Integer   year     ;
	/** 学生专业   */ private Integer   major    ; //代码3
	/** 学生班级   */ private Integer   stuClaId ;
	/** 学生经验   */ private Integer   exp      ;
	/** 学生等级   */ private Integer   level    ;
	/** 学生学分   */ private Double    credit   ;
	/** 创建时间   */ private Timestamp creTime  ;
	/** 更新时间   */ private Timestamp updTime  ;
	/** 学生去向   */ private Byte      stuTo    ; //2正常
	/** 学空状态   */ private Byte      state    ; //1申请中 2正常 3关闭
	/** 数据类型   */ private Byte      datTp    ; //2内部 3自助
	/** 防问计数   */ private Integer   visit    ;
	/** 校区名称   */ private String    schNm    ;
	/** 部门名称   */ private String    depNm    ;
	/** 班级校区   */ private Integer   claSchId ;
	/** 班级部门   */ private Integer   claDepId ;
	/** 班级类型   */ private Byte      claType  ; //代码10 1行政班 10教学班 20微课班
	/** 班级名称   */ private String    claName  ;
	/** 班级简介   */ private String    claBrief ;
	/** 开班年级   */ private Integer   claYear  ;
	/** 班级专业   */ private Integer   claMajor ; //代码3
	/** 班主任Id   */ private Integer   claThrId ;
	/** 开班时间   */ private Timestamp claTimeS ;
	/** 结业时间   */ private Timestamp claTimeE ;
	/** 充许旁听   */ private Byte      claVisit ; //1=允许 2不允许
	/** 开启申请   */ private Byte      claJoin  ; //1不开启 2申请码 3直接申请
	/** 申请审核   */ private Byte      claAudit ; //1必需审核 2申请码审核 3无需审核
	/** 班级状态   */ private Byte      claState ; //2正常 3关闭 4历史
	/** 名单维护   */ private Byte      setStu   ; //1任教老师 2班主任 3管理员 4关闭维护
	/** 备注       */ private String    remark   ;
	/** 学生总数   */ private Integer   stuSum   ;
	/** 男生总数   */ private Integer   boySum   ;
	/** 正式学生   */ private Integer   regStu   ;
	/** 正式男生   */ private Integer   regBoy   ;
	/** 部门名称   */ private String    claSchNm ;
	/** 部门名称   */ private String    claDepNm ;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：
	 *
	 * URL：p/claStu!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * claId        可选   班级Id
	 * stuId        可选   学生Id
	 * stuType      可选   学生类型 1普通 10旁听
	 * stuState     可选   学生状态 1待审核 2正常 4离开 5请出 6黑名单
	 * teamId       可选   所属小组Id
	 * order        可选   显示顺序
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[ClaStu]}
	 *
	 */

	//==================================================================================================================
	// 学生名单
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：学生名单
	 * 权限：管理、教师
	 *
	 * URL：p/claStu!stuList.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * claId        可选   班级Id
	 * stuId        可选   学生Id
	 * stuType      可选   学生类型 1普通 10旁听
	 * stuState     可选   学生状态 1待审核 2正常 4离开 5请出 6黑名单
	 * teamId       可选   所属小组Id
	 * order        可选   显示顺序
	 * memId        可选   会员Id
	 * stuNm        可选   学生姓名
	 * stuSex       可选   学生性别 男/女
	 * schId        可选   学生校区
	 * depId        可选   学生部门
	 * stuNO        可选   学号
	 * spaNm        可选   空间名称
	 * myself       可选   自我介绍
	 * year         可选   学生年级
	 * major        可选   学生专业 代码3
	 * stuClaId     可选   学生班级
	 * exp          可选   学生经验
	 * level        可选   学生等级
	 * credit       可选   学生学分
	 * stuTo        可选   学生去向 2正常
	 * state        可选   学空状态 1申请中 2正常 3关闭
	 * datTp        可选   数据类型 2内部 3自助
	 * visit        可选   防问计数
	 * schNm        可选   部门名称
	 * depNm        可选   部门名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_ClaStu_Stu]}
	 *
	 */

	//==================================================================================================================
	// 我的班级
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：我的班级
	 * 权限：管理、班级学员
	 *
	 * URL：p/claStu!myCla.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * claId        可选   班级Id
	 * stuId        可选   学生Id -- 管理
	 * stuType      可选   学生类型 1普通 10旁听
	 * stuState     可选   学生状态 1待审核 2正常 4离开 5请出 6黑名单
	 * teamId       可选   所属小组Id
	 * order        可选   显示顺序
	 * claSchId     可选   班级校区
	 * claDepId     可选   班级部门
	 * claType      可选   班级类型 代码10 1行政班 10教学班 20微课班
	 * claName      可选   班级名称
	 * claBrief     可选   班级简介
	 * claYear      可选   开班年级
	 * claMajor     可选   班级专业 代码3
	 * claThrId     可选   班主任Id
	 * claVisit     可选   充许旁听 1=允许 2不允许
	 * claJoin      可选   开启申请 1不开启 2申请码 3直接申请
	 * claAudit     可选   申请审核 1必需审核 2申请码审核 3无需审核
	 * claState     可选   班级状态 2正常 3关闭 4历史
	 * setStu       可选   名单维护 1任教老师 2班主任 3管理员 4关闭维护
	 * remark       可选   备注
	 * stuSum       可选   学生总数
	 * boySum       可选   男生总数
	 * regStu       可选   正式学生
	 * regBoy       可选   正式男生
	 * claSchNm     可选   部门名称
	 * claDepNm     可选   部门名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_ClaStu_Cla]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：名单维护者
	 *
	 * URL：p/claStu!newRec.action
	 *
	 * 参数
	 * claId      必需   班级Id
	 * stuId      必需   学生Id
	 * stuType    可选   学生类型 1普通 10旁听
	 * stuState   可选   学生状态 1待审核 2正常 4离开 5请出 6黑名单
	 * joinDate   可选   入班日期
	 * leaveDate  可选   离班日期
	 * teamId     可选   所属小组Id
	 * order      可选   显示顺序
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{ClaStu}}
	 *
	 */

	//==================================================================================================================
	// 批量保存(新增更新)
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：批量保存(新增更新)
	 * 使用者：名单维护者
	 *
	 * URL：p/claStu!batSave.action
	 *
	 * 参数
	 * claId      必需   班级Id
	 * stuIds     必需   学生Id   多个用“,”隔开
	 * stuType    可选   学生类型 1普通 10旁听
	 * stuState   可选   学生状态 1待审核 2正常 4离开 5请出 6黑名单
	 * joinDate   可选   入班日期
	 * leaveDate  可选   离班日期
	 * teamId     可选   所属小组Id
	 * order      可选   显示顺序
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改
	 * 权限：名单维护者
	 *
	 * URL：p/claStu!edit.action
	 *
	 * 参数
	 * claId      必需   班级Id
	 * stuId      必需   学生Id
	 * stuType    可选   学生类型 1普通 10旁听
	 * stuState   可选   学生状态 1待审核 2正常 4离开 5请出 6黑名单
	 * joinDate   可选   入班日期
	 * leaveDate  可选   离班日期
	 * teamId     可选   所属小组Id
	 * order      可选   显示顺序
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
	 * 权限：名单维护者
	 *
	 * URL：p/claStu!del.action
	 *
	 * 参数
	 * claId    必需   班级Id
	 * stuId    必需   学生Id
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
