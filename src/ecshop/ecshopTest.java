package ecshop;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ecshopTest{
	Element e = new Element();
	WebDriver driver;
  @Test(priority=1)
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
  @Test(priority=2)
  public void serch() throws InterruptedException {
	  driver.findElement(e.serchText).sendKeys("恒基伟业G101");
	  driver.findElement(e.serchButton).click();
	 try{ 
	  driver.findElement(e.good).click();
	 }catch (WebDriverException w){
		 	WebDriverWait wait = new WebDriverWait(driver, 5);
			System.out.println(2);
			wait.until(ExpectedConditions.elementToBeClickable(e.good));
			driver.findElement(e.good).click();
	 }
	  try{
	  driver.findElement(e.shopCarButton).click();
	  }catch (WebDriverException w){
		  	WebDriverWait wait = new WebDriverWait(driver, 5);
			System.out.println(2);
			wait.until(ExpectedConditions.elementToBeClickable(e.shopCarButton));
			driver.findElement(e.shopCarButton).click();
	  }
	  driver.findElement(e.payButton).click();
	 try{
	  driver.findElement(e.payInputButton).click();
	 }catch (WebDriverException w){
		 WebDriverWait wait = new WebDriverWait(driver, 5);
			System.out.println(2);
			wait.until(ExpectedConditions.elementToBeClickable(e.payInputButton));
			driver.findElement(e.payInputButton).click();
	 }
  }
  /*
   * 管理员发货
   */
  @Test(priority=3)
  public void delivery(){
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
		
		
	try{
		System.out.println(1);
		driver.findElement(e.toDeliver).click();
	}catch(WebDriverException we){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		System.out.println(2);
		wait.until(ExpectedConditions.elementToBeClickable(e.toDeliver));
		driver.findElement(e.toDeliver).click();
	}
		
		driver.findElement(e.check).click();
		driver.findElement(e.deliverConfirm).click();
	  }
  	/*
  	 * 确认收货
  	 */
	@Test(priority=4)
	public void confirmgoods(){
		driver.get(e.url);
		driver.findElement(e.userCenter).click();
		driver.findElement(e.myGoodslist).click();
		driver.findElement(e.confirmGoods).click();
		driver.switchTo().alert().accept();
	}
  
  @BeforeClass
  public void beforeClass() {
		File f = new File("");
		String path = f.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver",path+"/lib/selenium/chromedriver");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver",path+"/lib/selenium/geckodriver");
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(e.url);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  driver.quit();
  }

}
