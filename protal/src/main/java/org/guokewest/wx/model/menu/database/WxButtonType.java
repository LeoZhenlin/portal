package org.guokewest.wx.model.menu.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Wx_button_type")
@DynamicInsert(true)
@DynamicUpdate(true)
public class WxButtonType implements Serializable {
	private static final long serialVersionUID = -188105656881655727L;
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	private String id;
	@Column(name = "TYPE_KEY", nullable = false, length = 100)
	private String typeKey;
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

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

	public String getTypeKey() {
		return this.typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}
}
