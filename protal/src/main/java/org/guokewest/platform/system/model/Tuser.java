package org.guokewest.platform.system.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "tuser")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tuser implements Serializable {
	private String id;
	private Date createdatetime;
	private Date modifydatetime;
	private String name;
	private String pwd;
	/* 微信用户属性  */
	//用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private String subscribe;
	// 用户的标识，对当前公众号唯一
	private String openid;
	//用户的昵称
	private String nickname;
	//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String sex;
	//用户的语言，简体中文为zh_CN
	private String language;
	//用户所在城市
	private String city;
	//用户所在省份
	private String province;
	//用户所在国家
	private String country;
	// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	private String headimgurl;
	//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private Long subscribe_time;
	//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	private String unionid;
	//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	private String remark;
	// 用户所在的分组ID
	private String groupid;
	// 个人推广二维码ticket  可以通过该二维码换取二维码图片
	private String qrTicket;
	// 上级
	private Tuser parent;
	private Set<Trole> troles = new HashSet(0);

	public Tuser() {
	}

	public Tuser(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public Tuser(String id, Date createdatetime, Date modifydatetime, String name, String pwd, Set<Trole> troles) {
		this.id = id;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.name = name;
		this.pwd = pwd;
		this.troles = troles;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATETIME", length = 19)
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFYDATETIME", length = 19)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PWD", nullable = false, length = 100)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tuser_trole", joinColumns = {
			@JoinColumn(name = "TUSER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "TROLE_ID", nullable = false, updatable = false) })
	public Set<Trole> getTroles() {
		return this.troles;
	}

	public void setTroles(Set<Trole> troles) {
		this.troles = troles;
	}

	@Column(name = "Subscribe", nullable = true, length = 10)
	public String getSubscribe() {
		return this.subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	@Column(name = "Openid", nullable = true, length = 100)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "nickname", nullable = true, length = 100)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "sex", nullable = true, length = 10)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "language", nullable = true, length = 100)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "city", nullable = true, length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "province", nullable = true, length = 100)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "country", nullable = true, length = 100)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "headimgurl", nullable = true, length = 500)
	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	@Column(name = "subscribe_time", nullable = true, length = 300)
	public Long getSubscribe_time() {
		return this.subscribe_time;
	}

	public void setSubscribe_time(Long subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	@Column(name = "unionid", nullable = true, length = 100)
	public String getUnionid() {
		return this.unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	@Column(name = "remark", nullable = true, length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "groupid", nullable = true, length = 100)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID")
	public Tuser getParent() {
		return this.parent;
	}

	public void setParent(Tuser parent) {
		this.parent = parent;
	}

	public String getQrTicket() {
		return qrTicket;
	}

	@Column(name = "QrTicket", nullable = true, length = 500)
	public void setQrTicket(String qrTicket) {
		this.qrTicket = qrTicket;
	}

	@Override
	public String toString() {
		return "Tuser [id=" + id + ", createdatetime=" + createdatetime + ", modifydatetime=" + modifydatetime
				+ ", name=" + name + ", pwd=" + pwd + ", subscribe=" + subscribe + ", openid=" + openid + ", nickname="
				+ nickname + ", sex=" + sex + ", language=" + language + ", city=" + city + ", province=" + province
				+ ", country=" + country + ", headimgurl=" + headimgurl + ", subscribe_time=" + subscribe_time
				+ ", unionid=" + unionid + ", remark=" + remark + ", groupid=" + groupid + ", qrTicket=" + qrTicket
				+ ", parent=" + parent + ", troles=" + troles + "]";
	}
	
	
}
