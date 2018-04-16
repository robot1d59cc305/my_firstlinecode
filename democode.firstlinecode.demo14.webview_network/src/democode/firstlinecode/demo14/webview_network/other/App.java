package democode.firstlinecode.demo14.webview_network.other;

/**
 * App
 * 这里将想要被GSON自动将json文件里面的属性映射到这里面的属性值的就写好属性并且将相应的setter,getter方法都添加好.
 * HttpUrlConnectionActivty这个类中parseJSONWithGSON这个方法调用过这个类.
 * @author Administrator
 *
 */
public class App {

	/**
	 * ID值.
	 */
	private String id;

	/**
	 * 名称.
	 */
	private String name;

	/**
	 * 版本.
	 */
	private String version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}