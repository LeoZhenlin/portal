package wx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import system.pageModel.Json;
import wx.model.menu.database.WxButton;
import wx.service.WxButtonService;
import wx.util.MenuUtil;

@Controller
@RequestMapping({ "/menuController" })
public class MenuController extends system.controller.BaseController {
	@Resource
	private WxButtonService wxButtonService;

	@RequestMapping({ "/create" })
	@ResponseBody
	public Json create() throws Exception {
		List<WxButton> list = this.wxButtonService.tree();
		boolean flag = MenuUtil.createMenu(list);
		Json j = new Json();
		if (flag) {
			j.setSuccess(true);
			j.setMsg("创建成功！");
		} else {
			j.setSuccess(false);
			j.setMsg("创建失败！");
		}
		return j;
	}

	@RequestMapping({ "/delete" })
	@ResponseBody
	public Json delete() throws Exception {
		Json j = new Json();
		boolean flag = MenuUtil.delMenu();
		if (flag) {
			j.setSuccess(true);
			j.setMsg("删除成功！");
		} else {
			j.setSuccess(true);
			j.setMsg("删除失败！");
		}
		return j;
	}
}
