package wx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import wx.dao.WxButtonTypeDao;
import wx.model.menu.database.WxButtonType;
import wx.service.WxButtonTypeService;

@Service("wxButtonTypeService")
public class WxButtonTypeServiceImpl implements WxButtonTypeService {
	@Resource
	private WxButtonTypeDao wxButtonTypeDao;

	public List<WxButtonType> list() {
		List<WxButtonType> list = this.wxButtonTypeDao.find("select distinct t from WxButtonType t");
		return list;
	}

	public void add(WxButtonType WxButtonType) {
		this.wxButtonTypeDao.save(WxButtonType);
	}

	public void delete(String id) {
		WxButtonType wxButtonType = (WxButtonType) this.wxButtonTypeDao.get(WxButtonType.class, id);
		this.wxButtonTypeDao.delete(wxButtonType);
	}

	public void edit(WxButtonType wxButtonType) {
		this.wxButtonTypeDao.update(wxButtonType);
	}

	public WxButtonType get(String id) {
		WxButtonType wxButtonType = (WxButtonType) this.wxButtonTypeDao.get(WxButtonType.class, id);
		return wxButtonType;
	}
 }

