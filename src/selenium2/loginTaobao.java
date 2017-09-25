package selenium2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginTaobao {
    //以下方法获取登录淘宝成功后的cookie
    public static String click(String username, String password) throws InterruptedException {
    	WebDriver driver;
//	public static void main(String[] args){
    	String logurl = "http://pub.alimama.com/";
//    	https://ad.alimama.com/index.htm
//    	http://pub.alimama.com/
    	System.setProperty("webdriver.chrome.driver", "/Users/gaya/git/selenium/lib/selenium/chromedriver");
        driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver","/Users/gaya/git/selenium/lib/selenium/geckodriver");
//		driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(logurl);

	//因为淘宝的登录其实是嵌入在一个iframe里面的，所以得先切换到iframe中再操作
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("taobaoLoginIfr"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#J_Quick2Static")));
        driver.findElement(By.cssSelector("#J_Quick2Static")).click();
	//输入用户名
        driver.findElement(By.id("TPL_username_1")).clear();
        driver.findElement(By.id("TPL_username_1")).sendKeys(username);

	//输入密码
        driver.findElement(By.id("TPL_password_1")).clear();
        driver.findElement(By.id("TPL_password_1")).sendKeys(password);

	//点击登录按钮
        driver.findElement(By.id("J_SubmitStatic")).click();
        String currenturl = driver.getCurrentUrl();
        if(currenturl.equalsIgnoreCase(logurl)){
        	System.out.println(currenturl);
        }
        driver.switchTo().defaultContent();
        try {

	    //不停的检测，一旦当前页面URL不是登录页面URL，就说明浏览器已经进行了跳转
            while (true) {
                Thread.sleep(500L);
                if (!driver.getCurrentUrl().startsWith("http://login.1688.com/member/signin.htm")) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	//获取cookie，上面一跳出循环我认为就登录成功了，当然上面的判断不太严格，可以再进行修改
        Set<Cookie> cookies = driver.manage().getCookies();
        String cookieStr = "";
        System.out.println(cookies);
        for (Cookie cookie : cookies) {
            cookieStr += cookie.getName() + "=" + cookie.getValue() + "; ";
        }

	//退出，关闭浏览器
//      driver.quit();
        return cookieStr;
    }

}
