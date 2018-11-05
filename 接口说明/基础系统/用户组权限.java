/** 用户组权限 */

	/** 用户组Id */ private Integer usgId;
	/** 权限编号 */ private Integer powNO;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：查询
	 * 权限：
	 *
	 * URL：p/usgPow!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * usgId        可选   用户组Id
	 * powNO        可选   权限编号
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"t":"总记录数","d":[UsgPower]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：新增
	 * 权限：
	 *
	 * URL：p/usgPow!newRec.action
	 *
	 * 参数
	 * usgId  必需   用户组Id
	 * powNO  必需   权限编号
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息","d":{UsgPower}}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 * 功能：删除
	 * 权限：
	 *
	 * URL：p/usgPow!del.action
	 *
	 * 参数
	 * usgIds   必需   用户组Id 多个用“,”隔开
	 * powNOs   必需   权限编号 多个用“,”隔开
	 *
	 * 出错返回：{"s":false,"m":"错误信息"}
	 * 正确返回：{"s":true,"m":"成功信息"}
	 *
	 */

	//==================================================================================================================
