package org.guokewest.wx.dao.impl;

import org.guokewest.platform.system.dao.impl.BaseDaoImpl;
import org.guokewest.wx.dao.WxButtonDao;
import org.guokewest.wx.model.menu.database.WxButton;
import org.springframework.stereotype.Repository;

@Repository("WxButtonDao")
public class WxButtonDaoImpl extends BaseDaoImpl<WxButton> implements WxButtonDao {
}
