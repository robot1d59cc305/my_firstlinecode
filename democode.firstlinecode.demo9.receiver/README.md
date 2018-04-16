#### 项目说明
* 项目采用UTF-8编码,主要针对AndroidReceiver的使用做出一个简单的入门教程.

##### BootReceive.java
* 接受系统广播静态注册实现开机自启.

##### DynamicActivity.java
* 接受系统广播动态注册监听网络变化.

##### BenDiGuangBoActivity.java
* 发送本地广播,本地广播发出的广播只会在自己的应用程序里面收到.

##### MainActivity.java
* 功能主页

##### MyBroadcastReceiver.java && MyBroadcastReceiverActivity.java
* 这两个类是自定义广播发送器,一个是自定义发送一个广播,一个是接受自己发送的广播.
* 只不过这里是自定义发送的一个标准广播.

##### BaseActivity.java
* 这个类是一个工具类,来封装一些我们自己需要的需求.