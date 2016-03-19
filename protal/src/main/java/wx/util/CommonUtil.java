package wx.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.google.gson.Gson;

import common.util.PropertiesUtils;
import common.util.random.RandomGUIDUtil;
import common.util.spring.SpringContextHolder;
import wx.httpsManger.MyX509TrustManager;
import wx.model.accessToken.Token;
import wx.service.TokenService;

public class CommonUtil {
	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = { new MyX509TrustManager() };

			sslContext.init(null, tm, new SecureRandom());

			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			conn.setSSLSocketFactory(ssf);

			conn.setRequestMethod(requestMethod);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.connect();

			if ((outputStr != null) && (!"".equals(outputStr))) {
				OutputStream out = conn.getOutputStream();
				out.write(outputStr.getBytes("UTF-8"));
				out.close();
			}

			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}

			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static InputStream httpsRequest(String requestUrl, String requestMethod) {
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = { new MyX509TrustManager() };

			sslContext.init(null, tm, new SecureRandom());

			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			conn.setSSLSocketFactory(ssf);

			conn.setRequestMethod(requestMethod);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.connect();

			return conn.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Token getAccessToken() throws Exception {
		TokenService tokenService = (TokenService) SpringContextHolder.getBean(TokenService.class);
		List<Token> list = tokenService.list();
		Token token = null;
		if ((list != null) && (list.size() > 0)) {
			Token dbToken = (Token) list.get(0);
			Long expires_in = Long.valueOf((new Date().getTime() - dbToken.getCreatetime().getTime()) / 1000L);

			if (expires_in.longValue() > Long.parseLong(dbToken.getExpires_in())) {
				Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
				String requestUrl = properties.getProperty("tokenUrl");
				String result = httpsRequest(requestUrl, "GET", null);
				Gson gson = new Gson();
				token = (Token) gson.fromJson(result, Token.class);
				token.setId(RandomGUIDUtil.generateKey());
				token.setCreatetime(new Timestamp(new Date().getTime()));

				tokenService.add(token);
			} else {
				token = dbToken;
			}
		} else {
			Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
			String requestUrl = properties.getProperty("tokenUrl");
			String result = httpsRequest(requestUrl, "GET", null);
			Gson gson = new Gson();
			token = (Token) gson.fromJson(result, Token.class);
			token.setId(RandomGUIDUtil.generateKey());
			token.setCreatetime(new Timestamp(new Date().getTime()));

			tokenService.add(token);
		}
		return token;
	}
}
