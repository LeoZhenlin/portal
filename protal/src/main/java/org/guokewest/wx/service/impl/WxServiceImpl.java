package org.guokewest.wx.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.guokewest.wx.service.WxService;
import org.springframework.stereotype.Service;

@Service("WxService")
public class WxServiceImpl implements WxService {

	@Override
	public String processRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Autowired
//	private RoleDaoI roleDao;
//	@Autowired
//	private UserDaoI userDao;

//	public String processRequest(HttpServletRequest request) {
//		String respMessage = null;
//		try {
//			String respContent = "请求处理异常，请稍候尝试！";
//
//			Map<String, String> requestMap = MessageUtil.parseXml(request);
//
//			String fromUserName = (String) requestMap.get("FromUserName");
//
//			String toUserName = (String) requestMap.get("ToUserName");
//
//			String msgType = (String) requestMap.get("MsgType");
//
//			TextMessage textMessage = new TextMessage();
//			textMessage.setToUserName(fromUserName);
//			textMessage.setFromUserName(toUserName);
//			textMessage.setCreateTime(new Date().getTime());
//			textMessage.setMsgType("text");
//			textMessage.setFuncFlag(Integer.valueOf(0));
//
//			if (msgType.equals("text")) {
//				respContent = "您发送的是文本消息！";
//
//			} else if (msgType.equals("image")) {
//				respContent = "您发送的是图片消息！";
//
//			} else if (msgType.equals("location")) {
//				respContent = "您发送的是地理位置消息！";
//
//			} else if (msgType.equals("link")) {
//				respContent = "您发送的是链接消息！";
//
//			} else if (msgType.equals("voice")) {
//				respContent = "您发送的是音频消息！";
//
//			} else if (msgType.equals("event")) {
//				String eventType = (String) requestMap.get("Event");
//
//				if (eventType.equals("subscribe")) {
//					respContent = "谢谢您的关注！";
//
//					String eventkey = (String) requestMap.get("EventKey");
//					System.out.println("二维码参数：上级ID＝" + eventkey);
//					System.out.println("========1.获取微信用户信息=======");
//
//					WxUser WxUser = UserUtil.getUser(fromUserName);
//					Tuser user = new Tuser();
//					BeanUtils.copyProperties(WxUser, user);
//
//					user.setId(fromUserName);
//					user.setName(WxUser.getNickname());
//					user.setPwd(MD5Util.md5("123456"));
//					user.setCreatedatetime(new Date());
//
//					user.getTroles().addAll(this.roleDao.find("from Trole t"));
//					System.out.println("========2.将用户信息导入系统=======");
//					
//					System.out.println("========3.生成个人二维码=======");
//					String params = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": "+user.getId()+"}}}";
//					user.setQrTicket(QrcodeUtil.getQrTicken(params));
//					this.userDao.save(user);
//
//				} else if (!eventType.equals("unsubscribe")) {
//					userDao.delete(userDao.get(Tuser.class, fromUserName));
////					eventType.equals("CLICK");
//				}
//			}
//
//			textMessage.setContent(respContent);
//			respMessage = MessageUtil.messageToXml(textMessage);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return respMessage;
//	}
}
