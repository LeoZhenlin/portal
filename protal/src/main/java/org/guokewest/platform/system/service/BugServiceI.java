package org.guokewest.platform.system.service;

import org.guokewest.platform.system.pageModel.Bug;
import org.guokewest.platform.system.pageModel.DataGrid;
import org.guokewest.platform.system.pageModel.PageHelper;

/**
 * 
 * @author Seven.Chen
 * 
 */
public interface BugServiceI {

	/**
	 * 获取BUG数据表格
	 * 
	 * @param bug
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Bug bug, PageHelper ph);

	/**
	 * 添加BUG
	 * 
	 * @param bug
	 */
	public void add(Bug bug);

	/**
	 * 获得BUG对象
	 * 
	 * @param id
	 * @return
	 */
	public Bug get(String id);

	/**
	 * 修改BUG
	 * 
	 * @param bug
	 */
	public void edit(Bug bug);

	/**
	 * 删除BUG
	 * 
	 * @param id
	 */
	public void delete(String id);

}
