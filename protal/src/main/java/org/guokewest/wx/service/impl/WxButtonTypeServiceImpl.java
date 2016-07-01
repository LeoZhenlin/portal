package org.guokewest.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.guokewest.wx.dao.WxButtonTypeDao;
import org.guokewest.wx.model.menu.database.WxButtonType;
import org.guokewest.wx.service.WxButtonTypeService;
import org.springframework.stereotype.Service;

@Service("WxButtonTypeService")
public class WxButtonTypeServiceImpl implements WxButtonTypeService {
	@Resource
	private WxButtonTypeDao WxButtonTypeDao;

	public List<WxButtonType> list() {
		List<WxButtonType> list = this.WxButtonTypeDao.find("select distinct t from WxButtonType t");
		return list;
	}

	public void add(WxButtonType WxButtonType) {
		this.WxButtonTypeDao.save(WxButtonType);
	}

	public void delete(String id) {
		WxButtonType WxButtonType = (WxButtonType) this.WxButtonTypeDao.get(WxButtonType.class, id);
		this.WxButtonTypeDao.delete(WxButtonType);
	}

	public void edit(WxButtonType WxButtonType) {
		this.WxButtonTypeDao.update(WxButtonType);
	}

	public WxButtonType get(String id) {
		WxButtonType WxButtonType = (WxButtonType) this.WxButtonTypeDao.get(WxButtonType.class, id);
		return WxButtonType;
	}
 }

