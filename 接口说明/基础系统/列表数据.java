	/** 列表数据 */


    //==================================================================================================================
    // 编码信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
	 * 功能：获取各种字典编码信息列表
     *  URL：p/webDat!codeList.action
     *
     * 参数：
     * cp    必需   代码类型
     * ad    可选   1=返回[no,name]，否则返回[id,name]
     * st    可选   状态限制：2正常 3关闭
     * od    可选   排序字段名称，倒序前面加“@”
     * rp    可选   返回的数据格式：1    --> {"dataList":[{'id':'?','name':'?'},...]}
     *                              默认 --> [[id,name],...]
     *
     * 出错返回：{"s":false,"m":"错误信息"}
     *
     */

	//==================================================================================================================
	// 学期
	//------------------------------------------------------------------------------------------------------------------
	/**
	 * 功能：学期列表
     *  URL：p/webDat!termList.action
	 *
     * 参数：
     * st    可选   状态限制：2正常 3关闭
     * rp    可选   返回的数据格式：1    --> {"dataList":[{'id':'?','name':'?'},...]}
     *                              默认 --> [[id,name],...]
     *
     * 出错返回：{"s":false,"m":"错误信息"}
     *
	 */

	//==================================================================================================================
