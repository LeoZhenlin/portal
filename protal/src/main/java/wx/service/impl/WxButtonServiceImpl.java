package wx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import wx.dao.WxButtonDao;
import wx.entity.Button;
import wx.model.menu.database.WxButton;
import wx.service.WxButtonService;

@Service("wxButtonService")
public class WxButtonServiceImpl implements WxButtonService {
	@Resource
	private WxButtonDao wxButtonDao;

	public List<Button> treeGrid() {
		List<WxButton> list = this.wxButtonDao
				.find("select distinct t from WxButton t join fetch t.buttonType type order by t.seq");

		List<Button> treeGrid = new ArrayList<Button>();
		if ((list != null) && (list.size() > 0)) {
			for (WxButton button : list) {
				Button b = new Button();
				BeanUtils.copyProperties(button, b);
				if (button.getParent() != null) {
					b.setPid(button.getParent().getId());
					b.setpName(button.getParent().getName());
				}
				b.setTypeId(button.getButtonType().getId());
				b.setTypeName(button.getButtonType().getName());
				treeGrid.add(b);
			}
		}
		return treeGrid;
	}

	public void add(WxButton wxButton) {
		this.wxButtonDao.save(wxButton);
	}

	public void delete(String id) {
		WxButton wxButton = (WxButton) this.wxButtonDao.get(WxButton.class, id);
		del(wxButton);
	}

	public void edit(WxButton wxButton) {
		this.wxButtonDao.update(wxButton);
	}

	public WxButton get(String id) {
		WxButton wxButton = (WxButton) this.wxButtonDao.get(WxButton.class, id);
		return wxButton;
	}

	private void del(WxButton button) {
		if ((button.getChildren() != null) && (button.getChildren().size() > 0)) {
			for (WxButton b : button.getChildren()) {
				del(b);
			}
		}
		this.wxButtonDao.delete(button);
	}

	public List<WxButton> tree() {
		List<WxButton> list = this.wxButtonDao.find(
				"select distinct t from WxButton t join fetch t.buttonType type where t.parent is null order by t.seq");
		return list;
	}
}
