###(Android)由于该项目还在完善中，项目趋于满意时，会公布整个项目的源码。
####项目信息
* 功能：
       1. 免费全国两千多个省市县的天气信息
       2. 当天不同时段的天气预报
       3. 未来七天天气状况
       4. 生活服务信息
* 目标：
   秉持Material Design设计风格,呈现鲜艳活泼UI外观，给予用户良好体验。
* 项目思路：
    思路非常简单，通过选择所在市县，然后从服务器上取下天气信息显示到客户端。
* 素材来源：
Material-Design-Icons,[Google Calendar](http://www.google.com/calendar/about/),[Dribbble.com](https://Dribble.com),[花瓣网](http://huaban.com/),[千图网](http://www.58pic.com/)。
* 开源工具：
GSON-2.2.4,okhttp-3.2


####项目实施示例
1.数据库设计
<br />
数据库中有三张表:省，市，县,三张表通过主外键联系起来，逻辑比较清晰
![](http://i2.buimg.com/2ce073f2cab33642.png)    
![](http://i2.buimg.com/eacfa7bf748a02ce.png)
![](http://i2.buimg.com/cef764db864a9287.png)

2.网络请求框架((okhttp3.2)
<br  />
```
...

final OkHttpClient client = new OkHttpClient();
 
public void run() throws Exception {

    Request request = new Request.Builder()
        .url(url)
        .build();
        
    client.newCall(request).enqueue(new Callback() {
    
      public void onFailure(Request request, Throwable throwable) {
      
        
      }

      public void onResponse(Response response) throws IOException {
     

     }
  });
 }
 ...
```
上面只是简单的介绍项目实施，关于项目设计以及遇到的问题，还有很多需要自我总结思考，这里不再花篇幅介绍，后续会发布在博客上。


####应用下载：
您可以前往
<br />
[豌豆荚](http://i4.buimg.com/84a3e8a240525b19.png),
<br />
[fir.im](http://fir.im/apps/573a9e0f00fc747d17000001)
<br />
下载，如果对应用有任何意见，欢迎给我发邮件，不甚感谢;如果喜欢该应用，请分享给您的朋友，谢谢(*^‧^*)
####关于我
[我的*CSDN*](http://lios.top)
<br />
[我的*GitHub*](https://github.com/osdiy)
<br />
[我的*ITPUB*](http://blog.itpub.net/29876893/)
<br />
[邮箱:*diy.os.lios@gmail.com*](https://github.com/osdiy/yunweather/blob/master/README.md)
<br />
####应用截图
 <img src="http://i4.buimg.com/92053b1ab64ddb31.png" width = "150" height = "300" alt="图片名称" align=center />
  <img src="http://i4.buimg.com/54734e4bb25b225d.png" width = "150" height = "300" alt="图片名称" align=center />
  <img src="http://i4.buimg.com/43249ed1dc01f74b.png" width = "150" height = "300" alt="图片名称" align=center />
  <img src="http://i4.buimg.com/e022431553ace560.png" width = "150" height = "300" alt="图片名称" align=center />
  <img src="http://i4.buimg.com/6db8418f2d736f9c.png" width = "150" height = "300" alt="图片名称" align=center />
  <img src="http://i4.buimg.com/caa5db910b219812.png" width = "150" height = "300" alt="图片名称" align=center />

