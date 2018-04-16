package democode.firstlinecode.demo8.xinwenyingyong.model;

/**
 * 新闻类应用的实体类,每条新闻包含着,标题,内容 两个属性.
 * @author Administrator
 *
 */
public class News {
	
	private String title;
	
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public News(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
}