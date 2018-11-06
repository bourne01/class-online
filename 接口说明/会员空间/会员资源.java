/** 会员资源 */

	/** 资源Id     */ private Long      resId      ;
	/** 会员Id     */ private Long      memId      ;
	/** 会员文件   */ private Long      mefId      ;
	/** 资源内容   */ private String    html       ;
	/** 资源名称   */ private String    resName    ;
	/** 资源格式   */ private Byte      resFormat  ; //1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	/** 资源封面   */ private String    resImage   ; //图片URL
	/** 资源简介   */ private String    resBrief   ; //注意：作废保留，使用资源内容代替
	/** 资源分类   */ private Byte      resType    ; //1素材 2论文 3教案 4课件 ...
	/** 资源用途   */ private Byte      resUse     ; //1主视频 2参考 3讲义 4推荐
	/** 相关学级   */ private Byte      resLrv     ; //1小学 2初中 3高中 ...
	/** 相关学科   */ private Short     resSub     ; //1语文 2数学 ...
	/** 相关级段   */ private Short     resGra     ; //11小一 21初一 31高一 ...
	/** 相关学识   */ private Integer   resLrnId   ;
	/** 知识点Id   */ private Integer   resKnoId   ;
	/** 相关教材   */ private Integer   resTbkId   ;
	/** 教材章节   */ private Integer   resTbkSecId;
	/** 相关课程   */ private Integer   resCouId   ;
	/** 课程章节   */ private Integer   resCouSecId;
	/** 开放状态   */ private Byte      resOpen    ; //1私有 2公开
	/** 资源审核   */ private Byte      resAudit   ; //2未审核 6待审核 9已审核
	/** 创建时间   */ private Timestamp creTime    ;
	/** 更新时间   */ private Timestamp updTime    ;
	/** 使用计数   */ private Integer   useNum     ;
	/** 下载计数   */ private Integer   downNum    ;
	/** 文件URL    */ private String    fileUrl    ;
	/** 文件名     */ private String    fileName   ;
	/** 文件大小   */ private Integer   fileSize   ;
	/** 文件时长   */ private Integer   timeLen    ;
	/** 学识名称   */ private String    lrnName    ;
	/** 知识点名称 */ private String    knoName    ;
	/** 教材名称   */ private String    tbkName    ;
	/** 教材章节名 */ private String    tbkSecNm   ;
	/** 课程标题   */ private String    couTitle   ;
	/** 课程章节名 */ private String    couSecNm   ;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：管理、无限制(公开资源)
	 *
	 * URL：p/res!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * resId        可选   资源Id
	 * memId        可选   会员Id
	 * mefId        可选   会员文件
	 * resName      可选   资源名称
	 * resFormat    可选   资源格式 1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	 * resImage     可选   资源封面 图片URL
	 * resBrief     可选   资源简介
	 * resType      可选   资源分类 1素材 2论文 3教案 4课件 ...
	 * resUse       可选   资源用途 1主视频 2参考 3讲义 4推荐
	 * resLrv       可选   相关学级 1小学 2初中 3高中 ...
	 * resSub       可选   相关学科 1语文 2数学 ...
	 * resGra       可选   相关级段 11小一 21初一 31高一 ...
	 * resLrnId     可选   相关学识
	 * resKnoId     可选   知识点Id
	 * resTbkId     可选   相关教材
	 * resTbkSecId  可选   教材章节
	 * resCouId     可选   相关课程
	 * resCouSecId  可选   课程章节
	 * resOpen      可选   开放状态 1私有 2公开 -------------- 管理
	 * resAudit     可选   资源审核 2未审核 6待审核 9已审核 -- 管理
	 * useNum       可选   使用计数
	 * downNum      可选   下载计数
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[Resource]}
	 *
	 */

	//==================================================================================================================
	// 我的资源
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：我的资源
	 * 权限：个人
	 *
	 * URL：p/res!myRes.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * resId        可选   资源Id
	 * mefId        可选   会员文件
	 * resName      可选   资源名称
	 * resFormat    可选   资源格式 1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	 * resImage     可选   资源封面 图片URL
	 * resBrief     可选   资源简介
	 * resType      可选   资源分类 1素材 2论文 3教案 4课件 ...
	 * resUse       可选   资源用途 1主视频 2参考 3讲义 4推荐
	 * resLrv       可选   相关学级 1小学 2初中 3高中 ...
	 * resSub       可选   相关学科 1语文 2数学 ...
	 * resGra       可选   相关级段 11小一 21初一 31高一 ...
	 * resLrnId     可选   相关学识
	 * resKnoId     可选   知识点Id
	 * resTbkId     可选   相关教材
	 * resTbkSecId  可选   教材章节
	 * resCouId     可选   相关课程
	 * resCouSecId  可选   课程章节
	 * resOpen      可选   开放状态
	 * resAudit     可选   资源审核
	 * useNum       可选   使用计数
	 * downNum      可选   下载计数
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[Resource]}
	 *
	 */

	//==================================================================================================================
	// 查询2
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询2
	 * 权限：管理、无限制(公开资源)
	 *
	 * URL：p/res!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * resId        可选   资源Id
	 * memId        可选   会员Id
	 * mefId        可选   会员文件
	 * resName      可选   资源名称
	 * resFormat    可选   资源格式 1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	 * resImage     可选   资源封面 图片URL
	 * resBrief     可选   资源简介
	 * resType      可选   资源分类 1素材 2论文 3教案 4课件 ...
	 * resUse       可选   资源用途 1主视频 2参考 3讲义 4推荐
	 * resLrv       可选   相关学级 1小学 2初中 3高中 ...
	 * resSub       可选   相关学科 1语文 2数学 ...
	 * resGra       可选   相关级段 11小一 21初一 31高一 ...
	 * resLrnId     可选   相关学识
	 * resKnoId     可选   知识点Id
	 * resTbkId     可选   相关教材
	 * resTbkSecId  可选   教材章节
	 * resCouId     可选   相关课程
	 * resCouSecId  可选   课程章节
	 * resOpen      可选   开放状态 1私有 2公开 -------------- 管理
	 * resAudit     可选   资源审核 2未审核 6待审核 9已审核 -- 管理
	 * useNum       可选   使用计数
	 * downNum      可选   下载计数
	 * fileUrl      可选   文件URL
	 * fileName     可选   文件名
	 * fileSize     可选   文件大小
	 * timeLen      可选   文件时长
	 * lrnName      可选   学识名称
	 * knoName      可选   知识点名称
	 * tbkName      可选   教材名称
	 * tbkSecNm     可选   章节名称
	 * couTitle     可选   课程标题
	 * couSecNm     可选   章节名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_Resource]}
	 *
	 */

	//==================================================================================================================
	// 我的资源2
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：我的资源2
	 * 权限：个人
	 *
	 * URL：p/res!myRes2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * resId        可选   资源Id
	 * mefId        可选   会员文件
	 * resName      可选   资源名称
	 * resFormat    可选   资源格式 1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	 * resImage     可选   资源封面 图片URL
	 * resBrief     可选   资源简介
	 * resType      可选   资源分类 1素材 2论文 3教案 4课件 ...
	 * resUse       可选   资源用途 1主视频 2参考 3讲义 4推荐
	 * resLrv       可选   相关学级 1小学 2初中 3高中 ...
	 * resSub       可选   相关学科 1语文 2数学 ...
	 * resGra       可选   相关级段 11小一 21初一 31高一 ...
	 * resLrnId     可选   相关学识
	 * resKnoId     可选   知识点Id
	 * resTbkId     可选   相关教材
	 * resTbkSecId  可选   教材章节
	 * resCouId     可选   相关课程
	 * resCouSecId  可选   课程章节
	 * resOpen      可选   开放状态 1私有 2公开
	 * resAudit     可选   资源审核 2未审核 6待审核 9已审核
	 * useNum       可选   使用计数
	 * downNum      可选   下载计数
	 * fileUrl      可选   文件URL
	 * fileName     可选   文件名
	 * fileSize     可选   文件大小
	 * timeLen      可选   文件时长
	 * lrnName      可选   学识名称
	 * knoName      可选   知识点名称
	 * tbkName      可选   教材名称
	 * tbkSecNm     可选   章节名称
	 * couTitle     可选   课程标题
	 * couSecNm     可选   章节名称
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[V_Resource]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：管理、个人
	 *
	 * URL：p/res!newRec.action
	 *
	 * 参数
	 * memId        可选   会员Id -- 管理
	 * mefId        可选   会员文件Id  使用已有的文件
	 * file         可选   文件        直接上传一个文件。如果指定了“mefId”，则该参数无效
	 * html         可选   资源内容
	 * resName      必需   资源名称
	 * resFormat    必需   资源格式 1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	 * resImage     可选   资源封面 图片URL
	 * resBrief     可选   资源简介
	 * resType      可选   资源分类 1素材 2论文 3教案 4课件 ...
	 * resUse       可选   资源用途 1主视频 2参考 3讲义 4推荐
	 * resLrv       可选   相关学级 1小学 2初中 3高中 ...
	 * resSub       可选   相关学科 1语文 2数学 ...
	 * resGra       可选   相关级段 11小一 21初一 31高一 ...
	 * resLrnId     可选   相关学识
	 * resKnoId     可选   知识点Id
	 * resTbkId     可选   相关教材
	 * resTbkSecId  可选   教材章节
	 * resCouId     可选   相关课程
	 * resCouSecId  可选   课程章节
	 * resOpen      可选   开放状态 1私有 2公开
	 * resAudit     可选   资源审核 2未审核 6待审核
	 * resImg       可选   资源封面（图片文件）
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{Resource}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改
	 * 权限：管理、个人
	 *
	 * URL：p/res!edit.action
	 *
	 * 参数
	 * resId        必需   资源Id
	 * mefId        可选   会员文件Id  使用已有的文件
	 * file         可选   文件        直接上传一个文件。如果指定了“mefId”，则该参数无效
	 * html         可选   资源内容
	 * resName      可选   资源名称
	 * resFormat    可选   资源格式 1文本 2文档 3图片 4视频 5音乐 6SWF 10其它文件
	 * resImage     可选   资源封面 图片URL
	 * resBrief     可选   资源简介
	 * resType      可选   资源分类 1素材 2论文 3教案 4课件 ...
	 * resUse       可选   资源用途 1主视频 2参考 3讲义 4推荐
	 * resLrv       可选   相关学级 1小学 2初中 3高中 ...
	 * resSub       可选   相关学科 1语文 2数学 ...
	 * resGra       可选   相关级段 11小一 21初一 31高一 ...
	 * resLrnId     可选   相关学识
	 * resKnoId     可选   知识点Id
	 * resTbkId     可选   相关教材
	 * resTbkSecId  可选   教材章节
	 * resCouId     可选   相关课程
	 * resCouSecId  可选   课程章节
	 * resOpen      可选   开放状态 1私有 2公开
	 * resAudit     可选   资源审核 2未审核 6待审核
	 * resImg       可选   资源封面（图片文件）
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 审核
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：审核
	 * 权限：
	 *
	 * URL：p/res!audit.action
	 *
	 * 参数
	 * resIds     必需   资源Id 多个用“,”隔开
	 * resAudit   必需   审核标记 2未审核 6待审核 9已审核
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
	 * 权限：管理、个人
	 *
	 * URL：p/res!del.action
	 *
	 * 参数
	 * resIds   必需   资源Id 多个用“,”隔开
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 更新传资源内容
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：更新资源内容
	 * 权限：管理、个人
	 *
	 * URL：p/res!upHtml.action
	 *
	 * 参数
	 * resId   必需   资源Id
	 * html    必需   资源内容
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 获取资源内容
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：获取资源内容
	 * 权限：管理、个人、无限制
	 *
	 * URL：p/res!getHtml.action
	 *
	 * 参数
	 * resId   必需   资源Id
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"html":"资源内容"}
	 *
	 */

	//==================================================================================================================
	// 上传资源封面
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：上传资源封面
	 * 权限：管理、个人
	 *
	 * URL：p/res!upResImg.action
	 *
	 * 参数
	 * resId    必需   资源Id
	 * resImg   必需   资源封面（图片文件）
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 下载资源封面
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：下载资源封面
	 * 权限：管理、个人、无限制
	 *
	 * URL：p/res!downResImg.action
	 *
	 * 参数
	 * resId   必需   资源Id
	 * doTp    可选   获取类型：1=标准图、默认=缩略图
	 * ignUrl  可选   1=忽略URL，默认=优先返回URL
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：图片文件 或 {"s":true,"m":"url"}
	 *
	 */

	//==================================================================================================================
	// 下载资源文件
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：下载资源文件
	 * 权限：管理、个人(自己的资源)、无限制(公开的资源)
	 *
	 * URL：p/res!downResFile.action
	 *
	 * 参数
	 * resId   必需   资源Id
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：资源文件 或 {"s":true,"m":"文件url"}
	 *
	 */

	//==================================================================================================================
