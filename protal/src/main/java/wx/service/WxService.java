package wx.service;

import javax.servlet.http.HttpServletRequest;

public abstract interface WxService {
	public abstract String processRequest(HttpServletRequest request) ;
}