package wx.util;

import java.util.Properties;

import com.google.gson.Gson;

import common.util.PropertiesUtils;
import wx.model.accessToken.Token;
import wx.model.user.WxUser;

public class UserUtil {
	public static WxUser getUser(String openid) throws Exception {
		Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
		String requestUrl = properties.getProperty("wxUserInfoUrl");
		Token token = CommonUtil.getAccessToken();
		requestUrl = requestUrl.replaceAll("ACCESS_TOKEN", token.getAccess_token());
		requestUrl = requestUrl.replaceAll("OPENID", openid);
		String result = CommonUtil.httpsRequest(requestUrl, "GET", null);
		Gson gson = new Gson();
		return (WxUser) gson.fromJson(result, WxUser.class);
	}
}
