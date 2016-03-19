package wx.service;

import java.util.List;
import wx.model.accessToken.Token;

public abstract interface TokenService {
	public abstract void add(Token paramToken);

	public abstract void delete(String paramString);

	public abstract Token get(String paramString);

	public abstract List<Token> list();
}