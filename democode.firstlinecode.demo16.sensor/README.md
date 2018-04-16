##### 项目说明
* 这个项目使用UTF-8编码进行开发.

##### MainActivity.java
* 这个类是这个Android应用程序端的入口,主要的Activity.

##### BaseActivity.java
* Activity包装类,将需要对所有的Activity做出的操作都封装到这个类里面,然后其余的类继承此类即可.

##### IlluminationSensorActivity.java
* 简易光照探测器,利用Android光照传感器来实现.
* 运行一下程序，你将会在手机上看到当前环境下的光照强度，根据所处环境的不同，显示的数值有可能是几十到几百勒克斯。而如果你使用强光来照射手机的话，就有可能会达到上千勒克斯的光照强度.

##### AcceleratedSpeedActivity.java
* 加速度传感器,使用加速度传感器制作微信摇一摇功能.

##### DirectionSensor.java
* 使用方向传感器,制作简易指南针.