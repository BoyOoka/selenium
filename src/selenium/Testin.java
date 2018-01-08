package selenium;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Testin {
	GayaSelenium ga = new GayaSelenium();
	String login_password = "*";
	String login_email = "*";
 /*
  @Test
  public void cookieinLogin() {
	  Cookie cookie = new Cookie("authtoken", "A300B27Ca0c917ae9295a3b2cb8286ad270fbfca");
	  ga.driver.get("https://www.ztestin.com/");
	  ga.driver.manage().addCookie(cookie);
	  ga.driver.navigate().refresh();
  }
  */
  @Test
  public void login() throws IOException, InterruptedException{
	  Actions action = new Actions(ga.driver);
	  ga.driver.get("https://www.ztestin.com/");
	  ga.click(By.className("nav_login"));
	  ga.sendkeys(By.id("login_email"), login_email);
//	  ga.driver.findElement(By.id("login_email")).sendKeys("18582382014");
	  ga.sendkeys(By.id("login_password"), login_password);
//	  ga.driver.findElement(By.id("login_password")).sendKeys("80393873");
	  ga.click(By.id("btn_submit1989"));
	  Set<Cookie> cookies = ga.driver.manage().getCookies();
	  WebDriverWait wait = new WebDriverWait(ga.driver, 10);
//	  ga.click(By.className("active"));
	  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"qqww\"]/div[1]/div/ul/li[4]/div[1]/i[1]"))));
	  WebElement ele = ga.driver.findElement(By.xpath("//*[@id=\"qqww\"]/div[1]/div/ul/li[4]/div[1]/i[1]"));
//	  action.moveToElement(ele);
	  ga.click(By.cssSelector(".per_family > li:nth-child(4) > a:nth-child(1)"));
	  Set<Cookie> cookies2 = ga.driver.manage().getCookies();
	  for(Cookie cookie : cookies){
		  System.out.println(cookie.getDomain()+"	"+"TRUE"+"	"+cookie.getPath()+"	"+"FALSE"+"	"+"0"+"	"+cookie.getName()+"	"+cookie.getValue());
	  }
	  for(Cookie cookie : cookies2){
		  System.out.println(cookie.getDomain()+"	"+"TRUE"+"	"+cookie.getPath()+"	"+"FALSE"+"	"+"0"+"	"+cookie.getName()+"	"+cookie.getValue());
	  }
	  
  }
  @BeforeClass
  public void beforeClass() {
//	  System.setProperty("webdriver.chrome.driver", "/Users/gaya/git/selenium/lib/selenium/chromedriver");
//	  ga.driver = new ChromeDriver();
	  System.setProperty("webdriver.gecko.driver", "/Users/gaya/git/selenium/lib/selenium/geckodriver");
	  ga.driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  ga.driver.close();
  }

}
