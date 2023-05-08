<h1 align="center"> taobao-buyer</h1>
<div align="center">
    🛍️ 拼多多自动抢购
</div>

## 如何使用
由于使用selenium，所以
### 第一步：下载ChromeDriver
找到你对应Chrome版本的ChromeDriver
> https://sites.google.com/a/chromium.org/chromedriver/home

### 第二步：配置ChromeDriver
```java
        System.setProperty("webdriver.chrome.driver", "/Users/beamstark/Desktop/chromedriver");
```
由于我是系统全局配置，所以这行代码没有在代码块中出现，需要的小伙伴自行添加代码配置

### 第三步：修改代码
打开 /src/main/java/TaoBaoBuyer.java <br>
修改 **ShoppingTime** 为自己的购买时间 <br>
修改 **PhoneNumber** 为自己的手机号码  <br>
### 最后一步：运行代码
需要手动输入手机验证码登陆
<br>
### 说明：
该程序会选中购物车的第一个进行锁单，如需更改请查看代码中第51行。
<br>

****

**如果你想在 [淘宝](https://www.taobao.com) 上自动购买，请 [Click me](https://github.com/BeammNotFound/taobao-buyer).**
<br>
<br>

> Enjoy this! 😎

## 请我喝杯咖啡☕️
<img src="./src/public/IMG_6480.JPG" alt="" width="300">

<img src="./src/public/IMG_6479.JPG" alt="" width="300">

