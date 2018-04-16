##### 项目说明
* 这个项目使用UTF-8编码进行开发.

##### MainActivity.java
* 这个类是这个Android应用程序端的入口,主要的Activity.

##### BaseActivity.java
* Activity包装类,将需要对所有的Activity做出的操作都封装到这个类里面,然后其余的类继承此类即可.

##### MyLocationLatitudeActivity.java
* 确定用户当前位置,并将当前位置的经纬度显示在视图中的TextView控件中.

##### MyLocationLatitudeActivity2.java
* 确定用户当前位置,并将当前位置的经纬度通过访问 Geocoding API来获取到这个经纬度说表示的信息然后将信息显示在TextView控件当中.

##### BaiDuMapActivity.java
* 第一行代码 书本上p422-p432书籍内容讲的百度地图的版本已经非常的旧,已经跟不上现在的百度地图版本SDK的API. 所以这里是使用的最新的百度地图的
* http://lbsyun.baidu.com/index.php?title=androidsdk/guide/create-project/hellomap 这篇文章学习百度地图的使用,但是也只是初步的将百度地图的框架搭建好.
* 不过地图格中的数据并没有显示出来.