package ecshop;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class Deliver {
	public Deliver(){
		WebDriver driver;
		Element e = new Element();
		File f = new File("");
		String path = f.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver",path+"/lib/selenium/chromedriver");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
}
