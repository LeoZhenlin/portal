package system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.dao.BugDaoI;
import system.dao.BugTypeDaoI;
import system.dao.ResourceDaoI;
import system.dao.ResourceTypeDaoI;
import system.dao.RoleDaoI;
import system.dao.UserDaoI;
import system.model.Tbugtype;
import system.model.Tresource;
import system.model.Tresourcetype;
import system.model.Trole;
import system.model.Tuser;
import system.service.InitServiceI;
import system.util.MD5Util;
import wx.dao.WxButtonTypeDao;
import wx.model.menu.database.WxButtonType;

@Service
public class InitServiceImpl implements InitServiceI {
	@Autowired
	private UserDaoI userDao;
	@Autowired
	private RoleDaoI roleDao;
	@Autowired
	private ResourceDaoI resourceDao;
	@Autowired
	private ResourceTypeDaoI resourceTypeDao;
	@Autowired
	private BugDaoI bugDao;
	@Autowired
	private BugTypeDaoI bugTypeDao;
	@Autowired
	private WxButtonTypeDao wxButtonTypeDao;

	public synchronized void init() {
		initBugType();

		initResourceType();

		initResource();

		initRole();

		initUser();
		
		initWxButton();
	}

	private void initBugType() {
		Tbugtype cw = new Tbugtype();
		cw.setId("0");
		cw.setName("错误");
		this.bugTypeDao.saveOrUpdate(cw);

		Tbugtype gn = new Tbugtype();
		gn.setId("1");
		gn.setName("功能");
		this.bugTypeDao.saveOrUpdate(gn);
	}

	private void initResource() {
		Tresourcetype menuType = (Tresourcetype) this.resourceTypeDao.get(Tresourcetype.class, "0");
		Tresourcetype funType = (Tresourcetype) this.resourceTypeDao.get(Tresourcetype.class, "1");

		Tresource xtgl = new Tresource();
		xtgl.setId("xtgl");
		xtgl.setName("系统管理");
		xtgl.setTresourcetype(menuType);
		xtgl.setSeq(Integer.valueOf(0));
		xtgl.setIcon("plugin");
		this.resourceDao.saveOrUpdate(xtgl);

		Tresource zygl = new Tresource();
		zygl.setId("zygl");
		zygl.setName("资源管理");
		zygl.setTresourcetype(menuType);
		zygl.setTresource(xtgl);
		zygl.setSeq(Integer.valueOf(1));
		zygl.setUrl("/resourceController/manager");
		zygl.setIcon("database_gear");
		zygl.setRemark("管理系统中所有的菜单或功能");
		this.resourceDao.saveOrUpdate(zygl);

		Tresource zyglTreeGrid = new Tresource();
		zyglTreeGrid.setId("zyglTreeGrid");
		zyglTreeGrid.setName("资源表格");
		zyglTreeGrid.setTresourcetype(funType);
		zyglTreeGrid.setTresource(zygl);
		zyglTreeGrid.setSeq(Integer.valueOf(1));
		zyglTreeGrid.setUrl("/resourceController/treeGrid");
		zyglTreeGrid.setIcon("wrench");
		zyglTreeGrid.setRemark("显示资源列表");
		this.resourceDao.saveOrUpdate(zyglTreeGrid);

		Tresource zyglMenu = new Tresource();
		zyglMenu.setId("zyglMenu");
		zyglMenu.setName("功能菜单");
		zyglMenu.setTresourcetype(funType);
		zyglMenu.setTresource(zygl);
		zyglMenu.setSeq(Integer.valueOf(2));
		zyglMenu.setUrl("/resourceController/tree");
		zyglMenu.setIcon("wrench");
		this.resourceDao.saveOrUpdate(zyglMenu);

		Tresource zyglAddPage = new Tresource();
		zyglAddPage.setId("zyglAddPage");
		zyglAddPage.setName("添加资源页面");
		zyglAddPage.setTresourcetype(funType);
		zyglAddPage.setTresource(zygl);
		zyglAddPage.setSeq(Integer.valueOf(3));
		zyglAddPage.setUrl("/resourceController/addPage");
		zyglAddPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(zyglAddPage);

		Tresource zyglAdd = new Tresource();
		zyglAdd.setId("zyglAdd");
		zyglAdd.setName("添加资源");
		zyglAdd.setTresourcetype(funType);
		zyglAdd.setTresource(zygl);
		zyglAdd.setSeq(Integer.valueOf(4));
		zyglAdd.setUrl("/resourceController/add");
		zyglAdd.setIcon("wrench");
		this.resourceDao.saveOrUpdate(zyglAdd);

		Tresource zyglEditPage = new Tresource();
		zyglEditPage.setId("zyglEditPage");
		zyglEditPage.setName("编辑资源页面");
		zyglEditPage.setTresourcetype(funType);
		zyglEditPage.setTresource(zygl);
		zyglEditPage.setSeq(Integer.valueOf(5));
		zyglEditPage.setUrl("/resourceController/editPage");
		zyglEditPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(zyglEditPage);

		Tresource zyglEdit = new Tresource();
		zyglEdit.setId("zyglEdit");
		zyglEdit.setName("编辑资源");
		zyglEdit.setTresourcetype(funType);
		zyglEdit.setTresource(zygl);
		zyglEdit.setSeq(Integer.valueOf(6));
		zyglEdit.setUrl("/resourceController/edit");
		zyglEdit.setIcon("wrench");
		this.resourceDao.saveOrUpdate(zyglEdit);

		Tresource zyglDelete = new Tresource();
		zyglDelete.setId("zyglDelete");
		zyglDelete.setName("删除资源");
		zyglDelete.setTresourcetype(funType);
		zyglDelete.setTresource(zygl);
		zyglDelete.setSeq(Integer.valueOf(7));
		zyglDelete.setUrl("/resourceController/delete");
		zyglDelete.setIcon("wrench");
		this.resourceDao.saveOrUpdate(zyglDelete);

		Tresource jsgl = new Tresource();
		jsgl.setId("jsgl");
		jsgl.setName("角色管理");
		jsgl.setTresourcetype(menuType);
		jsgl.setTresource(xtgl);
		jsgl.setSeq(Integer.valueOf(2));
		jsgl.setUrl("/roleController/manager");
		jsgl.setIcon("tux");
		this.resourceDao.saveOrUpdate(jsgl);

		Tresource jsglTreeGrid = new Tresource();
		jsglTreeGrid.setId("jsglTreeGrid");
		jsglTreeGrid.setName("角色表格");
		jsglTreeGrid.setTresourcetype(funType);
		jsglTreeGrid.setTresource(jsgl);
		jsglTreeGrid.setSeq(Integer.valueOf(1));
		jsglTreeGrid.setUrl("/roleController/treeGrid");
		jsglTreeGrid.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglTreeGrid);

		Tresource jsglAddPage = new Tresource();
		jsglAddPage.setId("jsglAddPage");
		jsglAddPage.setName("添加角色页面");
		jsglAddPage.setTresourcetype(funType);
		jsglAddPage.setTresource(jsgl);
		jsglAddPage.setSeq(Integer.valueOf(2));
		jsglAddPage.setUrl("/roleController/addPage");
		jsglAddPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglAddPage);

		Tresource jsglAdd = new Tresource();
		jsglAdd.setId("jsglAdd");
		jsglAdd.setName("添加角色");
		jsglAdd.setTresourcetype(funType);
		jsglAdd.setTresource(jsgl);
		jsglAdd.setSeq(Integer.valueOf(3));
		jsglAdd.setUrl("/roleController/add");
		jsglAdd.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglAdd);

		Tresource jsglEditPage = new Tresource();
		jsglEditPage.setId("jsglEditPage");
		jsglEditPage.setName("编辑角色页面");
		jsglEditPage.setTresourcetype(funType);
		jsglEditPage.setTresource(jsgl);
		jsglEditPage.setSeq(Integer.valueOf(4));
		jsglEditPage.setUrl("/roleController/editPage");
		jsglEditPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglEditPage);

		Tresource jsglEdit = new Tresource();
		jsglEdit.setId("jsglEdit");
		jsglEdit.setName("编辑角色");
		jsglEdit.setTresourcetype(funType);
		jsglEdit.setTresource(jsgl);
		jsglEdit.setSeq(Integer.valueOf(5));
		jsglEdit.setUrl("/roleController/edit");
		jsglEdit.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglEdit);

		Tresource jsglDelete = new Tresource();
		jsglDelete.setId("jsglDelete");
		jsglDelete.setName("删除角色");
		jsglDelete.setTresourcetype(funType);
		jsglDelete.setTresource(jsgl);
		jsglDelete.setSeq(Integer.valueOf(6));
		jsglDelete.setUrl("/roleController/delete");
		jsglDelete.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglDelete);

		Tresource jsglGrantPage = new Tresource();
		jsglGrantPage.setId("jsglGrantPage");
		jsglGrantPage.setName("角色授权页面");
		jsglGrantPage.setTresourcetype(funType);
		jsglGrantPage.setTresource(jsgl);
		jsglGrantPage.setSeq(Integer.valueOf(7));
		jsglGrantPage.setUrl("/roleController/grantPage");
		jsglGrantPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglGrantPage);

		Tresource jsglGrant = new Tresource();
		jsglGrant.setId("jsglGrant");
		jsglGrant.setName("角色授权");
		jsglGrant.setTresourcetype(funType);
		jsglGrant.setTresource(jsgl);
		jsglGrant.setSeq(Integer.valueOf(8));
		jsglGrant.setUrl("/roleController/grant");
		jsglGrant.setIcon("wrench");
		this.resourceDao.saveOrUpdate(jsglGrant);

		Tresource yhgl = new Tresource();
		yhgl.setId("yhgl");
		yhgl.setName("用户管理");
		yhgl.setTresourcetype(menuType);
		yhgl.setTresource(xtgl);
		yhgl.setSeq(Integer.valueOf(3));
		yhgl.setUrl("/userController/manager");
		yhgl.setIcon("status_online");
		this.resourceDao.saveOrUpdate(yhgl);

		Tresource yhglDateGrid = new Tresource();
		yhglDateGrid.setId("yhglDateGrid");
		yhglDateGrid.setName("用户表格");
		yhglDateGrid.setTresourcetype(funType);
		yhglDateGrid.setTresource(yhgl);
		yhglDateGrid.setSeq(Integer.valueOf(1));
		yhglDateGrid.setUrl("/userController/dataGrid");
		yhglDateGrid.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglDateGrid);

		Tresource yhglAddPage = new Tresource();
		yhglAddPage.setId("yhglAddPage");
		yhglAddPage.setName("添加用户页面");
		yhglAddPage.setTresourcetype(funType);
		yhglAddPage.setTresource(yhgl);
		yhglAddPage.setSeq(Integer.valueOf(2));
		yhglAddPage.setUrl("/userController/addPage");
		yhglAddPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglAddPage);

		Tresource yhglAdd = new Tresource();
		yhglAdd.setId("yhglAdd");
		yhglAdd.setName("添加用户");
		yhglAdd.setTresourcetype(funType);
		yhglAdd.setTresource(yhgl);
		yhglAdd.setSeq(Integer.valueOf(3));
		yhglAdd.setUrl("/userController/add");
		yhglAdd.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglAdd);

		Tresource yhglEditPage = new Tresource();
		yhglEditPage.setId("yhglEditPage");
		yhglEditPage.setName("编辑用户页面");
		yhglEditPage.setTresourcetype(funType);
		yhglEditPage.setTresource(yhgl);
		yhglEditPage.setSeq(Integer.valueOf(4));
		yhglEditPage.setUrl("/userController/editPage");
		yhglEditPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglEditPage);

		Tresource yhglEdit = new Tresource();
		yhglEdit.setId("yhglEdit");
		yhglEdit.setName("编辑用户");
		yhglEdit.setTresourcetype(funType);
		yhglEdit.setTresource(yhgl);
		yhglEdit.setSeq(Integer.valueOf(5));
		yhglEdit.setUrl("/userController/edit");
		yhglEdit.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglEdit);

		Tresource yhglDelete = new Tresource();
		yhglDelete.setId("yhglDelete");
		yhglDelete.setName("删除用户");
		yhglDelete.setTresourcetype(funType);
		yhglDelete.setTresource(yhgl);
		yhglDelete.setSeq(Integer.valueOf(6));
		yhglDelete.setUrl("/userController/delete");
		yhglDelete.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglDelete);

		Tresource yhglBatchDelete = new Tresource();
		yhglBatchDelete.setId("yhglBatchDelete");
		yhglBatchDelete.setName("批量删除用户");
		yhglBatchDelete.setTresourcetype(funType);
		yhglBatchDelete.setTresource(yhgl);
		yhglBatchDelete.setSeq(Integer.valueOf(7));
		yhglBatchDelete.setUrl("/userController/batchDelete");
		yhglBatchDelete.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglBatchDelete);

		Tresource yhglGrantPage = new Tresource();
		yhglGrantPage.setId("yhglGrantPage");
		yhglGrantPage.setName("用户授权页面");
		yhglGrantPage.setTresourcetype(funType);
		yhglGrantPage.setTresource(yhgl);
		yhglGrantPage.setSeq(Integer.valueOf(8));
		yhglGrantPage.setUrl("/userController/grantPage");
		yhglGrantPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglGrantPage);

		Tresource yhglGrant = new Tresource();
		yhglGrant.setId("yhglGrant");
		yhglGrant.setName("用户授权");
		yhglGrant.setTresourcetype(funType);
		yhglGrant.setTresource(yhgl);
		yhglGrant.setSeq(Integer.valueOf(9));
		yhglGrant.setUrl("/userController/grant");
		yhglGrant.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglGrant);

		Tresource yhglEditPwdPage = new Tresource();
		yhglEditPwdPage.setId("yhglEditPwdPage");
		yhglEditPwdPage.setName("用户修改密码页面");
		yhglEditPwdPage.setTresourcetype(funType);
		yhglEditPwdPage.setTresource(yhgl);
		yhglEditPwdPage.setSeq(Integer.valueOf(10));
		yhglEditPwdPage.setUrl("/userController/editPwdPage");
		yhglEditPwdPage.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglEditPwdPage);

		Tresource yhglEditPwd = new Tresource();
		yhglEditPwd.setId("yhglEditPwd");
		yhglEditPwd.setName("用户修改密码");
		yhglEditPwd.setTresourcetype(funType);
		yhglEditPwd.setTresource(yhgl);
		yhglEditPwd.setSeq(Integer.valueOf(11));
		yhglEditPwd.setUrl("/userController/editPwd");
		yhglEditPwd.setIcon("wrench");
		this.resourceDao.saveOrUpdate(yhglEditPwd);

		Tresource buggl = new Tresource();
		buggl.setId("buggl");
		buggl.setName("BUG管理");
		buggl.setTresourcetype(menuType);
		buggl.setTresource(xtgl);
		buggl.setSeq(Integer.valueOf(4));
		buggl.setUrl("/bugController/manager");
		buggl.setIcon("bug");
		this.resourceDao.saveOrUpdate(buggl);

		Tresource bugglDateGrid = new Tresource();
		bugglDateGrid.setId("bugglDateGrid");
		bugglDateGrid.setName("BUG表格");
		bugglDateGrid.setTresourcetype(funType);
		bugglDateGrid.setTresource(buggl);
		bugglDateGrid.setSeq(Integer.valueOf(1));
		bugglDateGrid.setUrl("/bugController/dataGrid");
		bugglDateGrid.setIcon("bug_link");
		this.resourceDao.saveOrUpdate(bugglDateGrid);

		Tresource bugglAddPage = new Tresource();
		bugglAddPage.setId("bugglAddPage");
		bugglAddPage.setName("添加BUG页面");
		bugglAddPage.setTresourcetype(funType);
		bugglAddPage.setTresource(buggl);
		bugglAddPage.setSeq(Integer.valueOf(2));
		bugglAddPage.setUrl("/bugController/addPage");
		bugglAddPage.setIcon("bug_add");
		this.resourceDao.saveOrUpdate(bugglAddPage);

		Tresource bugglAdd = new Tresource();
		bugglAdd.setId("bugglAdd");
		bugglAdd.setName("添加BUG");
		bugglAdd.setTresourcetype(funType);
		bugglAdd.setTresource(buggl);
		bugglAdd.setSeq(Integer.valueOf(3));
		bugglAdd.setUrl("/bugController/add");
		bugglAdd.setIcon("bug_add");
		this.resourceDao.saveOrUpdate(bugglAdd);

		Tresource bugglEditPage = new Tresource();
		bugglEditPage.setId("bugglEditPage");
		bugglEditPage.setName("编辑BUG页面");
		bugglEditPage.setTresourcetype(funType);
		bugglEditPage.setTresource(buggl);
		bugglEditPage.setSeq(Integer.valueOf(4));
		bugglEditPage.setUrl("/bugController/editPage");
		bugglEditPage.setIcon("bug_edit");
		this.resourceDao.saveOrUpdate(bugglEditPage);

		Tresource bugglEdit = new Tresource();
		bugglEdit.setId("bugglEdit");
		bugglEdit.setName("编辑BUG");
		bugglEdit.setTresourcetype(funType);
		bugglEdit.setTresource(buggl);
		bugglEdit.setSeq(Integer.valueOf(5));
		bugglEdit.setUrl("/bugController/edit");
		bugglEdit.setIcon("bug_edit");
		this.resourceDao.saveOrUpdate(bugglEdit);

		Tresource bugglDelete = new Tresource();
		bugglDelete.setId("bugglDelete");
		bugglDelete.setName("删除BUG");
		bugglDelete.setTresourcetype(funType);
		bugglDelete.setTresource(buggl);
		bugglDelete.setSeq(Integer.valueOf(6));
		bugglDelete.setUrl("/bugController/delete");
		bugglDelete.setIcon("bug_delete");
		this.resourceDao.saveOrUpdate(bugglDelete);

		Tresource bugglView = new Tresource();
		bugglView.setId("bugglView");
		bugglView.setName("查看BUG");
		bugglView.setTresourcetype(funType);
		bugglView.setTresource(buggl);
		bugglView.setSeq(Integer.valueOf(7));
		bugglView.setUrl("/bugController/view");
		bugglView.setIcon("bug_link");
		this.resourceDao.saveOrUpdate(bugglView);

		Tresource sjygl = new Tresource();
		sjygl.setId("sjygl");
		sjygl.setName("数据源管理");
		sjygl.setTresourcetype(menuType);
		sjygl.setTresource(xtgl);
		sjygl.setSeq(Integer.valueOf(5));
		sjygl.setUrl("/druidController/druid");
		sjygl.setIcon("server_database");
		this.resourceDao.saveOrUpdate(sjygl);

		Tresource wjgl = new Tresource();
		wjgl.setId("wjgl");
		wjgl.setName("文件管理");
		wjgl.setTresourcetype(funType);
		wjgl.setTresource(xtgl);
		wjgl.setSeq(Integer.valueOf(6));
		wjgl.setUrl("");
		wjgl.setIcon("server_database");
		this.resourceDao.saveOrUpdate(wjgl);

		Tresource wjglView = new Tresource();
		wjglView.setId("wjglView");
		wjglView.setName("浏览服务器文件");
		wjglView.setTresourcetype(funType);
		wjglView.setTresource(wjgl);
		wjglView.setSeq(Integer.valueOf(1));
		wjglView.setUrl("/fileController/fileManage");
		wjglView.setIcon("server_database");
		this.resourceDao.saveOrUpdate(wjglView);

		Tresource wjglUpload = new Tresource();
		wjglUpload.setId("wjglUpload");
		wjglUpload.setName("上传文件");
		wjglUpload.setTresourcetype(funType);
		wjglUpload.setTresource(wjgl);
		wjglUpload.setSeq(Integer.valueOf(2));
		wjglUpload.setUrl("/fileController/upload");
		wjglUpload.setIcon("server_database");
		this.resourceDao.saveOrUpdate(wjglUpload);

		Tresource chart = new Tresource();
		chart.setId("chart");
		chart.setName("图表管理");
		chart.setTresourcetype(menuType);
		chart.setSeq(Integer.valueOf(7));
		chart.setIcon("chart_bar");
		this.resourceDao.saveOrUpdate(chart);

		Tresource userCreateDatetimeChart = new Tresource();
		userCreateDatetimeChart.setId("userCreateDatetimeChart");
		userCreateDatetimeChart.setName("用户图表");
		userCreateDatetimeChart.setTresourcetype(menuType);
		userCreateDatetimeChart.setUrl("/chartController/userCreateDatetimeChart");
		userCreateDatetimeChart.setSeq(Integer.valueOf(1));
		userCreateDatetimeChart.setIcon("chart_curve");
		userCreateDatetimeChart.setTresource(chart);
		this.resourceDao.saveOrUpdate(userCreateDatetimeChart);

		Tresource jeasyuiApi = new Tresource();
		jeasyuiApi.setId("jeasyuiApi");
		jeasyuiApi.setName("EasyUI API");
		jeasyuiApi.setTresourcetype(menuType);
		jeasyuiApi.setUrl("http://jeasyui.com/documentation");
		jeasyuiApi.setSeq(Integer.valueOf(1000));
		jeasyuiApi.setIcon("book");
		this.resourceDao.saveOrUpdate(jeasyuiApi);

		Tresource wxgl = new Tresource();
		wxgl.setId("wxgl");
		wxgl.setName("微信管理");
		wxgl.setTresourcetype(menuType);
		wxgl.setSeq(Integer.valueOf(6));
		wxgl.setIcon("plugin");
		this.resourceDao.saveOrUpdate(wxgl);

		Tresource zdycd = new Tresource();
		zdycd.setId("zdycd");
		zdycd.setName("自定义菜单");
		zdycd.setTresourcetype(menuType);
		zdycd.setTresource(wxgl);
		zdycd.setSeq(Integer.valueOf(1));
		zdycd.setUrl("/wxbuttonController/manager");
		zdycd.setIcon("");
		this.resourceDao.saveOrUpdate(zdycd);

		Tresource cdbg = new Tresource();
		cdbg.setId("cdbg");
		cdbg.setName("菜单表格");
		cdbg.setTresourcetype(funType);
		cdbg.setTresource(zdycd);
		cdbg.setSeq(Integer.valueOf(1));
		cdbg.setUrl("/wxbuttonController/treeGrid");
		cdbg.setIcon("");
		this.resourceDao.saveOrUpdate(cdbg);

		Tresource cdaddPage = new Tresource();
		cdaddPage.setId("cdaddPage");
		cdaddPage.setName("菜单添加页面");
		cdaddPage.setTresourcetype(funType);
		cdaddPage.setTresource(zdycd);
		cdaddPage.setSeq(Integer.valueOf(2));
		cdaddPage.setUrl("/wxbuttonController/addPage");
		cdaddPage.setIcon("");
		this.resourceDao.saveOrUpdate(cdaddPage);

		Tresource cdadd = new Tresource();
		cdadd.setId("cdadd");
		cdadd.setName("添加菜单");
		cdadd.setTresourcetype(funType);
		cdadd.setTresource(zdycd);
		cdadd.setSeq(Integer.valueOf(3));
		cdadd.setUrl("/wxbuttonController/add");
		cdadd.setIcon("");
		this.resourceDao.saveOrUpdate(cdadd);

		Tresource cdeditPage = new Tresource();
		cdeditPage.setId("cdeditPage");
		cdeditPage.setName("菜单编辑页面");
		cdeditPage.setTresourcetype(funType);
		cdeditPage.setTresource(zdycd);
		cdeditPage.setSeq(Integer.valueOf(4));
		cdeditPage.setUrl("/wxbuttonController/editPage");
		cdeditPage.setIcon("");
		this.resourceDao.saveOrUpdate(cdeditPage);

		Tresource cdedit = new Tresource();
		cdedit.setId("cdedit");
		cdedit.setName("编辑菜单");
		cdedit.setTresourcetype(funType);
		cdedit.setTresource(zdycd);
		cdedit.setSeq(Integer.valueOf(5));
		cdedit.setUrl("/wxbuttonController/edit");
		cdedit.setIcon("");
		this.resourceDao.saveOrUpdate(cdedit);

		Tresource cddelete = new Tresource();
		cddelete.setId("cddelete");
		cddelete.setName("删除菜单");
		cddelete.setTresourcetype(funType);
		cddelete.setTresource(zdycd);
		cddelete.setSeq(Integer.valueOf(6));
		cddelete.setUrl("/wxbuttonController/delete");
		cddelete.setIcon("");
		this.resourceDao.saveOrUpdate(cddelete);
		
		
	}

	private void initResourceType() {
		Tresourcetype t = new Tresourcetype();
		t.setId("0");
		t.setName("菜单");
		this.resourceTypeDao.saveOrUpdate(t);

		Tresourcetype t2 = new Tresourcetype();
		t2.setId("1");
		t2.setName("功能");
		this.resourceTypeDao.saveOrUpdate(t2);
	}
	
	private void initWxButton() {
		WxButtonType type1 = new WxButtonType();
		type1.setId("1");
		type1.setName("点击类型菜单");
		type1.setTypeKey("click");
		wxButtonTypeDao.saveOrUpdate(type1);
		WxButtonType type2 = new WxButtonType();
		type2.setId("2");
		type2.setName("视图类型菜单");
		type2.setTypeKey("view");
		wxButtonTypeDao.saveOrUpdate(type2);
		WxButtonType type3 = new WxButtonType();
		type3.setId("3");
		type3.setName("复合类型菜单");
		type3.setTypeKey("complex");
		wxButtonTypeDao.saveOrUpdate(type3);
	}

	private void initRole() {
		Trole superAdmin = new Trole();
		superAdmin.setId("0");
		superAdmin.setName("超管");
		superAdmin.getTresources().addAll(this.resourceDao.find("from Tresource t"));
		superAdmin.setSeq(Integer.valueOf(0));
		superAdmin.setRemark("超级管理员角色，拥有系统中所有的资源访问权限");
		this.roleDao.saveOrUpdate(superAdmin);

		Trole zyAdmin = new Trole();
		zyAdmin.setId("zyAdmin");
		zyAdmin.setName("资源管理员");
		zyAdmin.setTrole(superAdmin);
		zyAdmin.setSeq(Integer.valueOf(1));
		zyAdmin.getTresources()
				.addAll(this.resourceDao.find("from Tresource t where t.tresource.id in ('zygl') or t.id in ('zygl')"));
		this.roleDao.saveOrUpdate(zyAdmin);

		Trole jsAdmin = new Trole();
		jsAdmin.setId("jsAdmin");
		jsAdmin.setName("角色管理员");
		jsAdmin.setTrole(superAdmin);
		jsAdmin.setSeq(Integer.valueOf(2));
		jsAdmin.getTresources()
				.addAll(this.resourceDao.find("from Tresource t where t.tresource.id in ('jsgl') or t.id in ('jsgl')"));
		this.roleDao.saveOrUpdate(jsAdmin);

		Trole yhAdmin = new Trole();
		yhAdmin.setId("yhAdmin");
		yhAdmin.setName("用户管理员");
		yhAdmin.setTrole(superAdmin);
		yhAdmin.setSeq(Integer.valueOf(3));
		yhAdmin.getTresources()
				.addAll(this.resourceDao.find("from Tresource t where t.tresource.id in ('yhgl') or t.id in ('yhgl')"));
		this.roleDao.saveOrUpdate(yhAdmin);

		Trole sjyAdmin = new Trole();
		sjyAdmin.setId("sjyAdmin");
		sjyAdmin.setName("数据源管理员");
		sjyAdmin.setTrole(superAdmin);
		sjyAdmin.setSeq(Integer.valueOf(4));
		sjyAdmin.getTresources().addAll(
				this.resourceDao.find("from Tresource t where t.tresource.id in ('sjygl') or t.id in ('sjygl')"));
		this.roleDao.saveOrUpdate(sjyAdmin);

		Trole bugAdmin = new Trole();
		bugAdmin.setId("bugAdmin");
		bugAdmin.setName("BUG管理员");
		bugAdmin.setTrole(superAdmin);
		bugAdmin.setSeq(Integer.valueOf(5));
		bugAdmin.getTresources().addAll(
				this.resourceDao.find("from Tresource t where t.tresource.id in ('buggl') or t.id in ('buggl')"));
		this.roleDao.saveOrUpdate(bugAdmin);

		Trole guest = new Trole();
		guest.setId("guest");
		guest.setName("Guest");
		guest.getTresources().addAll(this.resourceDao.find(
				"from Tresource t where t.id in ('xtgl','zygl','zyglTreeGrid','jsgl','jsglTreeGrid','yhgl','yhglDateGrid','jeasyuiApi')"));
		guest.setSeq(Integer.valueOf(1));
		guest.setRemark("只拥有只看的权限");
		this.roleDao.saveOrUpdate(guest);
	}

	private void initUser() {
		List<Tuser> l = this.userDao.find(
				"from Tuser t where t.name in ('Seven.Chen','admin1','admin2','admin3','admin4','admin5','guest')");
		if ((l != null) && (l.size() > 0)) {
			for (Tuser user : l) {
				this.userDao.delete(user);
			}
		}

		Tuser admin = new Tuser();
		admin.setId("1");
		admin.setName("Seven.Chen");
		admin.setPwd(MD5Util.md5("123456"));
		admin.setCreatedatetime(new Date());
		admin.getTroles().addAll(this.roleDao.find("from Trole t"));
		this.userDao.save(admin);

		Tuser admin1 = new Tuser();
		admin1.setId("2");
		admin1.setName("admin1");
		admin1.setPwd(MD5Util.md5("123456"));
		admin1.setCreatedatetime(new Date());
		admin1.getTroles().addAll(this.roleDao.find("from Trole t where t.id = 'zyAdmin'"));
		this.userDao.save(admin1);

		Tuser admin2 = new Tuser();
		admin2.setId("3");
		admin2.setName("admin2");
		admin2.setPwd(MD5Util.md5("123456"));
		admin2.setCreatedatetime(new Date());
		admin2.getTroles().addAll(this.roleDao.find("from Trole t where t.id = 'jsAdmin'"));
		this.userDao.save(admin2);

		Tuser admin3 = new Tuser();
		admin3.setId("4");
		admin3.setName("admin3");
		admin3.setPwd(MD5Util.md5("123456"));
		admin3.setCreatedatetime(new Date());
		admin3.getTroles().addAll(this.roleDao.find("from Trole t where t.id = 'yhAdmin'"));
		this.userDao.save(admin3);

		Tuser admin4 = new Tuser();
		admin4.setId("5");
		admin4.setName("admin4");
		admin4.setPwd(MD5Util.md5("123456"));
		admin4.setCreatedatetime(new Date());
		admin4.getTroles().addAll(this.roleDao.find("from Trole t where t.id = 'sjyAdmin'"));
		this.userDao.save(admin4);

		Tuser admin5 = new Tuser();
		admin5.setId("6");
		admin5.setName("admin5");
		admin5.setPwd(MD5Util.md5("123456"));
		admin5.setCreatedatetime(new Date());
		admin5.getTroles().addAll(this.roleDao.find("from Trole t where t.id = 'bugAdmin'"));
		this.userDao.save(admin5);

		Tuser guest = new Tuser();
		guest.setId("7");
		guest.setName("guest");
		guest.setPwd(MD5Util.md5("123456"));
		guest.setCreatedatetime(new Date());
		guest.getTroles().addAll(this.roleDao.find("from Trole t where t.id = 'guest'"));
		this.userDao.save(guest);
	}
}
