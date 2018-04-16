package democode.firstlinecode.demo14.webview_network.other;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import android.util.Log;

/**
 * ContentHandler
 * 解析XML文件 使用SAX解析的方式来进行解析.
 * HttpUrlConnectionActivity中的parseXMLWithSAX方法调用此类进行解析操作.
 * @author Administrator
 *
 */
public class ContentHandler extends DefaultHandler {

	private String nodeName;

	private StringBuilder id;

	private StringBuilder name;

	private StringBuilder version;

	/**
	 * 1对类的成员属性进行初始化.
	 */
	@Override
	public void startDocument() throws SAXException {
		id = new StringBuilder();
		name = new StringBuilder();
		version = new StringBuilder();
	}

	/**
	 * 2.每当开始解析某个结点的时候，startElement()方法就会得到调用.其中 localName 参数记录着当前结点的名字，这里我们把它记录下来.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// 记录当前结点名
		nodeName = localName;
	}

	/**
	 * 3.接着在解析结点中具体内容的时候就会调用 characters()方法 ，我们会根据当前的结点名进行判断 ，将解析出的内容添加到哪一个
	 * StringBuilder 对象中。
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// 根据当前的结点名判断将内容添加到哪一个StringBuilder对象中
		if ("id".equals(nodeName)) {
			id.append(ch, start, length);
		} else if ("name".equals(nodeName)) {
			name.append(ch, start, length);
		} else if ("version".equals(nodeName)) {
			version.append(ch, start, length);
		}
	}

	/**
	 * 4.最后在 endElement()方法中进行判断，如果 app 结点已经解析完成，就打印出 id、name 和 version 的内容。
	 * 需要注意的是，目前 id、name 和 version 中都可能是包括回车或换行符的，因此在打印之前我们还需要调用 一下
	 * trim()方法，并且打印完成后还要将 StringBuilder 的内容清空掉，不然的话会影响下一次内容的读取。
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("app".equals(localName)) {
			Log.d("HttpUrlConnectionActivity", "id:" + id.toString().trim() + " " + " name:" + name.toString().trim()
					+ " " + " version:" + version.toString().trim());

			// 最后要将StringBuilder清空掉.
			id.setLength(0);
			name.setLength(0);
			version.setLength(0);
		}
	}

	@Override
	public void endDocument() throws SAXException {
	}

}