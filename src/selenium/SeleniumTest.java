package selenium;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
	static GayaSelenium g = new GayaSelenium();
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/gaya/git/selenium/lib/selenium/chromedriver");
		g.driver = new ChromeDriver();
		
	}

	@After
	public void tearDown() throws Exception {
		g.driver.quit();
	}

	@Test
	public void selectTest() throws IOException {
		g.driver.get("http://localhost/webtest/body.htm");
		g.click(By.id("a1"));
		g.click(By.id("a2"));
		Select sel = new Select(g.driver.findElement(By.name("lesson")));
		Random random = new Random();
		int i = random.nextInt(2);
		System.out.println(i);
		sel.selectByIndex(i);
	}
	@Test
	public void alertTest() throws IOException{
		g.driver.get("http://localhost/webtest/body.htm");
		g.click(By.id("confirm"));
//		String s0 = g.driver.switchTo().alert().getText();
//		g.driver.switchTo().alert().accept();
//		String s1 = g.driver.switchTo().alert().getText();
//		g.driver.switchTo().alert().accept();
//		Alert alert = g.driver.switchTo().alert();
//		String s0 = alert.getText();
//		alert.accept();
//		String s1 = alert.getText();
//		alert.accept();
//		System.out.println(s0+">>>"+s1);
		//调用封装
		String s = g.alert(1,"");
		g.alert(0,"");
		String s1 = g.alert(1,"");
		g.alert(2,"");
		System.out.println(s+","+s1);
		
//		g.click(By.xpath("//a"));
		g.click(By.cssSelector("a"));
	}
	@Test
	public void doubleClick(){
		g.driver.get("http://localhost/webtest/dblClick.htm");
		String s1 = g.driver.findElement(By.id("showme")).getAttribute("value");
		g.doubleClick(By.id("winTitle"));
		String s2 = g.driver.findElement(By.id("showme")).getAttribute("value");
		System.out.println(s1+","+s2);
	}
	@Test
	public void prompt() throws IOException{
		g.driver.get("http://localhost/webtest/dialog.htm");
		g.click(By.id("prompt"));
		g.alert(3, "test");
		g.alert(0, "");
		System.out.println(g.driver.getPageSource());
	}
	@Test
	public void upload(){
		g.driver.get("http://localhost/webtest/input.htm");
		g.driver.findElement(By.id("id5")).sendKeys("/Users/gaya/Desktop/图片/0.jpg");
	}
	@Test
	public void window() throws IOException{
		g.driver.get("http://localhost/webtest/locator.htm");
		String parent = g.driver.getWindowHandle();
		g.click(By.linkText("百度"));
		g.click(By.linkText("计算器"));
		Set<String> handles = g.driver.getWindowHandles();
		for(String handle : handles){
			g.driver.switchTo().window(handle);
			if(g.driver.getTitle().equals("百度一下，你就知道")){
				g.sendkeys(By.id("kw"), "good");
				g.click(By.id("su"));
			}
			if(g.driver.getTitle().equals("简单计算器")){
				g.click(By.id("btn7"));
				g.click(By.id("times"));
				g.click(By.id("btn6"));
				g.click(By.id("equal"));
				System.out.println(g.driver.findElement(By.name("numScreen")).getAttribute("value"));
			}
		}
		g.driver.switchTo().window(parent);
		g.click(By.name("continue"));
	}
}
