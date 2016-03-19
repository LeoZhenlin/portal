package wx.model.menu.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "wx_button")
@DynamicInsert(true)
@DynamicUpdate(true)
public class WxButton implements Serializable {
	private static final long serialVersionUID = 1231237957459685617L;
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	private String id;
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUTTONTYPE_ID", nullable = false)
	private WxButtonType buttonType;
	@Column(name = "CLICK_KEY", length = 100)
	private String key;
	@Column(name = "VIEW_URL", length = 300)
	private String url;
	@Column(name = "SEQ")
	private Integer seq;
	@ManyToOne
	@JoinColumn(name = "PID")
	private WxButton parent;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<WxButton> children = new HashSet<WxButton>();
	@Column(name = "REMARK", length = 300)
	private String remark;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WxButtonType getButtonType() {
		return this.buttonType;
	}

	public void setButtonType(WxButtonType buttonType) {
		this.buttonType = buttonType;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WxButton getParent() {
		return this.parent;
	}

	public void setParent(WxButton parent) {
		this.parent = parent;
	}

	public Set<WxButton> getChildren() {
		return this.children;
	}

	public void setChildren(Set<WxButton> children) {
		this.children = children;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
