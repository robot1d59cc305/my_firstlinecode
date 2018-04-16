##### 项目说明
* 本项目采用UTF-8编码.
* 主要是结合AndroidBroadcastReceiver技术来实现一个防QQ的强制下线功能.

##### MainActivity.java
* 首页,主要是在将login.xml这个布局文件设置为顶级视图.
* 处理用户在login.xml这个布局文件当中输入的数据,做出判断.

##### ProductActivity.java
* 发出一个广播,对用户点击了"强制下线"功能按钮之后做出反应.
* 让MyBroadcastReceiver.java来接受这个广播.

##### MyBroadcastReceiver.java
* 这个广播做出一些业务逻辑,然后发出一个拥有着顶级视图的对话框,让用户确定强制下线的功能.
* 并且在强制下线之后回到MainActivity.java当中.

##### ActivityCollector.java
* 管理着所有的Activity,能够删除所有的Activity类.

##### BaseActivity.java
* 对Activity中的一些方法做出封装,让后面的Activity类在继承的时候能够直接获得一些用户想要每个Activity都能够做到的特性.
