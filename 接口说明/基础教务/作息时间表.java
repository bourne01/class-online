/** 作息时间表 */

	/** 作息表Id   */ private Integer autoId ;
	/** 学期Id     */ private Integer termId ; //0代表通用
	/** 校区Id     */ private Integer schId  ; //0代表通用
	/** 作息表名称 */ private String  name   ;
	/** 早晨1开始  */ private Time    morn1S ;
	/** 早晨1结束  */ private Time    morn1E ;
	/** 早晨2开始  */ private Time    morn2S ;
	/** 早晨2结束  */ private Time    morn2E ;
	/** 上午1开始  */ private Time    am1S   ;
	/** 上午1结束  */ private Time    am1E   ;
	/** 上午2开始  */ private Time    am2S   ;
	/** 上午2结束  */ private Time    am2E   ;
	/** 上午3开始  */ private Time    am3S   ;
	/** 上午3结束  */ private Time    am3E   ;
	/** 上午4开始  */ private Time    am4S   ;
	/** 上午4结束  */ private Time    am4E   ;
	/** 上午5开始  */ private Time    am5S   ;
	/** 上午5结束  */ private Time    am5E   ;
	/** 上午6开始  */ private Time    am6S   ;
	/** 上午6结束  */ private Time    am6E   ;
	/** 下午1开始  */ private Time    pm1S   ;
	/** 下午1结束  */ private Time    pm1E   ;
	/** 下午2开始  */ private Time    pm2S   ;
	/** 下午2结束  */ private Time    pm2E   ;
	/** 下午3开始  */ private Time    pm3S   ;
	/** 下午3结束  */ private Time    pm3E   ;
	/** 下午4开始  */ private Time    pm4S   ;
	/** 下午4结束  */ private Time    pm4E   ;
	/** 下午5开始  */ private Time    pm5S   ;
	/** 下午5结束  */ private Time    pm5E   ;
	/** 下午6开始  */ private Time    pm6S   ;
	/** 下午6结束  */ private Time    pm6E   ;
	/** 晚上1开始  */ private Time    night1S;
	/** 晚上1结束  */ private Time    night1E;
	/** 晚上2开始  */ private Time    night2S;
	/** 晚上2结束  */ private Time    night2E;
	/** 当前作息表 */ private Byte    cur    ; //1是 2否
	/** 记录状态   */ private Byte    state  ; //2正常 3关闭 4历史

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：
	 *
	 * URL：p/timeTab!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * autoId       可选   作息表Id
	 * termId       可选   学期Id
	 * schId        可选   校区Id
	 * name         可选   作息表名称
	 * cur          可选   当前作息表 1是 2否
	 * state        可选   记录状态 2正常 3关闭 4历史
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[TimeTable]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：
	 *
	 * URL：p/timeTab!newRec.action
	 *
	 * 参数
	 * termId   必需   学期Id 0代表通用
	 * schId    必需   校区Id 0代表通用
	 * name     必需   作息表名称
	 * morn1S   可选   早晨1开始
	 * morn1E   可选   早晨1结束
	 * morn2S   可选   早晨2开始
	 * morn2E   可选   早晨2结束
	 * am1S     可选   上午1开始
	 * am1E     可选   上午1结束
	 * am2S     可选   上午2开始
	 * am2E     可选   上午2结束
	 * am3S     可选   上午3开始
	 * am3E     可选   上午3结束
	 * am4S     可选   上午4开始
	 * am4E     可选   上午4结束
	 * am5S     可选   上午5开始
	 * am5E     可选   上午5结束
	 * am6S     可选   上午6开始
	 * am6E     可选   上午6结束
	 * pm1S     可选   下午1开始
	 * pm1E     可选   下午1结束
	 * pm2S     可选   下午2开始
	 * pm2E     可选   下午2结束
	 * pm3S     可选   下午3开始
	 * pm3E     可选   下午3结束
	 * pm4S     可选   下午4开始
	 * pm4E     可选   下午4结束
	 * pm5S     可选   下午5开始
	 * pm5E     可选   下午5结束
	 * pm6S     可选   下午6开始
	 * pm6E     可选   下午6结束
	 * night1S  可选   晚上1开始
	 * night1E  可选   晚上1结束
	 * night2S  可选   晚上2开始
	 * night2E  可选   晚上2结束
	 * cur      可选   当前作息表 1是 2否
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{TimeTable}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：修改
	 * 权限：
	 *
	 * URL：p/timeTab!edit.action
	 *
	 * 参数
	 * autoId   必需   作息表Id
	 * termId   可选   学期Id
	 * schId    可选   校区Id
	 * name     可选   作息表名称
	 * morn1S   可选   早晨1开始
	 * morn1E   可选   早晨1结束
	 * morn2S   可选   早晨2开始
	 * morn2E   可选   早晨2结束
	 * am1S     可选   上午1开始
	 * am1E     可选   上午1结束
	 * am2S     可选   上午2开始
	 * am2E     可选   上午2结束
	 * am3S     可选   上午3开始
	 * am3E     可选   上午3结束
	 * am4S     可选   上午4开始
	 * am4E     可选   上午4结束
	 * am5S     可选   上午5开始
	 * am5E     可选   上午5结束
	 * am6S     可选   上午6开始
	 * am6E     可选   上午6结束
	 * pm1S     可选   下午1开始
	 * pm1E     可选   下午1结束
	 * pm2S     可选   下午2开始
	 * pm2E     可选   下午2结束
	 * pm3S     可选   下午3开始
	 * pm3E     可选   下午3结束
	 * pm4S     可选   下午4开始
	 * pm4E     可选   下午4结束
	 * pm5S     可选   下午5开始
	 * pm5E     可选   下午5结束
	 * pm6S     可选   下午6开始
	 * pm6E     可选   下午6结束
	 * night1S  可选   晚上1开始
	 * night1E  可选   晚上1结束
	 * night2S  可选   晚上2开始
	 * night2E  可选   晚上2结束
	 * cur      可选   当前作息表 1是 2否
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
	 * URL：p/timeTab!chState.action
	 *
	 * 参数
	 * autoIds   必需   作息表Id 多个用“,”隔开
	 * state     必需   状态值
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：删除  只能删除状态为“4历史”的记录
	 * 权限：
	 *
	 * URL：p/timeTab!del.action
	 *
	 * 参数
	 * autoIds   必需   作息表Id 多个用“,”隔开
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
