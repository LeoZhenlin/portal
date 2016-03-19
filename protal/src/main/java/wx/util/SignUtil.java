package wx.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;

import common.util.PropertiesUtils;

public class SignUtil {
	private static String token = "";

	static {
		Properties properties = null;
		try {
			properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
			token = properties.getProperty("token");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		boolean flag = false;
		String[] arr = { token, timestamp, nonce };
		Arrays.sort(arr);
		String str = arr[0].concat(arr[1]).concat(arr[2]);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] digest = md.digest(str.getBytes());
		String tmpStr = byte2str(digest);
		if ((tmpStr != null) && (tmpStr.equals(signature))) {
			flag = true;
		}
		return flag;
	}

	public static String byte2str(byte[] array) {
		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < array.length; i++) {
			shaHex = Integer.toHexString(array[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		return hexstr.toString();
	}
}
