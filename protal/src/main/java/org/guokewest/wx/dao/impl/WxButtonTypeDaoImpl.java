package org.guokewest.wx.dao.impl;

import org.guokewest.platform.system.dao.impl.BaseDaoImpl;
import org.guokewest.wx.dao.WxButtonTypeDao;
import org.guokewest.wx.model.menu.database.WxButtonType;
import org.springframework.stereotype.Repository;

@Repository("WxButtonTypeDao")
public class WxButtonTypeDaoImpl extends BaseDaoImpl<WxButtonType> implements WxButtonTypeDao {
}
