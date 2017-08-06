package ecshop;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testOpen {
	public static void main(String[] args){
		WebDriver driver;
		File f = new File("");
		String path = f.getAbsolutePath();
//		System.setProperty("webdriver.chrome.driver",path+"/lib/selenium/chromedriver");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver",path+"/lib/selenium/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost/ECShop_V2.7.3_UTF8_release1106/upload/");
	}
}
