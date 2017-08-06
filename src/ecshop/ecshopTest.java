package ecshop;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ecshopTest {
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
  @Test(priority=2)
  public void serch() {
	  driver.findElement(e.serchText).sendKeys("诺基亚E66");
	  driver.findElement(e.serchButton).click();
	  driver.findElement(e.good).click();
	  driver.findElement(e.shopCarButton).click();;
	  driver.findElement(e.payButton).click();;
	  driver.findElement(e.payInputButton).click();
  }
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
		driver.findElement(e.toDeliver).click();
		driver.findElement(e.check).click();
		driver.findElement(e.deliverConfirm).click();
	  }
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(e.url);
  }

  @AfterClass
  public void afterClass() {
//	  driver.close();
//	  driver.quit();
  }

}
