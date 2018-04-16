#### 一切都从StandardActivity中开始的.
* 最重要的实际上是你要能够自己观察出这些启动模式之间的不同以及生命周期的变化.

#### SingleTopActivity
* 这个类的主要功能在于实现当当前的Activity的位置处于栈顶的时候,是否又会重复的造onCreate()方法?

#### SingleTaskActivity与SingleTaskActivity2,SingleTaskActivity3这三个活动之间的关系是什么?
* 首先将SingleTaskActivity的启动模式设置为singleTask.
* SingleTaskActivity2,SingleTaskActivity3 这两个启动模式还是默认的设置.
* 我为了方便理解,将着三个Activity做成了一个小业务(当然业务逻辑不完善,,不过方便理解是一个使用的场景就可以了):
  SingleTaskActivity(登录页面) --> SingleTaskActivity2(注册页面) --> SingleTaskActivity3(注册成功!返回登录界面!)
* 那么请问,我们在平常的工作当中,是不是说注册完之后就不会回到SingleTaskActivity2这样的Activity,注册成功后直接回到SingleTaskActivity页面,对吧?
* 那么我们这里要怎么去做这个东西了?实际上就可以将SingleTaskActivity的启动模式设置为singleTask模式,如果说当程序运行到SingleTaskActivity3用户还没有做出任何的逻辑操作时,那么此时
  SingleTaskActivity,SingleTaskActivity2,SingleTaskActivity3都不会直接调用onDestroy()这个方法.
* 但如果说此时我们提供了一个按钮可以让SingleTaskActivity3跳转到SingleTaskActivity这个活动,且此时SingleTaskActivity为这个模式,那么就会将SingleTaskActivity2,SingleTaskActivity3这两个直接调用onDestroy()方法.
* 而SingleTaskActivity则直接调用onRestart()方法.这样一下就清除了很多的内存,你看,如果让你来做应该如何去做这个业务了?  对不对可以直接把在它上面的直接干掉,清理干净.这在平常的应用程序里面也非常的多见.

#### SingleInstance
* 这些个类的主要特征在于,去实现了两个返回栈的情况,方法调用情况.最后在手机中按下back键的时候是一个什么样子的.

注意,这里的README.md文件编码必须要是UTF-8才能正确显示中文.但整个项目是GBK编码.