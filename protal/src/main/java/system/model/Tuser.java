package system.model;

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
	private String subscribe;
	private String openid;
	private String nickname;
	private String sex;
	private String language;
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	private Long subscribe_time;
	private String unionid;
	private String remark;
	private String groupid;
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
