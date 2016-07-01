package org.guokewest.wx.service;

import javax.servlet.http.HttpServletRequest;

public interface WxService {
	public abstract String processRequest(HttpServletRequest request) ;
}