package wx.model.message;

import java.util.List;

public class NewsMessage extends BaseMessage {
	private Integer ArticleCount;
	private List<Article> Articles;

	public Integer getArticleCount() {
		return this.ArticleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return this.Articles;
	}

	public void setArticles(List<Article> articles) {
		this.Articles = articles;
	}
 }
