##### 项目说明
* 这个项目使用UTF-8编码进行开发.

##### MainActivity.java
* 这个类是这个Android应用程序端的入口,主要的Activity.

##### BaseActivity.java
* Activity包装类,将需要对所有的Activity做出的操作都封装到这个类里面,然后其余的类继承此类即可.

##### MyAplication.java
* Android 提供了一个 Application 类，每当应用程序启动的时候，系统就会自动将这个类进行初始化。
* 而我们可以定制一个自己的 Application 类，以便于管理程序内一些全局的状态信息，比如说全局 Context。

##### FirstActivity.java
* 接下来在 FirstActivity 中我们仍然可以使用相同的代码来传递 Person 对象，只不过在SecondActivity 中获取对象的时候需要稍加改动

##### democode.firstlinecode.demo17.develop.skill.intent
* 使用Intent传递对象
* Serializable方式
* Parcelable方式

##### democode.firstlinecode.demo17.develop.skill.log
* Log,定制自己的工具.

