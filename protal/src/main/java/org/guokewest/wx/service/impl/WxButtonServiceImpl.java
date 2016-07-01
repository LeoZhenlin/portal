package org.guokewest.wx.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.guokewest.wx.dao.WxButtonDao;
import org.guokewest.wx.entity.Button;
import org.guokewest.wx.model.menu.database.WxButton;
import org.guokewest.wx.service.WxButtonService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



@Service("wxButtonService")
public class WxButtonServiceImpl implements WxButtonService {
	@Resource
	private WxButtonDao WxButtonDao;

	public List<Button> treeGrid() {
		List<WxButton> list = this.WxButtonDao
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

	public void add(WxButton WxButton) {
		this.WxButtonDao.save(WxButton);
	}

	public void delete(String id) {
		WxButton WxButton = (WxButton) this.WxButtonDao.get(WxButton.class, id);
		del(WxButton);
	}

	public void edit(WxButton WxButton) {
		this.WxButtonDao.update(WxButton);
	}

	public WxButton get(String id) {
		WxButton WxButton = (WxButton) this.WxButtonDao.get(WxButton.class, id);
		return WxButton;
	}

	private void del(WxButton button) {
		if ((button.getChildren() != null) && (button.getChildren().size() > 0)) {
			for (WxButton b : button.getChildren()) {
				del(b);
			}
		}
		this.WxButtonDao.delete(button);
	}

	public List<WxButton> tree() {
		List<WxButton> list = this.WxButtonDao.find(
				"select distinct t from WxButton t join fetch t.buttonType type where t.parent is null order by t.seq");
		return list;
	}
}
