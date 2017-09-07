package selenium2;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class moveToElement {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver;
		File f = new File("");
		String path = f.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver",path+"/lib/selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com/");
		WebElement e = driver.findElement(By.id("kw"));
		e.sendKeys("软件");
		e.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(e);
//		Thread.sleep(1000);
		WebElement e2 = driver.findElement(By.xpath("//form[@id='form']/div/ul/li"));
		System.out.println(e2.getText());
		e2.click();
		driver.close();
		driver.quit();
	}
}
