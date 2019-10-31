# Android端JSAPI具体使用方式
###一、接入方式
1、引入Jsapi组件库
2、在项目中使用组件QCWebView
3、创建QCJSActionRegister子类，用于注册交互事件
4、调用QCWebView.setJSActionRegister(QCJSActionRegister register)函数将webview与交互事件绑定
5、创建各种交互事件实现类并继承QCJSAction抽象类，在action函数内编写交互功能代码
6、在action函数中调用QCJSCallBack.callback(response)将操作结果返回给前端页面
###二、说明
1、在action(QCJSAPIInterface jsApiInfo, T data, QCJSCallBack qcjsCallBack)函数中，jsApiInfo可用于获取Context和WebView对象，data为前端发送事件时的携带参数，qcjsCallBack用于向前端返回响应
2、前端发送事件的数据结构使用QCJSDataRequest接收并解析，客户端返回事件用QCJSDataBean发送响应
3、QCJSDataBean中需要的code和message尽量使用QCJSError定义的返回信息


   




