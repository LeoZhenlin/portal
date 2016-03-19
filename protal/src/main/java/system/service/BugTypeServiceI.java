package system.service;

import java.util.List;

import system.model.Tbugtype;

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
