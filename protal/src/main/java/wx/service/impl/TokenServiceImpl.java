package wx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import wx.dao.TokenDao;
import wx.model.accessToken.Token;
import wx.service.TokenService;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {
	@Resource
	private TokenDao tokenDao;

	public List<Token> list() {
		List<Token> list = this.tokenDao.find("select t from Token t order by t.createtime desc");
		return list;
	}

	public void add(Token token) {
		this.tokenDao.save(token);
	}

	public void delete(String id) {
		Token token = (Token) this.tokenDao.get(Token.class, id);
		this.tokenDao.delete(token);
	}

	public Token get(String id) {
		Token token = (Token) this.tokenDao.get(Token.class, id);
		return token;
	}
}
