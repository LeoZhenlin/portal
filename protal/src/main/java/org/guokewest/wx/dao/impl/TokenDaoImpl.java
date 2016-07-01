package org.guokewest.wx.dao.impl;

import org.springframework.stereotype.Repository;

import org.guokewest.platform.system.dao.impl.BaseDaoImpl;
import org.guokewest.wx.dao.TokenDao;
import org.guokewest.wx.model.accessToken.Token;

@Repository("tokenDao")
public class TokenDaoImpl extends BaseDaoImpl<Token> implements TokenDao {
}
