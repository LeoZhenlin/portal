package protal.wx;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.guokewest.platform.common.util.PropertiesUtils;
import org.guokewest.platform.system.model.Tuser;
import org.guokewest.platform.system.util.MD5Util;
import org.guokewest.wx.model.accessToken.Token;
import org.guokewest.wx.model.user.WxUser;
import org.guokewest.wx.util.CommonUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.google.gson.Gson;

public class TestGetUser {
	private static String tokenUrl;
	private static Token token;

	static {

		Properties properties = null;
		try {
			properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
		} catch (IOException e) {
			e.printStackTrace();
		}
		tokenUrl = properties.getProperty("tokenUrl");
		String result = CommonUtil.httpsRequest(tokenUrl, "GET", null);
		Gson gson = new Gson();
		token = (Token) gson.fromJson(result, Token.class);
	}

	@Test
	public void getUsers() throws Exception {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replaceAll("ACCESS_TOKEN", token.getAccess_token());
		String json = CommonUtil.httpsRequest(requestUrl, "GET", null);
		System.out.println(json);
	}

	@Test
	public void getUser() throws Exception {
		Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
		String requestUrl = properties.getProperty("wxUserInfoUrl");
		requestUrl = requestUrl.replaceAll("ACCESS_TOKEN", token.getAccess_token());
		requestUrl = requestUrl.replaceAll("OPENID", "op7PFvvbR6JdtTj8iF_1ZR80pCak");
		String result = CommonUtil.httpsRequest(requestUrl, "GET", null);
		Gson gson = new Gson();
		WxUser wxUser = gson.fromJson(result, WxUser.class);
		Tuser user = new Tuser();
		BeanUtils.copyProperties(wxUser, user);
		user.setId("op7PFvvbR6JdtTj8iF_1ZR80pCak");
		user.setName(wxUser.getNickname());
		user.setPwd(MD5Util.md5("123456"));
		user.setCreatedatetime(new Date());
		String params = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": "+user.getId()+"}}}";
		//user.setQrTicket(QrcodeUtil.getQrTicken(params));
		System.out.println(user);
	}
}
