package ecshop;

import org.openqa.selenium.By;

public class Element {
	//网址
	String url = "http://localhost/ECShop_V2.7.3_UTF8_release1106/upload";
	String adminUrl = "http://localhost/ECShop_V2.7.3_UTF8_release1106/upload/admin/privilege.php?act=login";
	//用户名
	String user = "test1";
	//用户密码
	String password = "12345678";
	//用户验证信息
	String userInfo = "您好，"+user+", 欢迎您回来！ 用户中心| 退出";
	//用户信息
	By userInfoL = By.cssSelector("#ECS_MEMBERZONE > font");
	//登录按钮
	By userLogin = By.xpath("//font[@id='ECS_MEMBERZONE']/a/img");
	//用户名输入框
	By userName = By.name("username");
	//用户密码输入框
	By userPassword = By.name("password");
	//提交登录信息按钮
	By userSubmit = By.name("submit");
	//搜索输入框
	By serchText = By.id("keyword");
	//搜索按钮
	By serchButton = By.xpath("//input[@name='imageField']");
	//商品
	By good = By.cssSelector("img.goodsimg");
	//购物车按钮
	By shopCarButton = By.cssSelector("li.padd > a > img");
//	By shopCarButton = By.xpath("//li[9]/a/img");
	//结算按钮
	By payButton = By.cssSelector("img[alt='checkout']");
	//订单提交按钮
	By payInputButton = By.cssSelector("input[type='image']");
	//后台管理员
	String adminName = "test";
	String adminPassword = "123456Pp";
	//后台用户名输入框
	By adminUserNmae = By.name("username");
	//后台用户密码输入
	By adminUserPassword = By.name("password");
	//后台登录按钮
	By adminlogin = By.cssSelector("input.button");
	//后台订单列表
	By orderList = By.linkText("订单列表");
	//后台列表选择
	By orderListChose = By.id("order_0");
	//生成发货单按钮
	By shipButton = By.name("ship");
	//确认生成发货单按钮
	By deliverConfir = By.name("delivery_confirmed");
	//发货按钮
	By toDeliver = By.name("to_delivery");
	//待发货查看
	By check = By.linkText("查看");
	//确认发货
	By deliverConfirm = By.name("delivery_confirmed");
	//用户中心按钮
	By userCenter = By.linkText("用户中心");
	//我的订单按钮
	By myGoodslist = By.linkText("我的订单");
	//确认收货按钮
	By confirmGoods = By.linkText("确认收货");
}
