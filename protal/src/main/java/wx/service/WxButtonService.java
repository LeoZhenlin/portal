package wx.service;

import java.util.List;

import wx.entity.Button;
import wx.model.menu.database.WxButton;

public abstract interface WxButtonService {
	public abstract List<Button> treeGrid();

	public abstract void add(WxButton paramWxButton);

	public abstract void delete(String paramString);

	public abstract void edit(WxButton paramWxButton);

	public abstract WxButton get(String paramString);

	public abstract List<WxButton> tree();
}