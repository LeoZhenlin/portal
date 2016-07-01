package org.guokewest.wx.service;

import java.util.List;

import org.guokewest.wx.entity.Button;
import org.guokewest.wx.model.menu.database.WxButton;

public interface WxButtonService {
	public abstract List<Button> treeGrid();

	public abstract void add(WxButton paramWxButton);

	public abstract void delete(String paramString);

	public abstract void edit(WxButton paramWxButton);

	public abstract WxButton get(String paramString);

	public abstract List<WxButton> tree();
}