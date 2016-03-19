package wx.model.accessToken;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "wx_access_token")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Token {
	@Id
	@Column(name = "ID", nullable = false, length = 36)
	private String id;
	@Column(name = "access_token", nullable = false, length = 500)
	private String access_token;
	@Column(name = "expires_in", nullable = false, length = 30)
	private String expires_in;
	@Column(name = "createtime", nullable = false, length = 30)
	private Timestamp createtime;

	public String getAccess_token() {
		return this.access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return this.expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
