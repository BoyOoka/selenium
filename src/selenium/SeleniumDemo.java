package selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import ecshop.Element;

public class SeleniumDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	Element e = new Element();
    	GayaSelenium g = new GayaSelenium();
		System.setProperty("webdriver.chrome.driver", "/Users/gaya/git/selenium/lib/selenium/chromedriver");
		g.driver = new ChromeDriver();
//        Navigation navigate = driver.navigate();

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(g.driver);
        //注册事件
        eventDriver.register(new MyWebDriverListener());

        //浏览特定网页
//        eventDriver.navigate().to("http://www.jd.com/");
        eventDriver.get("http://www.jd.com/");
        //点击按钮
        WebElement loginLink = eventDriver.findElement(By.partialLinkText("登"));
        loginLink.click();

        //在搜索框输入内容
//        eventDriver.findElement(By.id("kw")).sendKeys("诛仙剑阵");

        //故意写一个错误操作, 使selenium产生异常
        try{
            eventDriver.findElement(By.id("番天印"));
        }catch(Exception e1){
            e1.printStackTrace();
        }
        eventDriver.get(e.url);
  	  //登录
//         eventDriver.findElement(e.userLogin).click();
        g.click(e.userLogin);
        eventDriver.findElement(e.userName).sendKeys(e.user);
        eventDriver.findElement(e.userPassword).sendKeys(e.password);
        eventDriver.findElement(e.userSubmit).click();
        
        
        //验证正确登录
        assertEquals(g.driver.findElement(e.userInfoL).getText(), e.userInfo);
        
    }
}
