package wx.dao.impl;

import org.springframework.stereotype.Repository;

import system.dao.impl.BaseDaoImpl;
import wx.dao.WxButtonDao;
import wx.model.menu.database.WxButton;

@Repository("wxButtonDao")
public class WxButtonDaoImpl extends BaseDaoImpl<WxButton> implements WxButtonDao {
}
