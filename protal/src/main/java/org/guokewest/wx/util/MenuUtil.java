package org.guokewest.wx.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.guokewest.platform.common.util.PropertiesUtils;
import org.guokewest.wx.model.accessToken.ReturnJsonMsg;
import org.guokewest.wx.model.accessToken.Token;
import org.guokewest.wx.model.menu.Button;
import org.guokewest.wx.model.menu.ClickButton;
import org.guokewest.wx.model.menu.ComplexButton;
import org.guokewest.wx.model.menu.Menu;
import org.guokewest.wx.model.menu.ViewButton;
import org.guokewest.wx.model.menu.database.WxButton;

import com.google.gson.Gson;

public class MenuUtil {
	public static boolean createMenu(List<WxButton> list) throws Exception {
		boolean flag = false;
		List<Button> menuButtons = new ArrayList<Button>();
		List<Button> sub_button = new ArrayList<Button>();
		for (WxButton button : list) {
			if ("click".equals(button.getButtonType().getTypeKey())) {
				ClickButton clickButton = new ClickButton();
				clickButton.setName(button.getName());
				clickButton.setType(button.getButtonType().getTypeKey());
				clickButton.setKey(button.getKey());
				menuButtons.add(clickButton);
			} else if ("view".equals(button.getButtonType().getTypeKey())) {
				ViewButton viewButton = new ViewButton();
				viewButton.setName(button.getName());
				viewButton.setType(button.getButtonType().getTypeKey());
				viewButton.setUrl(button.getUrl());
				menuButtons.add(viewButton);
			} else if ("complex".equals(button.getButtonType().getTypeKey())) {
				ComplexButton complexButton = new ComplexButton();
				complexButton.setName(button.getName());
				for (WxButton children : button.getChildren()) {
					if ("click".equals(children.getButtonType().getTypeKey())) {
						ClickButton clickButton = new ClickButton();
						clickButton.setName(children.getName());
						clickButton.setType(children.getButtonType().getTypeKey());
						clickButton.setKey(children.getKey());
						sub_button.add(clickButton);
					} else if ("view".equals(children.getButtonType().getTypeKey())) {
						ViewButton viewButton = new ViewButton();
						viewButton.setName(children.getName());
						viewButton.setType(children.getButtonType().getTypeKey());
						viewButton.setUrl(children.getUrl());
						sub_button.add(viewButton);
					}
				}

				complexButton.setSub_button(sub_button);
				menuButtons.add(complexButton);
			}
		}

		Menu menu = new Menu();
		menu.setButton(menuButtons);
		Gson gson = new Gson();
		String menuJson = gson.toJson(menu);
		Token token = CommonUtil.getAccessToken();
		Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
		String requestUrl = properties.getProperty("createMenuUrl");
		requestUrl = requestUrl + token.getAccess_token();
		String json = CommonUtil.httpsRequest(requestUrl, "POST", menuJson);
		ReturnJsonMsg msg = (ReturnJsonMsg) gson.fromJson(json, ReturnJsonMsg.class);
		if ("0".equals(msg.getErrcode())) {
			flag = true;
		}
		return flag;
	}

	public static boolean delMenu() throws Exception {
		boolean flag = false;
		Token token = CommonUtil.getAccessToken();
		Properties properties = PropertiesUtils.loadProperties(new String[] { "config.properties" });
		String requestUrl = properties.getProperty("deleteMenuUrl");
		requestUrl = requestUrl + token.getAccess_token();
		String json = CommonUtil.httpsRequest(requestUrl, "GET", null);
		Gson gson = new Gson();
		System.out.println(json);
		ReturnJsonMsg msg = (ReturnJsonMsg) gson.fromJson(json, ReturnJsonMsg.class);
		if ("0".equals(msg.getErrcode())) {
			flag = true;
		}
		return flag;
	}
}
