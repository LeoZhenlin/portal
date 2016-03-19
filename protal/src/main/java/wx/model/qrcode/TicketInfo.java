package wx.model.qrcode;

public class TicketInfo {
	private String ticket;
	private Long expire_seconds;
	private String url;

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Long getExpire_seconds() {
		return this.expire_seconds;
	}

	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
