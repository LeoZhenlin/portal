package org.guokewest.wx.service;

import java.util.List;

import org.guokewest.wx.model.menu.database.WxButtonType;

public interface WxButtonTypeService {
	public abstract List<WxButtonType> list();

	public abstract void add(WxButtonType paramWxButtonType);

	public abstract void delete(String paramString);

	public abstract void edit(WxButtonType paramWxButtonType);

	public abstract WxButtonType get(String paramString);
}