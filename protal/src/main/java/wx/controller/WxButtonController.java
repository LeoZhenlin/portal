package wx.controller;

import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import system.controller.BaseController;
import system.pageModel.Json;
import wx.entity.Button;
import wx.model.menu.database.WxButton;
import wx.service.WxButtonService;
import wx.service.WxButtonTypeService;

@Controller
@RequestMapping({ "/wxbuttonController" })
public class WxButtonController extends BaseController {
	@Resource
	private WxButtonService wxButtonService;
	@Resource
	private WxButtonTypeService wxButtonTypeService;

	@RequestMapping({ "/manager" })
	public String manager() {
		return "/wx/wxbuttonManager";
	}

	@RequestMapping({ "/addPage" })
	public String addPage(HttpServletRequest request) {
		request.setAttribute("typeList", this.wxButtonTypeService.list());
		request.setAttribute("parentList", this.wxButtonService.tree());
		return "/wx/wxButtonAdd";
	}

	@RequestMapping({ "/add" })
	@ResponseBody
	public Json add(WxButton wxButton) throws Exception {
		wxButton.setId(UUID.randomUUID().toString());
		if ((wxButton.getParent().getId() == null) || ("".equals(wxButton.getParent().getId()))) {
			wxButton.setParent(null);
		}
		this.wxButtonService.add(wxButton);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("添加成功！");
		return j;
	}

	@RequestMapping({ "/editPage" })
	public String editPage(HttpServletRequest request, String id) {
		request.setAttribute("typeList", this.wxButtonTypeService.list());
		request.setAttribute("parentList", this.wxButtonService.tree());
		WxButton wxButton = this.wxButtonService.get(id);
		request.setAttribute("wxButton", wxButton);
		return "/wx/wxButtonEdit";
	}

	@RequestMapping({ "/edit" })
	@ResponseBody
	public Json edit(WxButton wxButton) {
		Json j = new Json();
		if ((wxButton.getParent().getId() == null) || ("".equals(wxButton.getParent().getId()))) {
			wxButton.setParent(null);
		}
		this.wxButtonService.edit(wxButton);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	@RequestMapping({ "/treeGrid" })
	@ResponseBody
	public List<Button> treeGrid() {
		List<Button> treeGrid = this.wxButtonService.treeGrid();
		return treeGrid;
	}

	@RequestMapping({ "/delete" })
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		this.wxButtonService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}
}
