package wx.model.message;

public class TextMessage extends BaseMessage {
	private String Content;
	private Integer funcFlag;

	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	public Integer getFuncFlag() {
		return this.funcFlag;
	}

	public void setFuncFlag(Integer funcFlag) {
		this.funcFlag = funcFlag;
	}
 }

