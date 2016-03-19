package wx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import system.controller.BaseController;
import wx.service.WxService;
import wx.util.SignUtil;

@Controller
@RequestMapping({ "/wxController" })
public class WxController extends BaseController {
	@Resource
	private WxService wxService;

	@RequestMapping(value = { "/weixin" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			response.getWriter().write(echostr);
		}
	}

	@RequestMapping(value = { "/weixin" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String respMessage = this.wxService.processRequest(request);
		response.getWriter().write(respMessage);
	}
}
