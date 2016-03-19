package wx.dao.impl;

import org.springframework.stereotype.Repository;

import system.dao.impl.BaseDaoImpl;
import wx.dao.TokenDao;
import wx.model.accessToken.Token;

@Repository("tokenDao")
public class TokenDaoImpl extends BaseDaoImpl<Token> implements TokenDao {
}
