# Demo-EventBus
---
下载EventBus的类库
源码：https://github.com/greenrobot/EventBus

##EventBus基本使用
1）自定义一个类，用于存放消息,相当于javabean。
```
public class AnyEventType {  
     public AnyEventType(){}  
 }  
```
2）生命周期绑定：
在onCreate()的时候
```
eventBus.register(this);
```
在onDestoty()的时候
```
eventBus.unregister(this);
```
>备注：发布者和订阅者都需要register和unregister

3）发布者：发送消息
```
eventBus.post(new AnyEventType event);  
```

4）接受者: 接受消息的页面实现(共有四个函数，各功能不同，这是其中之一，可以选择性的实现，这里先实现一个)：
```
public void onEvent(AnyEventType event) {}  
```

