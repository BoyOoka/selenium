package selenium;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class testGayaSelenium {
	static GayaSelenium g = new GayaSelenium();
	@Before
	public void beforeclass()  {
		System.setProperty("webdriver.chrome.driver", "/Users/gaya/git/selenium/lib/selenium/chromedriver");
		g.driver = new ChromeDriver();
	    EventFiringWebDriver eventDriver = new EventFiringWebDriver(g.driver);
	        //注册事件
	    eventDriver.register(new MyWebDriverListener());

	    eventDriver.get("http://pub.alimama.com/");
	}

	@After
	public void afterclass() {
		g.driver.quit();
	}

	@Test
	public void testClick() throws IOException {
		g.switchToframe("taobaoLoginIfr");
		g.click(By.cssSelector("#J_Quick2Static"));
//		g.jsClick(By.cssSelector("#J_Quick2Static"));
		g.sendkeys(By.id("TPL_username_1"), "13281549858");
		g.sendkeys(By.id("TPL_password_1"), "13183937209Peng");
		try {
			g.takeScreen("淘宝客"+1, "/Users/gaya/Downloads/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.click(By.id("J_SubmitStatic"));
//		g.jsClick(By.id("J_SubmitStatic"));
	}

}
