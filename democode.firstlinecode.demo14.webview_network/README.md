##### 项目说明
* 使用UTF-8编码.
* 使用WebView技术展现网页.

##### MainActivity.java
* 这是应用程序的主界面,同时主界面中提供其它7个功能的入口按钮.
* 提供 在应用程序中打开一个Activity打开指定的网页.
* 提供 使用httpurlconnection的方式来访问网络,获取服务器上的文件.
* 提供 使用httpclient的方式来访问网络,获取服务器上的文件.
* 提供 使用PULL的方式解析Apache服务器上的XML文件.
* 提供 使用SAX的方式解析Apache服务器上的XML文件.
* 提供 解析JSON格式数据.

##### WebViewActivity.java
* Web展示Activity,在应用程序当中调用网页.

##### HttpUrlConnectionActivity.java
* Web展示Activity,在应用程序当中调用网页.

##### App.java
* 这里将想要被GSON自动将json文件里面的属性映射到这里面的属性值的就写好属性并且将相应的setter,getter方法都添加好.
* HttpUrlConnectionActivty这个类中parseJSONWithGSON这个方法调用过这个类.

##### ContentHandler.java
* 解析XML文件 使用SAX解析的方式来进行解析.
* HttpUrlConnectionActivity中的parseXMLWithSAX方法调用此类进行解析操作. 

##### HttpCallbackListener.java
* 为了解决在调用HttpUtil中的sendHttpRequest方法因为这个方法是属于网络请求,没有开启线程进行执行,所以如果说网路请求的速度比较慢,则可能会影响主线程,从而导致主线程柱塞.
* 在HttpUtil中的sendHttpRequest方法中调用过.

##### HttpUtil.java
* 网络编程,针对服务器发出的一个请求做出的方法封装,以后只需要调用一次就可以获取相应的文件.
* 并且提供版本超过两个,能够解决当网络编程请求较多,返回的时长较慢的情况. 