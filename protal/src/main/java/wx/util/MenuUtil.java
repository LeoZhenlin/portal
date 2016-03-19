package wx.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;

import common.util.PropertiesUtils;
import wx.model.accessToken.ReturnJsonMsg;
import wx.model.accessToken.Token;
import wx.model.menu.Button;
import wx.model.menu.ClickButton;
import wx.model.menu.ComplexButton;
import wx.model.menu.Menu;
import wx.model.menu.ViewButton;
import wx.model.menu.database.WxButton;

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
