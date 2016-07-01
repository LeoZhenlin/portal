package org.guokewest.platform.system.service;

import java.util.List;

import org.guokewest.platform.system.pageModel.ResourceType;

/**
 * 资源类型服务
 * 
 * @author Seven.Chen
 * 
 */
public interface ResourceTypeServiceI {

	/**
	 * 获取资源类型
	 * 
	 * @return
	 */
	public List<ResourceType> getResourceTypeList();

}
