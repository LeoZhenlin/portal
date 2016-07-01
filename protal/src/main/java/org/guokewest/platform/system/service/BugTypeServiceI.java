package org.guokewest.platform.system.service;

import java.util.List;

import org.guokewest.platform.system.model.Tbugtype;

/**
 * 
 * @author Seven.Chen
 * 
 */
public interface BugTypeServiceI {

	/**
	 * 获得BUG类型列表
	 * 
	 * @return
	 */
	public List<Tbugtype> getBugTypeList();

}
