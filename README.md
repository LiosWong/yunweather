###由于该项目还在完善中，项目逐步趋于完善时，会公布整个项目的源码。
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
* 开源工具
GSON-2.2.4,okhttp-3.2


####项目实施
1.数据库设计
<br />
数据库中有三张表:省，市，县,三张表通过主外键联系起来，逻辑比较清晰
![](http://i2.buimg.com/2ce073f2cab33642.png)    
![](http://i2.buimg.com/eacfa7bf748a02ce.png)
![](http://i2.buimg.com/cef764db864a9287.png)
2.网络请求框架okhttp3.2

```
final OkHttpClient client = new OkHttpClient();
 
public void run() throws Exception {
    Request request = new Request.Builder()
        .url(url)
        .build();
    client.newCall(request).enqueue(new Callback() {
    
      @Override 
      public void onFailure(Request request, Throwable throwable) {
      
        
      }
 
      @Override
      public void onResponse(Response response) throws IOException {
     

     }
  });
 }
```
