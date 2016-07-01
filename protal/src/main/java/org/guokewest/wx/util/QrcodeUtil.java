package org.guokewest.wx.util;

import com.google.gson.Gson;

import org.guokewest.wx.model.accessToken.Token;
import org.guokewest.wx.model.qrcode.TicketInfo;

public class QrcodeUtil {
	public static String getQrTicken(String params) throws Exception {
		String requestUrl = " https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
		Token token = CommonUtil.getAccessToken();
		requestUrl = requestUrl.replace("TOKEN", token.getAccess_token());
		String responeStr = CommonUtil.httpsRequest(requestUrl, "POST", params);
		Gson gson = new Gson();
		TicketInfo ticketInfo = (TicketInfo) gson.fromJson(responeStr, TicketInfo.class);
		return ticketInfo.getTicket();
	}
   
}