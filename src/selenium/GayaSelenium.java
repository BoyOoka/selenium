package selenium;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GayaSelenium {
	WebDriver driver;
	int waitTime = 10;
	//单击
	public void click(By locator){
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	//双击
	public void doubleClick(By locator){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement e = driver.findElement(locator);
		action.doubleClick(e);
	}
	//输入
	public void sendkeys(By locator,String string){
		driver.findElement(locator).sendKeys(string);
	}
	//切换到frame
	public void switchToframe(By locator){
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	//切换到frame
	public void switchToframe(int frameLocator){
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	//切换到frame
	public void switchToframe(String framename){
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framename));
	}
	//截图
	public  void takeScreen(String name,String path) throws Exception{
	 	OutputStream out = null; 
		TakesScreenshot take = (TakesScreenshot)driver;
		File file = take.getScreenshotAs(OutputType.FILE);
		out = new FileOutputStream(path+name+".jpg");
		FileUtils.copyFile(file,out);
	 }
	//js点击
	public void jsClick(By locator){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].click();", new Object[]{driver.findElement(locator)});
	}
	//等待到达
	public void waitLocated(By locator){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	//等待标题
	public void waitTitles(String title){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleIs(title));
	}
}
