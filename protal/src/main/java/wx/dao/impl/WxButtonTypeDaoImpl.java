package wx.dao.impl;

import org.springframework.stereotype.Repository;

import system.dao.impl.BaseDaoImpl;
import wx.dao.WxButtonTypeDao;
import wx.model.menu.database.WxButtonType;

@Repository("wxButtonTypeDao")
public class WxButtonTypeDaoImpl extends BaseDaoImpl<WxButtonType> implements WxButtonTypeDao {
}
