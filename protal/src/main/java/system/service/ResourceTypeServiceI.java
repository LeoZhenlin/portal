package system.service;

import java.util.List;

import system.pageModel.ResourceType;

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