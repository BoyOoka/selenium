package ecshop;


import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.DEFAULT) 
public class ecshopJunit  {
	static Element e = new Element();
	static WebDriver driver;
  @Test
  public void login() {
	  //登录
	 driver.findElement(e.userLogin).click();
	 driver.findElement(e.userName).sendKeys(e.user);
	 driver.findElement(e.userPassword).sendKeys(e.password);
	 driver.findElement(e.userSubmit).click();
	 
	 //验证正确登录
	 assertEquals(driver.findElement(e.userInfoL).getText(), e.userInfo);
  }
  /*
   *搜索商品加入购物车付款 
   */
  @Test
  public void serch() throws InterruptedException {
	  driver.findElement(e.serchText).sendKeys("恒基伟业G101");
	  driver.findElement(e.serchButton).click();
	  driver.findElement(e.good).click();
	  driver.findElement(e.shopCarButton).click();;
	  driver.findElement(e.payButton).click();;
	  driver.findElement(e.payInputButton).click();
  }
  /*
   * 管理员发货
   */
  @Test
  public void delivery() throws WebDriverException{
		driver.get(e.adminUrl);
		driver.findElement(e.adminUserNmae).sendKeys(e.adminName);
		driver.findElement(e.adminUserPassword).sendKeys(e.adminPassword);
		driver.findElement(e.adminlogin).click();
		//切换到headerframe
		driver.switchTo().frame(driver.findElement(By.id("header-frame")));
		driver.findElement(e.orderList).click();
		driver.switchTo().parentFrame();
		//切换到main-frame
		driver.switchTo().frame("main-frame");
		driver.findElement(e.orderListChose).click();
		driver.findElement(e.shipButton).click();
		driver.findElement(e.deliverConfir).click();
		driver.findElement(e.toDeliver).click();
		driver.findElement(e.check).click();
		driver.findElement(e.deliverConfirm).click();
	  }
  	/*
  	 * 确认收货
  	 */
	@Test
	public void confirmgoods(){
		driver.get(e.url);
		driver.findElement(e.userCenter).click();
		driver.findElement(e.myGoodslist).click();
		driver.findElement(e.confirmGoods).click();
		driver.switchTo().alert().accept();
	}
  
  @BeforeClass
  public static void beforeClass() {
		File f = new File("");
		String path = f.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver",path+"/lib/selenium/chromedriver");
		driver = new ChromeDriver();
//		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(e.url);
  }

  @AfterClass
  public static void afterClass() {
//	  driver.close();
//	  driver.quit();
  }

}
