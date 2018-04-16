##### 项目说明
* 项目使用编码UTF-8.
* 主要使用广播 + 服务 + Alarm 来实现一个长久的后台自动执行某任务的功能.

##### MainActivity
* 程序启动界面,无操作.
* 实际上真正在调用程序的是AlarmReceiver这个广播类,每次自动调用这个广播跳转到LongRunningService服务,根据设定的时间又切回来AlarmReceiver里面,这样就可以形成一个永久的循环.

##### AlarmReceiver
* 通过广播调用定时任务服务处理.

##### LongRunningService
* 长时间运行服务.
* 配合Alarm机制形成一个服务.