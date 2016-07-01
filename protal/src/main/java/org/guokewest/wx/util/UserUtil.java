package org.guokewest.wx.util;

import java.util.Properties;

import org.guokewest.platform.common.util.PropertiesUtils;
import org.guokewest.wx.model.accessToken.Token;
import org.guokewest.wx.model.user.WxUser;

import com.google.gson.Gson;

public class UserUtil {
	public static WxUser getUser(String openid) throws Exception {
		Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
		String requestUrl = properties.getProperty("WxUserInfoUrl");
		Token token = CommonUtil.getAccessToken();
		requestUrl = requestUrl.replaceAll("ACCESS_TOKEN", token.getAccess_token());
		requestUrl = requestUrl.replaceAll("OPENID", openid);
		String result = CommonUtil.httpsRequest(requestUrl, "GET", null);
		Gson gson = new Gson();
		return (WxUser) gson.fromJson(result, WxUser.class);
	}
}
